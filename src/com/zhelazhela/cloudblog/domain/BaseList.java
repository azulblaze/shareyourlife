package com.zhelazhela.cloudblog.domain;

public class BaseList extends BaseBean {

	public BaseList(String node_name){
		super(node_name);
	}
	
	public String count = "20";
	public String max_id;
	public String min_id;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
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
}
