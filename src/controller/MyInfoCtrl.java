package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Queue;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className MyInfoCtrl
 * @author: Mango
 * @date: 2020-09-10 08:16
 */

@WebServlet("/myinfo")
public class MyInfoCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // if (request.getSession(false) != null) {
        //     request.getRequestDispatcher("/WEB-INF/myInfo/").forward(request, response);
        // } else {
        //     response.sendRedirect(request.getContextPath()+"/view/login/");
        // }

        request.getRequestDispatcher("/WEB-INF/myInfo/").forward(request, response);

    }
}
