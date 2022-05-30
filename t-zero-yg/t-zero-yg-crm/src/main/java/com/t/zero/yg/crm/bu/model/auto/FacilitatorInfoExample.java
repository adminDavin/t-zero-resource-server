package com.t.zero.yg.crm.bu.model.auto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FacilitatorInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public FacilitatorInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
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
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
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

        public Criteria andPvCodeIsNull() {
            addCriterion("pv_code is null");
            return (Criteria) this;
        }

        public Criteria andPvCodeIsNotNull() {
            addCriterion("pv_code is not null");
            return (Criteria) this;
        }

        public Criteria andPvCodeEqualTo(String value) {
            addCriterion("pv_code =", value, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeNotEqualTo(String value) {
            addCriterion("pv_code <>", value, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeGreaterThan(String value) {
            addCriterion("pv_code >", value, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pv_code >=", value, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeLessThan(String value) {
            addCriterion("pv_code <", value, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeLessThanOrEqualTo(String value) {
            addCriterion("pv_code <=", value, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeLike(String value) {
            addCriterion("pv_code like", value, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeNotLike(String value) {
            addCriterion("pv_code not like", value, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeIn(List<String> values) {
            addCriterion("pv_code in", values, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeNotIn(List<String> values) {
            addCriterion("pv_code not in", values, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeBetween(String value1, String value2) {
            addCriterion("pv_code between", value1, value2, "pvCode");
            return (Criteria) this;
        }

        public Criteria andPvCodeNotBetween(String value1, String value2) {
            addCriterion("pv_code not between", value1, value2, "pvCode");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Integer value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Integer value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Integer value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Integer value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Integer value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Integer> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Integer> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Integer value1, Integer value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNull() {
            addCriterion("corp_id is null");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNotNull() {
            addCriterion("corp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCorpIdEqualTo(Integer value) {
            addCriterion("corp_id =", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotEqualTo(Integer value) {
            addCriterion("corp_id <>", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThan(Integer value) {
            addCriterion("corp_id >", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("corp_id >=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThan(Integer value) {
            addCriterion("corp_id <", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThanOrEqualTo(Integer value) {
            addCriterion("corp_id <=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdIn(List<Integer> values) {
            addCriterion("corp_id in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotIn(List<Integer> values) {
            addCriterion("corp_id not in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdBetween(Integer value1, Integer value2) {
            addCriterion("corp_id between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("corp_id not between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpCodeIsNull() {
            addCriterion("corp_code is null");
            return (Criteria) this;
        }

        public Criteria andCorpCodeIsNotNull() {
            addCriterion("corp_code is not null");
            return (Criteria) this;
        }

        public Criteria andCorpCodeEqualTo(String value) {
            addCriterion("corp_code =", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotEqualTo(String value) {
            addCriterion("corp_code <>", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeGreaterThan(String value) {
            addCriterion("corp_code >", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("corp_code >=", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeLessThan(String value) {
            addCriterion("corp_code <", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeLessThanOrEqualTo(String value) {
            addCriterion("corp_code <=", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeLike(String value) {
            addCriterion("corp_code like", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotLike(String value) {
            addCriterion("corp_code not like", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeIn(List<String> values) {
            addCriterion("corp_code in", values, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotIn(List<String> values) {
            addCriterion("corp_code not in", values, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeBetween(String value1, String value2) {
            addCriterion("corp_code between", value1, value2, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotBetween(String value1, String value2) {
            addCriterion("corp_code not between", value1, value2, "corpCode");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameIsNull() {
            addCriterion("facilitator_name is null");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameIsNotNull() {
            addCriterion("facilitator_name is not null");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameEqualTo(String value) {
            addCriterion("facilitator_name =", value, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameNotEqualTo(String value) {
            addCriterion("facilitator_name <>", value, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameGreaterThan(String value) {
            addCriterion("facilitator_name >", value, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("facilitator_name >=", value, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameLessThan(String value) {
            addCriterion("facilitator_name <", value, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameLessThanOrEqualTo(String value) {
            addCriterion("facilitator_name <=", value, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameLike(String value) {
            addCriterion("facilitator_name like", value, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameNotLike(String value) {
            addCriterion("facilitator_name not like", value, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameIn(List<String> values) {
            addCriterion("facilitator_name in", values, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameNotIn(List<String> values) {
            addCriterion("facilitator_name not in", values, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameBetween(String value1, String value2) {
            addCriterion("facilitator_name between", value1, value2, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorNameNotBetween(String value1, String value2) {
            addCriterion("facilitator_name not between", value1, value2, "facilitatorName");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaIsNull() {
            addCriterion("facilitator_quota is null");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaIsNotNull() {
            addCriterion("facilitator_quota is not null");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaEqualTo(String value) {
            addCriterion("facilitator_quota =", value, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaNotEqualTo(String value) {
            addCriterion("facilitator_quota <>", value, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaGreaterThan(String value) {
            addCriterion("facilitator_quota >", value, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaGreaterThanOrEqualTo(String value) {
            addCriterion("facilitator_quota >=", value, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaLessThan(String value) {
            addCriterion("facilitator_quota <", value, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaLessThanOrEqualTo(String value) {
            addCriterion("facilitator_quota <=", value, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaLike(String value) {
            addCriterion("facilitator_quota like", value, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaNotLike(String value) {
            addCriterion("facilitator_quota not like", value, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaIn(List<String> values) {
            addCriterion("facilitator_quota in", values, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaNotIn(List<String> values) {
            addCriterion("facilitator_quota not in", values, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaBetween(String value1, String value2) {
            addCriterion("facilitator_quota between", value1, value2, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andFacilitatorQuotaNotBetween(String value1, String value2) {
            addCriterion("facilitator_quota not between", value1, value2, "facilitatorQuota");
            return (Criteria) this;
        }

        public Criteria andPvStatusIsNull() {
            addCriterion("pv_status is null");
            return (Criteria) this;
        }

        public Criteria andPvStatusIsNotNull() {
            addCriterion("pv_status is not null");
            return (Criteria) this;
        }

        public Criteria andPvStatusEqualTo(String value) {
            addCriterion("pv_status =", value, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusNotEqualTo(String value) {
            addCriterion("pv_status <>", value, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusGreaterThan(String value) {
            addCriterion("pv_status >", value, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pv_status >=", value, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusLessThan(String value) {
            addCriterion("pv_status <", value, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusLessThanOrEqualTo(String value) {
            addCriterion("pv_status <=", value, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusLike(String value) {
            addCriterion("pv_status like", value, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusNotLike(String value) {
            addCriterion("pv_status not like", value, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusIn(List<String> values) {
            addCriterion("pv_status in", values, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusNotIn(List<String> values) {
            addCriterion("pv_status not in", values, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusBetween(String value1, String value2) {
            addCriterion("pv_status between", value1, value2, "pvStatus");
            return (Criteria) this;
        }

        public Criteria andPvStatusNotBetween(String value1, String value2) {
            addCriterion("pv_status not between", value1, value2, "pvStatus");
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

        public Criteria andUpdatedUserIdIsNull() {
            addCriterion("updated_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdIsNotNull() {
            addCriterion("updated_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdEqualTo(String value) {
            addCriterion("updated_user_id =", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdNotEqualTo(String value) {
            addCriterion("updated_user_id <>", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdGreaterThan(String value) {
            addCriterion("updated_user_id >", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("updated_user_id >=", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdLessThan(String value) {
            addCriterion("updated_user_id <", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdLessThanOrEqualTo(String value) {
            addCriterion("updated_user_id <=", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdLike(String value) {
            addCriterion("updated_user_id like", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdNotLike(String value) {
            addCriterion("updated_user_id not like", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdIn(List<String> values) {
            addCriterion("updated_user_id in", values, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdNotIn(List<String> values) {
            addCriterion("updated_user_id not in", values, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdBetween(String value1, String value2) {
            addCriterion("updated_user_id between", value1, value2, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdNotBetween(String value1, String value2) {
            addCriterion("updated_user_id not between", value1, value2, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(LocalDateTime value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(LocalDateTime value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(LocalDateTime value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(LocalDateTime value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<LocalDateTime> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<LocalDateTime> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagEqualTo(String value) {
            addCriterion("is_deleted =", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotEqualTo(String value) {
            addCriterion("is_deleted <>", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagGreaterThan(String value) {
            addCriterion("is_deleted >", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagGreaterThanOrEqualTo(String value) {
            addCriterion("is_deleted >=", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagLessThan(String value) {
            addCriterion("is_deleted <", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagLessThanOrEqualTo(String value) {
            addCriterion("is_deleted <=", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagLike(String value) {
            addCriterion("is_deleted like", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotLike(String value) {
            addCriterion("is_deleted not like", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIn(List<String> values) {
            addCriterion("is_deleted in", values, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotIn(List<String> values) {
            addCriterion("is_deleted not in", values, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagBetween(String value1, String value2) {
            addCriterion("is_deleted between", value1, value2, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotBetween(String value1, String value2) {
            addCriterion("is_deleted not between", value1, value2, "deletedFlag");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated do_not_delete_during_merge Mon May 30 09:12:20 CST 2022
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
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