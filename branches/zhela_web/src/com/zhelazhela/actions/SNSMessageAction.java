package com.zhelazhela.actions;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.zhelazhela.db.model.InboxMessage;
import com.zhelazhela.db.model.OutboxMessage;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.services.UserMessageService;

@SuppressWarnings("serial")
public class SNSMessageAction extends BaseAction {

	private long dest_user;
	
	private long msgid;
	/**
	 * inbox or outbox or trash
	 */
	private int target;
	
	private int action;
	
	private String subject;
	
	private String message;
	
	private int page;
	
	private int pagesize;
	
	private UserMessageService userMessageService;
	
	public void setUserMessageService(UserMessageService userMessageService) {
		this.userMessageService = userMessageService;
	}

	public long getDest_user() {
		return dest_user;
	}

	public void setDest_user(long destUser) {
		dest_user = destUser;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getMsgid() {
		return msgid;
	}

	public void setMsgid(long msgid) {
		this.msgid = msgid;
	}
	
	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public String sendNormalMessage() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		if(StringUtils.isBlank(subject)){
			jb.put("result", "fail");
			jb.put("msg", "您必须填写好标题");
			setValue("json",jb.toString());
			return JSON;
		}
		if(StringUtils.isBlank(message)){
			jb.put("result", "fail");
			jb.put("msg", "您必须填写消息内容");
			setValue("json",jb.toString());
			return JSON;
		}
		try{
			OutboxMessage obm = userMessageService.sendFriend(tmp.getId(), dest_user, subject, message);
			if(obm!=null){
				jb.put("data", obm);
				jb.put("result", "success");
				setValue("json",jb.toString());
				return JSON;
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("json", "fail");
		setValue("json",jb.toString());
		return JSON;
	}
	
	public String dealMessage() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		try{
			boolean result = userMessageService.dealMessage(msgid, tmp.getId(), action);
			if(result){
				jb.put("result", "success");
				setValue("json",jb.toString());
				return JSON;
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("json", "fail");
		setValue("json",jb.toString());
		return JSON;
	}
	
	public String readMessage() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		switch(target){
		//inbox
		case 1:
			InboxMessage im = userMessageService.readInBoxMessage(msgid,tmp.getId());
			if(im!=null){
				jb.put("result", "success");
				jb.put("data", im);
				setValue("json",jb.toString());
				return JSON;
			}
			break;
		//outbox	
		case 2:
			OutboxMessage om = userMessageService.readOutBoxMessage(msgid,tmp.getId());
			if(om!=null){
				jb.put("result", "success");
				jb.put("data", om);
				setValue("json",jb.toString());
				return JSON;
			}
			break;
		//other	
		default:
			break;
		}
		jb.put("reuslt", "fail");
		setValue("json",jb.toString());
		return JSON;
	}
	
	public String loadMessageList() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(tmp==null){
			return LOGIN;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		switch(target){
		//inbox
		case 1:
			setValue("msgs",userMessageService.loadInbox(tmp.getId(), page, pagesize));
			return "inbox";
		//outbox
		case 2:
			setValue("msgs",userMessageService.loadOutbox(tmp.getId(), page, pagesize));
			return "outbox";
		default:
			throw new Exception();
		}
	}
	
	public String countUnReadMessage() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		jb.put("result", "success");
		jb.put("data", userMessageService.countUnReadMessage(tmp.getId()));
		setValue("json",jb.toString());
		return JSON;
	}
	
	public String delMessage() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		String []_ids = getRequestParameterValues("ids");
		java.util.List<Long> ids = new java.util.ArrayList<Long>();
		if(_ids!=null){
			for(String _id:_ids){
				try{
					ids.add(Long.parseLong(_id));
				}catch(Exception e){
					
				}
			}
		}
		switch(target){
		case 1:
			userMessageService.delInbox(ids, tmp.getId());
			break;
		case 2:
			userMessageService.delOutbox(ids, tmp.getId());
			break;
		}
		jb.put("result", "success");
		this.setValue("json", jb.toString());
		return JSON;
	}
}
