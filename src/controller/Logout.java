package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>用户退出登陆 控制兼模型层</p>
 * <p>类详细介绍</p>
 * @className Logout
 * @author: Mango
 * @date: 2020-09-10 14:48
 */

@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if ( session != null) {
            session.invalidate();
        }

        response.sendRedirect(request.getContextPath()+"/messagewall");
    }
}
