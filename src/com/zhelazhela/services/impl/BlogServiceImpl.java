package com.zhelazhela.services.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.zhelazhela.db.dao.AttachmentsDAO;
import com.zhelazhela.db.dao.BlogCommentsDAO;
import com.zhelazhela.db.dao.BlogDetailDAO;
import com.zhelazhela.db.dao.BlogQaDAO;
import com.zhelazhela.db.dao.BlogTagDAO;
import com.zhelazhela.db.dao.TagsDAO;
import com.zhelazhela.db.model.Attachments;
import com.zhelazhela.db.model.AttachmentsExample;
import com.zhelazhela.db.model.BlogComments;
import com.zhelazhela.db.model.BlogCommentsExample;
import com.zhelazhela.db.model.BlogDetail;
import com.zhelazhela.db.model.BlogDetailExample;
import com.zhelazhela.db.model.BlogQa;
import com.zhelazhela.db.model.BlogQaExample;
import com.zhelazhela.db.model.BlogTag;
import com.zhelazhela.db.model.BlogTagExample;
import com.zhelazhela.db.model.Tags;
import com.zhelazhela.db.model.TagsExample;
import com.zhelazhela.domain.AttachmentList;
import com.zhelazhela.domain.BlogDetailList;
import com.zhelazhela.domain.BlogQaList;
import com.zhelazhela.services.BlogService;
import com.zhelazhela.system.config.SystemConfig;
import com.zhelazhela.util.CommonMethod;

public class BlogServiceImpl implements BlogService {

	private BlogDetailDAO blogDetailDAO;
	
	private BlogTagDAO blogTagDAO;
	
	private BlogCommentsDAO blogCommentsDAO;
	
	private TagsDAO tagsDAO;
	
	private BlogQaDAO blogQaDAO;
	
	private SystemConfig systemConfig;
	
	private AttachmentsDAO attachmentsDAO;
	
	private PlatformTransactionManager m_db_tx_manager;
	
	private static long lasttime = System.currentTimeMillis();
	
	private static java.util.List<Tags> toptags = null;
	
	private static long c_lasttime = System.currentTimeMillis();
	
	private static java.util.List<String> c_categorys = null;
		
	public void setTxManager(PlatformTransactionManager tx){
		this.m_db_tx_manager = tx;
	}
	
	public void setBlogDetailDAO(BlogDetailDAO blogDetailDAO) {
		this.blogDetailDAO = blogDetailDAO;
	}

	public void setBlogTagDAO(BlogTagDAO blogTagDAO) {
		this.blogTagDAO = blogTagDAO;
	}

	public void setBlogCommentsDAO(BlogCommentsDAO blogCommentsDAO) {
		this.blogCommentsDAO = blogCommentsDAO;
	}

	public void setTagsDAO(TagsDAO tagsDAO) {
		this.tagsDAO = tagsDAO;
	}

	public void setBlogQaDAO(BlogQaDAO blogQaDAO) {
		this.blogQaDAO = blogQaDAO;
	}
	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

	public void setAttachmentsDAO(AttachmentsDAO attachmentsDAO) {
		this.attachmentsDAO = attachmentsDAO;
	}

	@Override
	public boolean delBlog(long id) throws Exception {
		if(blogDetailDAO.deleteByPrimaryKey(id)>0){
			BlogTagExample example = new BlogTagExample();
			example.createCriteria().andBlogIdEqualTo(id);
			blogTagDAO.deleteByExample(example);
			return true;
		}
		return false;
	}

	@Override
	public BlogDetail loadBlogDetail(long id) throws Exception {
		BlogDetail blog =  blogDetailDAO.selectByPrimaryKey(id);
		if(blog!=null){
			blog.setTags(tagsDAO.loadTagsByBlog(id));
			return blog;
		}
		return null;
	}

	@Override
	public BlogDetailList loadList(int page, int pagesize, String category,
			Date start, Date end,Boolean published,Boolean staticed) throws Exception {
		BlogDetailExample example = new BlogDetailExample();
		if(pagesize>0){
			example.setLimit(""+(page-1)*pagesize+","+pagesize);
		}
		
		BlogDetailExample.Criteria cri = example.createCriteria();
		if(category!=null){
			cri.andCategoryEqualTo(category);
		}
		if(published!=null){
			cri.andPublishedEqualTo(published);
		}
		if(staticed!=null){
			cri.andStaticedEqualTo(staticed);
		}
		if(start!=null&&end!=null){
			cri.andUpdateTimeBetween(start, end);
		}
		example.setOrderByClause("update_time desc");
		BlogDetailList bdl = new BlogDetailList();
		bdl.setPagesize(pagesize);
		bdl.setPage(page);
		bdl.setList(blogDetailDAO.selectByExampleWithoutBLOBs(example));
		bdl.setSize(blogDetailDAO.countByExample(example));
		return bdl;
	}

	@Override
	public boolean publishBlog(long id,String rootpath) throws Exception {
		BlogDetail bd = new BlogDetail();
		bd.setId(id);
		bd.setPublished(true);
		bd.setUpdateTime(new java.util.Date());
		int row = blogDetailDAO.updateByPrimaryKeySelective(bd);
		if(row>0){
			new StaticPage(systemConfig.getDomain()+"/blog/detail.zl?id="+id,rootpath+"/blog/detail/"+id+".html",id).start();
			return true;
		}
		return false;
	}

	@Override
	public BlogDetail saveBlog(BlogDetail record,String tags) throws Exception {
		record.setPublished(false);
		record.setStaticed(false);
		long id = 0;
		TransactionStatus status = m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
		try{
			id = blogDetailDAO.insertSelectiveReturnId(record);
			if(id>0){
				saveTags(tags,id);
			}
			m_db_tx_manager.commit(status);
		}catch(Exception e){
			m_db_tx_manager.rollback(status);
		}
		return loadBlogDetail(id);
	}

	@Override
	public BlogDetail updateBlogDetail(BlogDetail record,String tags) throws Exception {
		TransactionStatus status = m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
		try{
			int row = blogDetailDAO.updateByPrimaryKeySelective(record);
			if(row>0){
				saveTags(tags,record.getId());
			}
			m_db_tx_manager.commit(status);
		}catch(Exception e){
			m_db_tx_manager.rollback(status);
		}
		return loadBlogDetail(record.getId());
	}

	@Override
	public BlogComments comment(BlogComments record) throws Exception {
		if(blogDetailDAO.selectByPrimaryKey(record.getBlogId())==null){
			return null;
		}
		long id = blogCommentsDAO.insertSelectiveReturnId(record);
		if(id>0){
			return blogCommentsDAO.selectByPrimaryKey(id);
		}
		return null;
	}

	@Override
	public List<BlogComments> loadComment(long id) throws Exception {
		BlogCommentsExample example = new BlogCommentsExample();
		example.createCriteria().andBlogIdEqualTo(id);
		return blogCommentsDAO.selectByExample(example);
	}

	@Override
	public BlogDetailList loadList(int page, int pagesize, String tag)
			throws Exception {
		BlogDetailList bdl = new BlogDetailList();
		java.util.List<Long> blogs = blogTagDAO.loadBlogTagIds(tag);
		if(blogs.size()==0){
			bdl.setSize(0);
			bdl.setList(new java.util.ArrayList<BlogDetail>());
			return bdl;
		}
		BlogDetailExample example = new BlogDetailExample();
		if(pagesize>0){
			example.setLimit(""+(page-1)*pagesize+","+pagesize);
		}
		example.setOrderByClause("update_time desc");
		example.createCriteria().andPublishedEqualTo(true).andIdIn(blogs);
		bdl.setPagesize(pagesize);
		bdl.setPage(page);
		bdl.setSize(blogDetailDAO.countByExample(example));
		bdl.setList(blogDetailDAO.selectByExampleWithoutBLOBs(example));
		return bdl;
	}
	
	private void saveTags(String tags,long blog_id){
		if(tags!=null&&tags.trim().length()>0){
			String _tag[] = tags.split(",");
			Set<String> mytags = new java.util.HashSet<String>();
			for(String tmp:_tag){
				if(tmp!=null&&tmp.trim().length()>0){
					mytags.add(tmp.trim());
				}
			}
			TagsExample example = new TagsExample();
			example.createCriteria().andNameIn(new java.util.ArrayList<String>(mytags));
			java.util.List<Tags> taglist = tagsDAO.selectByExample(example);
			Tags forobj = new Tags();
			java.util.List<Long> tag_ids = new java.util.ArrayList<Long>();
			int tag_index;
			for(String tmp:mytags){
				forobj.setName(tmp);
				forobj.setId(null);
				tag_index = taglist.indexOf(forobj);
				if(tag_index>=0){
					tag_ids.add(taglist.get(tag_index).getId());
				}else{
					forobj.setUpdateTime(new java.util.Date());
					tag_ids.add(tagsDAO.insertSelectiveReturnId(forobj));
				}
			}
			BlogTagExample bex = new BlogTagExample();
			bex.createCriteria().andBlogIdEqualTo(blog_id);
			blogTagDAO.deleteByExample(bex);
			BlogTag bt = null;
			for(long id:tag_ids){
				bt = new BlogTag();
				bt.setBlogId(blog_id);
				bt.setTagId(id);
				blogTagDAO.insert(bt);
			}
		}else{
			BlogTagExample bex = new BlogTagExample();
			bex.createCriteria().andBlogIdEqualTo(blog_id);
			blogTagDAO.deleteByExample(bex);
		}
	}

	@Override
	public List<Tags> loadTopTags(int size) throws Exception {
		if(toptags==null){
			toptags = tagsDAO.loadTopTags(size);
			lasttime = System.currentTimeMillis();
			return toptags;
		}
		else{
			if((System.currentTimeMillis()-lasttime)>7200000){
				toptags = tagsDAO.loadTopTags(size);
				lasttime = System.currentTimeMillis();
			}
		}
		return toptags;
	}

	@Override
	public List<String> loadCategorys() throws Exception {
		if(c_categorys==null){
			c_categorys = blogDetailDAO.loadDisCategorys();
			c_lasttime = System.currentTimeMillis();
			return c_categorys;
		}
		else{
			if((System.currentTimeMillis()-lasttime)>7200000){
				c_categorys = blogDetailDAO.loadDisCategorys();
				c_lasttime = System.currentTimeMillis();
			}
		}
		return c_categorys;
	}

	@Override
	public void Question(BlogQa bq) throws Exception {
		blogQaDAO.insert(bq);
	}

	@Override
	public boolean delQuestion(long id) throws Exception {
		int row = blogQaDAO.deleteByPrimaryKey(id);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public BlogQaList loadBlogQaList(int page, int pagesize) throws Exception {
		BlogQaExample example = new BlogQaExample();
		if(pagesize>0){
			example.setLimit(""+(page-1)*pagesize+","+pagesize);
		}
		example.setOrderByClause("id desc");
		BlogQaList bq = new BlogQaList();
		bq.setPagesize(pagesize);
		bq.setPage(page);
		bq.setList(blogQaDAO.selectByExample(example));
		bq.setSize(blogQaDAO.countByExample(example));
		return bq;
	}

	class StaticPage extends Thread{
		String url;
		String destfile;
		long id;
		public StaticPage(String source,String target,long id){
			this.url = source;
			this.destfile = target;
			this.id = id;
		}
		public void run(){
			try{
				HttpClient httpclient=new HttpClient();  
				GetMethod getMethod=new GetMethod(url);
				httpclient.executeMethod(getMethod);
				java.io.File file = new java.io.File(destfile);
				file.createNewFile();
				java.io.OutputStream fos = new java.io.FileOutputStream(file);
				java.io.InputStream is = getMethod.getResponseBodyAsStream();
				byte[] buf = new byte[4 * 1024];
				int read;
				while((read=is.read(buf))!=-1){
					fos.write(buf, 0, read);
				}
				fos.flush();
				fos.close();
				getMethod.releaseConnection();
				BlogDetail bd = new BlogDetail();
				bd.setId(id);
				bd.setStaticed(true);
				bd.setUpdateTime(new java.util.Date());
				blogDetailDAO.updateByPrimaryKeySelective(bd);
			}catch(Exception e){
				e.printStackTrace();
			} 
		}
	}

	@Override
	public boolean delPic(long id,String path) throws Exception {
		Attachments record = attachmentsDAO.selectByPrimaryKey(id);
		if(record!=null){
			CommonMethod.newInstance().deleteFile(path+record.getFileName());
			attachmentsDAO.deleteByPrimaryKey(id);
			return true;
		}
		return false;
	}

	@Override
	public AttachmentList loadBlogPic(int page, int pagesize)
			throws Exception {
		AttachmentsExample example = new AttachmentsExample();
		if(pagesize>0){
			example.setLimit(""+(page-1)*pagesize+","+pagesize);
		}
		example.createCriteria().andRelTableEqualTo("blog_detail");
		AttachmentList al = new AttachmentList();
		al.setPagesize(pagesize);
		al.setPage(page);
		al.setSize(attachmentsDAO.countByExample(example));
		al.setList(attachmentsDAO.selectByExample(example));
		return al;
	}

	@Override
	public Attachments uploadPic(Attachments am, String path, String extType,
			File pic) throws Exception {
		TransactionStatus  status = this.m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
		try{
			if(pic!=null){
				CommonMethod cm = CommonMethod.newInstance();
				String file_path = cm.saveLogo(pic, path, systemConfig.getUpload_blog_pic(), extType);
				am.setFileName(file_path);
				long id = attachmentsDAO.insertSelectiveReturnId(am);
				if(id>0){
					m_db_tx_manager.commit(status);
					return attachmentsDAO.selectByPrimaryKey(id);
				}
				throw new Exception("save path error");
			}
			
		}catch(Exception e){
			this.m_db_tx_manager.rollback(status);
			throw new java.lang.Exception(e.getMessage());
		}
		return null;
	}
	
}
