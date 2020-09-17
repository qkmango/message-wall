package controller;

import entity.PageMessageList;
import entity.UserInfo;
import model.Message;
import model.MyInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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



        HttpSession session = request.getSession(false);

        if (session != null) {
            //通过session中的用户最基本信息（uid，nickname，sex）的uid来获取到完整的(除密码)用户信息类UserInfo对象
            //然后将其添加到此次请求的request范围中，然后转发到JSP页面供使用
            UserInfo user = (UserInfo)session.getAttribute("user");
            UserInfo myInfo = MyInfo.getMyInfo(user.getUid());
            request.setAttribute("myInfo",myInfo);

            request.setCharacterEncoding("UTF-8");
            String info = request.getParameter("info");
            if (info == null) {
                info = "other";
            }


            //根据请求参数转发到不同的jsp

            //1. 用户基本信息
            switch (info) {
                case "base":
                    request.getRequestDispatcher("/WEB-INF/myInfo/base.jsp").forward(request, response);
                    break;

                //    2. 用户所的所有留言
                case "messagelist":
                    String page = request.getParameter("page");
                    int pageNum = 1;
                    if (page != null) {
                        pageNum = Integer.parseInt(page);
                    }
                    PageMessageList pageMessageList = Message.pageMessageListFromUid(pageNum,user.getUid());
                    request.setAttribute("pageMessageList",pageMessageList);
                    request.getRequestDispatcher("/WEB-INF/myInfo/messagelist.jsp").forward(request, response);
                    break;
                // 3. 用户更改密码
                case "chpwd":
                    request.getRequestDispatcher("/WEB-INF/myInfo/chpwd.jsp").forward(request, response);
                    break;
                // 用户更改头像
                case "chavatar":
                    request.getRequestDispatcher("/WEB-INF/myInfo/chavatar.jsp").forward(request, response);
                    break;

                default:
                    request.getRequestDispatcher("/WEB-INF/myInfo/base.jsp").forward(request, response);
            }



        //如果没有登陆则转重定向到登陆页面
        } else {
            response.sendRedirect(request.getContextPath()+"/view/login/");
        }

    }
}
