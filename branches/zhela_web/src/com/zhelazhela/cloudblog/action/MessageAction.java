package com.zhelazhela.cloudblog.action;

import java.util.HashMap;
import java.util.Map;

import com.zhelazhela.cloudblog.services.MessageService;

@SuppressWarnings("serial")
public class MessageAction extends BaseAction {

	private String id;
	private String text;
	private String max_id;
	private String min_id;
	private String count;
	private MessageService messageService;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMax_id() {
		return max_id;
	}

	public void setMax_id(String maxId) {
		max_id = maxId;
	}

	public String getMin_id() {
		return min_id;
	}

	public void setMin_id(String minId) {
		min_id = minId;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public String delMsg() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("msgid", id);
		setValue(XML,messageService.del(param));
		return SUCCESS;
	}
	
	public String sendMsg() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("userid", id);
		param.put("text", text);
		setValue(XML,messageService.del(param));
		return SUCCESS;
	}
	
	public String inbox() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("max_id", max_id);
		param.put("min_id", min_id);
		param.put("count", count);
		setValue(XML,messageService.del(param));
		return SUCCESS;
	}
	
	public String outbox() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("max_id", max_id);
		param.put("min_id", min_id);
		param.put("count", count);
		setValue(XML,messageService.del(param));
		return SUCCESS;
	}
}
