package test;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

// @WebServlet("/test")
@MultipartConfig
public class Test extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Part file = request.getPart("file");
        // BufferedInputStream is = new BufferedInputStream(file.getInputStream());
        //
        // byte[] data = new byte[1024];
        // int len = -1;
        //
        // FileOutputStream outputStream = new FileOutputStream(new File("E:\\资料\\tx.jpg"));
        //
        // while ((len = is.read(data) )!= -1) {
        //     outputStream.write(data,0,len);
        // }
        // outputStream.close();




        // BASE64Encoder encoder = new BASE64Encoder();
        // String base64Str = encoder.encode(data);
        // System.out.println(base64Str);

        request.setCharacterEncoding("UTF-8");

        System.out.println(request.getParameter("nickname"));
        System.out.println(request.getParameter("sex"));
        System.out.println(request.getParameter("birthday"));
        System.out.println(request.getParameter("qq"));
        System.out.println(request.getParameter("tel"));
        System.out.println(request.getParameter("json"));

    }
}
