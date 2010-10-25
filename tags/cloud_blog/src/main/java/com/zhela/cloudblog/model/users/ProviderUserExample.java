package com.zhela.cloudblog.model.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhela.cloudblog.model.DefaultExample;

public class ProviderUserExample extends DefaultExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	public ProviderUserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	protected ProviderUserExample(ProviderUserExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table provider_user
	 * @ibatorgenerated  Mon Oct 25 16:01:43 CST 2010
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

		public Criteria andProviderIdIsNull() {
			addCriterion("provider_id is null");
			return this;
		}

		public Criteria andProviderIdIsNotNull() {
			addCriterion("provider_id is not null");
			return this;
		}

		public Criteria andProviderIdEqualTo(Long value) {
			addCriterion("provider_id =", value, "providerId");
			return this;
		}

		public Criteria andProviderIdNotEqualTo(Long value) {
			addCriterion("provider_id <>", value, "providerId");
			return this;
		}

		public Criteria andProviderIdGreaterThan(Long value) {
			addCriterion("provider_id >", value, "providerId");
			return this;
		}

		public Criteria andProviderIdGreaterThanOrEqualTo(Long value) {
			addCriterion("provider_id >=", value, "providerId");
			return this;
		}

		public Criteria andProviderIdLessThan(Long value) {
			addCriterion("provider_id <", value, "providerId");
			return this;
		}

		public Criteria andProviderIdLessThanOrEqualTo(Long value) {
			addCriterion("provider_id <=", value, "providerId");
			return this;
		}

		public Criteria andProviderIdIn(List<Long> values) {
			addCriterion("provider_id in", values, "providerId");
			return this;
		}

		public Criteria andProviderIdNotIn(List<Long> values) {
			addCriterion("provider_id not in", values, "providerId");
			return this;
		}

		public Criteria andProviderIdBetween(Long value1, Long value2) {
			addCriterion("provider_id between", value1, value2, "providerId");
			return this;
		}

		public Criteria andProviderIdNotBetween(Long value1, Long value2) {
			addCriterion("provider_id not between", value1, value2,
					"providerId");
			return this;
		}

		public Criteria andUsersAccountIsNull() {
			addCriterion("users_account is null");
			return this;
		}

		public Criteria andUsersAccountIsNotNull() {
			addCriterion("users_account is not null");
			return this;
		}

		public Criteria andUsersAccountEqualTo(String value) {
			addCriterion("users_account =", value, "usersAccount");
			return this;
		}

		public Criteria andUsersAccountNotEqualTo(String value) {
			addCriterion("users_account <>", value, "usersAccount");
			return this;
		}

		public Criteria andUsersAccountGreaterThan(String value) {
			addCriterion("users_account >", value, "usersAccount");
			return this;
		}

		public Criteria andUsersAccountGreaterThanOrEqualTo(String value) {
			addCriterion("users_account >=", value, "usersAccount");
			return this;
		}

		public Criteria andUsersAccountLessThan(String value) {
			addCriterion("users_account <", value, "usersAccount");
			return this;
		}

		public Criteria andUsersAccountLessThanOrEqualTo(String value) {
			addCriterion("users_account <=", value, "usersAccount");
			return this;
		}

		public Criteria andUsersAccountLike(String value) {
			addCriterion("users_account like", value, "usersAccount");
			return this;
		}

		public Criteria andUsersAccountNotLike(String value) {
			addCriterion("users_account not like", value, "usersAccount");
			return this;
		}

		public Criteria andUsersAccountIn(List<String> values) {
			addCriterion("users_account in", values, "usersAccount");
			return this;
		}

		public Criteria andUsersAccountNotIn(List<String> values) {
			addCriterion("users_account not in", values, "usersAccount");
			return this;
		}

		public Criteria andUsersAccountBetween(String value1, String value2) {
			addCriterion("users_account between", value1, value2,
					"usersAccount");
			return this;
		}

		public Criteria andUsersAccountNotBetween(String value1, String value2) {
			addCriterion("users_account not between", value1, value2,
					"usersAccount");
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

		public Criteria andTokenIsNull() {
			addCriterion("token is null");
			return this;
		}

		public Criteria andTokenIsNotNull() {
			addCriterion("token is not null");
			return this;
		}

		public Criteria andTokenEqualTo(String value) {
			addCriterion("token =", value, "token");
			return this;
		}

		public Criteria andTokenNotEqualTo(String value) {
			addCriterion("token <>", value, "token");
			return this;
		}

		public Criteria andTokenGreaterThan(String value) {
			addCriterion("token >", value, "token");
			return this;
		}

		public Criteria andTokenGreaterThanOrEqualTo(String value) {
			addCriterion("token >=", value, "token");
			return this;
		}

		public Criteria andTokenLessThan(String value) {
			addCriterion("token <", value, "token");
			return this;
		}

		public Criteria andTokenLessThanOrEqualTo(String value) {
			addCriterion("token <=", value, "token");
			return this;
		}

		public Criteria andTokenLike(String value) {
			addCriterion("token like", value, "token");
			return this;
		}

		public Criteria andTokenNotLike(String value) {
			addCriterion("token not like", value, "token");
			return this;
		}

		public Criteria andTokenIn(List<String> values) {
			addCriterion("token in", values, "token");
			return this;
		}

		public Criteria andTokenNotIn(List<String> values) {
			addCriterion("token not in", values, "token");
			return this;
		}

		public Criteria andTokenBetween(String value1, String value2) {
			addCriterion("token between", value1, value2, "token");
			return this;
		}

		public Criteria andTokenNotBetween(String value1, String value2) {
			addCriterion("token not between", value1, value2, "token");
			return this;
		}

		public Criteria andTokenSecretIsNull() {
			addCriterion("token_secret is null");
			return this;
		}

		public Criteria andTokenSecretIsNotNull() {
			addCriterion("token_secret is not null");
			return this;
		}

		public Criteria andTokenSecretEqualTo(String value) {
			addCriterion("token_secret =", value, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretNotEqualTo(String value) {
			addCriterion("token_secret <>", value, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretGreaterThan(String value) {
			addCriterion("token_secret >", value, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretGreaterThanOrEqualTo(String value) {
			addCriterion("token_secret >=", value, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretLessThan(String value) {
			addCriterion("token_secret <", value, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretLessThanOrEqualTo(String value) {
			addCriterion("token_secret <=", value, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretLike(String value) {
			addCriterion("token_secret like", value, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretNotLike(String value) {
			addCriterion("token_secret not like", value, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretIn(List<String> values) {
			addCriterion("token_secret in", values, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretNotIn(List<String> values) {
			addCriterion("token_secret not in", values, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretBetween(String value1, String value2) {
			addCriterion("token_secret between", value1, value2, "tokenSecret");
			return this;
		}

		public Criteria andTokenSecretNotBetween(String value1, String value2) {
			addCriterion("token_secret not between", value1, value2,
					"tokenSecret");
			return this;
		}

		public Criteria andTokenMoreIsNull() {
			addCriterion("token_more is null");
			return this;
		}

		public Criteria andTokenMoreIsNotNull() {
			addCriterion("token_more is not null");
			return this;
		}

		public Criteria andTokenMoreEqualTo(String value) {
			addCriterion("token_more =", value, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreNotEqualTo(String value) {
			addCriterion("token_more <>", value, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreGreaterThan(String value) {
			addCriterion("token_more >", value, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreGreaterThanOrEqualTo(String value) {
			addCriterion("token_more >=", value, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreLessThan(String value) {
			addCriterion("token_more <", value, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreLessThanOrEqualTo(String value) {
			addCriterion("token_more <=", value, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreLike(String value) {
			addCriterion("token_more like", value, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreNotLike(String value) {
			addCriterion("token_more not like", value, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreIn(List<String> values) {
			addCriterion("token_more in", values, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreNotIn(List<String> values) {
			addCriterion("token_more not in", values, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreBetween(String value1, String value2) {
			addCriterion("token_more between", value1, value2, "tokenMore");
			return this;
		}

		public Criteria andTokenMoreNotBetween(String value1, String value2) {
			addCriterion("token_more not between", value1, value2, "tokenMore");
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