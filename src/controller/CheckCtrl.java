package controller;

import entity.MessageInfo;
import model.Check;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className MsgDetailedCtrl
 * @author: Mango
 * @date: 2020-09-08 03:50
 */
@WebServlet("/check")
public class CheckCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int mid = Integer.parseInt(request.getParameter("mid"));
        MessageInfo MessageInfo = Check.getCheckForMid(mid);
        request.setAttribute("MessageInfo",MessageInfo);

        request.getRequestDispatcher("/WEB-INF/check/index.jsp").forward(request,response);


    }
}
