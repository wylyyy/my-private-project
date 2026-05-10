package ncu.wyl.demo2;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class GetCookie extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String cookieName = "user";
        String cookieValue = null;
        // 从请求中获取所有Cookie
        Cookie[] cookies = request.getCookies();
        // 遍历查找名为"user"的Cookie
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals(cookieName)) {
                    cookieValue = cookie.getValue();
                    break;
                }
            }
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><title>get cookies</title>");
        out.println("<body><h2>A cookie has been got from browser</h2>");
        out.println("CookieName: " + cookieName + "<br>");
        out.println("CookieValue: " + cookieValue + "<br>");
        out.println("</body></html>");
    }
}