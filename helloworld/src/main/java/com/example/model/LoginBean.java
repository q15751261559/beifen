package com.example.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

public class LoginBean {
    @NotBlank(message = "用户名不能为空")
    @Length(min = 5,max = 20,message = "长度在5到20之间")
    String uname;
    String urole;

    @Override
    public String toString() {
        return "LoginBean{" +
                "uname='" + uname + '\'' +
                ", urole='" + urole + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }

    @Range(min = 18,max = 60,message = "年龄在18到60之间")
    int age;
    @Past(message = "日期在系统时间之前")
    Date date;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUrole() {
        return urole;
    }

    public void setUrole(String urole) {
        this.urole = urole;
    }
}
