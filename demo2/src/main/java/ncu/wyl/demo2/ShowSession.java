package ncu.wyl.demo2;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.Date;

public class ShowSession extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // 获取当前会话，如果没有则创建
        HttpSession session = request.getSession();
        String heading = null;

        // 从session中获取访问次数
        Integer accessCount = (Integer) session.getAttribute("accessCount");

        if (accessCount == null) {
            accessCount = Integer.valueOf(0);
            heading = "Welcome, Newcomer";
        } else {
            heading = "Welcome Back.";
            //使用自动拆装箱，直接进行算术运算
            accessCount = accessCount + 1;
        }

        // 更新session中的访问次数
        session.setAttribute("accessCount", accessCount);

        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Session Tracking Example</title></head>");
        out.println("<body><center>");
        out.println("<h1>" + heading + "</h1>");
        out.println("<h2>Information about your session.</h2>");
        out.println("<table border='1'>");
        out.println("<tr bgcolor=\"ffad00\"><th>Info Type<th>Value\n");
        out.println("<tr><td>ID<td>" + session.getId() + "\n");
        out.println("<tr><td>Creation Time:<td>");
        out.println("" + new Date(session.getCreationTime()) + "\n");
        out.println("<tr><td>Time of last access:<td>");
        out.println("" + new Date(session.getLastAccessedTime()) + "\n");
        out.println("<tr><td>Access number:<td>" + accessCount + "\n");
        out.println("</table></center></body></html>");
    }
}
