package ncu.wyl.test10.exer;

/**
 * VO: Customer
 */
public class Customer {
    private String account;
    private String password;
    private String cname;
    private boolean member; // 题目2中提到的属性

    // 无参构造函数
    public Customer() {}

    // Getter 和 Setter 方法
    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getCname() { return cname; }
    public void setCname(String cname) { this.cname = cname; }

    public boolean isMember() { return member; }
    public void setMember(boolean member) { this.member = member; }


}

