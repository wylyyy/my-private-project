package ncu.wyl.test10.exer;

import java.sql.*;

/**
 * DAO:StudentDAO
 */
public class CustomerDAO {
    // 数据库连接
    private String jdbcURL = "jdbc:mysql://localhost:3306/customer?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "222555";

    protected Connection getConnection() {
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

    // 验证登录方法
    public Customer validate(String account, String password) {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE account = ? AND password = ?";

        try(Connection conn = getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, account);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                customer = new Customer();
                customer.setAccount(rs.getString("account"));
                customer.setCname(rs.getString("cname"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }
}
