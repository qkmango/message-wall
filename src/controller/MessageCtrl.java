package controller;

import entity.PageMessageList;
import model.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * <p>主页留言墙 获取留言的控制层</p>
 * <p>是项目主要功能的控制类</p>
 * @className MessageCtrl
 * @author: Mango
 * @date: 2020-09-08 02:18
 */
@WebServlet("/messagewall")
public class MessageCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        int pageNum = 1;
        if (page != null) {
            pageNum = Integer.parseInt(page);
        }

        PageMessageList pageMessageList = Message.pageMessageListAll(pageNum);
        request.setAttribute("pageMessageList",pageMessageList);
        request.getRequestDispatcher("/WEB-INF/messagewall/index.jsp").forward(request,response);
        System.out.println("=====");
    }
}
