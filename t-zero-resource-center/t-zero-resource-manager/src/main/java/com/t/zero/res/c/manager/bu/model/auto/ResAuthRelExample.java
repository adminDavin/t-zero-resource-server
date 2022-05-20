package com.t.zero.res.c.manager.bu.model.auto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResAuthRelExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public ResAuthRelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
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
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
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

        public Criteria andResAuthIdIsNull() {
            addCriterion("res_auth_id is null");
            return (Criteria) this;
        }

        public Criteria andResAuthIdIsNotNull() {
            addCriterion("res_auth_id is not null");
            return (Criteria) this;
        }

        public Criteria andResAuthIdEqualTo(Integer value) {
            addCriterion("res_auth_id =", value, "resAuthId");
            return (Criteria) this;
        }

        public Criteria andResAuthIdNotEqualTo(Integer value) {
            addCriterion("res_auth_id <>", value, "resAuthId");
            return (Criteria) this;
        }

        public Criteria andResAuthIdGreaterThan(Integer value) {
            addCriterion("res_auth_id >", value, "resAuthId");
            return (Criteria) this;
        }

        public Criteria andResAuthIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_auth_id >=", value, "resAuthId");
            return (Criteria) this;
        }

        public Criteria andResAuthIdLessThan(Integer value) {
            addCriterion("res_auth_id <", value, "resAuthId");
            return (Criteria) this;
        }

        public Criteria andResAuthIdLessThanOrEqualTo(Integer value) {
            addCriterion("res_auth_id <=", value, "resAuthId");
            return (Criteria) this;
        }

        public Criteria andResAuthIdIn(List<Integer> values) {
            addCriterion("res_auth_id in", values, "resAuthId");
            return (Criteria) this;
        }

        public Criteria andResAuthIdNotIn(List<Integer> values) {
            addCriterion("res_auth_id not in", values, "resAuthId");
            return (Criteria) this;
        }

        public Criteria andResAuthIdBetween(Integer value1, Integer value2) {
            addCriterion("res_auth_id between", value1, value2, "resAuthId");
            return (Criteria) this;
        }

        public Criteria andResAuthIdNotBetween(Integer value1, Integer value2) {
            addCriterion("res_auth_id not between", value1, value2, "resAuthId");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeIsNull() {
            addCriterion("res_auth_code is null");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeIsNotNull() {
            addCriterion("res_auth_code is not null");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeEqualTo(String value) {
            addCriterion("res_auth_code =", value, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeNotEqualTo(String value) {
            addCriterion("res_auth_code <>", value, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeGreaterThan(String value) {
            addCriterion("res_auth_code >", value, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeGreaterThanOrEqualTo(String value) {
            addCriterion("res_auth_code >=", value, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeLessThan(String value) {
            addCriterion("res_auth_code <", value, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeLessThanOrEqualTo(String value) {
            addCriterion("res_auth_code <=", value, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeLike(String value) {
            addCriterion("res_auth_code like", value, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeNotLike(String value) {
            addCriterion("res_auth_code not like", value, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeIn(List<String> values) {
            addCriterion("res_auth_code in", values, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeNotIn(List<String> values) {
            addCriterion("res_auth_code not in", values, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeBetween(String value1, String value2) {
            addCriterion("res_auth_code between", value1, value2, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthCodeNotBetween(String value1, String value2) {
            addCriterion("res_auth_code not between", value1, value2, "resAuthCode");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeIsNull() {
            addCriterion("res_auth_type is null");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeIsNotNull() {
            addCriterion("res_auth_type is not null");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeEqualTo(String value) {
            addCriterion("res_auth_type =", value, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeNotEqualTo(String value) {
            addCriterion("res_auth_type <>", value, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeGreaterThan(String value) {
            addCriterion("res_auth_type >", value, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeGreaterThanOrEqualTo(String value) {
            addCriterion("res_auth_type >=", value, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeLessThan(String value) {
            addCriterion("res_auth_type <", value, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeLessThanOrEqualTo(String value) {
            addCriterion("res_auth_type <=", value, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeLike(String value) {
            addCriterion("res_auth_type like", value, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeNotLike(String value) {
            addCriterion("res_auth_type not like", value, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeIn(List<String> values) {
            addCriterion("res_auth_type in", values, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeNotIn(List<String> values) {
            addCriterion("res_auth_type not in", values, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeBetween(String value1, String value2) {
            addCriterion("res_auth_type between", value1, value2, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthTypeNotBetween(String value1, String value2) {
            addCriterion("res_auth_type not between", value1, value2, "resAuthType");
            return (Criteria) this;
        }

        public Criteria andResAuthPathIsNull() {
            addCriterion("res_auth_path is null");
            return (Criteria) this;
        }

        public Criteria andResAuthPathIsNotNull() {
            addCriterion("res_auth_path is not null");
            return (Criteria) this;
        }

        public Criteria andResAuthPathEqualTo(String value) {
            addCriterion("res_auth_path =", value, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathNotEqualTo(String value) {
            addCriterion("res_auth_path <>", value, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathGreaterThan(String value) {
            addCriterion("res_auth_path >", value, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathGreaterThanOrEqualTo(String value) {
            addCriterion("res_auth_path >=", value, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathLessThan(String value) {
            addCriterion("res_auth_path <", value, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathLessThanOrEqualTo(String value) {
            addCriterion("res_auth_path <=", value, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathLike(String value) {
            addCriterion("res_auth_path like", value, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathNotLike(String value) {
            addCriterion("res_auth_path not like", value, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathIn(List<String> values) {
            addCriterion("res_auth_path in", values, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathNotIn(List<String> values) {
            addCriterion("res_auth_path not in", values, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathBetween(String value1, String value2) {
            addCriterion("res_auth_path between", value1, value2, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResAuthPathNotBetween(String value1, String value2) {
            addCriterion("res_auth_path not between", value1, value2, "resAuthPath");
            return (Criteria) this;
        }

        public Criteria andResInfoIdIsNull() {
            addCriterion("res_info_id is null");
            return (Criteria) this;
        }

        public Criteria andResInfoIdIsNotNull() {
            addCriterion("res_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andResInfoIdEqualTo(Integer value) {
            addCriterion("res_info_id =", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdNotEqualTo(Integer value) {
            addCriterion("res_info_id <>", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdGreaterThan(Integer value) {
            addCriterion("res_info_id >", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_info_id >=", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdLessThan(Integer value) {
            addCriterion("res_info_id <", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("res_info_id <=", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdIn(List<Integer> values) {
            addCriterion("res_info_id in", values, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdNotIn(List<Integer> values) {
            addCriterion("res_info_id not in", values, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("res_info_id between", value1, value2, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("res_info_id not between", value1, value2, "resInfoId");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated do_not_delete_during_merge Tue May 17 13:12:23 CST 2022
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
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