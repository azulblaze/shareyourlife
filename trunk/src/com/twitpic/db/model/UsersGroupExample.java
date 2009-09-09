package com.twitpic.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersGroupExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public UsersGroupExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	protected UsersGroupExample(UsersGroupExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
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

		public Criteria andIdGroupsIsNull() {
			addCriterion("id_groups is null");
			return this;
		}

		public Criteria andIdGroupsIsNotNull() {
			addCriterion("id_groups is not null");
			return this;
		}

		public Criteria andIdGroupsEqualTo(Long value) {
			addCriterion("id_groups =", value, "idGroups");
			return this;
		}

		public Criteria andIdGroupsNotEqualTo(Long value) {
			addCriterion("id_groups <>", value, "idGroups");
			return this;
		}

		public Criteria andIdGroupsGreaterThan(Long value) {
			addCriterion("id_groups >", value, "idGroups");
			return this;
		}

		public Criteria andIdGroupsGreaterThanOrEqualTo(Long value) {
			addCriterion("id_groups >=", value, "idGroups");
			return this;
		}

		public Criteria andIdGroupsLessThan(Long value) {
			addCriterion("id_groups <", value, "idGroups");
			return this;
		}

		public Criteria andIdGroupsLessThanOrEqualTo(Long value) {
			addCriterion("id_groups <=", value, "idGroups");
			return this;
		}

		public Criteria andIdGroupsIn(List<Long> values) {
			addCriterion("id_groups in", values, "idGroups");
			return this;
		}

		public Criteria andIdGroupsNotIn(List<Long> values) {
			addCriterion("id_groups not in", values, "idGroups");
			return this;
		}

		public Criteria andIdGroupsBetween(Long value1, Long value2) {
			addCriterion("id_groups between", value1, value2, "idGroups");
			return this;
		}

		public Criteria andIdGroupsNotBetween(Long value1, Long value2) {
			addCriterion("id_groups not between", value1, value2, "idGroups");
			return this;
		}

		public Criteria andSrcAccountIsNull() {
			addCriterion("src_account is null");
			return this;
		}

		public Criteria andSrcAccountIsNotNull() {
			addCriterion("src_account is not null");
			return this;
		}

		public Criteria andSrcAccountEqualTo(String value) {
			addCriterion("src_account =", value, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountNotEqualTo(String value) {
			addCriterion("src_account <>", value, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountGreaterThan(String value) {
			addCriterion("src_account >", value, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountGreaterThanOrEqualTo(String value) {
			addCriterion("src_account >=", value, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountLessThan(String value) {
			addCriterion("src_account <", value, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountLessThanOrEqualTo(String value) {
			addCriterion("src_account <=", value, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountLike(String value) {
			addCriterion("src_account like", value, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountNotLike(String value) {
			addCriterion("src_account not like", value, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountIn(List<String> values) {
			addCriterion("src_account in", values, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountNotIn(List<String> values) {
			addCriterion("src_account not in", values, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountBetween(String value1, String value2) {
			addCriterion("src_account between", value1, value2, "srcAccount");
			return this;
		}

		public Criteria andSrcAccountNotBetween(String value1, String value2) {
			addCriterion("src_account not between", value1, value2,
					"srcAccount");
			return this;
		}

		public Criteria andAccountIsNull() {
			addCriterion("account is null");
			return this;
		}

		public Criteria andAccountIsNotNull() {
			addCriterion("account is not null");
			return this;
		}

		public Criteria andAccountEqualTo(String value) {
			addCriterion("account =", value, "account");
			return this;
		}

		public Criteria andAccountNotEqualTo(String value) {
			addCriterion("account <>", value, "account");
			return this;
		}

		public Criteria andAccountGreaterThan(String value) {
			addCriterion("account >", value, "account");
			return this;
		}

		public Criteria andAccountGreaterThanOrEqualTo(String value) {
			addCriterion("account >=", value, "account");
			return this;
		}

		public Criteria andAccountLessThan(String value) {
			addCriterion("account <", value, "account");
			return this;
		}

		public Criteria andAccountLessThanOrEqualTo(String value) {
			addCriterion("account <=", value, "account");
			return this;
		}

		public Criteria andAccountLike(String value) {
			addCriterion("account like", value, "account");
			return this;
		}

		public Criteria andAccountNotLike(String value) {
			addCriterion("account not like", value, "account");
			return this;
		}

		public Criteria andAccountIn(List<String> values) {
			addCriterion("account in", values, "account");
			return this;
		}

		public Criteria andAccountNotIn(List<String> values) {
			addCriterion("account not in", values, "account");
			return this;
		}

		public Criteria andAccountBetween(String value1, String value2) {
			addCriterion("account between", value1, value2, "account");
			return this;
		}

		public Criteria andAccountNotBetween(String value1, String value2) {
			addCriterion("account not between", value1, value2, "account");
			return this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
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
	}
}