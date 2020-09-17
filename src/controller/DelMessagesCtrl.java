package controller;

import model.DelMessages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * <p>从个人信息里面的我的留言列表中删除message 控制层</p>
 * <p>类详细介绍</p>
 * @className MessageList
 * @author: Mango
 * @date: 2020-09-17 17:26
 */
@WebServlet("/delmessages")
public class DelMessagesCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String mids = request.getParameter("mids");
        mids = mids.substring(0,mids.length()-1);

        int row = DelMessages.delMessages(mids);

        if (row > 0) {
            // response.setContentType("text/");
            response.getWriter().write("1");
        } else {
            response.getWriter().write("-1");
        }

    }
}
