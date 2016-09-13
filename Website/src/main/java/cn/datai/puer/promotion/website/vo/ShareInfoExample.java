package cn.datai.puer.promotion.website.vo;

import cn.datai.puer.promotion.website.vo.plugins.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareInfoExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public ShareInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
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
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: SHARE_INFO
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

        public Criteria andShareIdIsNull() {
            addCriterion("SHARE_ID is null");
            return (Criteria) this;
        }

        public Criteria andShareIdIsNotNull() {
            addCriterion("SHARE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShareIdEqualTo(String value) {
            addCriterion("SHARE_ID =", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotEqualTo(String value) {
            addCriterion("SHARE_ID <>", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThan(String value) {
            addCriterion("SHARE_ID >", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_ID >=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThan(String value) {
            addCriterion("SHARE_ID <", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThanOrEqualTo(String value) {
            addCriterion("SHARE_ID <=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLike(String value) {
            addCriterion("SHARE_ID like", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotLike(String value) {
            addCriterion("SHARE_ID not like", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdIn(List<String> values) {
            addCriterion("SHARE_ID in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotIn(List<String> values) {
            addCriterion("SHARE_ID not in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdBetween(String value1, String value2) {
            addCriterion("SHARE_ID between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotBetween(String value1, String value2) {
            addCriterion("SHARE_ID not between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andSharePhoneIsNull() {
            addCriterion("SHARE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andSharePhoneIsNotNull() {
            addCriterion("SHARE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andSharePhoneEqualTo(String value) {
            addCriterion("SHARE_PHONE =", value, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneNotEqualTo(String value) {
            addCriterion("SHARE_PHONE <>", value, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneGreaterThan(String value) {
            addCriterion("SHARE_PHONE >", value, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_PHONE >=", value, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneLessThan(String value) {
            addCriterion("SHARE_PHONE <", value, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneLessThanOrEqualTo(String value) {
            addCriterion("SHARE_PHONE <=", value, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneLike(String value) {
            addCriterion("SHARE_PHONE like", value, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneNotLike(String value) {
            addCriterion("SHARE_PHONE not like", value, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneIn(List<String> values) {
            addCriterion("SHARE_PHONE in", values, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneNotIn(List<String> values) {
            addCriterion("SHARE_PHONE not in", values, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneBetween(String value1, String value2) {
            addCriterion("SHARE_PHONE between", value1, value2, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andSharePhoneNotBetween(String value1, String value2) {
            addCriterion("SHARE_PHONE not between", value1, value2, "sharePhone");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdIsNull() {
            addCriterion("SHARE_MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdIsNotNull() {
            addCriterion("SHARE_MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdEqualTo(String value) {
            addCriterion("SHARE_MEMBER_ID =", value, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdNotEqualTo(String value) {
            addCriterion("SHARE_MEMBER_ID <>", value, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdGreaterThan(String value) {
            addCriterion("SHARE_MEMBER_ID >", value, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_MEMBER_ID >=", value, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdLessThan(String value) {
            addCriterion("SHARE_MEMBER_ID <", value, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdLessThanOrEqualTo(String value) {
            addCriterion("SHARE_MEMBER_ID <=", value, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdLike(String value) {
            addCriterion("SHARE_MEMBER_ID like", value, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdNotLike(String value) {
            addCriterion("SHARE_MEMBER_ID not like", value, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdIn(List<String> values) {
            addCriterion("SHARE_MEMBER_ID in", values, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdNotIn(List<String> values) {
            addCriterion("SHARE_MEMBER_ID not in", values, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdBetween(String value1, String value2) {
            addCriterion("SHARE_MEMBER_ID between", value1, value2, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareMemberIdNotBetween(String value1, String value2) {
            addCriterion("SHARE_MEMBER_ID not between", value1, value2, "shareMemberId");
            return (Criteria) this;
        }

        public Criteria andShareAccountIsNull() {
            addCriterion("SHARE_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andShareAccountIsNotNull() {
            addCriterion("SHARE_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andShareAccountEqualTo(String value) {
            addCriterion("SHARE_ACCOUNT =", value, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountNotEqualTo(String value) {
            addCriterion("SHARE_ACCOUNT <>", value, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountGreaterThan(String value) {
            addCriterion("SHARE_ACCOUNT >", value, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_ACCOUNT >=", value, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountLessThan(String value) {
            addCriterion("SHARE_ACCOUNT <", value, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountLessThanOrEqualTo(String value) {
            addCriterion("SHARE_ACCOUNT <=", value, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountLike(String value) {
            addCriterion("SHARE_ACCOUNT like", value, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountNotLike(String value) {
            addCriterion("SHARE_ACCOUNT not like", value, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountIn(List<String> values) {
            addCriterion("SHARE_ACCOUNT in", values, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountNotIn(List<String> values) {
            addCriterion("SHARE_ACCOUNT not in", values, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountBetween(String value1, String value2) {
            addCriterion("SHARE_ACCOUNT between", value1, value2, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareAccountNotBetween(String value1, String value2) {
            addCriterion("SHARE_ACCOUNT not between", value1, value2, "shareAccount");
            return (Criteria) this;
        }

        public Criteria andShareNameIsNull() {
            addCriterion("SHARE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShareNameIsNotNull() {
            addCriterion("SHARE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShareNameEqualTo(String value) {
            addCriterion("SHARE_NAME =", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotEqualTo(String value) {
            addCriterion("SHARE_NAME <>", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameGreaterThan(String value) {
            addCriterion("SHARE_NAME >", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_NAME >=", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameLessThan(String value) {
            addCriterion("SHARE_NAME <", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameLessThanOrEqualTo(String value) {
            addCriterion("SHARE_NAME <=", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameLike(String value) {
            addCriterion("SHARE_NAME like", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotLike(String value) {
            addCriterion("SHARE_NAME not like", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameIn(List<String> values) {
            addCriterion("SHARE_NAME in", values, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotIn(List<String> values) {
            addCriterion("SHARE_NAME not in", values, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameBetween(String value1, String value2) {
            addCriterion("SHARE_NAME between", value1, value2, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotBetween(String value1, String value2) {
            addCriterion("SHARE_NAME not between", value1, value2, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNull() {
            addCriterion("SHARE_URL is null");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNotNull() {
            addCriterion("SHARE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andShareUrlEqualTo(String value) {
            addCriterion("SHARE_URL =", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotEqualTo(String value) {
            addCriterion("SHARE_URL <>", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThan(String value) {
            addCriterion("SHARE_URL >", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_URL >=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThan(String value) {
            addCriterion("SHARE_URL <", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThanOrEqualTo(String value) {
            addCriterion("SHARE_URL <=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLike(String value) {
            addCriterion("SHARE_URL like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotLike(String value) {
            addCriterion("SHARE_URL not like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlIn(List<String> values) {
            addCriterion("SHARE_URL in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotIn(List<String> values) {
            addCriterion("SHARE_URL not in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlBetween(String value1, String value2) {
            addCriterion("SHARE_URL between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotBetween(String value1, String value2) {
            addCriterion("SHARE_URL not between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareTimeIsNull() {
            addCriterion("SHARE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andShareTimeIsNotNull() {
            addCriterion("SHARE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andShareTimeEqualTo(Date value) {
            addCriterion("SHARE_TIME =", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotEqualTo(Date value) {
            addCriterion("SHARE_TIME <>", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeGreaterThan(Date value) {
            addCriterion("SHARE_TIME >", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SHARE_TIME >=", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeLessThan(Date value) {
            addCriterion("SHARE_TIME <", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeLessThanOrEqualTo(Date value) {
            addCriterion("SHARE_TIME <=", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeIn(List<Date> values) {
            addCriterion("SHARE_TIME in", values, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotIn(List<Date> values) {
            addCriterion("SHARE_TIME not in", values, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeBetween(Date value1, Date value2) {
            addCriterion("SHARE_TIME between", value1, value2, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotBetween(Date value1, Date value2) {
            addCriterion("SHARE_TIME not between", value1, value2, "shareTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SHARE_INFO
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: SHARE_INFO
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