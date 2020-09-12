package controller;

import entity.UserInfo;
import entity.UserLRInfo;
import model.ChAvatar;
import model.ChPwd;
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
 * <p>更新头像的控制类</p>
 * <p>类详细介绍</p>
 * @className ChAvatarCtrl
 * @author: Mango
 * @date: 2020-09-12 21:24
 */

@WebServlet("/chavatar")
public class ChAvatarCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null) {


            String avatar = request.getParameter("avatar");
            avatar = avatar.replace(" ","+");
            System.out.println(avatar.length());
            System.out.println(avatar);
            UserInfo user = (UserInfo) session.getAttribute("user");
            int uid = user.getUid();
            String password = user.getPassword();

            boolean flag = ChAvatar.chAvatar(avatar,uid);


            if (flag) {
                response.getWriter().write("1");
            } else {
                response.getWriter().write("-1");
            }


        } else {
            response.sendRedirect(request.getContextPath()+"/view/login/");
        }

    }
}
