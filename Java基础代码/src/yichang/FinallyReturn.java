package yichang;
/*
当finally和return一起出现的情况：
  1.如果finally里边有return，结果返回finally中的。
  2.如果finally里没有return，结果返回try，或者catch中的。
 */
public class FinallyReturn {
    public static void main(String[] args) {
        System.out.println(getNum());
        System.out.println(getInt());
    }

    public static int getNum() {
        int i = 1;

        try {
            i = 2;
            System.out.println("try");
            return i;
        } catch (Exception e) {
            i = 3;
            System.out.println("catch");
            return i;
        } finally {
            i = 4;
            System.out.println("finally");
            return i;
        }
    }

    public static int getInt() {
        int i = 1;

        try {
            i = 2;
            System.out.println("try i = " + i);
            return i;
        } catch (Exception e) {
            i = 3;
            System.out.println("catch");
            return i;
        } finally {
            i = 4;
            System.out.println("finally i = " + i);
        }
    }
}
