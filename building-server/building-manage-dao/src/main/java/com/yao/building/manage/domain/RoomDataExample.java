package com.yao.building.manage.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomDataExample() {
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

        public Criteria andRoomIdIsNull() {
            addCriterion("Froom_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("Froom_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("Froom_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("Froom_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("Froom_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Froom_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("Froom_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("Froom_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("Froom_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("Froom_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("Froom_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Froom_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRentIsNull() {
            addCriterion("Frent is null");
            return (Criteria) this;
        }

        public Criteria andRentIsNotNull() {
            addCriterion("Frent is not null");
            return (Criteria) this;
        }

        public Criteria andRentEqualTo(Integer value) {
            addCriterion("Frent =", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotEqualTo(Integer value) {
            addCriterion("Frent <>", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThan(Integer value) {
            addCriterion("Frent >", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThanOrEqualTo(Integer value) {
            addCriterion("Frent >=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThan(Integer value) {
            addCriterion("Frent <", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThanOrEqualTo(Integer value) {
            addCriterion("Frent <=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentIn(List<Integer> values) {
            addCriterion("Frent in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotIn(List<Integer> values) {
            addCriterion("Frent not in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentBetween(Integer value1, Integer value2) {
            addCriterion("Frent between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotBetween(Integer value1, Integer value2) {
            addCriterion("Frent not between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andEnergyNumIsNull() {
            addCriterion("Fenergy_num is null");
            return (Criteria) this;
        }

        public Criteria andEnergyNumIsNotNull() {
            addCriterion("Fenergy_num is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyNumEqualTo(Integer value) {
            addCriterion("Fenergy_num =", value, "energyNum");
            return (Criteria) this;
        }

        public Criteria andEnergyNumNotEqualTo(Integer value) {
            addCriterion("Fenergy_num <>", value, "energyNum");
            return (Criteria) this;
        }

        public Criteria andEnergyNumGreaterThan(Integer value) {
            addCriterion("Fenergy_num >", value, "energyNum");
            return (Criteria) this;
        }

        public Criteria andEnergyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Fenergy_num >=", value, "energyNum");
            return (Criteria) this;
        }

        public Criteria andEnergyNumLessThan(Integer value) {
            addCriterion("Fenergy_num <", value, "energyNum");
            return (Criteria) this;
        }

        public Criteria andEnergyNumLessThanOrEqualTo(Integer value) {
            addCriterion("Fenergy_num <=", value, "energyNum");
            return (Criteria) this;
        }

        public Criteria andEnergyNumIn(List<Integer> values) {
            addCriterion("Fenergy_num in", values, "energyNum");
            return (Criteria) this;
        }

        public Criteria andEnergyNumNotIn(List<Integer> values) {
            addCriterion("Fenergy_num not in", values, "energyNum");
            return (Criteria) this;
        }

        public Criteria andEnergyNumBetween(Integer value1, Integer value2) {
            addCriterion("Fenergy_num between", value1, value2, "energyNum");
            return (Criteria) this;
        }

        public Criteria andEnergyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("Fenergy_num not between", value1, value2, "energyNum");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountIsNull() {
            addCriterion("Fenergy_use_count is null");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountIsNotNull() {
            addCriterion("Fenergy_use_count is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountEqualTo(Integer value) {
            addCriterion("Fenergy_use_count =", value, "energyUseCount");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountNotEqualTo(Integer value) {
            addCriterion("Fenergy_use_count <>", value, "energyUseCount");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountGreaterThan(Integer value) {
            addCriterion("Fenergy_use_count >", value, "energyUseCount");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Fenergy_use_count >=", value, "energyUseCount");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountLessThan(Integer value) {
            addCriterion("Fenergy_use_count <", value, "energyUseCount");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountLessThanOrEqualTo(Integer value) {
            addCriterion("Fenergy_use_count <=", value, "energyUseCount");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountIn(List<Integer> values) {
            addCriterion("Fenergy_use_count in", values, "energyUseCount");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountNotIn(List<Integer> values) {
            addCriterion("Fenergy_use_count not in", values, "energyUseCount");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountBetween(Integer value1, Integer value2) {
            addCriterion("Fenergy_use_count between", value1, value2, "energyUseCount");
            return (Criteria) this;
        }

        public Criteria andEnergyUseCountNotBetween(Integer value1, Integer value2) {
            addCriterion("Fenergy_use_count not between", value1, value2, "energyUseCount");
            return (Criteria) this;
        }

        public Criteria andWaterNumIsNull() {
            addCriterion("Fwater_num is null");
            return (Criteria) this;
        }

        public Criteria andWaterNumIsNotNull() {
            addCriterion("Fwater_num is not null");
            return (Criteria) this;
        }

        public Criteria andWaterNumEqualTo(Integer value) {
            addCriterion("Fwater_num =", value, "waterNum");
            return (Criteria) this;
        }

        public Criteria andWaterNumNotEqualTo(Integer value) {
            addCriterion("Fwater_num <>", value, "waterNum");
            return (Criteria) this;
        }

        public Criteria andWaterNumGreaterThan(Integer value) {
            addCriterion("Fwater_num >", value, "waterNum");
            return (Criteria) this;
        }

        public Criteria andWaterNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Fwater_num >=", value, "waterNum");
            return (Criteria) this;
        }

        public Criteria andWaterNumLessThan(Integer value) {
            addCriterion("Fwater_num <", value, "waterNum");
            return (Criteria) this;
        }

        public Criteria andWaterNumLessThanOrEqualTo(Integer value) {
            addCriterion("Fwater_num <=", value, "waterNum");
            return (Criteria) this;
        }

        public Criteria andWaterNumIn(List<Integer> values) {
            addCriterion("Fwater_num in", values, "waterNum");
            return (Criteria) this;
        }

        public Criteria andWaterNumNotIn(List<Integer> values) {
            addCriterion("Fwater_num not in", values, "waterNum");
            return (Criteria) this;
        }

        public Criteria andWaterNumBetween(Integer value1, Integer value2) {
            addCriterion("Fwater_num between", value1, value2, "waterNum");
            return (Criteria) this;
        }

        public Criteria andWaterNumNotBetween(Integer value1, Integer value2) {
            addCriterion("Fwater_num not between", value1, value2, "waterNum");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountIsNull() {
            addCriterion("Fwater_use_count is null");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountIsNotNull() {
            addCriterion("Fwater_use_count is not null");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountEqualTo(Integer value) {
            addCriterion("Fwater_use_count =", value, "waterUseCount");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountNotEqualTo(Integer value) {
            addCriterion("Fwater_use_count <>", value, "waterUseCount");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountGreaterThan(Integer value) {
            addCriterion("Fwater_use_count >", value, "waterUseCount");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Fwater_use_count >=", value, "waterUseCount");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountLessThan(Integer value) {
            addCriterion("Fwater_use_count <", value, "waterUseCount");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountLessThanOrEqualTo(Integer value) {
            addCriterion("Fwater_use_count <=", value, "waterUseCount");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountIn(List<Integer> values) {
            addCriterion("Fwater_use_count in", values, "waterUseCount");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountNotIn(List<Integer> values) {
            addCriterion("Fwater_use_count not in", values, "waterUseCount");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountBetween(Integer value1, Integer value2) {
            addCriterion("Fwater_use_count between", value1, value2, "waterUseCount");
            return (Criteria) this;
        }

        public Criteria andWaterUseCountNotBetween(Integer value1, Integer value2) {
            addCriterion("Fwater_use_count not between", value1, value2, "waterUseCount");
            return (Criteria) this;
        }

        public Criteria andRentStatusIsNull() {
            addCriterion("Frent_status is null");
            return (Criteria) this;
        }

        public Criteria andRentStatusIsNotNull() {
            addCriterion("Frent_status is not null");
            return (Criteria) this;
        }

        public Criteria andRentStatusEqualTo(Integer value) {
            addCriterion("Frent_status =", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusNotEqualTo(Integer value) {
            addCriterion("Frent_status <>", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusGreaterThan(Integer value) {
            addCriterion("Frent_status >", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Frent_status >=", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusLessThan(Integer value) {
            addCriterion("Frent_status <", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Frent_status <=", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusIn(List<Integer> values) {
            addCriterion("Frent_status in", values, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusNotIn(List<Integer> values) {
            addCriterion("Frent_status not in", values, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusBetween(Integer value1, Integer value2) {
            addCriterion("Frent_status between", value1, value2, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Frent_status not between", value1, value2, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNull() {
            addCriterion("Fread_time is null");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNotNull() {
            addCriterion("Fread_time is not null");
            return (Criteria) this;
        }

        public Criteria andReadTimeEqualTo(Date value) {
            addCriterion("Fread_time =", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotEqualTo(Date value) {
            addCriterion("Fread_time <>", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThan(Date value) {
            addCriterion("Fread_time >", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Fread_time >=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThan(Date value) {
            addCriterion("Fread_time <", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThanOrEqualTo(Date value) {
            addCriterion("Fread_time <=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeIn(List<Date> values) {
            addCriterion("Fread_time in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotIn(List<Date> values) {
            addCriterion("Fread_time not in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeBetween(Date value1, Date value2) {
            addCriterion("Fread_time between", value1, value2, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotBetween(Date value1, Date value2) {
            addCriterion("Fread_time not between", value1, value2, "readTime");
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