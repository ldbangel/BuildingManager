package com.yao.building.manage.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomFeeWaterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomFeeWaterExample() {
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

        public Criteria andRentFeeIsNull() {
            addCriterion("Frent_fee is null");
            return (Criteria) this;
        }

        public Criteria andRentFeeIsNotNull() {
            addCriterion("Frent_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRentFeeEqualTo(Integer value) {
            addCriterion("Frent_fee =", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeNotEqualTo(Integer value) {
            addCriterion("Frent_fee <>", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeGreaterThan(Integer value) {
            addCriterion("Frent_fee >", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Frent_fee >=", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeLessThan(Integer value) {
            addCriterion("Frent_fee <", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeLessThanOrEqualTo(Integer value) {
            addCriterion("Frent_fee <=", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeIn(List<Integer> values) {
            addCriterion("Frent_fee in", values, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeNotIn(List<Integer> values) {
            addCriterion("Frent_fee not in", values, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeBetween(Integer value1, Integer value2) {
            addCriterion("Frent_fee between", value1, value2, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("Frent_fee not between", value1, value2, "rentFee");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeIsNull() {
            addCriterion("Fenergy_fee is null");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeIsNotNull() {
            addCriterion("Fenergy_fee is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeEqualTo(BigDecimal value) {
            addCriterion("Fenergy_fee =", value, "energyFee");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeNotEqualTo(BigDecimal value) {
            addCriterion("Fenergy_fee <>", value, "energyFee");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeGreaterThan(BigDecimal value) {
            addCriterion("Fenergy_fee >", value, "energyFee");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Fenergy_fee >=", value, "energyFee");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeLessThan(BigDecimal value) {
            addCriterion("Fenergy_fee <", value, "energyFee");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Fenergy_fee <=", value, "energyFee");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeIn(List<BigDecimal> values) {
            addCriterion("Fenergy_fee in", values, "energyFee");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeNotIn(List<BigDecimal> values) {
            addCriterion("Fenergy_fee not in", values, "energyFee");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Fenergy_fee between", value1, value2, "energyFee");
            return (Criteria) this;
        }

        public Criteria andEnergyFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Fenergy_fee not between", value1, value2, "energyFee");
            return (Criteria) this;
        }

        public Criteria andWaterFeeIsNull() {
            addCriterion("Fwater_fee is null");
            return (Criteria) this;
        }

        public Criteria andWaterFeeIsNotNull() {
            addCriterion("Fwater_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWaterFeeEqualTo(BigDecimal value) {
            addCriterion("Fwater_fee =", value, "waterFee");
            return (Criteria) this;
        }

        public Criteria andWaterFeeNotEqualTo(BigDecimal value) {
            addCriterion("Fwater_fee <>", value, "waterFee");
            return (Criteria) this;
        }

        public Criteria andWaterFeeGreaterThan(BigDecimal value) {
            addCriterion("Fwater_fee >", value, "waterFee");
            return (Criteria) this;
        }

        public Criteria andWaterFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Fwater_fee >=", value, "waterFee");
            return (Criteria) this;
        }

        public Criteria andWaterFeeLessThan(BigDecimal value) {
            addCriterion("Fwater_fee <", value, "waterFee");
            return (Criteria) this;
        }

        public Criteria andWaterFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Fwater_fee <=", value, "waterFee");
            return (Criteria) this;
        }

        public Criteria andWaterFeeIn(List<BigDecimal> values) {
            addCriterion("Fwater_fee in", values, "waterFee");
            return (Criteria) this;
        }

        public Criteria andWaterFeeNotIn(List<BigDecimal> values) {
            addCriterion("Fwater_fee not in", values, "waterFee");
            return (Criteria) this;
        }

        public Criteria andWaterFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Fwater_fee between", value1, value2, "waterFee");
            return (Criteria) this;
        }

        public Criteria andWaterFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Fwater_fee not between", value1, value2, "waterFee");
            return (Criteria) this;
        }

        public Criteria andManageFeeIsNull() {
            addCriterion("Fmanage_fee is null");
            return (Criteria) this;
        }

        public Criteria andManageFeeIsNotNull() {
            addCriterion("Fmanage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andManageFeeEqualTo(Integer value) {
            addCriterion("Fmanage_fee =", value, "manageFee");
            return (Criteria) this;
        }

        public Criteria andManageFeeNotEqualTo(Integer value) {
            addCriterion("Fmanage_fee <>", value, "manageFee");
            return (Criteria) this;
        }

        public Criteria andManageFeeGreaterThan(Integer value) {
            addCriterion("Fmanage_fee >", value, "manageFee");
            return (Criteria) this;
        }

        public Criteria andManageFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Fmanage_fee >=", value, "manageFee");
            return (Criteria) this;
        }

        public Criteria andManageFeeLessThan(Integer value) {
            addCriterion("Fmanage_fee <", value, "manageFee");
            return (Criteria) this;
        }

        public Criteria andManageFeeLessThanOrEqualTo(Integer value) {
            addCriterion("Fmanage_fee <=", value, "manageFee");
            return (Criteria) this;
        }

        public Criteria andManageFeeIn(List<Integer> values) {
            addCriterion("Fmanage_fee in", values, "manageFee");
            return (Criteria) this;
        }

        public Criteria andManageFeeNotIn(List<Integer> values) {
            addCriterion("Fmanage_fee not in", values, "manageFee");
            return (Criteria) this;
        }

        public Criteria andManageFeeBetween(Integer value1, Integer value2) {
            addCriterion("Fmanage_fee between", value1, value2, "manageFee");
            return (Criteria) this;
        }

        public Criteria andManageFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("Fmanage_fee not between", value1, value2, "manageFee");
            return (Criteria) this;
        }

        public Criteria andCleanFeeIsNull() {
            addCriterion("Fclean_fee is null");
            return (Criteria) this;
        }

        public Criteria andCleanFeeIsNotNull() {
            addCriterion("Fclean_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCleanFeeEqualTo(Integer value) {
            addCriterion("Fclean_fee =", value, "cleanFee");
            return (Criteria) this;
        }

        public Criteria andCleanFeeNotEqualTo(Integer value) {
            addCriterion("Fclean_fee <>", value, "cleanFee");
            return (Criteria) this;
        }

        public Criteria andCleanFeeGreaterThan(Integer value) {
            addCriterion("Fclean_fee >", value, "cleanFee");
            return (Criteria) this;
        }

        public Criteria andCleanFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Fclean_fee >=", value, "cleanFee");
            return (Criteria) this;
        }

        public Criteria andCleanFeeLessThan(Integer value) {
            addCriterion("Fclean_fee <", value, "cleanFee");
            return (Criteria) this;
        }

        public Criteria andCleanFeeLessThanOrEqualTo(Integer value) {
            addCriterion("Fclean_fee <=", value, "cleanFee");
            return (Criteria) this;
        }

        public Criteria andCleanFeeIn(List<Integer> values) {
            addCriterion("Fclean_fee in", values, "cleanFee");
            return (Criteria) this;
        }

        public Criteria andCleanFeeNotIn(List<Integer> values) {
            addCriterion("Fclean_fee not in", values, "cleanFee");
            return (Criteria) this;
        }

        public Criteria andCleanFeeBetween(Integer value1, Integer value2) {
            addCriterion("Fclean_fee between", value1, value2, "cleanFee");
            return (Criteria) this;
        }

        public Criteria andCleanFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("Fclean_fee not between", value1, value2, "cleanFee");
            return (Criteria) this;
        }

        public Criteria andInternetFeeIsNull() {
            addCriterion("Finternet_fee is null");
            return (Criteria) this;
        }

        public Criteria andInternetFeeIsNotNull() {
            addCriterion("Finternet_fee is not null");
            return (Criteria) this;
        }

        public Criteria andInternetFeeEqualTo(Integer value) {
            addCriterion("Finternet_fee =", value, "internetFee");
            return (Criteria) this;
        }

        public Criteria andInternetFeeNotEqualTo(Integer value) {
            addCriterion("Finternet_fee <>", value, "internetFee");
            return (Criteria) this;
        }

        public Criteria andInternetFeeGreaterThan(Integer value) {
            addCriterion("Finternet_fee >", value, "internetFee");
            return (Criteria) this;
        }

        public Criteria andInternetFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Finternet_fee >=", value, "internetFee");
            return (Criteria) this;
        }

        public Criteria andInternetFeeLessThan(Integer value) {
            addCriterion("Finternet_fee <", value, "internetFee");
            return (Criteria) this;
        }

        public Criteria andInternetFeeLessThanOrEqualTo(Integer value) {
            addCriterion("Finternet_fee <=", value, "internetFee");
            return (Criteria) this;
        }

        public Criteria andInternetFeeIn(List<Integer> values) {
            addCriterion("Finternet_fee in", values, "internetFee");
            return (Criteria) this;
        }

        public Criteria andInternetFeeNotIn(List<Integer> values) {
            addCriterion("Finternet_fee not in", values, "internetFee");
            return (Criteria) this;
        }

        public Criteria andInternetFeeBetween(Integer value1, Integer value2) {
            addCriterion("Finternet_fee between", value1, value2, "internetFee");
            return (Criteria) this;
        }

        public Criteria andInternetFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("Finternet_fee not between", value1, value2, "internetFee");
            return (Criteria) this;
        }

        public Criteria andAllFeeIsNull() {
            addCriterion("Fall_fee is null");
            return (Criteria) this;
        }

        public Criteria andAllFeeIsNotNull() {
            addCriterion("Fall_fee is not null");
            return (Criteria) this;
        }

        public Criteria andAllFeeEqualTo(BigDecimal value) {
            addCriterion("Fall_fee =", value, "allFee");
            return (Criteria) this;
        }

        public Criteria andAllFeeNotEqualTo(BigDecimal value) {
            addCriterion("Fall_fee <>", value, "allFee");
            return (Criteria) this;
        }

        public Criteria andAllFeeGreaterThan(BigDecimal value) {
            addCriterion("Fall_fee >", value, "allFee");
            return (Criteria) this;
        }

        public Criteria andAllFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Fall_fee >=", value, "allFee");
            return (Criteria) this;
        }

        public Criteria andAllFeeLessThan(BigDecimal value) {
            addCriterion("Fall_fee <", value, "allFee");
            return (Criteria) this;
        }

        public Criteria andAllFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Fall_fee <=", value, "allFee");
            return (Criteria) this;
        }

        public Criteria andAllFeeIn(List<BigDecimal> values) {
            addCriterion("Fall_fee in", values, "allFee");
            return (Criteria) this;
        }

        public Criteria andAllFeeNotIn(List<BigDecimal> values) {
            addCriterion("Fall_fee not in", values, "allFee");
            return (Criteria) this;
        }

        public Criteria andAllFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Fall_fee between", value1, value2, "allFee");
            return (Criteria) this;
        }

        public Criteria andAllFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Fall_fee not between", value1, value2, "allFee");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("Fpay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("Fpay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("Fpay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("Fpay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("Fpay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Fpay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("Fpay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Fpay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("Fpay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("Fpay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("Fpay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Fpay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeIsNull() {
            addCriterion("Fstart_fee_time is null");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeIsNotNull() {
            addCriterion("Fstart_fee_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeEqualTo(Date value) {
            addCriterion("Fstart_fee_time =", value, "startFeeTime");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeNotEqualTo(Date value) {
            addCriterion("Fstart_fee_time <>", value, "startFeeTime");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeGreaterThan(Date value) {
            addCriterion("Fstart_fee_time >", value, "startFeeTime");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Fstart_fee_time >=", value, "startFeeTime");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeLessThan(Date value) {
            addCriterion("Fstart_fee_time <", value, "startFeeTime");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeLessThanOrEqualTo(Date value) {
            addCriterion("Fstart_fee_time <=", value, "startFeeTime");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeIn(List<Date> values) {
            addCriterion("Fstart_fee_time in", values, "startFeeTime");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeNotIn(List<Date> values) {
            addCriterion("Fstart_fee_time not in", values, "startFeeTime");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeBetween(Date value1, Date value2) {
            addCriterion("Fstart_fee_time between", value1, value2, "startFeeTime");
            return (Criteria) this;
        }

        public Criteria andStartFeeTimeNotBetween(Date value1, Date value2) {
            addCriterion("Fstart_fee_time not between", value1, value2, "startFeeTime");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeIsNull() {
            addCriterion("Fend_fee_time is null");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeIsNotNull() {
            addCriterion("Fend_fee_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeEqualTo(Date value) {
            addCriterion("Fend_fee_time =", value, "endFeeTime");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeNotEqualTo(Date value) {
            addCriterion("Fend_fee_time <>", value, "endFeeTime");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeGreaterThan(Date value) {
            addCriterion("Fend_fee_time >", value, "endFeeTime");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Fend_fee_time >=", value, "endFeeTime");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeLessThan(Date value) {
            addCriterion("Fend_fee_time <", value, "endFeeTime");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeLessThanOrEqualTo(Date value) {
            addCriterion("Fend_fee_time <=", value, "endFeeTime");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeIn(List<Date> values) {
            addCriterion("Fend_fee_time in", values, "endFeeTime");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeNotIn(List<Date> values) {
            addCriterion("Fend_fee_time not in", values, "endFeeTime");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeBetween(Date value1, Date value2) {
            addCriterion("Fend_fee_time between", value1, value2, "endFeeTime");
            return (Criteria) this;
        }

        public Criteria andEndFeeTimeNotBetween(Date value1, Date value2) {
            addCriterion("Fend_fee_time not between", value1, value2, "endFeeTime");
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