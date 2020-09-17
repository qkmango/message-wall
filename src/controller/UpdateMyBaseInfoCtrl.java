package controller;

import entity.UserInfo;
import model.Login;
import model.UpdateMyBaseInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version 1.0
 * <p>更新个人基本信息的 控制类</p>
 * <p>根据请求的内容，创建一个UserInfo对象，调用UpdateMyBaseInfo模型层的方法来更改基本信息</p>
 * @className UpdateMyInfo
 * @author: Mango
 * @date: 2020-09-10 14:12
 */

@WebServlet("/updatemybaseinfo")
public class UpdateMyBaseInfoCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        UserInfo user = (UserInfo) session.getAttribute("user");

        System.out.println("/updatemyinfo");
        if (session != null) {

            UserInfo updateUserInfo = new UserInfo(
                    user.getUid(),
                    request.getParameter("nickname"),
                    Integer.parseInt(request.getParameter("sex")),
                    request.getParameter("birthday"),
                    request.getParameter("qq"),
                    request.getParameter("tel"),
                    request.getParameter("hide")
            );

            // System.out.println(request.getParameter("sex"));
            // System.out.println(request.getParameter("sex") instanceof String);
            // System.out.println(updateUserInfo);

            boolean flag = UpdateMyBaseInfo.toUpdateMyInfo(updateUserInfo);
            if (flag) {
                user = Login.ReloadUserInfo(user.getUid());
                session.setAttribute("user",user);
                response.getWriter().write("1");
            } else {
                response.getWriter().write("-1");
            }


        } else {
            response.sendRedirect(request.getContextPath()+"/view/login/");
        }

    }
}
