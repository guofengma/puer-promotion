package cn.datai.puer.promotion.website.vo;

import cn.datai.puer.promotion.website.vo.plugins.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SharedInfoExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public SharedInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
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
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: SHARED_INFO
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

        public Criteria andSharedIdIsNull() {
            addCriterion("SHARED_ID is null");
            return (Criteria) this;
        }

        public Criteria andSharedIdIsNotNull() {
            addCriterion("SHARED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSharedIdEqualTo(String value) {
            addCriterion("SHARED_ID =", value, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdNotEqualTo(String value) {
            addCriterion("SHARED_ID <>", value, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdGreaterThan(String value) {
            addCriterion("SHARED_ID >", value, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHARED_ID >=", value, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdLessThan(String value) {
            addCriterion("SHARED_ID <", value, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdLessThanOrEqualTo(String value) {
            addCriterion("SHARED_ID <=", value, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdLike(String value) {
            addCriterion("SHARED_ID like", value, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdNotLike(String value) {
            addCriterion("SHARED_ID not like", value, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdIn(List<String> values) {
            addCriterion("SHARED_ID in", values, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdNotIn(List<String> values) {
            addCriterion("SHARED_ID not in", values, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdBetween(String value1, String value2) {
            addCriterion("SHARED_ID between", value1, value2, "sharedId");
            return (Criteria) this;
        }

        public Criteria andSharedIdNotBetween(String value1, String value2) {
            addCriterion("SHARED_ID not between", value1, value2, "sharedId");
            return (Criteria) this;
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

        public Criteria andSharedPhoneIsNull() {
            addCriterion("SHARED_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneIsNotNull() {
            addCriterion("SHARED_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneEqualTo(String value) {
            addCriterion("SHARED_PHONE =", value, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneNotEqualTo(String value) {
            addCriterion("SHARED_PHONE <>", value, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneGreaterThan(String value) {
            addCriterion("SHARED_PHONE >", value, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("SHARED_PHONE >=", value, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneLessThan(String value) {
            addCriterion("SHARED_PHONE <", value, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneLessThanOrEqualTo(String value) {
            addCriterion("SHARED_PHONE <=", value, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneLike(String value) {
            addCriterion("SHARED_PHONE like", value, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneNotLike(String value) {
            addCriterion("SHARED_PHONE not like", value, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneIn(List<String> values) {
            addCriterion("SHARED_PHONE in", values, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneNotIn(List<String> values) {
            addCriterion("SHARED_PHONE not in", values, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneBetween(String value1, String value2) {
            addCriterion("SHARED_PHONE between", value1, value2, "sharedPhone");
            return (Criteria) this;
        }

        public Criteria andSharedPhoneNotBetween(String value1, String value2) {
            addCriterion("SHARED_PHONE not between", value1, value2, "sharedPhone");
            return (Criteria) this;
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

        public Criteria andSharedTimeIsNull() {
            addCriterion("SHARED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSharedTimeIsNotNull() {
            addCriterion("SHARED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSharedTimeEqualTo(Date value) {
            addCriterion("SHARED_TIME =", value, "sharedTime");
            return (Criteria) this;
        }

        public Criteria andSharedTimeNotEqualTo(Date value) {
            addCriterion("SHARED_TIME <>", value, "sharedTime");
            return (Criteria) this;
        }

        public Criteria andSharedTimeGreaterThan(Date value) {
            addCriterion("SHARED_TIME >", value, "sharedTime");
            return (Criteria) this;
        }

        public Criteria andSharedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SHARED_TIME >=", value, "sharedTime");
            return (Criteria) this;
        }

        public Criteria andSharedTimeLessThan(Date value) {
            addCriterion("SHARED_TIME <", value, "sharedTime");
            return (Criteria) this;
        }

        public Criteria andSharedTimeLessThanOrEqualTo(Date value) {
            addCriterion("SHARED_TIME <=", value, "sharedTime");
            return (Criteria) this;
        }

        public Criteria andSharedTimeIn(List<Date> values) {
            addCriterion("SHARED_TIME in", values, "sharedTime");
            return (Criteria) this;
        }

        public Criteria andSharedTimeNotIn(List<Date> values) {
            addCriterion("SHARED_TIME not in", values, "sharedTime");
            return (Criteria) this;
        }

        public Criteria andSharedTimeBetween(Date value1, Date value2) {
            addCriterion("SHARED_TIME between", value1, value2, "sharedTime");
            return (Criteria) this;
        }

        public Criteria andSharedTimeNotBetween(Date value1, Date value2) {
            addCriterion("SHARED_TIME not between", value1, value2, "sharedTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeIsNull() {
            addCriterion("OPEN_ACCOUNT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeIsNotNull() {
            addCriterion("OPEN_ACCOUNT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeEqualTo(Date value) {
            addCriterion("OPEN_ACCOUNT_TIME =", value, "openAccountTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeNotEqualTo(Date value) {
            addCriterion("OPEN_ACCOUNT_TIME <>", value, "openAccountTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeGreaterThan(Date value) {
            addCriterion("OPEN_ACCOUNT_TIME >", value, "openAccountTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPEN_ACCOUNT_TIME >=", value, "openAccountTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeLessThan(Date value) {
            addCriterion("OPEN_ACCOUNT_TIME <", value, "openAccountTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeLessThanOrEqualTo(Date value) {
            addCriterion("OPEN_ACCOUNT_TIME <=", value, "openAccountTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeIn(List<Date> values) {
            addCriterion("OPEN_ACCOUNT_TIME in", values, "openAccountTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeNotIn(List<Date> values) {
            addCriterion("OPEN_ACCOUNT_TIME not in", values, "openAccountTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeBetween(Date value1, Date value2) {
            addCriterion("OPEN_ACCOUNT_TIME between", value1, value2, "openAccountTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountTimeNotBetween(Date value1, Date value2) {
            addCriterion("OPEN_ACCOUNT_TIME not between", value1, value2, "openAccountTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusIsNull() {
            addCriterion("OPEN_ACCOUNT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusIsNotNull() {
            addCriterion("OPEN_ACCOUNT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusEqualTo(String value) {
            addCriterion("OPEN_ACCOUNT_STATUS =", value, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusNotEqualTo(String value) {
            addCriterion("OPEN_ACCOUNT_STATUS <>", value, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusGreaterThan(String value) {
            addCriterion("OPEN_ACCOUNT_STATUS >", value, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_ACCOUNT_STATUS >=", value, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusLessThan(String value) {
            addCriterion("OPEN_ACCOUNT_STATUS <", value, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusLessThanOrEqualTo(String value) {
            addCriterion("OPEN_ACCOUNT_STATUS <=", value, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusLike(String value) {
            addCriterion("OPEN_ACCOUNT_STATUS like", value, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusNotLike(String value) {
            addCriterion("OPEN_ACCOUNT_STATUS not like", value, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusIn(List<String> values) {
            addCriterion("OPEN_ACCOUNT_STATUS in", values, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusNotIn(List<String> values) {
            addCriterion("OPEN_ACCOUNT_STATUS not in", values, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusBetween(String value1, String value2) {
            addCriterion("OPEN_ACCOUNT_STATUS between", value1, value2, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andOpenAccountStatusNotBetween(String value1, String value2) {
            addCriterion("OPEN_ACCOUNT_STATUS not between", value1, value2, "openAccountStatus");
            return (Criteria) this;
        }

        public Criteria andShareChannelIsNull() {
            addCriterion("SHARE_CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andShareChannelIsNotNull() {
            addCriterion("SHARE_CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andShareChannelEqualTo(String value) {
            addCriterion("SHARE_CHANNEL =", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelNotEqualTo(String value) {
            addCriterion("SHARE_CHANNEL <>", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelGreaterThan(String value) {
            addCriterion("SHARE_CHANNEL >", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_CHANNEL >=", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelLessThan(String value) {
            addCriterion("SHARE_CHANNEL <", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelLessThanOrEqualTo(String value) {
            addCriterion("SHARE_CHANNEL <=", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelLike(String value) {
            addCriterion("SHARE_CHANNEL like", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelNotLike(String value) {
            addCriterion("SHARE_CHANNEL not like", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelIn(List<String> values) {
            addCriterion("SHARE_CHANNEL in", values, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelNotIn(List<String> values) {
            addCriterion("SHARE_CHANNEL not in", values, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelBetween(String value1, String value2) {
            addCriterion("SHARE_CHANNEL between", value1, value2, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelNotBetween(String value1, String value2) {
            addCriterion("SHARE_CHANNEL not between", value1, value2, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("SIGN is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("SIGN is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("SIGN =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("SIGN <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("SIGN >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("SIGN <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("SIGN <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("SIGN like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("SIGN not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("SIGN in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("SIGN not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("SIGN between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("SIGN not between", value1, value2, "sign");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SHARED_INFO
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: SHARED_INFO
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