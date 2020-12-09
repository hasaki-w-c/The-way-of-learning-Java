package fanxing.DatabaseOperate;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author hasaki
 */
public class DAOTest {

    @Test
    public void test1() {
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> forList = dao1.getForList(10);
    }

    @Test
    public void test2() {
        StudentDAO dao2 = new StudentDAO();
        
        dao2.add(new Student());
        Student stu = dao2.getIndex(2);
    }
}
