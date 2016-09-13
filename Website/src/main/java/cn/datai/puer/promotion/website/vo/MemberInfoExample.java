package cn.datai.puer.promotion.website.vo;

import cn.datai.puer.promotion.website.vo.plugins.Page;
import java.util.ArrayList;
import java.util.List;

public class MemberInfoExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public MemberInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
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
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: MEMBER_INFO
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

        public Criteria andMemberIdIsNull() {
            addCriterion("MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("MEMBER_ID =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("MEMBER_ID <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("MEMBER_ID >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("MEMBER_ID <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("MEMBER_ID like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("MEMBER_ID not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("MEMBER_ID in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("MEMBER_ID not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("MEMBER_ID between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("MEMBER_ID not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNull() {
            addCriterion("MEMBER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNotNull() {
            addCriterion("MEMBER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("MEMBER_NAME =", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("MEMBER_NAME <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("MEMBER_NAME >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_NAME >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("MEMBER_NAME <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_NAME <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLike(String value) {
            addCriterion("MEMBER_NAME like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotLike(String value) {
            addCriterion("MEMBER_NAME not like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("MEMBER_NAME in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("MEMBER_NAME not in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("MEMBER_NAME between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("MEMBER_NAME not between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberUrlIsNull() {
            addCriterion("MEMBER_URL is null");
            return (Criteria) this;
        }

        public Criteria andMemberUrlIsNotNull() {
            addCriterion("MEMBER_URL is not null");
            return (Criteria) this;
        }

        public Criteria andMemberUrlEqualTo(String value) {
            addCriterion("MEMBER_URL =", value, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlNotEqualTo(String value) {
            addCriterion("MEMBER_URL <>", value, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlGreaterThan(String value) {
            addCriterion("MEMBER_URL >", value, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_URL >=", value, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlLessThan(String value) {
            addCriterion("MEMBER_URL <", value, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_URL <=", value, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlLike(String value) {
            addCriterion("MEMBER_URL like", value, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlNotLike(String value) {
            addCriterion("MEMBER_URL not like", value, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlIn(List<String> values) {
            addCriterion("MEMBER_URL in", values, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlNotIn(List<String> values) {
            addCriterion("MEMBER_URL not in", values, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlBetween(String value1, String value2) {
            addCriterion("MEMBER_URL between", value1, value2, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberUrlNotBetween(String value1, String value2) {
            addCriterion("MEMBER_URL not between", value1, value2, "memberUrl");
            return (Criteria) this;
        }

        public Criteria andMemberStatusIsNull() {
            addCriterion("MEMBER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMemberStatusIsNotNull() {
            addCriterion("MEMBER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMemberStatusEqualTo(String value) {
            addCriterion("MEMBER_STATUS =", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotEqualTo(String value) {
            addCriterion("MEMBER_STATUS <>", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusGreaterThan(String value) {
            addCriterion("MEMBER_STATUS >", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_STATUS >=", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusLessThan(String value) {
            addCriterion("MEMBER_STATUS <", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_STATUS <=", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusLike(String value) {
            addCriterion("MEMBER_STATUS like", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotLike(String value) {
            addCriterion("MEMBER_STATUS not like", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusIn(List<String> values) {
            addCriterion("MEMBER_STATUS in", values, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotIn(List<String> values) {
            addCriterion("MEMBER_STATUS not in", values, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusBetween(String value1, String value2) {
            addCriterion("MEMBER_STATUS between", value1, value2, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotBetween(String value1, String value2) {
            addCriterion("MEMBER_STATUS not between", value1, value2, "memberStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table MEMBER_INFO
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: MEMBER_INFO
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