package controller;

import entity.MessageInfo;
import model.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @version 1.0
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className MessageCtrl
 * @author: Mango
 * @date: 2020-09-08 02:18
 */

@WebServlet("/messagewall")
// @WebServlet("/")
public class MessageCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<MessageInfo> messageList = Message.getMessageList();
        request.setAttribute("messageList",messageList);
        request.getRequestDispatcher("/WEB-INF/messagewall/index.jsp").forward(request,response);
        System.out.println("=====");
    }
}
