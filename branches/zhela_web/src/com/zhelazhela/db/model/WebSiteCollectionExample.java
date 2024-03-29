package com.zhelazhela.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebSiteCollectionExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public WebSiteCollectionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    protected WebSiteCollectionExample(WebSiteCollectionExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table web_site_collection
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
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

        public Criteria andCollectionTypeIsNull() {
            addCriterion("collection_type is null");
            return this;
        }

        public Criteria andCollectionTypeIsNotNull() {
            addCriterion("collection_type is not null");
            return this;
        }

        public Criteria andCollectionTypeEqualTo(Integer value) {
            addCriterion("collection_type =", value, "collectionType");
            return this;
        }

        public Criteria andCollectionTypeNotEqualTo(Integer value) {
            addCriterion("collection_type <>", value, "collectionType");
            return this;
        }

        public Criteria andCollectionTypeGreaterThan(Integer value) {
            addCriterion("collection_type >", value, "collectionType");
            return this;
        }

        public Criteria andCollectionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_type >=", value, "collectionType");
            return this;
        }

        public Criteria andCollectionTypeLessThan(Integer value) {
            addCriterion("collection_type <", value, "collectionType");
            return this;
        }

        public Criteria andCollectionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("collection_type <=", value, "collectionType");
            return this;
        }

        public Criteria andCollectionTypeIn(List<Integer> values) {
            addCriterion("collection_type in", values, "collectionType");
            return this;
        }

        public Criteria andCollectionTypeNotIn(List<Integer> values) {
            addCriterion("collection_type not in", values, "collectionType");
            return this;
        }

        public Criteria andCollectionTypeBetween(Integer value1, Integer value2) {
            addCriterion("collection_type between", value1, value2, "collectionType");
            return this;
        }

        public Criteria andCollectionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_type not between", value1, value2, "collectionType");
            return this;
        }

        public Criteria andSiteExpIsNull() {
            addCriterion("site_exp is null");
            return this;
        }

        public Criteria andSiteExpIsNotNull() {
            addCriterion("site_exp is not null");
            return this;
        }

        public Criteria andSiteExpEqualTo(String value) {
            addCriterion("site_exp =", value, "siteExp");
            return this;
        }

        public Criteria andSiteExpNotEqualTo(String value) {
            addCriterion("site_exp <>", value, "siteExp");
            return this;
        }

        public Criteria andSiteExpGreaterThan(String value) {
            addCriterion("site_exp >", value, "siteExp");
            return this;
        }

        public Criteria andSiteExpGreaterThanOrEqualTo(String value) {
            addCriterion("site_exp >=", value, "siteExp");
            return this;
        }

        public Criteria andSiteExpLessThan(String value) {
            addCriterion("site_exp <", value, "siteExp");
            return this;
        }

        public Criteria andSiteExpLessThanOrEqualTo(String value) {
            addCriterion("site_exp <=", value, "siteExp");
            return this;
        }

        public Criteria andSiteExpLike(String value) {
            addCriterion("site_exp like", value, "siteExp");
            return this;
        }

        public Criteria andSiteExpNotLike(String value) {
            addCriterion("site_exp not like", value, "siteExp");
            return this;
        }

        public Criteria andSiteExpIn(List<String> values) {
            addCriterion("site_exp in", values, "siteExp");
            return this;
        }

        public Criteria andSiteExpNotIn(List<String> values) {
            addCriterion("site_exp not in", values, "siteExp");
            return this;
        }

        public Criteria andSiteExpBetween(String value1, String value2) {
            addCriterion("site_exp between", value1, value2, "siteExp");
            return this;
        }

        public Criteria andSiteExpNotBetween(String value1, String value2) {
            addCriterion("site_exp not between", value1, value2, "siteExp");
            return this;
        }

        public Criteria andTagStartIsNull() {
            addCriterion("tag_start is null");
            return this;
        }

        public Criteria andTagStartIsNotNull() {
            addCriterion("tag_start is not null");
            return this;
        }

        public Criteria andTagStartEqualTo(String value) {
            addCriterion("tag_start =", value, "tagStart");
            return this;
        }

        public Criteria andTagStartNotEqualTo(String value) {
            addCriterion("tag_start <>", value, "tagStart");
            return this;
        }

        public Criteria andTagStartGreaterThan(String value) {
            addCriterion("tag_start >", value, "tagStart");
            return this;
        }

        public Criteria andTagStartGreaterThanOrEqualTo(String value) {
            addCriterion("tag_start >=", value, "tagStart");
            return this;
        }

        public Criteria andTagStartLessThan(String value) {
            addCriterion("tag_start <", value, "tagStart");
            return this;
        }

        public Criteria andTagStartLessThanOrEqualTo(String value) {
            addCriterion("tag_start <=", value, "tagStart");
            return this;
        }

        public Criteria andTagStartLike(String value) {
            addCriterion("tag_start like", value, "tagStart");
            return this;
        }

        public Criteria andTagStartNotLike(String value) {
            addCriterion("tag_start not like", value, "tagStart");
            return this;
        }

        public Criteria andTagStartIn(List<String> values) {
            addCriterion("tag_start in", values, "tagStart");
            return this;
        }

        public Criteria andTagStartNotIn(List<String> values) {
            addCriterion("tag_start not in", values, "tagStart");
            return this;
        }

        public Criteria andTagStartBetween(String value1, String value2) {
            addCriterion("tag_start between", value1, value2, "tagStart");
            return this;
        }

        public Criteria andTagStartNotBetween(String value1, String value2) {
            addCriterion("tag_start not between", value1, value2, "tagStart");
            return this;
        }

        public Criteria andTagEndIsNull() {
            addCriterion("tag_end is null");
            return this;
        }

        public Criteria andTagEndIsNotNull() {
            addCriterion("tag_end is not null");
            return this;
        }

        public Criteria andTagEndEqualTo(String value) {
            addCriterion("tag_end =", value, "tagEnd");
            return this;
        }

        public Criteria andTagEndNotEqualTo(String value) {
            addCriterion("tag_end <>", value, "tagEnd");
            return this;
        }

        public Criteria andTagEndGreaterThan(String value) {
            addCriterion("tag_end >", value, "tagEnd");
            return this;
        }

        public Criteria andTagEndGreaterThanOrEqualTo(String value) {
            addCriterion("tag_end >=", value, "tagEnd");
            return this;
        }

        public Criteria andTagEndLessThan(String value) {
            addCriterion("tag_end <", value, "tagEnd");
            return this;
        }

        public Criteria andTagEndLessThanOrEqualTo(String value) {
            addCriterion("tag_end <=", value, "tagEnd");
            return this;
        }

        public Criteria andTagEndLike(String value) {
            addCriterion("tag_end like", value, "tagEnd");
            return this;
        }

        public Criteria andTagEndNotLike(String value) {
            addCriterion("tag_end not like", value, "tagEnd");
            return this;
        }

        public Criteria andTagEndIn(List<String> values) {
            addCriterion("tag_end in", values, "tagEnd");
            return this;
        }

        public Criteria andTagEndNotIn(List<String> values) {
            addCriterion("tag_end not in", values, "tagEnd");
            return this;
        }

        public Criteria andTagEndBetween(String value1, String value2) {
            addCriterion("tag_end between", value1, value2, "tagEnd");
            return this;
        }

        public Criteria andTagEndNotBetween(String value1, String value2) {
            addCriterion("tag_end not between", value1, value2, "tagEnd");
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
            addCriterion("update_time not between", value1, value2, "updateTime");
            return this;
        }
    }
}