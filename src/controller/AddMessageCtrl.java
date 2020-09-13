package controller;

import entity.MessageInfo;
import entity.UserInfo;
import model.AddMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * <p>添加留言的控制类</p>
 * <p>通过前端请求，此类调用模型层在数据库添加一条留言记录</p>
 * @className AddMessageCtrl
 * @author: Mango
 * @date: 2020-09-08 13:35
 */

@WebServlet("/addMessage")
public class AddMessageCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            request.setCharacterEncoding("UTF-8");
            UserInfo user = (UserInfo)session.getAttribute("user");

            int uid = user.getUid();
            String target = request.getParameter("target");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(new Date());
            String msg = request.getParameter("msg");
            int color = Integer.parseInt(request.getParameter("color"));
            int anony = request.getParameter("anony") == null?1:0;

            MessageInfo messageInfo = new MessageInfo(uid, target, date, msg, color, anony);
            boolean flag = AddMessage.addMessage(messageInfo);
        } else {
            response.sendRedirect(request.getContextPath()+"/view/login/");
        }
    }
}
