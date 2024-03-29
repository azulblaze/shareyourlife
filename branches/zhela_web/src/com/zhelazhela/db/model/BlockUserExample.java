package com.zhelazhela.db.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockUserExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public BlockUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    protected BlockUserExample(BlockUserExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
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
     * This method corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table block_user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
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

        public Criteria andBlockedUserIdIsNull() {
            addCriterion("blocked_user_id is null");
            return this;
        }

        public Criteria andBlockedUserIdIsNotNull() {
            addCriterion("blocked_user_id is not null");
            return this;
        }

        public Criteria andBlockedUserIdEqualTo(Long value) {
            addCriterion("blocked_user_id =", value, "blockedUserId");
            return this;
        }

        public Criteria andBlockedUserIdNotEqualTo(Long value) {
            addCriterion("blocked_user_id <>", value, "blockedUserId");
            return this;
        }

        public Criteria andBlockedUserIdGreaterThan(Long value) {
            addCriterion("blocked_user_id >", value, "blockedUserId");
            return this;
        }

        public Criteria andBlockedUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("blocked_user_id >=", value, "blockedUserId");
            return this;
        }

        public Criteria andBlockedUserIdLessThan(Long value) {
            addCriterion("blocked_user_id <", value, "blockedUserId");
            return this;
        }

        public Criteria andBlockedUserIdLessThanOrEqualTo(Long value) {
            addCriterion("blocked_user_id <=", value, "blockedUserId");
            return this;
        }

        public Criteria andBlockedUserIdIn(List<Long> values) {
            addCriterion("blocked_user_id in", values, "blockedUserId");
            return this;
        }

        public Criteria andBlockedUserIdNotIn(List<Long> values) {
            addCriterion("blocked_user_id not in", values, "blockedUserId");
            return this;
        }

        public Criteria andBlockedUserIdBetween(Long value1, Long value2) {
            addCriterion("blocked_user_id between", value1, value2, "blockedUserId");
            return this;
        }

        public Criteria andBlockedUserIdNotBetween(Long value1, Long value2) {
            addCriterion("blocked_user_id not between", value1, value2, "blockedUserId");
            return this;
        }
    }
}