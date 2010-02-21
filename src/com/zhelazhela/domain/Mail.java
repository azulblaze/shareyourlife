package com.zhelazhela.domain;

public class Mail {
	
	public static final String MAIL_TYPE_HTML = "HTML";
	
	private String toAddr;
	
	private String subject;
	
	private String type;
	
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToAddr() {
		return toAddr;
	}

	public void setToAddr(String toAddr) {
		this.toAddr = toAddr;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String toString(){
		return "subject:"+subject
				+" type:"+type
				+" toAddr:"+toAddr
				+" content:"+content;
	}
	
	public static synchronized Mail getActvityEmail(long user_id,String email,String code,String domain){
		Mail m = new Mail();
		String tmp = "请使用下面的链接激活您的账号：<a href=\""+domain+"/sns/act.zl?id="+user_id+"&code="+code+"\">"+domain+"/sns/act.zl?id="+user_id+"&code="+code+"</a>";
		tmp = tmp + "<br/>或者复制下面的地址到浏览器中激活："+domain+"/sns/act.zl?id="+user_id+"&code="+code;
		m.setContent(tmp);
		m.setSubject("激活您的账号 -- 这啦折啦");
		m.setToAddr(email);
		m.setType(MAIL_TYPE_HTML);
		return m;
	}
	
}
