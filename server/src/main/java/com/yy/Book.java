package com.yy;

import com.boco.transnms.common.dto.base.GenericDO;
import java.util.Date;

public class Book extends GenericDO {
    public static final Long serialVersionUID = 1L;

    public static final String CLASS_NAME = "BOOK";

    public static final String BOOK_ID = "BOOK_ID";

    public static final String BOOK_NAME = "BOOK_NAME";

    public static final String BOOK_AUTHOR = "BOOK_AUTHOR";

    public static final String TYPE_ID = "TYPE_ID";

    public static final String BOOK_PUB = "BOOK_PUB";

    public static final String BOOK_REMARK = "BOOK_REMARK";

    public Book() {
        this(CLASS_NAME);
    }

    public Book(String className) {
        super(className);
    }

    public Long getBookId() {
        return (Long)getAttrValue(BOOK_ID);
    }

    public void setBookId(Long bookId) {
        setAttrValue(BOOK_ID,bookId);
    }

    public String getBookName() {
        return (String)getAttrValue(BOOK_NAME);
    }

    public void setBookName(String bookName) {
        setAttrValue(BOOK_NAME,bookName);
    }

    public String getBookAuthor() {
        return (String)getAttrValue(BOOK_AUTHOR);
    }

    public void setBookAuthor(String bookAuthor) {
        setAttrValue(BOOK_AUTHOR,bookAuthor);
    }

    public Integer getTypeId() {
        return (Integer)getAttrValue(TYPE_ID);
    }

    public void setTypeId(Integer typeId) {
        setAttrValue(TYPE_ID,typeId);
    }

    public Date getBookPub() {
        return (Date)getAttrValue(BOOK_PUB);
    }

    public void setBookPub(Date bookPub) {
        setAttrValue(BOOK_PUB,bookPub);
    }

    public String getBookRemark() {
        return (String)getAttrValue(BOOK_REMARK);
    }

    public void setBookRemark(String bookRemark) {
        setAttrValue(BOOK_REMARK,bookRemark);
    }
}