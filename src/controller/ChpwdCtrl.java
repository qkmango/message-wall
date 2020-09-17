package controller;

import entity.ChPwdEty;
import entity.UserInfo;
import model.ChPwd;

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
 * <p>更改用户密码 控制层</p>
 * <p>类详细介绍</p>
 * @className ChpwdCtrl
 * @author: Mango
 * @date: 2020-09-12 08:41
 */

@WebServlet("/chpwd")
public class ChpwdCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null) {

            UserInfo user = (UserInfo) session.getAttribute("user");
            ChPwdEty chPwdEty = new ChPwdEty(
                    user.getUid(),
                    request.getParameter("oldpwd"),
                    request.getParameter("newpwd"));

            boolean flag = ChPwd.updatePassword(chPwdEty);
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
