package DAO.View;

import DAO.Service.AdminService;

import java.util.Scanner;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/14 19:52
 */
public class StudentView {
    AdminService as = new AdminService();
    public static void main(String[] args) {
        new StudentView().login();
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();


        if (as.login(username, password)) {
            System.out.println("登陆成功！");
        }else {
            System.out.println("登陆失败！");
        }
    }
}
