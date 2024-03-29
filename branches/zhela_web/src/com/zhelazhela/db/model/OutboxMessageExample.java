package com.zhelazhela.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutboxMessageExample {
	
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	public OutboxMessageExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	protected OutboxMessageExample(OutboxMessageExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table outbox_message
	 * @ibatorgenerated  Fri Mar 12 21:58:31 CST 2010
	 */
	public static class Criteria {
		protected List<String> criteriaWithoutValue;
		protected List<Map<String, Object>> criteriaWithSingleValue;
		protected List<Map<String, Object>> criteriaWithListValue;
		protected List<Map<String, Object>> criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList<String>();
			criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
			criteriaWithListValue = new ArrayList<Map<String, Object>>();
			criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List<String> getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List<Map<String, Object>> getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List<Map<String, Object>> getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List<Map<String, Object>> getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition,
				List<? extends Object> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List<Object> list = new ArrayList<Object>();
			list.add(value1);
			list.add(value2);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return this;
		}

		public Criteria andReplyIdIsNull() {
			addCriterion("reply_id is null");
			return this;
		}

		public Criteria andReplyIdIsNotNull() {
			addCriterion("reply_id is not null");
			return this;
		}

		public Criteria andReplyIdEqualTo(Long value) {
			addCriterion("reply_id =", value, "replyId");
			return this;
		}

		public Criteria andReplyIdNotEqualTo(Long value) {
			addCriterion("reply_id <>", value, "replyId");
			return this;
		}

		public Criteria andReplyIdGreaterThan(Long value) {
			addCriterion("reply_id >", value, "replyId");
			return this;
		}

		public Criteria andReplyIdGreaterThanOrEqualTo(Long value) {
			addCriterion("reply_id >=", value, "replyId");
			return this;
		}

		public Criteria andReplyIdLessThan(Long value) {
			addCriterion("reply_id <", value, "replyId");
			return this;
		}

		public Criteria andReplyIdLessThanOrEqualTo(Long value) {
			addCriterion("reply_id <=", value, "replyId");
			return this;
		}

		public Criteria andReplyIdIn(List<Long> values) {
			addCriterion("reply_id in", values, "replyId");
			return this;
		}

		public Criteria andReplyIdNotIn(List<Long> values) {
			addCriterion("reply_id not in", values, "replyId");
			return this;
		}

		public Criteria andReplyIdBetween(Long value1, Long value2) {
			addCriterion("reply_id between", value1, value2, "replyId");
			return this;
		}

		public Criteria andReplyIdNotBetween(Long value1, Long value2) {
			addCriterion("reply_id not between", value1, value2, "replyId");
			return this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return this;
		}

		public Criteria andToIdIsNull() {
			addCriterion("to_id is null");
			return this;
		}

		public Criteria andToIdIsNotNull() {
			addCriterion("to_id is not null");
			return this;
		}

		public Criteria andToIdEqualTo(Long value) {
			addCriterion("to_id =", value, "toId");
			return this;
		}

		public Criteria andToIdNotEqualTo(Long value) {
			addCriterion("to_id <>", value, "toId");
			return this;
		}

		public Criteria andToIdGreaterThan(Long value) {
			addCriterion("to_id >", value, "toId");
			return this;
		}

		public Criteria andToIdGreaterThanOrEqualTo(Long value) {
			addCriterion("to_id >=", value, "toId");
			return this;
		}

		public Criteria andToIdLessThan(Long value) {
			addCriterion("to_id <", value, "toId");
			return this;
		}

		public Criteria andToIdLessThanOrEqualTo(Long value) {
			addCriterion("to_id <=", value, "toId");
			return this;
		}

		public Criteria andToIdIn(List<Long> values) {
			addCriterion("to_id in", values, "toId");
			return this;
		}

		public Criteria andToIdNotIn(List<Long> values) {
			addCriterion("to_id not in", values, "toId");
			return this;
		}

		public Criteria andToIdBetween(Long value1, Long value2) {
			addCriterion("to_id between", value1, value2, "toId");
			return this;
		}

		public Criteria andToIdNotBetween(Long value1, Long value2) {
			addCriterion("to_id not between", value1, value2, "toId");
			return this;
		}

		public Criteria andSubjectIsNull() {
			addCriterion("subject is null");
			return this;
		}

		public Criteria andSubjectIsNotNull() {
			addCriterion("subject is not null");
			return this;
		}

		public Criteria andSubjectEqualTo(String value) {
			addCriterion("subject =", value, "subject");
			return this;
		}

		public Criteria andSubjectNotEqualTo(String value) {
			addCriterion("subject <>", value, "subject");
			return this;
		}

		public Criteria andSubjectGreaterThan(String value) {
			addCriterion("subject >", value, "subject");
			return this;
		}

		public Criteria andSubjectGreaterThanOrEqualTo(String value) {
			addCriterion("subject >=", value, "subject");
			return this;
		}

		public Criteria andSubjectLessThan(String value) {
			addCriterion("subject <", value, "subject");
			return this;
		}

		public Criteria andSubjectLessThanOrEqualTo(String value) {
			addCriterion("subject <=", value, "subject");
			return this;
		}

		public Criteria andSubjectLike(String value) {
			addCriterion("subject like", value, "subject");
			return this;
		}

		public Criteria andSubjectNotLike(String value) {
			addCriterion("subject not like", value, "subject");
			return this;
		}

		public Criteria andSubjectIn(List<String> values) {
			addCriterion("subject in", values, "subject");
			return this;
		}

		public Criteria andSubjectNotIn(List<String> values) {
			addCriterion("subject not in", values, "subject");
			return this;
		}

		public Criteria andSubjectBetween(String value1, String value2) {
			addCriterion("subject between", value1, value2, "subject");
			return this;
		}

		public Criteria andSubjectNotBetween(String value1, String value2) {
			addCriterion("subject not between", value1, value2, "subject");
			return this;
		}

		public Criteria andMessageTypeIsNull() {
			addCriterion("message_type is null");
			return this;
		}

		public Criteria andMessageTypeIsNotNull() {
			addCriterion("message_type is not null");
			return this;
		}

		public Criteria andMessageTypeEqualTo(Integer value) {
			addCriterion("message_type =", value, "messageType");
			return this;
		}

		public Criteria andMessageTypeNotEqualTo(Integer value) {
			addCriterion("message_type <>", value, "messageType");
			return this;
		}

		public Criteria andMessageTypeGreaterThan(Integer value) {
			addCriterion("message_type >", value, "messageType");
			return this;
		}

		public Criteria andMessageTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("message_type >=", value, "messageType");
			return this;
		}

		public Criteria andMessageTypeLessThan(Integer value) {
			addCriterion("message_type <", value, "messageType");
			return this;
		}

		public Criteria andMessageTypeLessThanOrEqualTo(Integer value) {
			addCriterion("message_type <=", value, "messageType");
			return this;
		}

		public Criteria andMessageTypeIn(List<Integer> values) {
			addCriterion("message_type in", values, "messageType");
			return this;
		}

		public Criteria andMessageTypeNotIn(List<Integer> values) {
			addCriterion("message_type not in", values, "messageType");
			return this;
		}

		public Criteria andMessageTypeBetween(Integer value1, Integer value2) {
			addCriterion("message_type between", value1, value2, "messageType");
			return this;
		}

		public Criteria andMessageTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("message_type not between", value1, value2,
					"messageType");
			return this;
		}

		public Criteria andMessageStatusIsNull() {
			addCriterion("message_status is null");
			return this;
		}

		public Criteria andMessageStatusIsNotNull() {
			addCriterion("message_status is not null");
			return this;
		}

		public Criteria andMessageStatusEqualTo(String value) {
			addCriterion("message_status =", value, "messageStatus");
			return this;
		}

		public Criteria andMessageStatusNotEqualTo(String value) {
			addCriterion("message_status <>", value, "messageStatus");
			return this;
		}

		public Criteria andMessageStatusGreaterThan(String value) {
			addCriterion("message_status >", value, "messageStatus");
			return this;
		}

		public Criteria andMessageStatusGreaterThanOrEqualTo(String value) {
			addCriterion("message_status >=", value, "messageStatus");
			return this;
		}

		public Criteria andMessageStatusLessThan(String value) {
			addCriterion("message_status <", value, "messageStatus");
			return this;
		}

		public Criteria andMessageStatusLessThanOrEqualTo(String value) {
			addCriterion("message_status <=", value, "messageStatus");
			return this;
		}

		public Criteria andMessageStatusLike(String value) {
			addCriterion("message_status like", value, "messageStatus");
			return this;
		}

		public Criteria andMessageStatusNotLike(String value) {
			addCriterion("message_status not like", value, "messageStatus");
			return this;
		}

		public Criteria andMessageStatusIn(List<String> values) {
			addCriterion("message_status in", values, "messageStatus");
			return this;
		}

		public Criteria andMessageStatusNotIn(List<String> values) {
			addCriterion("message_status not in", values, "messageStatus");
			return this;
		}

		public Criteria andMessageStatusBetween(String value1, String value2) {
			addCriterion("message_status between", value1, value2,
					"messageStatus");
			return this;
		}

		public Criteria andMessageStatusNotBetween(String value1, String value2) {
			addCriterion("message_status not between", value1, value2,
					"messageStatus");
			return this;
		}

		public Criteria andMessageIsNull() {
			addCriterion("message is null");
			return this;
		}

		public Criteria andMessageIsNotNull() {
			addCriterion("message is not null");
			return this;
		}

		public Criteria andMessageEqualTo(String value) {
			addCriterion("message =", value, "message");
			return this;
		}

		public Criteria andMessageNotEqualTo(String value) {
			addCriterion("message <>", value, "message");
			return this;
		}

		public Criteria andMessageGreaterThan(String value) {
			addCriterion("message >", value, "message");
			return this;
		}

		public Criteria andMessageGreaterThanOrEqualTo(String value) {
			addCriterion("message >=", value, "message");
			return this;
		}

		public Criteria andMessageLessThan(String value) {
			addCriterion("message <", value, "message");
			return this;
		}

		public Criteria andMessageLessThanOrEqualTo(String value) {
			addCriterion("message <=", value, "message");
			return this;
		}

		public Criteria andMessageLike(String value) {
			addCriterion("message like", value, "message");
			return this;
		}

		public Criteria andMessageNotLike(String value) {
			addCriterion("message not like", value, "message");
			return this;
		}

		public Criteria andMessageIn(List<String> values) {
			addCriterion("message in", values, "message");
			return this;
		}

		public Criteria andMessageNotIn(List<String> values) {
			addCriterion("message not in", values, "message");
			return this;
		}

		public Criteria andMessageBetween(String value1, String value2) {
			addCriterion("message between", value1, value2, "message");
			return this;
		}

		public Criteria andMessageNotBetween(String value1, String value2) {
			addCriterion("message not between", value1, value2, "message");
			return this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("update_time =", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("update_time <>", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("update_time >", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("update_time >=", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("update_time <", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("update_time <=", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("update_time in", values, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("update_time not in", values, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("update_time not between", value1, value2,
					"updateTime");
			return this;
		}

		public Criteria andIsDeletedIsNull() {
			addCriterion("is_deleted is null");
			return this;
		}

		public Criteria andIsDeletedIsNotNull() {
			addCriterion("is_deleted is not null");
			return this;
		}

		public Criteria andIsDeletedEqualTo(Boolean value) {
			addCriterion("is_deleted =", value, "isDeleted");
			return this;
		}

		public Criteria andIsDeletedNotEqualTo(Boolean value) {
			addCriterion("is_deleted <>", value, "isDeleted");
			return this;
		}

		public Criteria andIsDeletedGreaterThan(Boolean value) {
			addCriterion("is_deleted >", value, "isDeleted");
			return this;
		}

		public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_deleted >=", value, "isDeleted");
			return this;
		}

		public Criteria andIsDeletedLessThan(Boolean value) {
			addCriterion("is_deleted <", value, "isDeleted");
			return this;
		}

		public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
			addCriterion("is_deleted <=", value, "isDeleted");
			return this;
		}

		public Criteria andIsDeletedIn(List<Boolean> values) {
			addCriterion("is_deleted in", values, "isDeleted");
			return this;
		}

		public Criteria andIsDeletedNotIn(List<Boolean> values) {
			addCriterion("is_deleted not in", values, "isDeleted");
			return this;
		}

		public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
			addCriterion("is_deleted between", value1, value2, "isDeleted");
			return this;
		}

		public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_deleted not between", value1, value2, "isDeleted");
			return this;
		}
	}

	private String limit;
	
    public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}
}