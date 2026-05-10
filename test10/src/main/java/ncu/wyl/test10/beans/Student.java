package ncu.wyl.test10.beans;

import java.io.Serializable;

public class Student implements Serializable {

    // 私有属性（正确）
    private String stuno;
    private String stuname;
    private boolean isMember;
    private String[] phones;

    // 1. 无参构造方法（必须添加）
    public Student() {
    }

    // 2. stuno 的 getter/setter（改为 public）
    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    // 3. stuname 的 getter/setter（改为 public）
    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    // 4. isMember 的 getter/setter（正确，但建议统一命名风格）
    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean isMember) {
        this.isMember = isMember;
    }

    // 5. phones 的 getter/setter（正确）
    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }
}