package com.zhelazhela.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactProfileExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public ContactProfileExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	protected ContactProfileExample(ContactProfileExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
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

		public Criteria andVisibilityIsNull() {
			addCriterion("visibility is null");
			return this;
		}

		public Criteria andVisibilityIsNotNull() {
			addCriterion("visibility is not null");
			return this;
		}

		public Criteria andVisibilityEqualTo(Integer value) {
			addCriterion("visibility =", value, "visibility");
			return this;
		}

		public Criteria andVisibilityNotEqualTo(Integer value) {
			addCriterion("visibility <>", value, "visibility");
			return this;
		}

		public Criteria andVisibilityGreaterThan(Integer value) {
			addCriterion("visibility >", value, "visibility");
			return this;
		}

		public Criteria andVisibilityGreaterThanOrEqualTo(Integer value) {
			addCriterion("visibility >=", value, "visibility");
			return this;
		}

		public Criteria andVisibilityLessThan(Integer value) {
			addCriterion("visibility <", value, "visibility");
			return this;
		}

		public Criteria andVisibilityLessThanOrEqualTo(Integer value) {
			addCriterion("visibility <=", value, "visibility");
			return this;
		}

		public Criteria andVisibilityIn(List<Integer> values) {
			addCriterion("visibility in", values, "visibility");
			return this;
		}

		public Criteria andVisibilityNotIn(List<Integer> values) {
			addCriterion("visibility not in", values, "visibility");
			return this;
		}

		public Criteria andVisibilityBetween(Integer value1, Integer value2) {
			addCriterion("visibility between", value1, value2, "visibility");
			return this;
		}

		public Criteria andVisibilityNotBetween(Integer value1, Integer value2) {
			addCriterion("visibility not between", value1, value2, "visibility");
			return this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("mobile is null");
			return this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("mobile is not null");
			return this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("mobile =", value, "mobile");
			return this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("mobile <>", value, "mobile");
			return this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("mobile >", value, "mobile");
			return this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("mobile >=", value, "mobile");
			return this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("mobile <", value, "mobile");
			return this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("mobile <=", value, "mobile");
			return this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("mobile like", value, "mobile");
			return this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("mobile not like", value, "mobile");
			return this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("mobile in", values, "mobile");
			return this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("mobile not in", values, "mobile");
			return this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("mobile between", value1, value2, "mobile");
			return this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("mobile not between", value1, value2, "mobile");
			return this;
		}

		public Criteria andPhoneIsNull() {
			addCriterion("phone is null");
			return this;
		}

		public Criteria andPhoneIsNotNull() {
			addCriterion("phone is not null");
			return this;
		}

		public Criteria andPhoneEqualTo(String value) {
			addCriterion("phone =", value, "phone");
			return this;
		}

		public Criteria andPhoneNotEqualTo(String value) {
			addCriterion("phone <>", value, "phone");
			return this;
		}

		public Criteria andPhoneGreaterThan(String value) {
			addCriterion("phone >", value, "phone");
			return this;
		}

		public Criteria andPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("phone >=", value, "phone");
			return this;
		}

		public Criteria andPhoneLessThan(String value) {
			addCriterion("phone <", value, "phone");
			return this;
		}

		public Criteria andPhoneLessThanOrEqualTo(String value) {
			addCriterion("phone <=", value, "phone");
			return this;
		}

		public Criteria andPhoneLike(String value) {
			addCriterion("phone like", value, "phone");
			return this;
		}

		public Criteria andPhoneNotLike(String value) {
			addCriterion("phone not like", value, "phone");
			return this;
		}

		public Criteria andPhoneIn(List<String> values) {
			addCriterion("phone in", values, "phone");
			return this;
		}

		public Criteria andPhoneNotIn(List<String> values) {
			addCriterion("phone not in", values, "phone");
			return this;
		}

		public Criteria andPhoneBetween(String value1, String value2) {
			addCriterion("phone between", value1, value2, "phone");
			return this;
		}

		public Criteria andPhoneNotBetween(String value1, String value2) {
			addCriterion("phone not between", value1, value2, "phone");
			return this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return this;
		}

		public Criteria andCityIsNull() {
			addCriterion("city is null");
			return this;
		}

		public Criteria andCityIsNotNull() {
			addCriterion("city is not null");
			return this;
		}

		public Criteria andCityEqualTo(String value) {
			addCriterion("city =", value, "city");
			return this;
		}

		public Criteria andCityNotEqualTo(String value) {
			addCriterion("city <>", value, "city");
			return this;
		}

		public Criteria andCityGreaterThan(String value) {
			addCriterion("city >", value, "city");
			return this;
		}

		public Criteria andCityGreaterThanOrEqualTo(String value) {
			addCriterion("city >=", value, "city");
			return this;
		}

		public Criteria andCityLessThan(String value) {
			addCriterion("city <", value, "city");
			return this;
		}

		public Criteria andCityLessThanOrEqualTo(String value) {
			addCriterion("city <=", value, "city");
			return this;
		}

		public Criteria andCityLike(String value) {
			addCriterion("city like", value, "city");
			return this;
		}

		public Criteria andCityNotLike(String value) {
			addCriterion("city not like", value, "city");
			return this;
		}

		public Criteria andCityIn(List<String> values) {
			addCriterion("city in", values, "city");
			return this;
		}

		public Criteria andCityNotIn(List<String> values) {
			addCriterion("city not in", values, "city");
			return this;
		}

		public Criteria andCityBetween(String value1, String value2) {
			addCriterion("city between", value1, value2, "city");
			return this;
		}

		public Criteria andCityNotBetween(String value1, String value2) {
			addCriterion("city not between", value1, value2, "city");
			return this;
		}

		public Criteria andStateProvinceIsNull() {
			addCriterion("state_province is null");
			return this;
		}

		public Criteria andStateProvinceIsNotNull() {
			addCriterion("state_province is not null");
			return this;
		}

		public Criteria andStateProvinceEqualTo(String value) {
			addCriterion("state_province =", value, "stateProvince");
			return this;
		}

		public Criteria andStateProvinceNotEqualTo(String value) {
			addCriterion("state_province <>", value, "stateProvince");
			return this;
		}

		public Criteria andStateProvinceGreaterThan(String value) {
			addCriterion("state_province >", value, "stateProvince");
			return this;
		}

		public Criteria andStateProvinceGreaterThanOrEqualTo(String value) {
			addCriterion("state_province >=", value, "stateProvince");
			return this;
		}

		public Criteria andStateProvinceLessThan(String value) {
			addCriterion("state_province <", value, "stateProvince");
			return this;
		}

		public Criteria andStateProvinceLessThanOrEqualTo(String value) {
			addCriterion("state_province <=", value, "stateProvince");
			return this;
		}

		public Criteria andStateProvinceLike(String value) {
			addCriterion("state_province like", value, "stateProvince");
			return this;
		}

		public Criteria andStateProvinceNotLike(String value) {
			addCriterion("state_province not like", value, "stateProvince");
			return this;
		}

		public Criteria andStateProvinceIn(List<String> values) {
			addCriterion("state_province in", values, "stateProvince");
			return this;
		}

		public Criteria andStateProvinceNotIn(List<String> values) {
			addCriterion("state_province not in", values, "stateProvince");
			return this;
		}

		public Criteria andStateProvinceBetween(String value1, String value2) {
			addCriterion("state_province between", value1, value2,
					"stateProvince");
			return this;
		}

		public Criteria andStateProvinceNotBetween(String value1, String value2) {
			addCriterion("state_province not between", value1, value2,
					"stateProvince");
			return this;
		}

		public Criteria andCountryIsNull() {
			addCriterion("country is null");
			return this;
		}

		public Criteria andCountryIsNotNull() {
			addCriterion("country is not null");
			return this;
		}

		public Criteria andCountryEqualTo(String value) {
			addCriterion("country =", value, "country");
			return this;
		}

		public Criteria andCountryNotEqualTo(String value) {
			addCriterion("country <>", value, "country");
			return this;
		}

		public Criteria andCountryGreaterThan(String value) {
			addCriterion("country >", value, "country");
			return this;
		}

		public Criteria andCountryGreaterThanOrEqualTo(String value) {
			addCriterion("country >=", value, "country");
			return this;
		}

		public Criteria andCountryLessThan(String value) {
			addCriterion("country <", value, "country");
			return this;
		}

		public Criteria andCountryLessThanOrEqualTo(String value) {
			addCriterion("country <=", value, "country");
			return this;
		}

		public Criteria andCountryLike(String value) {
			addCriterion("country like", value, "country");
			return this;
		}

		public Criteria andCountryNotLike(String value) {
			addCriterion("country not like", value, "country");
			return this;
		}

		public Criteria andCountryIn(List<String> values) {
			addCriterion("country in", values, "country");
			return this;
		}

		public Criteria andCountryNotIn(List<String> values) {
			addCriterion("country not in", values, "country");
			return this;
		}

		public Criteria andCountryBetween(String value1, String value2) {
			addCriterion("country between", value1, value2, "country");
			return this;
		}

		public Criteria andCountryNotBetween(String value1, String value2) {
			addCriterion("country not between", value1, value2, "country");
			return this;
		}

		public Criteria andZipCodeIsNull() {
			addCriterion("zip_code is null");
			return this;
		}

		public Criteria andZipCodeIsNotNull() {
			addCriterion("zip_code is not null");
			return this;
		}

		public Criteria andZipCodeEqualTo(String value) {
			addCriterion("zip_code =", value, "zipCode");
			return this;
		}

		public Criteria andZipCodeNotEqualTo(String value) {
			addCriterion("zip_code <>", value, "zipCode");
			return this;
		}

		public Criteria andZipCodeGreaterThan(String value) {
			addCriterion("zip_code >", value, "zipCode");
			return this;
		}

		public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
			addCriterion("zip_code >=", value, "zipCode");
			return this;
		}

		public Criteria andZipCodeLessThan(String value) {
			addCriterion("zip_code <", value, "zipCode");
			return this;
		}

		public Criteria andZipCodeLessThanOrEqualTo(String value) {
			addCriterion("zip_code <=", value, "zipCode");
			return this;
		}

		public Criteria andZipCodeLike(String value) {
			addCriterion("zip_code like", value, "zipCode");
			return this;
		}

		public Criteria andZipCodeNotLike(String value) {
			addCriterion("zip_code not like", value, "zipCode");
			return this;
		}

		public Criteria andZipCodeIn(List<String> values) {
			addCriterion("zip_code in", values, "zipCode");
			return this;
		}

		public Criteria andZipCodeNotIn(List<String> values) {
			addCriterion("zip_code not in", values, "zipCode");
			return this;
		}

		public Criteria andZipCodeBetween(String value1, String value2) {
			addCriterion("zip_code between", value1, value2, "zipCode");
			return this;
		}

		public Criteria andZipCodeNotBetween(String value1, String value2) {
			addCriterion("zip_code not between", value1, value2, "zipCode");
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