package com.wc.yhyw;

/**
 * CustomerView为主模块，负责菜单的显示和处理用户操作
 * @author 王琛
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer cust = new Customer("王琛",'男',20,"18329261252","1970962524@qq.com");
        customerList.addCostomer(cust);
    }

    /**
     * 显示主界面的操作
     */
    public void enterMainMenu() {

        boolean flag = true;
        while (flag) {
            System.out.println(" ---------------------------------");
            System.out.println("|         .客户信息管理.          |");
            System.out.println("|         一、添加客户.           |");
            System.out.println("|         二、修改客户.           |");
            System.out.println("|         三、删除客户.           |");
            System.out.println("|         四、客户列表.           |");
            System.out.println("|         五、退出系统.           |");
            System.out.println("|         请选择(1-5):            |");
            System.out.println(" ---------------------------------");

            char menu = CMUtility.readMenuSelection();    //'1'而非1
            switch (menu) {

                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N):");
                    char exit = CMUtility.readConfirmSelection();
                    if (exit == 'Y') {
                        flag = false;
                    }
            }
        }
    }

    /**
     * 添加新客户的操作
     */
    private void addNewCustomer() {
        System.out.println("----------------添加新客户----------------");

        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char sex = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(11);
        System.out.print("邮箱");
        String email = CMUtility.readString(20);

        //将数据封装到一个Customer对象中
        Customer customer = new Customer(name,sex,age,phone,email);
        boolean addSuccess = customerList.addCostomer(customer);
        if (addSuccess) {
            System.out.println("----------------已添加完成----------------");
        }else {
            System.out.println("----------------未添加成功----------------");
        }
    }

    /**
     * 修改客户的操作
     */
    private void modifyCustomer() {
        System.out.println("----------------修改客户信息-------------------");
        Customer cust;
        int number;

        for (; ; ) {
            System.out.print("请选择客户编号（-1退出）：");
            number = CMUtility.readInt();

            if (number == -1) {
                return;
            }

            cust = customerList.getcustomer(number - 1);    //客户编号是从1开始的
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            }else {
                break;    //跳出循环
            }
        }

        System.out.print("姓名（" + cust.getName() + "）：");
        String name = CMUtility.readString(10, cust.getName());
        System.out.print("性别（" + cust.getSex() + "）：");
        char sex = CMUtility.readchar(cust.getSex());
        System.out.print("年龄（" + cust.getAge() + "）：");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话（" + cust.getPhone() + "）：");
        String phone = CMUtility.readString(11,cust.getPhone());
        System.out.print("邮箱（" + cust.getEmail() + "）：");
        String email = CMUtility.readString(20,cust.getEmail());

        Customer c = new Customer(name,sex,age,phone,email);

        boolean isReplace = customerList.replaceCustomer(number - 1, c);
        if (isReplace) {
            System.out.println("--------------修改成功--------------");
        }else {
            System.out.println("--------------修改失败--------------");
        }
    }

    /**
     * 删除客户的操作
     */
    private void deleteCustomer() {
        System.out.println("-----------------删除客户----------------");
        int number;

        for (; ;) {
            System.out.println("请输入待删除客户的编号（-1退出）：");
            number = CMUtility.readInt();
            if (number == -1) {
                return;
            }

            Customer cust = customerList.getcustomer(number - 1);//客户编号从1开始

            if (cust == null) {
                System.out.println("无法找到指定客户！");
            }else {
                break;    //结束循环
            }
        }

        System.out.print("是否删除（Y/N）：");
        char confirmDelete = CMUtility.readConfirmSelection();
        if (confirmDelete == 'Y') {
            boolean isDelete = customerList.deleteCostomer(number - 1);
            if (isDelete) {
                System.out.println("-----------------删除完成-----------------");
            }else {
                System.out.println("-----------------删除失败-----------------");
            }
        }

    }

    /**
     * 显示所有客户的操作
     */
    private void listAllCustomers() {
        System.out.println("--------------------客户列表---------------------");

        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录");
        }else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < custs.length; i ++) {
                Customer cust = custs[i];
                System.out.println((i + 1) +"\t\t" + cust.getName() + "\t" + cust.getSex() + "\t\t" + cust.getAge() + "\t\t" + cust.getPhone() + "\t" + cust.getEmail());
            }
        }
        System.out.println("--------------------客户列表---------------------");
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}


