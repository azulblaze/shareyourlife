package com.zhelazhela.actions;

import com.zhelazhela.domain.SNSUser;

public class SNSMainAction extends BaseAction {
	
	private static final long serialVersionUID = -6185954932555185651L;

	public String main() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(tmp==null||tmp.getReg_level()<=0){
			return LOGIN;
		}
		return SUCCESS;
	}
	
	public String collection() throws Exception{
		String source = this.getRequestParameter("source");
		if(source!=null&&source.trim().length()>0){
			setValue("url","/sns/collection.zl?source="+source);
			setValue("source",source);
			SNSUser tmp = (SNSUser)this.getSession("user");
			if(tmp==null||tmp.getReg_level()<=0){
				return LOGIN;
			}
			return SUCCESS;
		}
		throw new Exception();
	}
}
