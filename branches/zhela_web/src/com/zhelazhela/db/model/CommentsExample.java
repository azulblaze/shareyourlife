package com.zhelazhela.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentsExample {
	
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	protected List<Criteria> oredCriteria;


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public CommentsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	protected CommentsExample(CommentsExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
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

		public Criteria andDiscountInfoIdIsNull() {
			addCriterion("discount_info_id is null");
			return this;
		}

		public Criteria andDiscountInfoIdIsNotNull() {
			addCriterion("discount_info_id is not null");
			return this;
		}

		public Criteria andDiscountInfoIdEqualTo(Long value) {
			addCriterion("discount_info_id =", value, "discountInfoId");
			return this;
		}

		public Criteria andDiscountInfoIdNotEqualTo(Long value) {
			addCriterion("discount_info_id <>", value, "discountInfoId");
			return this;
		}

		public Criteria andDiscountInfoIdGreaterThan(Long value) {
			addCriterion("discount_info_id >", value, "discountInfoId");
			return this;
		}

		public Criteria andDiscountInfoIdGreaterThanOrEqualTo(Long value) {
			addCriterion("discount_info_id >=", value, "discountInfoId");
			return this;
		}

		public Criteria andDiscountInfoIdLessThan(Long value) {
			addCriterion("discount_info_id <", value, "discountInfoId");
			return this;
		}

		public Criteria andDiscountInfoIdLessThanOrEqualTo(Long value) {
			addCriterion("discount_info_id <=", value, "discountInfoId");
			return this;
		}

		public Criteria andDiscountInfoIdIn(List<Long> values) {
			addCriterion("discount_info_id in", values, "discountInfoId");
			return this;
		}

		public Criteria andDiscountInfoIdNotIn(List<Long> values) {
			addCriterion("discount_info_id not in", values, "discountInfoId");
			return this;
		}

		public Criteria andDiscountInfoIdBetween(Long value1, Long value2) {
			addCriterion("discount_info_id between", value1, value2,
					"discountInfoId");
			return this;
		}

		public Criteria andDiscountInfoIdNotBetween(Long value1, Long value2) {
			addCriterion("discount_info_id not between", value1, value2,
					"discountInfoId");
			return this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return this;
		}

		public Criteria andUserIndexIsNull() {
			addCriterion("user_index is null");
			return this;
		}

		public Criteria andUserIndexIsNotNull() {
			addCriterion("user_index is not null");
			return this;
		}

		public Criteria andUserIndexEqualTo(String value) {
			addCriterion("user_index =", value, "userIndex");
			return this;
		}

		public Criteria andUserIndexNotEqualTo(String value) {
			addCriterion("user_index <>", value, "userIndex");
			return this;
		}

		public Criteria andUserIndexGreaterThan(String value) {
			addCriterion("user_index >", value, "userIndex");
			return this;
		}

		public Criteria andUserIndexGreaterThanOrEqualTo(String value) {
			addCriterion("user_index >=", value, "userIndex");
			return this;
		}

		public Criteria andUserIndexLessThan(String value) {
			addCriterion("user_index <", value, "userIndex");
			return this;
		}

		public Criteria andUserIndexLessThanOrEqualTo(String value) {
			addCriterion("user_index <=", value, "userIndex");
			return this;
		}

		public Criteria andUserIndexLike(String value) {
			addCriterion("user_index like", value, "userIndex");
			return this;
		}

		public Criteria andUserIndexNotLike(String value) {
			addCriterion("user_index not like", value, "userIndex");
			return this;
		}

		public Criteria andUserIndexIn(List<String> values) {
			addCriterion("user_index in", values, "userIndex");
			return this;
		}

		public Criteria andUserIndexNotIn(List<String> values) {
			addCriterion("user_index not in", values, "userIndex");
			return this;
		}

		public Criteria andUserIndexBetween(String value1, String value2) {
			addCriterion("user_index between", value1, value2, "userIndex");
			return this;
		}

		public Criteria andUserIndexNotBetween(String value1, String value2) {
			addCriterion("user_index not between", value1, value2, "userIndex");
			return this;
		}

		public Criteria andUserEmailIsNull() {
			addCriterion("user_email is null");
			return this;
		}

		public Criteria andUserEmailIsNotNull() {
			addCriterion("user_email is not null");
			return this;
		}

		public Criteria andUserEmailEqualTo(String value) {
			addCriterion("user_email =", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailNotEqualTo(String value) {
			addCriterion("user_email <>", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailGreaterThan(String value) {
			addCriterion("user_email >", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
			addCriterion("user_email >=", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailLessThan(String value) {
			addCriterion("user_email <", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailLessThanOrEqualTo(String value) {
			addCriterion("user_email <=", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailLike(String value) {
			addCriterion("user_email like", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailNotLike(String value) {
			addCriterion("user_email not like", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailIn(List<String> values) {
			addCriterion("user_email in", values, "userEmail");
			return this;
		}

		public Criteria andUserEmailNotIn(List<String> values) {
			addCriterion("user_email not in", values, "userEmail");
			return this;
		}

		public Criteria andUserEmailBetween(String value1, String value2) {
			addCriterion("user_email between", value1, value2, "userEmail");
			return this;
		}

		public Criteria andUserEmailNotBetween(String value1, String value2) {
			addCriterion("user_email not between", value1, value2, "userEmail");
			return this;
		}

		public Criteria andIpAddrIsNull() {
			addCriterion("ip_addr is null");
			return this;
		}

		public Criteria andIpAddrIsNotNull() {
			addCriterion("ip_addr is not null");
			return this;
		}

		public Criteria andIpAddrEqualTo(String value) {
			addCriterion("ip_addr =", value, "ipAddr");
			return this;
		}

		public Criteria andIpAddrNotEqualTo(String value) {
			addCriterion("ip_addr <>", value, "ipAddr");
			return this;
		}

		public Criteria andIpAddrGreaterThan(String value) {
			addCriterion("ip_addr >", value, "ipAddr");
			return this;
		}

		public Criteria andIpAddrGreaterThanOrEqualTo(String value) {
			addCriterion("ip_addr >=", value, "ipAddr");
			return this;
		}

		public Criteria andIpAddrLessThan(String value) {
			addCriterion("ip_addr <", value, "ipAddr");
			return this;
		}

		public Criteria andIpAddrLessThanOrEqualTo(String value) {
			addCriterion("ip_addr <=", value, "ipAddr");
			return this;
		}

		public Criteria andIpAddrLike(String value) {
			addCriterion("ip_addr like", value, "ipAddr");
			return this;
		}

		public Criteria andIpAddrNotLike(String value) {
			addCriterion("ip_addr not like", value, "ipAddr");
			return this;
		}

		public Criteria andIpAddrIn(List<String> values) {
			addCriterion("ip_addr in", values, "ipAddr");
			return this;
		}

		public Criteria andIpAddrNotIn(List<String> values) {
			addCriterion("ip_addr not in", values, "ipAddr");
			return this;
		}

		public Criteria andIpAddrBetween(String value1, String value2) {
			addCriterion("ip_addr between", value1, value2, "ipAddr");
			return this;
		}

		public Criteria andIpAddrNotBetween(String value1, String value2) {
			addCriterion("ip_addr not between", value1, value2, "ipAddr");
			return this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("content =", value, "content");
			return this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("content <>", value, "content");
			return this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("content >", value, "content");
			return this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("content >=", value, "content");
			return this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("content <", value, "content");
			return this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("content <=", value, "content");
			return this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("content like", value, "content");
			return this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("content not like", value, "content");
			return this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("content in", values, "content");
			return this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("content not in", values, "content");
			return this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("content between", value1, value2, "content");
			return this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("content not between", value1, value2, "content");
			return this;
		}

		public Criteria andSupportTimesIsNull() {
			addCriterion("support_times is null");
			return this;
		}

		public Criteria andSupportTimesIsNotNull() {
			addCriterion("support_times is not null");
			return this;
		}

		public Criteria andSupportTimesEqualTo(Long value) {
			addCriterion("support_times =", value, "supportTimes");
			return this;
		}

		public Criteria andSupportTimesNotEqualTo(Long value) {
			addCriterion("support_times <>", value, "supportTimes");
			return this;
		}

		public Criteria andSupportTimesGreaterThan(Long value) {
			addCriterion("support_times >", value, "supportTimes");
			return this;
		}

		public Criteria andSupportTimesGreaterThanOrEqualTo(Long value) {
			addCriterion("support_times >=", value, "supportTimes");
			return this;
		}

		public Criteria andSupportTimesLessThan(Long value) {
			addCriterion("support_times <", value, "supportTimes");
			return this;
		}

		public Criteria andSupportTimesLessThanOrEqualTo(Long value) {
			addCriterion("support_times <=", value, "supportTimes");
			return this;
		}

		public Criteria andSupportTimesIn(List<Long> values) {
			addCriterion("support_times in", values, "supportTimes");
			return this;
		}

		public Criteria andSupportTimesNotIn(List<Long> values) {
			addCriterion("support_times not in", values, "supportTimes");
			return this;
		}

		public Criteria andSupportTimesBetween(Long value1, Long value2) {
			addCriterion("support_times between", value1, value2,
					"supportTimes");
			return this;
		}

		public Criteria andSupportTimesNotBetween(Long value1, Long value2) {
			addCriterion("support_times not between", value1, value2,
					"supportTimes");
			return this;
		}

		public Criteria andAgainstTimesIsNull() {
			addCriterion("against_times is null");
			return this;
		}

		public Criteria andAgainstTimesIsNotNull() {
			addCriterion("against_times is not null");
			return this;
		}

		public Criteria andAgainstTimesEqualTo(Long value) {
			addCriterion("against_times =", value, "againstTimes");
			return this;
		}

		public Criteria andAgainstTimesNotEqualTo(Long value) {
			addCriterion("against_times <>", value, "againstTimes");
			return this;
		}

		public Criteria andAgainstTimesGreaterThan(Long value) {
			addCriterion("against_times >", value, "againstTimes");
			return this;
		}

		public Criteria andAgainstTimesGreaterThanOrEqualTo(Long value) {
			addCriterion("against_times >=", value, "againstTimes");
			return this;
		}

		public Criteria andAgainstTimesLessThan(Long value) {
			addCriterion("against_times <", value, "againstTimes");
			return this;
		}

		public Criteria andAgainstTimesLessThanOrEqualTo(Long value) {
			addCriterion("against_times <=", value, "againstTimes");
			return this;
		}

		public Criteria andAgainstTimesIn(List<Long> values) {
			addCriterion("against_times in", values, "againstTimes");
			return this;
		}

		public Criteria andAgainstTimesNotIn(List<Long> values) {
			addCriterion("against_times not in", values, "againstTimes");
			return this;
		}

		public Criteria andAgainstTimesBetween(Long value1, Long value2) {
			addCriterion("against_times between", value1, value2,
					"againstTimes");
			return this;
		}

		public Criteria andAgainstTimesNotBetween(Long value1, Long value2) {
			addCriterion("against_times not between", value1, value2,
					"againstTimes");
			return this;
		}

		public Criteria andCommentTimeIsNull() {
			addCriterion("comment_time is null");
			return this;
		}

		public Criteria andCommentTimeIsNotNull() {
			addCriterion("comment_time is not null");
			return this;
		}

		public Criteria andCommentTimeEqualTo(Date value) {
			addCriterion("comment_time =", value, "commentTime");
			return this;
		}

		public Criteria andCommentTimeNotEqualTo(Date value) {
			addCriterion("comment_time <>", value, "commentTime");
			return this;
		}

		public Criteria andCommentTimeGreaterThan(Date value) {
			addCriterion("comment_time >", value, "commentTime");
			return this;
		}

		public Criteria andCommentTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("comment_time >=", value, "commentTime");
			return this;
		}

		public Criteria andCommentTimeLessThan(Date value) {
			addCriterion("comment_time <", value, "commentTime");
			return this;
		}

		public Criteria andCommentTimeLessThanOrEqualTo(Date value) {
			addCriterion("comment_time <=", value, "commentTime");
			return this;
		}

		public Criteria andCommentTimeIn(List<Date> values) {
			addCriterion("comment_time in", values, "commentTime");
			return this;
		}

		public Criteria andCommentTimeNotIn(List<Date> values) {
			addCriterion("comment_time not in", values, "commentTime");
			return this;
		}

		public Criteria andCommentTimeBetween(Date value1, Date value2) {
			addCriterion("comment_time between", value1, value2, "commentTime");
			return this;
		}

		public Criteria andCommentTimeNotBetween(Date value1, Date value2) {
			addCriterion("comment_time not between", value1, value2,
					"commentTime");
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