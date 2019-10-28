package com.yao.building.manage.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("Fusername is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("Fusername is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("Fusername =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("Fusername <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("Fusername >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("Fusername >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("Fusername <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("Fusername <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("Fusername like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("Fusername not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("Fusername in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("Fusername not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("Fusername between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("Fusername not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNull() {
            addCriterion("Fuser_mobile is null");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNotNull() {
            addCriterion("Fuser_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andUserMobileEqualTo(String value) {
            addCriterion("Fuser_mobile =", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotEqualTo(String value) {
            addCriterion("Fuser_mobile <>", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThan(String value) {
            addCriterion("Fuser_mobile >", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("Fuser_mobile >=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThan(String value) {
            addCriterion("Fuser_mobile <", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThanOrEqualTo(String value) {
            addCriterion("Fuser_mobile <=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLike(String value) {
            addCriterion("Fuser_mobile like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotLike(String value) {
            addCriterion("Fuser_mobile not like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileIn(List<String> values) {
            addCriterion("Fuser_mobile in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotIn(List<String> values) {
            addCriterion("Fuser_mobile not in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileBetween(String value1, String value2) {
            addCriterion("Fuser_mobile between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotBetween(String value1, String value2) {
            addCriterion("Fuser_mobile not between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserIdCardIsNull() {
            addCriterion("Fuser_id_card is null");
            return (Criteria) this;
        }

        public Criteria andUserIdCardIsNotNull() {
            addCriterion("Fuser_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdCardEqualTo(String value) {
            addCriterion("Fuser_id_card =", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardNotEqualTo(String value) {
            addCriterion("Fuser_id_card <>", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardGreaterThan(String value) {
            addCriterion("Fuser_id_card >", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("Fuser_id_card >=", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardLessThan(String value) {
            addCriterion("Fuser_id_card <", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardLessThanOrEqualTo(String value) {
            addCriterion("Fuser_id_card <=", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardLike(String value) {
            addCriterion("Fuser_id_card like", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardNotLike(String value) {
            addCriterion("Fuser_id_card not like", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardIn(List<String> values) {
            addCriterion("Fuser_id_card in", values, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardNotIn(List<String> values) {
            addCriterion("Fuser_id_card not in", values, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardBetween(String value1, String value2) {
            addCriterion("Fuser_id_card between", value1, value2, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardNotBetween(String value1, String value2) {
            addCriterion("Fuser_id_card not between", value1, value2, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1IsNull() {
            addCriterion("Fid_card_url1 is null");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1IsNotNull() {
            addCriterion("Fid_card_url1 is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1EqualTo(String value) {
            addCriterion("Fid_card_url1 =", value, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1NotEqualTo(String value) {
            addCriterion("Fid_card_url1 <>", value, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1GreaterThan(String value) {
            addCriterion("Fid_card_url1 >", value, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1GreaterThanOrEqualTo(String value) {
            addCriterion("Fid_card_url1 >=", value, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1LessThan(String value) {
            addCriterion("Fid_card_url1 <", value, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1LessThanOrEqualTo(String value) {
            addCriterion("Fid_card_url1 <=", value, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1Like(String value) {
            addCriterion("Fid_card_url1 like", value, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1NotLike(String value) {
            addCriterion("Fid_card_url1 not like", value, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1In(List<String> values) {
            addCriterion("Fid_card_url1 in", values, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1NotIn(List<String> values) {
            addCriterion("Fid_card_url1 not in", values, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1Between(String value1, String value2) {
            addCriterion("Fid_card_url1 between", value1, value2, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl1NotBetween(String value1, String value2) {
            addCriterion("Fid_card_url1 not between", value1, value2, "idCardUrl1");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2IsNull() {
            addCriterion("Fid_card_url2 is null");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2IsNotNull() {
            addCriterion("Fid_card_url2 is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2EqualTo(String value) {
            addCriterion("Fid_card_url2 =", value, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2NotEqualTo(String value) {
            addCriterion("Fid_card_url2 <>", value, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2GreaterThan(String value) {
            addCriterion("Fid_card_url2 >", value, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2GreaterThanOrEqualTo(String value) {
            addCriterion("Fid_card_url2 >=", value, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2LessThan(String value) {
            addCriterion("Fid_card_url2 <", value, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2LessThanOrEqualTo(String value) {
            addCriterion("Fid_card_url2 <=", value, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2Like(String value) {
            addCriterion("Fid_card_url2 like", value, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2NotLike(String value) {
            addCriterion("Fid_card_url2 not like", value, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2In(List<String> values) {
            addCriterion("Fid_card_url2 in", values, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2NotIn(List<String> values) {
            addCriterion("Fid_card_url2 not in", values, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2Between(String value1, String value2) {
            addCriterion("Fid_card_url2 between", value1, value2, "idCardUrl2");
            return (Criteria) this;
        }

        public Criteria andIdCardUrl2NotBetween(String value1, String value2) {
            addCriterion("Fid_card_url2 not between", value1, value2, "idCardUrl2");
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

        public Criteria andRentBeginTimeIsNull() {
            addCriterion("Frent_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeIsNotNull() {
            addCriterion("Frent_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeEqualTo(Date value) {
            addCriterion("Frent_begin_time =", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeNotEqualTo(Date value) {
            addCriterion("Frent_begin_time <>", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeGreaterThan(Date value) {
            addCriterion("Frent_begin_time >", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Frent_begin_time >=", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeLessThan(Date value) {
            addCriterion("Frent_begin_time <", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("Frent_begin_time <=", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeIn(List<Date> values) {
            addCriterion("Frent_begin_time in", values, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeNotIn(List<Date> values) {
            addCriterion("Frent_begin_time not in", values, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeBetween(Date value1, Date value2) {
            addCriterion("Frent_begin_time between", value1, value2, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("Frent_begin_time not between", value1, value2, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeIsNull() {
            addCriterion("Frent_end_time is null");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeIsNotNull() {
            addCriterion("Frent_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeEqualTo(Date value) {
            addCriterion("Frent_end_time =", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeNotEqualTo(Date value) {
            addCriterion("Frent_end_time <>", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeGreaterThan(Date value) {
            addCriterion("Frent_end_time >", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Frent_end_time >=", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeLessThan(Date value) {
            addCriterion("Frent_end_time <", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("Frent_end_time <=", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeIn(List<Date> values) {
            addCriterion("Frent_end_time in", values, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeNotIn(List<Date> values) {
            addCriterion("Frent_end_time not in", values, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeBetween(Date value1, Date value2) {
            addCriterion("Frent_end_time between", value1, value2, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("Frent_end_time not between", value1, value2, "rentEndTime");
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