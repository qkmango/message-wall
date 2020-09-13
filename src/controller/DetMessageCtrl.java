package controller;

import entity.ChPwdEty;
import entity.MessageInfo;
import entity.UserInfo;
import model.ChPwd;
import model.DetMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version 1.0
 * <p>message详细信息</p>
 * <p>类详细介绍</p>
 * @className DetMessageCtrl
 * @author: Mango
 * @date: 2020-09-13 12:07
 */

@WebServlet("/detmessage")
public class DetMessageCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        // HttpSession session = request.getSession(false);

        int mid = Integer.parseInt(request.getParameter("mid"));
        MessageInfo detMessage = DetMessage.getDetMessage(mid);
        if (detMessage != null) {
            request.setAttribute("detMessage",detMessage);
            request.getRequestDispatcher("/WEB-INF/detMessage/index.jsp").forward(request,response);
        }
    }
}
