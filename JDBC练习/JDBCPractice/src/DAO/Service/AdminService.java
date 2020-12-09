package DAO.Service;

import DAO.AdminDAO;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/14 19:44
 */
public class AdminService {
    AdminDAO dao = new AdminDAO();
    public boolean login(String username, String password) {

        Object count = dao.scalar("select count(*) from admin where username = ? and password = ?", username, password);

        return Integer.parseInt(count + "") > 0;
    }

}
