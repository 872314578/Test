package com.hang.serviceImp;

import com.hang.daoImp.UserDaoImp;
import com.hang.domain.Word;
import com.hang.service.UserService;

import java.sql.Connection;
import java.util.List;

public class UserServiceImp implements UserService {
    private UserDaoImp userDaoImp;

    public UserDaoImp getUserDaoImp() {
        return userDaoImp;
    }

    public void setUserDaoImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Override
    public boolean selectUserByUsername(Connection connection, String username) {
        return userDaoImp.selectUserByUsername(connection,username);
    }

    @Override
    public List<Word> selectWord() throws Exception {
         return  userDaoImp.selectWord();
    }

    @Override
    public void removeWordById(Integer id) {
        try {
            userDaoImp.deleteWordById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
