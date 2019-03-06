package com.hang.daoImp;

import com.hang.dao.UserDao;
import com.hang.domain.Word;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImp implements UserDao {
    private Connection connection;


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    @Override
    public boolean selectUserByUsername(Connection connection, String username) {
        String sql = "select * from user where username = ?";
        PreparedStatement prepareStatement=null;
        try {
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, username);
            ResultSet executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public  List<Word> selectWord() throws Exception {
        QueryRunner queryRunner = new QueryRunner();

        String sql = "select * from word";

        List<Word> words = queryRunner.query(connection, sql, new BeanListHandler<Word>(Word.class));

        return words;
    }

    @Override
    public void deleteWordById(Integer id) throws Exception {
        QueryRunner queryRunner = new QueryRunner();

        String sql = "delete from word where id = ?";

        queryRunner.update(connection, sql, id);
    }
}
