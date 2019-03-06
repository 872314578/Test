package com.hang.dao;

import com.hang.domain.Word;

import java.sql.Connection;
import java.util.List;


public interface UserDao {

	public boolean selectUserByUsername(Connection connection, String username);
    public List<Word> selectWord() throws Exception;
    public void deleteWordById(Integer id) throws Exception;

}
