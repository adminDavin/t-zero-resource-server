package com.t.zero.cust.app.bu.model.auto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustRelTagGroupExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public CustRelTagGroupExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeIsNull() {
            addCriterion("tag_info_code is null");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeIsNotNull() {
            addCriterion("tag_info_code is not null");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeEqualTo(String value) {
            addCriterion("tag_info_code =", value, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeNotEqualTo(String value) {
            addCriterion("tag_info_code <>", value, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeGreaterThan(String value) {
            addCriterion("tag_info_code >", value, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tag_info_code >=", value, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeLessThan(String value) {
            addCriterion("tag_info_code <", value, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeLessThanOrEqualTo(String value) {
            addCriterion("tag_info_code <=", value, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeLike(String value) {
            addCriterion("tag_info_code like", value, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeNotLike(String value) {
            addCriterion("tag_info_code not like", value, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeIn(List<String> values) {
            addCriterion("tag_info_code in", values, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeNotIn(List<String> values) {
            addCriterion("tag_info_code not in", values, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeBetween(String value1, String value2) {
            addCriterion("tag_info_code between", value1, value2, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoCodeNotBetween(String value1, String value2) {
            addCriterion("tag_info_code not between", value1, value2, "tagInfoCode");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameIsNull() {
            addCriterion("tag_info_name is null");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameIsNotNull() {
            addCriterion("tag_info_name is not null");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameEqualTo(String value) {
            addCriterion("tag_info_name =", value, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameNotEqualTo(String value) {
            addCriterion("tag_info_name <>", value, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameGreaterThan(String value) {
            addCriterion("tag_info_name >", value, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameGreaterThanOrEqualTo(String value) {
            addCriterion("tag_info_name >=", value, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameLessThan(String value) {
            addCriterion("tag_info_name <", value, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameLessThanOrEqualTo(String value) {
            addCriterion("tag_info_name <=", value, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameLike(String value) {
            addCriterion("tag_info_name like", value, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameNotLike(String value) {
            addCriterion("tag_info_name not like", value, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameIn(List<String> values) {
            addCriterion("tag_info_name in", values, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameNotIn(List<String> values) {
            addCriterion("tag_info_name not in", values, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameBetween(String value1, String value2) {
            addCriterion("tag_info_name between", value1, value2, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagInfoNameNotBetween(String value1, String value2) {
            addCriterion("tag_info_name not between", value1, value2, "tagInfoName");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeIsNull() {
            addCriterion("tag_group_code is null");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeIsNotNull() {
            addCriterion("tag_group_code is not null");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeEqualTo(String value) {
            addCriterion("tag_group_code =", value, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeNotEqualTo(String value) {
            addCriterion("tag_group_code <>", value, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeGreaterThan(String value) {
            addCriterion("tag_group_code >", value, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tag_group_code >=", value, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeLessThan(String value) {
            addCriterion("tag_group_code <", value, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeLessThanOrEqualTo(String value) {
            addCriterion("tag_group_code <=", value, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeLike(String value) {
            addCriterion("tag_group_code like", value, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeNotLike(String value) {
            addCriterion("tag_group_code not like", value, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeIn(List<String> values) {
            addCriterion("tag_group_code in", values, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeNotIn(List<String> values) {
            addCriterion("tag_group_code not in", values, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeBetween(String value1, String value2) {
            addCriterion("tag_group_code between", value1, value2, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupCodeNotBetween(String value1, String value2) {
            addCriterion("tag_group_code not between", value1, value2, "tagGroupCode");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameIsNull() {
            addCriterion("tag_group_name is null");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameIsNotNull() {
            addCriterion("tag_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameEqualTo(String value) {
            addCriterion("tag_group_name =", value, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameNotEqualTo(String value) {
            addCriterion("tag_group_name <>", value, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameGreaterThan(String value) {
            addCriterion("tag_group_name >", value, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("tag_group_name >=", value, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameLessThan(String value) {
            addCriterion("tag_group_name <", value, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameLessThanOrEqualTo(String value) {
            addCriterion("tag_group_name <=", value, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameLike(String value) {
            addCriterion("tag_group_name like", value, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameNotLike(String value) {
            addCriterion("tag_group_name not like", value, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameIn(List<String> values) {
            addCriterion("tag_group_name in", values, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameNotIn(List<String> values) {
            addCriterion("tag_group_name not in", values, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameBetween(String value1, String value2) {
            addCriterion("tag_group_name between", value1, value2, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andTagGroupNameNotBetween(String value1, String value2) {
            addCriterion("tag_group_name not between", value1, value2, "tagGroupName");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdIsNull() {
            addCriterion("created_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdIsNotNull() {
            addCriterion("created_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdEqualTo(String value) {
            addCriterion("created_user_id =", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdNotEqualTo(String value) {
            addCriterion("created_user_id <>", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdGreaterThan(String value) {
            addCriterion("created_user_id >", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("created_user_id >=", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdLessThan(String value) {
            addCriterion("created_user_id <", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdLessThanOrEqualTo(String value) {
            addCriterion("created_user_id <=", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdLike(String value) {
            addCriterion("created_user_id like", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdNotLike(String value) {
            addCriterion("created_user_id not like", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdIn(List<String> values) {
            addCriterion("created_user_id in", values, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdNotIn(List<String> values) {
            addCriterion("created_user_id not in", values, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdBetween(String value1, String value2) {
            addCriterion("created_user_id between", value1, value2, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdNotBetween(String value1, String value2) {
            addCriterion("created_user_id not between", value1, value2, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(LocalDateTime value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(LocalDateTime value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(LocalDateTime value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(LocalDateTime value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<LocalDateTime> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<LocalDateTime> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated do_not_delete_during_merge Tue Apr 12 10:26:08 CST 2022
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_zero_cust_rel_tag_group
     *
     * @mbg.generated Tue Apr 12 10:26:08 CST 2022
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}