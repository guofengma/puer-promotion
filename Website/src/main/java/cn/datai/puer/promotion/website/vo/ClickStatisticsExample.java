package cn.datai.puer.promotion.website.vo;

import cn.datai.puer.promotion.website.vo.plugins.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClickStatisticsExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public ClickStatisticsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
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

        public Criteria andClickIdIsNull() {
            addCriterion("CLICK_ID is null");
            return (Criteria) this;
        }

        public Criteria andClickIdIsNotNull() {
            addCriterion("CLICK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andClickIdEqualTo(String value) {
            addCriterion("CLICK_ID =", value, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdNotEqualTo(String value) {
            addCriterion("CLICK_ID <>", value, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdGreaterThan(String value) {
            addCriterion("CLICK_ID >", value, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdGreaterThanOrEqualTo(String value) {
            addCriterion("CLICK_ID >=", value, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdLessThan(String value) {
            addCriterion("CLICK_ID <", value, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdLessThanOrEqualTo(String value) {
            addCriterion("CLICK_ID <=", value, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdLike(String value) {
            addCriterion("CLICK_ID like", value, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdNotLike(String value) {
            addCriterion("CLICK_ID not like", value, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdIn(List<String> values) {
            addCriterion("CLICK_ID in", values, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdNotIn(List<String> values) {
            addCriterion("CLICK_ID not in", values, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdBetween(String value1, String value2) {
            addCriterion("CLICK_ID between", value1, value2, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickIdNotBetween(String value1, String value2) {
            addCriterion("CLICK_ID not between", value1, value2, "clickId");
            return (Criteria) this;
        }

        public Criteria andClickTypeIsNull() {
            addCriterion("CLICK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andClickTypeIsNotNull() {
            addCriterion("CLICK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andClickTypeEqualTo(String value) {
            addCriterion("CLICK_TYPE =", value, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeNotEqualTo(String value) {
            addCriterion("CLICK_TYPE <>", value, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeGreaterThan(String value) {
            addCriterion("CLICK_TYPE >", value, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CLICK_TYPE >=", value, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeLessThan(String value) {
            addCriterion("CLICK_TYPE <", value, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeLessThanOrEqualTo(String value) {
            addCriterion("CLICK_TYPE <=", value, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeLike(String value) {
            addCriterion("CLICK_TYPE like", value, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeNotLike(String value) {
            addCriterion("CLICK_TYPE not like", value, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeIn(List<String> values) {
            addCriterion("CLICK_TYPE in", values, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeNotIn(List<String> values) {
            addCriterion("CLICK_TYPE not in", values, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeBetween(String value1, String value2) {
            addCriterion("CLICK_TYPE between", value1, value2, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTypeNotBetween(String value1, String value2) {
            addCriterion("CLICK_TYPE not between", value1, value2, "clickType");
            return (Criteria) this;
        }

        public Criteria andClickTimeIsNull() {
            addCriterion("CLICK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andClickTimeIsNotNull() {
            addCriterion("CLICK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andClickTimeEqualTo(Date value) {
            addCriterion("CLICK_TIME =", value, "clickTime");
            return (Criteria) this;
        }

        public Criteria andClickTimeNotEqualTo(Date value) {
            addCriterion("CLICK_TIME <>", value, "clickTime");
            return (Criteria) this;
        }

        public Criteria andClickTimeGreaterThan(Date value) {
            addCriterion("CLICK_TIME >", value, "clickTime");
            return (Criteria) this;
        }

        public Criteria andClickTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CLICK_TIME >=", value, "clickTime");
            return (Criteria) this;
        }

        public Criteria andClickTimeLessThan(Date value) {
            addCriterion("CLICK_TIME <", value, "clickTime");
            return (Criteria) this;
        }

        public Criteria andClickTimeLessThanOrEqualTo(Date value) {
            addCriterion("CLICK_TIME <=", value, "clickTime");
            return (Criteria) this;
        }

        public Criteria andClickTimeIn(List<Date> values) {
            addCriterion("CLICK_TIME in", values, "clickTime");
            return (Criteria) this;
        }

        public Criteria andClickTimeNotIn(List<Date> values) {
            addCriterion("CLICK_TIME not in", values, "clickTime");
            return (Criteria) this;
        }

        public Criteria andClickTimeBetween(Date value1, Date value2) {
            addCriterion("CLICK_TIME between", value1, value2, "clickTime");
            return (Criteria) this;
        }

        public Criteria andClickTimeNotBetween(Date value1, Date value2) {
            addCriterion("CLICK_TIME not between", value1, value2, "clickTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table CLICK_STATISTICS
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
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