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
 * <p>搜索message的 控制层</p>
 * <p>类详细介绍</p>
 * @className searchMessageCtrl
 * @author: Mango
 * @date: 2020-09-20 18:23
 */

@WebServlet("/search")
public class searchMessageCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        //get提交解决乱码
        //1. 获取乱码字符
        String search = request.getParameter("search");
        if (search != null) {
            //通过"ISO-8859-1"进行还原
            byte[] bytes = search.getBytes("ISO-8859-1");
            //通过正确的字符集进行解码
            search = new String(bytes,"UTF-8");

            int pageNum = 1;
            if (page != null) {
                pageNum = Integer.parseInt(page);
            }

            PageMessageList pageMessageList = Message.pageMessageListSearchAll(pageNum, search);

            request.setAttribute("pageMessageList",pageMessageList);
            //将搜索内容设置到request中，为了前端回显搜索内容
            request.setAttribute("search",search);
            request.getRequestDispatcher("/WEB-INF/searchMessage/index.jsp").forward(request,response);
        }


    }
}
