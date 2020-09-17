package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * <p>添加新的Message编辑页面控制层</p>
 * <p>当要进入编辑Message时，判断用户是否登陆，如果登陆，则转发调用编辑页面jsp；如果没有登陆，则重定向到登陆页面</p>
 * @className MessageEditor
 * @author: Mango
 * @date: 2020-09-08 13:49
 */

@WebServlet("/messageEditor")
public class MessageEditor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false) != null) {
            request.getRequestDispatcher("/WEB-INF/messageEditor/index.jsp").forward(request,response);
        } else {
            //html
            response.sendRedirect(request.getContextPath()+"/view/login/");
        }
    }
}
