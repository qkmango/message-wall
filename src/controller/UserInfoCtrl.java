package controller;

import Utils.UserInfoHideFilter;
import Utils.UserInfoUtils;
import entity.PageMessageList;
import entity.UserInfo;
import model.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * <p>用户信息（其他用户信息）控制层</p>
 * <p>类详细介绍</p>
 * @className UserInfoCtrl
 * @author: Mango
 * @date: 2020-09-19 17:08
 */

@WebServlet("/userinfo")
public class UserInfoCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("userinfo Ctrl");
        request.setCharacterEncoding("UTF-8");
        String info = request.getParameter("info");
        String uid = request.getParameter("uid");

        if (uid != null) {

            UserInfo userinfo = UserInfoUtils.getUserInfoFromUid(Integer.parseInt(uid));
            System.out.println(userinfo);
            //过滤其他用户信息，将设置为对外隐藏的信息过滤掉，将其设置为-1或"-1"
            userinfo = UserInfoHideFilter.toFilter(userinfo);


            request.setAttribute("userInfo",userinfo);
            // request.setAttribute("uid",uid);

            switch (info) {
                //转发到留言列表JSP
                case "messagelist":
                    //pageNum默认为1
                    int pageNum = 1;
                    //获取请求的参数page（即pageNum）
                    String page = request.getParameter("page");
                    //判断，如果page!=null，转为int类型后赋值为pageNum
                    if (page != null) {
                        pageNum = Integer.parseInt(page);
                    }


                    //通过指定pageNum、uid，获取非匿名的分页pageMessageList
                    PageMessageList pageMessageList = Message.pageMessageListFromUidWhereNotAnony(pageNum, Integer.parseInt(uid));

                    request.setAttribute("pageMessageList",pageMessageList);
                    request.getRequestDispatcher("/WEB-INF/userInfo/messagelist.jsp").forward(request, response);
                    break;
                //默认转发到基本信息JSP
                default:
                    request.getRequestDispatcher("/WEB-INF/userInfo/base.jsp").forward(request, response);
                    break;
            }

        }

    }
}
