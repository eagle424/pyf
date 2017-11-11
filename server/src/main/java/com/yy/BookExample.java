package com.yy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookExample {
    protected String orderByClause;

    protected List<Criteria> oredCriteria;

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BookExample(BookExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
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
    }

    public static class Criteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andBookIdIsNull() {
            addCriterion("BOOK_ID is null");
            return this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("BOOK_ID is not null");
            return this;
        }

        public Criteria andBookIdEqualTo(Long value) {
            addCriterion("BOOK_ID =", value, "bookId");
            return this;
        }

        public Criteria andBookIdNotEqualTo(Long value) {
            addCriterion("BOOK_ID <>", value, "bookId");
            return this;
        }

        public Criteria andBookIdGreaterThan(Long value) {
            addCriterion("BOOK_ID >", value, "bookId");
            return this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BOOK_ID >=", value, "bookId");
            return this;
        }

        public Criteria andBookIdLessThan(Long value) {
            addCriterion("BOOK_ID <", value, "bookId");
            return this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Long value) {
            addCriterion("BOOK_ID <=", value, "bookId");
            return this;
        }

        public Criteria andBookIdIn(List<Long> values) {
            addCriterion("BOOK_ID in", values, "bookId");
            return this;
        }

        public Criteria andBookIdNotIn(List<Long> values) {
            addCriterion("BOOK_ID not in", values, "bookId");
            return this;
        }

        public Criteria andBookIdBetween(Long value1, Long value2) {
            addCriterion("BOOK_ID between", value1, value2, "bookId");
            return this;
        }

        public Criteria andBookIdNotBetween(Long value1, Long value2) {
            addCriterion("BOOK_ID not between", value1, value2, "bookId");
            return this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("BOOK_NAME is null");
            return this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("BOOK_NAME is not null");
            return this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("BOOK_NAME =", value, "bookName");
            return this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("BOOK_NAME <>", value, "bookName");
            return this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("BOOK_NAME >", value, "bookName");
            return this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("BOOK_NAME >=", value, "bookName");
            return this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("BOOK_NAME <", value, "bookName");
            return this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("BOOK_NAME <=", value, "bookName");
            return this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("BOOK_NAME like", value, "bookName");
            return this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("BOOK_NAME not like", value, "bookName");
            return this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("BOOK_NAME in", values, "bookName");
            return this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("BOOK_NAME not in", values, "bookName");
            return this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("BOOK_NAME between", value1, value2, "bookName");
            return this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("BOOK_NAME not between", value1, value2, "bookName");
            return this;
        }

        public Criteria andBookAuthorIsNull() {
            addCriterion("BOOK_AUTHOR is null");
            return this;
        }

        public Criteria andBookAuthorIsNotNull() {
            addCriterion("BOOK_AUTHOR is not null");
            return this;
        }

        public Criteria andBookAuthorEqualTo(String value) {
            addCriterion("BOOK_AUTHOR =", value, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorNotEqualTo(String value) {
            addCriterion("BOOK_AUTHOR <>", value, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorGreaterThan(String value) {
            addCriterion("BOOK_AUTHOR >", value, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("BOOK_AUTHOR >=", value, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorLessThan(String value) {
            addCriterion("BOOK_AUTHOR <", value, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorLessThanOrEqualTo(String value) {
            addCriterion("BOOK_AUTHOR <=", value, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorLike(String value) {
            addCriterion("BOOK_AUTHOR like", value, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorNotLike(String value) {
            addCriterion("BOOK_AUTHOR not like", value, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorIn(List<String> values) {
            addCriterion("BOOK_AUTHOR in", values, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorNotIn(List<String> values) {
            addCriterion("BOOK_AUTHOR not in", values, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorBetween(String value1, String value2) {
            addCriterion("BOOK_AUTHOR between", value1, value2, "bookAuthor");
            return this;
        }

        public Criteria andBookAuthorNotBetween(String value1, String value2) {
            addCriterion("BOOK_AUTHOR not between", value1, value2, "bookAuthor");
            return this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("TYPE_ID is null");
            return this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("TYPE_ID is not null");
            return this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("TYPE_ID =", value, "typeId");
            return this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("TYPE_ID <>", value, "typeId");
            return this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("TYPE_ID >", value, "typeId");
            return this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE_ID >=", value, "typeId");
            return this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("TYPE_ID <", value, "typeId");
            return this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE_ID <=", value, "typeId");
            return this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("TYPE_ID in", values, "typeId");
            return this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("TYPE_ID not in", values, "typeId");
            return this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("TYPE_ID between", value1, value2, "typeId");
            return this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE_ID not between", value1, value2, "typeId");
            return this;
        }

        public Criteria andBookPubIsNull() {
            addCriterion("BOOK_PUB is null");
            return this;
        }

        public Criteria andBookPubIsNotNull() {
            addCriterion("BOOK_PUB is not null");
            return this;
        }

        public Criteria andBookPubEqualTo(Date value) {
            addCriterion("BOOK_PUB =", value, "bookPub");
            return this;
        }

        public Criteria andBookPubNotEqualTo(Date value) {
            addCriterion("BOOK_PUB <>", value, "bookPub");
            return this;
        }

        public Criteria andBookPubGreaterThan(Date value) {
            addCriterion("BOOK_PUB >", value, "bookPub");
            return this;
        }

        public Criteria andBookPubGreaterThanOrEqualTo(Date value) {
            addCriterion("BOOK_PUB >=", value, "bookPub");
            return this;
        }

        public Criteria andBookPubLessThan(Date value) {
            addCriterion("BOOK_PUB <", value, "bookPub");
            return this;
        }

        public Criteria andBookPubLessThanOrEqualTo(Date value) {
            addCriterion("BOOK_PUB <=", value, "bookPub");
            return this;
        }

        public Criteria andBookPubIn(List<Date> values) {
            addCriterion("BOOK_PUB in", values, "bookPub");
            return this;
        }

        public Criteria andBookPubNotIn(List<Date> values) {
            addCriterion("BOOK_PUB not in", values, "bookPub");
            return this;
        }

        public Criteria andBookPubBetween(Date value1, Date value2) {
            addCriterion("BOOK_PUB between", value1, value2, "bookPub");
            return this;
        }

        public Criteria andBookPubNotBetween(Date value1, Date value2) {
            addCriterion("BOOK_PUB not between", value1, value2, "bookPub");
            return this;
        }

        public Criteria andBookRemarkIsNull() {
            addCriterion("BOOK_REMARK is null");
            return this;
        }

        public Criteria andBookRemarkIsNotNull() {
            addCriterion("BOOK_REMARK is not null");
            return this;
        }

        public Criteria andBookRemarkEqualTo(String value) {
            addCriterion("BOOK_REMARK =", value, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkNotEqualTo(String value) {
            addCriterion("BOOK_REMARK <>", value, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkGreaterThan(String value) {
            addCriterion("BOOK_REMARK >", value, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("BOOK_REMARK >=", value, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkLessThan(String value) {
            addCriterion("BOOK_REMARK <", value, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkLessThanOrEqualTo(String value) {
            addCriterion("BOOK_REMARK <=", value, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkLike(String value) {
            addCriterion("BOOK_REMARK like", value, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkNotLike(String value) {
            addCriterion("BOOK_REMARK not like", value, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkIn(List<String> values) {
            addCriterion("BOOK_REMARK in", values, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkNotIn(List<String> values) {
            addCriterion("BOOK_REMARK not in", values, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkBetween(String value1, String value2) {
            addCriterion("BOOK_REMARK between", value1, value2, "bookRemark");
            return this;
        }

        public Criteria andBookRemarkNotBetween(String value1, String value2) {
            addCriterion("BOOK_REMARK not between", value1, value2, "bookRemark");
            return this;
        }
    }
}