package com.yy.dao;

import java.sql.SQLException;
import java.util.List;

import com.boco.raptor.drm.core.dto.DrmSingleClassQuery;
import com.yy.BookExample;
import com.yy.dto.Book;
import com.yy.dto.Condition;

public interface BookDAO {
    void insert(Book record) throws SQLException;

    int updateByPrimaryKey(Book record) throws SQLException;

    int updateByPrimaryKeySelective(Book record) throws SQLException;

    List<Book> selectByExample(BookExample example) throws SQLException;

    Book selectByPrimaryKey(Long bookId) throws SQLException;

    int deleteByExample(BookExample example) throws SQLException;

    int deleteByPrimaryKey(Long bookId) throws SQLException;

    int countByExample(BookExample example) throws SQLException;

    int updateByExampleSelective(Book record, BookExample example) throws SQLException;

    int updateByExample(Book record, BookExample example) throws SQLException;
    
    List<Book> selectByExample(Condition conditions);
}