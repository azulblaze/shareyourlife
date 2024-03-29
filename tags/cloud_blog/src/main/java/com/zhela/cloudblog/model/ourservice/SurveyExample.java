package com.zhela.cloudblog.model.ourservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhela.cloudblog.model.DefaultExample;

public class SurveyExample extends DefaultExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public SurveyExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	protected SurveyExample(SurveyExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table survey
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
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

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("description is null");
			return this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("description is not null");
			return this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("description =", value, "description");
			return this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("description <>", value, "description");
			return this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("description >", value, "description");
			return this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("description >=", value, "description");
			return this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("description <", value, "description");
			return this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("description <=", value, "description");
			return this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("description like", value, "description");
			return this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("description not like", value, "description");
			return this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("description in", values, "description");
			return this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("description not in", values, "description");
			return this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("description between", value1, value2, "description");
			return this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("description not between", value1, value2,
					"description");
			return this;
		}

		public Criteria andPermissionIsNull() {
			addCriterion("permission is null");
			return this;
		}

		public Criteria andPermissionIsNotNull() {
			addCriterion("permission is not null");
			return this;
		}

		public Criteria andPermissionEqualTo(String value) {
			addCriterion("permission =", value, "permission");
			return this;
		}

		public Criteria andPermissionNotEqualTo(String value) {
			addCriterion("permission <>", value, "permission");
			return this;
		}

		public Criteria andPermissionGreaterThan(String value) {
			addCriterion("permission >", value, "permission");
			return this;
		}

		public Criteria andPermissionGreaterThanOrEqualTo(String value) {
			addCriterion("permission >=", value, "permission");
			return this;
		}

		public Criteria andPermissionLessThan(String value) {
			addCriterion("permission <", value, "permission");
			return this;
		}

		public Criteria andPermissionLessThanOrEqualTo(String value) {
			addCriterion("permission <=", value, "permission");
			return this;
		}

		public Criteria andPermissionLike(String value) {
			addCriterion("permission like", value, "permission");
			return this;
		}

		public Criteria andPermissionNotLike(String value) {
			addCriterion("permission not like", value, "permission");
			return this;
		}

		public Criteria andPermissionIn(List<String> values) {
			addCriterion("permission in", values, "permission");
			return this;
		}

		public Criteria andPermissionNotIn(List<String> values) {
			addCriterion("permission not in", values, "permission");
			return this;
		}

		public Criteria andPermissionBetween(String value1, String value2) {
			addCriterion("permission between", value1, value2, "permission");
			return this;
		}

		public Criteria andPermissionNotBetween(String value1, String value2) {
			addCriterion("permission not between", value1, value2, "permission");
			return this;
		}

		public Criteria andPermissionParamIsNull() {
			addCriterion("permission_param is null");
			return this;
		}

		public Criteria andPermissionParamIsNotNull() {
			addCriterion("permission_param is not null");
			return this;
		}

		public Criteria andPermissionParamEqualTo(String value) {
			addCriterion("permission_param =", value, "permissionParam");
			return this;
		}

		public Criteria andPermissionParamNotEqualTo(String value) {
			addCriterion("permission_param <>", value, "permissionParam");
			return this;
		}

		public Criteria andPermissionParamGreaterThan(String value) {
			addCriterion("permission_param >", value, "permissionParam");
			return this;
		}

		public Criteria andPermissionParamGreaterThanOrEqualTo(String value) {
			addCriterion("permission_param >=", value, "permissionParam");
			return this;
		}

		public Criteria andPermissionParamLessThan(String value) {
			addCriterion("permission_param <", value, "permissionParam");
			return this;
		}

		public Criteria andPermissionParamLessThanOrEqualTo(String value) {
			addCriterion("permission_param <=", value, "permissionParam");
			return this;
		}

		public Criteria andPermissionParamLike(String value) {
			addCriterion("permission_param like", value, "permissionParam");
			return this;
		}

		public Criteria andPermissionParamNotLike(String value) {
			addCriterion("permission_param not like", value, "permissionParam");
			return this;
		}

		public Criteria andPermissionParamIn(List<String> values) {
			addCriterion("permission_param in", values, "permissionParam");
			return this;
		}

		public Criteria andPermissionParamNotIn(List<String> values) {
			addCriterion("permission_param not in", values, "permissionParam");
			return this;
		}

		public Criteria andPermissionParamBetween(String value1, String value2) {
			addCriterion("permission_param between", value1, value2,
					"permissionParam");
			return this;
		}

		public Criteria andPermissionParamNotBetween(String value1,
				String value2) {
			addCriterion("permission_param not between", value1, value2,
					"permissionParam");
			return this;
		}

		public Criteria andViewTimeIsNull() {
			addCriterion("view_time is null");
			return this;
		}

		public Criteria andViewTimeIsNotNull() {
			addCriterion("view_time is not null");
			return this;
		}

		public Criteria andViewTimeEqualTo(String value) {
			addCriterion("view_time =", value, "viewTime");
			return this;
		}

		public Criteria andViewTimeNotEqualTo(String value) {
			addCriterion("view_time <>", value, "viewTime");
			return this;
		}

		public Criteria andViewTimeGreaterThan(String value) {
			addCriterion("view_time >", value, "viewTime");
			return this;
		}

		public Criteria andViewTimeGreaterThanOrEqualTo(String value) {
			addCriterion("view_time >=", value, "viewTime");
			return this;
		}

		public Criteria andViewTimeLessThan(String value) {
			addCriterion("view_time <", value, "viewTime");
			return this;
		}

		public Criteria andViewTimeLessThanOrEqualTo(String value) {
			addCriterion("view_time <=", value, "viewTime");
			return this;
		}

		public Criteria andViewTimeLike(String value) {
			addCriterion("view_time like", value, "viewTime");
			return this;
		}

		public Criteria andViewTimeNotLike(String value) {
			addCriterion("view_time not like", value, "viewTime");
			return this;
		}

		public Criteria andViewTimeIn(List<String> values) {
			addCriterion("view_time in", values, "viewTime");
			return this;
		}

		public Criteria andViewTimeNotIn(List<String> values) {
			addCriterion("view_time not in", values, "viewTime");
			return this;
		}

		public Criteria andViewTimeBetween(String value1, String value2) {
			addCriterion("view_time between", value1, value2, "viewTime");
			return this;
		}

		public Criteria andViewTimeNotBetween(String value1, String value2) {
			addCriterion("view_time not between", value1, value2, "viewTime");
			return this;
		}

		public Criteria andAnswerTimeIsNull() {
			addCriterion("answer_time is null");
			return this;
		}

		public Criteria andAnswerTimeIsNotNull() {
			addCriterion("answer_time is not null");
			return this;
		}

		public Criteria andAnswerTimeEqualTo(Integer value) {
			addCriterion("answer_time =", value, "answerTime");
			return this;
		}

		public Criteria andAnswerTimeNotEqualTo(Integer value) {
			addCriterion("answer_time <>", value, "answerTime");
			return this;
		}

		public Criteria andAnswerTimeGreaterThan(Integer value) {
			addCriterion("answer_time >", value, "answerTime");
			return this;
		}

		public Criteria andAnswerTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("answer_time >=", value, "answerTime");
			return this;
		}

		public Criteria andAnswerTimeLessThan(Integer value) {
			addCriterion("answer_time <", value, "answerTime");
			return this;
		}

		public Criteria andAnswerTimeLessThanOrEqualTo(Integer value) {
			addCriterion("answer_time <=", value, "answerTime");
			return this;
		}

		public Criteria andAnswerTimeIn(List<Integer> values) {
			addCriterion("answer_time in", values, "answerTime");
			return this;
		}

		public Criteria andAnswerTimeNotIn(List<Integer> values) {
			addCriterion("answer_time not in", values, "answerTime");
			return this;
		}

		public Criteria andAnswerTimeBetween(Integer value1, Integer value2) {
			addCriterion("answer_time between", value1, value2, "answerTime");
			return this;
		}

		public Criteria andAnswerTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("answer_time not between", value1, value2,
					"answerTime");
			return this;
		}

		public Criteria andResultPermissionIsNull() {
			addCriterion("result_permission is null");
			return this;
		}

		public Criteria andResultPermissionIsNotNull() {
			addCriterion("result_permission is not null");
			return this;
		}

		public Criteria andResultPermissionEqualTo(String value) {
			addCriterion("result_permission =", value, "resultPermission");
			return this;
		}

		public Criteria andResultPermissionNotEqualTo(String value) {
			addCriterion("result_permission <>", value, "resultPermission");
			return this;
		}

		public Criteria andResultPermissionGreaterThan(String value) {
			addCriterion("result_permission >", value, "resultPermission");
			return this;
		}

		public Criteria andResultPermissionGreaterThanOrEqualTo(String value) {
			addCriterion("result_permission >=", value, "resultPermission");
			return this;
		}

		public Criteria andResultPermissionLessThan(String value) {
			addCriterion("result_permission <", value, "resultPermission");
			return this;
		}

		public Criteria andResultPermissionLessThanOrEqualTo(String value) {
			addCriterion("result_permission <=", value, "resultPermission");
			return this;
		}

		public Criteria andResultPermissionLike(String value) {
			addCriterion("result_permission like", value, "resultPermission");
			return this;
		}

		public Criteria andResultPermissionNotLike(String value) {
			addCriterion("result_permission not like", value,
					"resultPermission");
			return this;
		}

		public Criteria andResultPermissionIn(List<String> values) {
			addCriterion("result_permission in", values, "resultPermission");
			return this;
		}

		public Criteria andResultPermissionNotIn(List<String> values) {
			addCriterion("result_permission not in", values, "resultPermission");
			return this;
		}

		public Criteria andResultPermissionBetween(String value1, String value2) {
			addCriterion("result_permission between", value1, value2,
					"resultPermission");
			return this;
		}

		public Criteria andResultPermissionNotBetween(String value1,
				String value2) {
			addCriterion("result_permission not between", value1, value2,
					"resultPermission");
			return this;
		}

		public Criteria andResultTemplateIsNull() {
			addCriterion("result_template is null");
			return this;
		}

		public Criteria andResultTemplateIsNotNull() {
			addCriterion("result_template is not null");
			return this;
		}

		public Criteria andResultTemplateEqualTo(String value) {
			addCriterion("result_template =", value, "resultTemplate");
			return this;
		}

		public Criteria andResultTemplateNotEqualTo(String value) {
			addCriterion("result_template <>", value, "resultTemplate");
			return this;
		}

		public Criteria andResultTemplateGreaterThan(String value) {
			addCriterion("result_template >", value, "resultTemplate");
			return this;
		}

		public Criteria andResultTemplateGreaterThanOrEqualTo(String value) {
			addCriterion("result_template >=", value, "resultTemplate");
			return this;
		}

		public Criteria andResultTemplateLessThan(String value) {
			addCriterion("result_template <", value, "resultTemplate");
			return this;
		}

		public Criteria andResultTemplateLessThanOrEqualTo(String value) {
			addCriterion("result_template <=", value, "resultTemplate");
			return this;
		}

		public Criteria andResultTemplateLike(String value) {
			addCriterion("result_template like", value, "resultTemplate");
			return this;
		}

		public Criteria andResultTemplateNotLike(String value) {
			addCriterion("result_template not like", value, "resultTemplate");
			return this;
		}

		public Criteria andResultTemplateIn(List<String> values) {
			addCriterion("result_template in", values, "resultTemplate");
			return this;
		}

		public Criteria andResultTemplateNotIn(List<String> values) {
			addCriterion("result_template not in", values, "resultTemplate");
			return this;
		}

		public Criteria andResultTemplateBetween(String value1, String value2) {
			addCriterion("result_template between", value1, value2,
					"resultTemplate");
			return this;
		}

		public Criteria andResultTemplateNotBetween(String value1, String value2) {
			addCriterion("result_template not between", value1, value2,
					"resultTemplate");
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

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
			return this;
		}

		public Criteria andStartTimeIsNull() {
			addCriterion("start_time is null");
			return this;
		}

		public Criteria andStartTimeIsNotNull() {
			addCriterion("start_time is not null");
			return this;
		}

		public Criteria andStartTimeEqualTo(Date value) {
			addCriterion("start_time =", value, "startTime");
			return this;
		}

		public Criteria andStartTimeNotEqualTo(Date value) {
			addCriterion("start_time <>", value, "startTime");
			return this;
		}

		public Criteria andStartTimeGreaterThan(Date value) {
			addCriterion("start_time >", value, "startTime");
			return this;
		}

		public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("start_time >=", value, "startTime");
			return this;
		}

		public Criteria andStartTimeLessThan(Date value) {
			addCriterion("start_time <", value, "startTime");
			return this;
		}

		public Criteria andStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("start_time <=", value, "startTime");
			return this;
		}

		public Criteria andStartTimeIn(List<Date> values) {
			addCriterion("start_time in", values, "startTime");
			return this;
		}

		public Criteria andStartTimeNotIn(List<Date> values) {
			addCriterion("start_time not in", values, "startTime");
			return this;
		}

		public Criteria andStartTimeBetween(Date value1, Date value2) {
			addCriterion("start_time between", value1, value2, "startTime");
			return this;
		}

		public Criteria andStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("start_time not between", value1, value2, "startTime");
			return this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return this;
		}

		public Criteria andEndTimeEqualTo(Date value) {
			addCriterion("end_time =", value, "endTime");
			return this;
		}

		public Criteria andEndTimeNotEqualTo(Date value) {
			addCriterion("end_time <>", value, "endTime");
			return this;
		}

		public Criteria andEndTimeGreaterThan(Date value) {
			addCriterion("end_time >", value, "endTime");
			return this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("end_time >=", value, "endTime");
			return this;
		}

		public Criteria andEndTimeLessThan(Date value) {
			addCriterion("end_time <", value, "endTime");
			return this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("end_time <=", value, "endTime");
			return this;
		}

		public Criteria andEndTimeIn(List<Date> values) {
			addCriterion("end_time in", values, "endTime");
			return this;
		}

		public Criteria andEndTimeNotIn(List<Date> values) {
			addCriterion("end_time not in", values, "endTime");
			return this;
		}

		public Criteria andEndTimeBetween(Date value1, Date value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return this;
		}

		public Criteria andEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
			return this;
		}
	}
}