package com.yao.building.manage.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomInfoWaterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomInfoWaterExample() {
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

        public Criteria andIndexIsNull() {
            addCriterion("Findex is null");
            return (Criteria) this;
        }

        public Criteria andIndexIsNotNull() {
            addCriterion("Findex is not null");
            return (Criteria) this;
        }

        public Criteria andIndexEqualTo(Integer value) {
            addCriterion("Findex =", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotEqualTo(Integer value) {
            addCriterion("Findex <>", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThan(Integer value) {
            addCriterion("Findex >", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("Findex >=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThan(Integer value) {
            addCriterion("Findex <", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThanOrEqualTo(Integer value) {
            addCriterion("Findex <=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexIn(List<Integer> values) {
            addCriterion("Findex in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotIn(List<Integer> values) {
            addCriterion("Findex not in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexBetween(Integer value1, Integer value2) {
            addCriterion("Findex between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("Findex not between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andRoomNoIsNull() {
            addCriterion("Froom_no is null");
            return (Criteria) this;
        }

        public Criteria andRoomNoIsNotNull() {
            addCriterion("Froom_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNoEqualTo(Integer value) {
            addCriterion("Froom_no =", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoNotEqualTo(Integer value) {
            addCriterion("Froom_no <>", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoGreaterThan(Integer value) {
            addCriterion("Froom_no >", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Froom_no >=", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoLessThan(Integer value) {
            addCriterion("Froom_no <", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoLessThanOrEqualTo(Integer value) {
            addCriterion("Froom_no <=", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoIn(List<Integer> values) {
            addCriterion("Froom_no in", values, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoNotIn(List<Integer> values) {
            addCriterion("Froom_no not in", values, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoBetween(Integer value1, Integer value2) {
            addCriterion("Froom_no between", value1, value2, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoNotBetween(Integer value1, Integer value2) {
            addCriterion("Froom_no not between", value1, value2, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomDescIsNull() {
            addCriterion("Froom_desc is null");
            return (Criteria) this;
        }

        public Criteria andRoomDescIsNotNull() {
            addCriterion("Froom_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRoomDescEqualTo(String value) {
            addCriterion("Froom_desc =", value, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescNotEqualTo(String value) {
            addCriterion("Froom_desc <>", value, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescGreaterThan(String value) {
            addCriterion("Froom_desc >", value, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescGreaterThanOrEqualTo(String value) {
            addCriterion("Froom_desc >=", value, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescLessThan(String value) {
            addCriterion("Froom_desc <", value, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescLessThanOrEqualTo(String value) {
            addCriterion("Froom_desc <=", value, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescLike(String value) {
            addCriterion("Froom_desc like", value, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescNotLike(String value) {
            addCriterion("Froom_desc not like", value, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescIn(List<String> values) {
            addCriterion("Froom_desc in", values, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescNotIn(List<String> values) {
            addCriterion("Froom_desc not in", values, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescBetween(String value1, String value2) {
            addCriterion("Froom_desc between", value1, value2, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomDescNotBetween(String value1, String value2) {
            addCriterion("Froom_desc not between", value1, value2, "roomDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNull() {
            addCriterion("Froom_type is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNotNull() {
            addCriterion("Froom_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeEqualTo(Byte value) {
            addCriterion("Froom_type =", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotEqualTo(Byte value) {
            addCriterion("Froom_type <>", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThan(Byte value) {
            addCriterion("Froom_type >", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("Froom_type >=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThan(Byte value) {
            addCriterion("Froom_type <", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThanOrEqualTo(Byte value) {
            addCriterion("Froom_type <=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIn(List<Byte> values) {
            addCriterion("Froom_type in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotIn(List<Byte> values) {
            addCriterion("Froom_type not in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeBetween(Byte value1, Byte value2) {
            addCriterion("Froom_type between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("Froom_type not between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescIsNull() {
            addCriterion("Froom_type_desc is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescIsNotNull() {
            addCriterion("Froom_type_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescEqualTo(String value) {
            addCriterion("Froom_type_desc =", value, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescNotEqualTo(String value) {
            addCriterion("Froom_type_desc <>", value, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescGreaterThan(String value) {
            addCriterion("Froom_type_desc >", value, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("Froom_type_desc >=", value, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescLessThan(String value) {
            addCriterion("Froom_type_desc <", value, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescLessThanOrEqualTo(String value) {
            addCriterion("Froom_type_desc <=", value, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescLike(String value) {
            addCriterion("Froom_type_desc like", value, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescNotLike(String value) {
            addCriterion("Froom_type_desc not like", value, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescIn(List<String> values) {
            addCriterion("Froom_type_desc in", values, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescNotIn(List<String> values) {
            addCriterion("Froom_type_desc not in", values, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescBetween(String value1, String value2) {
            addCriterion("Froom_type_desc between", value1, value2, "roomTypeDesc");
            return (Criteria) this;
        }

        public Criteria andRoomTypeDescNotBetween(String value1, String value2) {
            addCriterion("Froom_type_desc not between", value1, value2, "roomTypeDesc");
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

        public Criteria andRoomStatusIsNull() {
            addCriterion("Froom_status is null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIsNotNull() {
            addCriterion("Froom_status is not null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusEqualTo(Integer value) {
            addCriterion("Froom_status =", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotEqualTo(Integer value) {
            addCriterion("Froom_status <>", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThan(Integer value) {
            addCriterion("Froom_status >", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Froom_status >=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThan(Integer value) {
            addCriterion("Froom_status <", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Froom_status <=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIn(List<Integer> values) {
            addCriterion("Froom_status in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotIn(List<Integer> values) {
            addCriterion("Froom_status not in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusBetween(Integer value1, Integer value2) {
            addCriterion("Froom_status between", value1, value2, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Froom_status not between", value1, value2, "roomStatus");
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