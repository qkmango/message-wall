package controller;

import entity.UserLoginInfo;
import model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // System.out.println(email);
        // System.out.println(password);

        UserLoginInfo userLoginInfo = new UserLoginInfo(email, password);

        response.setContentType("text/plain;charset=UTF-8");

        if(Login.canLogin(userLoginInfo)){
            response.getWriter().write("true");

        } else {
            response.getWriter().write("false");
        }

        // System.out.println("=========");

    }
}
