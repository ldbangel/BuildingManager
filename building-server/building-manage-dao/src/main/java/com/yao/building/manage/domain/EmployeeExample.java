package com.yao.building.manage.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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
            addCriterion("Fid is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Fid is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Fid =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Fid <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Fid >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Fid >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Fid <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Fid <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Fid in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Fid not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Fid between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Fid not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileIsNull() {
            addCriterion("Femployee_mobile is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileIsNotNull() {
            addCriterion("Femployee_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileEqualTo(String value) {
            addCriterion("Femployee_mobile =", value, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileNotEqualTo(String value) {
            addCriterion("Femployee_mobile <>", value, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileGreaterThan(String value) {
            addCriterion("Femployee_mobile >", value, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileGreaterThanOrEqualTo(String value) {
            addCriterion("Femployee_mobile >=", value, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileLessThan(String value) {
            addCriterion("Femployee_mobile <", value, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileLessThanOrEqualTo(String value) {
            addCriterion("Femployee_mobile <=", value, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileLike(String value) {
            addCriterion("Femployee_mobile like", value, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileNotLike(String value) {
            addCriterion("Femployee_mobile not like", value, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileIn(List<String> values) {
            addCriterion("Femployee_mobile in", values, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileNotIn(List<String> values) {
            addCriterion("Femployee_mobile not in", values, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileBetween(String value1, String value2) {
            addCriterion("Femployee_mobile between", value1, value2, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andEmployeeMobileNotBetween(String value1, String value2) {
            addCriterion("Femployee_mobile not between", value1, value2, "employeeMobile");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("Fpassword is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("Fpassword is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("Fpassword =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("Fpassword <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("Fpassword >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("Fpassword >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("Fpassword <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("Fpassword <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("Fpassword like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("Fpassword not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("Fpassword in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("Fpassword not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("Fpassword between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("Fpassword not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("Fid_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("Fid_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("Fid_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("Fid_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("Fid_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("Fid_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("Fid_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("Fid_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("Fid_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("Fid_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("Fid_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("Fid_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("Fid_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("Fid_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNull() {
            addCriterion("Femployee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("Femployee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("Femployee_name =", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("Femployee_name <>", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("Femployee_name >", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("Femployee_name >=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("Femployee_name <", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("Femployee_name <=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLike(String value) {
            addCriterion("Femployee_name like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("Femployee_name not like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("Femployee_name in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("Femployee_name not in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("Femployee_name between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("Femployee_name not between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleIsNull() {
            addCriterion("Femployee_role is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleIsNotNull() {
            addCriterion("Femployee_role is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleEqualTo(Integer value) {
            addCriterion("Femployee_role =", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleNotEqualTo(Integer value) {
            addCriterion("Femployee_role <>", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleGreaterThan(Integer value) {
            addCriterion("Femployee_role >", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("Femployee_role >=", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleLessThan(Integer value) {
            addCriterion("Femployee_role <", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleLessThanOrEqualTo(Integer value) {
            addCriterion("Femployee_role <=", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleIn(List<Integer> values) {
            addCriterion("Femployee_role in", values, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleNotIn(List<Integer> values) {
            addCriterion("Femployee_role not in", values, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleBetween(Integer value1, Integer value2) {
            addCriterion("Femployee_role between", value1, value2, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("Femployee_role not between", value1, value2, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescIsNull() {
            addCriterion("Femployee_role_desc is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescIsNotNull() {
            addCriterion("Femployee_role_desc is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescEqualTo(String value) {
            addCriterion("Femployee_role_desc =", value, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescNotEqualTo(String value) {
            addCriterion("Femployee_role_desc <>", value, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescGreaterThan(String value) {
            addCriterion("Femployee_role_desc >", value, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescGreaterThanOrEqualTo(String value) {
            addCriterion("Femployee_role_desc >=", value, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescLessThan(String value) {
            addCriterion("Femployee_role_desc <", value, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescLessThanOrEqualTo(String value) {
            addCriterion("Femployee_role_desc <=", value, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescLike(String value) {
            addCriterion("Femployee_role_desc like", value, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescNotLike(String value) {
            addCriterion("Femployee_role_desc not like", value, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescIn(List<String> values) {
            addCriterion("Femployee_role_desc in", values, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescNotIn(List<String> values) {
            addCriterion("Femployee_role_desc not in", values, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescBetween(String value1, String value2) {
            addCriterion("Femployee_role_desc between", value1, value2, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleDescNotBetween(String value1, String value2) {
            addCriterion("Femployee_role_desc not between", value1, value2, "employeeRoleDesc");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Fstatus is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Fstatus is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Fstatus =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Fstatus <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Fstatus >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Fstatus >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Fstatus <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Fstatus <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Fstatus in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Fstatus not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Fstatus between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Fstatus not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("Fcreate_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("Fcreate_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("Fcreate_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("Fcreate_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("Fcreate_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Fcreate_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("Fcreate_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("Fcreate_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("Fcreate_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("Fcreate_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("Fcreate_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("Fcreate_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("Fmodify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("Fmodify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("Fmodify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("Fmodify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("Fmodify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Fmodify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("Fmodify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("Fmodify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("Fmodify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("Fmodify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("Fmodify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("Fmodify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("Foperator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("Foperator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("Foperator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("Foperator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("Foperator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("Foperator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("Foperator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("Foperator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("Foperator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("Foperator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("Foperator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("Foperator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("Foperator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("Foperator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("Fversion is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("Fversion is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("Fversion =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("Fversion <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("Fversion >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("Fversion >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("Fversion <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("Fversion <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("Fversion in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("Fversion not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("Fversion between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("Fversion not between", value1, value2, "version");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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