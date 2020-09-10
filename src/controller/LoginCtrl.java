package controller;

import entity.UserInfo;
import entity.UserLRInfo;
import model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version 1.0
 * @Description:
 * <p>登陆控制</p>
 * <p></p>
 * @className LoginServlet
 * @author: Mango
 * @date: 2020-09-05 22:37
 */

@WebServlet("/login")
public class LoginCtrl extends HttpServlet {
    /**
     * 用户登陆控制层
     * <p>用户登陆成功返回给前端跳转地址，失败返回个前端-1</p>
     * @param request 请求
     * @param response 响应
     * @return void
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserLRInfo userLRInfo = new UserLRInfo(email, password);

        response.setContentType("text/plain;charset=UTF-8");

        UserInfo user = Login.canLogin(userLRInfo);

        if(user != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("user",user);
            response.getWriter().write("/MessageWall/messagewall");
        } else {
            response.getWriter().write("-1");
        }
    }
}
