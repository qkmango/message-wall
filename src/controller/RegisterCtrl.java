package controller;

import Utils.UserInfoUtils;
import entity.UserInfo;
import entity.UserLRInfo;
import model.Login;
import model.Register;

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
 * <p>用户注册 控制层</p>
 * <p>类详细介绍</p>
 * @className RegisterCtrl
 * @author: Mango
 * @date: 2020-09-07 10:20
 */

@WebServlet("/register")
public class RegisterCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");

        UserLRInfo userLRInfo = new UserLRInfo(email, password, nickname);

        response.setContentType("text/plain;charset=UTF-8");
        int flag = Register.canRegister(userLRInfo);
        if (flag == 1) {
            HttpSession session = request.getSession(true);
            UserInfo user = Login.canLogin(userLRInfo);
            if (user != null) {
                session.setAttribute("user",user);
            }
            response.getWriter().write("1");
        } else {
            response.getWriter().write("-1");
        }
    }
}
