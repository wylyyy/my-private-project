package ncu.wyl.test10.exer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private CustomerDAO customerDAO;

    public void init() {
        customerDAO = new CustomerDAO();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // 1. 获取表单数据
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        // 2. 调用 DAO 验证
        Customer customer = customerDAO.validate(account, password);

        if (customer != null) {
            // 3. 验证通过：将对象存入 Session 或 Request
            HttpSession session = request.getSession();
            session.setAttribute("currentCustomer", customer);
            // 跳转到显示页面
            response.sendRedirect("test3/welcome.jsp");
        } else {
            // 验证失败
            response.sendRedirect("test3/login.jsp?error=1");
        }
    }
}