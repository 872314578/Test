package com.hang.action;

import com.google.gson.Gson;
import com.hang.daoImp.UserDaoImp;
import com.hang.domain.Word;
import com.hang.serviceImp.UserServiceImp;
import com.hang.util.DruidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteWordAction")
public class DeleteWordAction extends HttpServlet {
    private UserServiceImp userServiceImp;
    private void initData(){
        UserDaoImp userDaoImp = new UserDaoImp();
        userDaoImp.setConnection(DruidUtil.getConnection());
        userServiceImp = new UserServiceImp();
        userServiceImp.setUserDaoImp(userDaoImp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initData();
        String id = req.getParameter("id");

        //处理字符串
        id = id.split("-")[1];
        userServiceImp.removeWordById(Integer.parseInt(id));
    }
}
