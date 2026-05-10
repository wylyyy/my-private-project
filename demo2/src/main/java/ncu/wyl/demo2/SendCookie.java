package ncu.wyl.demo2;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SendCookie extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        // 创建Cookie，key-value形式存储
        Cookie userCookie = new Cookie("user", "uid1234");
        // 设置Cookie有效期：7天（单位：秒）
        userCookie.setMaxAge(60 * 60 * 24 * 7);
        // 将Cookie添加到响应中，发送给客户端
        response.addCookie(userCookie);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><title>add cookies</title>");
        out.println("<body><h2>" +
                "A cookie has been sent to browser</h2></body>");
        out.println("</html>");
    }
}