package com.yy.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.boco.raptor.drm.core.dto.DrmSingleClassQuery;
import com.yy.BookExample;
import com.yy.dto.Book;
import com.yy.dto.Condition;

@SuppressWarnings("deprecation")
@Repository
public class BookDAOImpl implements BookDAO {
	
	@Resource
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void insert(Book record) throws SQLException {
    	sqlMapClientTemplate.insert("BOOK.insert", record);
    }

    public int updateByPrimaryKey(Book record) throws SQLException {
        int rows = sqlMapClientTemplate.update("BOOK.updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(Book record) throws SQLException {
        int rows = sqlMapClientTemplate.update("BOOK.updateByPrimaryKeySelective", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<Book> selectByExample(Condition conditions) {
        List<Book> list = null;
        try{
        	list = (List<Book>) sqlMapClientTemplate.queryForList("BOOK.selectByExample", conditions);
        } catch(Exception e){
        	e.printStackTrace();
        }
        return list;
    }

    public Book selectByPrimaryKey(Long bookId) throws SQLException {
        Book key = new Book();
        key.setBookId(bookId);
        Book record = (Book) sqlMapClientTemplate.queryForObject("BOOK.selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(BookExample example) throws SQLException {
        int rows = sqlMapClientTemplate.delete("BOOK.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long bookId) throws SQLException {
        Book key = new Book();
        key.setBookId(bookId);
        int rows = sqlMapClientTemplate.delete("BOOK.deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(BookExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClientTemplate.queryForObject("BOOK.countByExample", example);
        return count;
    }


	@Override
	public int updateByExampleSelective(Book record, BookExample example)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int updateByExample(Book record, BookExample example)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Book> selectByExample(BookExample example) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}