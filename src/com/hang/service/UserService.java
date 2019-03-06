package com.hang.service;

import com.hang.domain.Word;

import java.sql.Connection;
import java.util.List;

public interface UserService {
    public boolean selectUserByUsername(Connection connection, String username);
    public List<Word> selectWord() throws Exception;
    public  void removeWordById(Integer id);

}
