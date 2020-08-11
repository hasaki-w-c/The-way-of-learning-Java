/*
打印如下图形（菱形）
    *
   * *
  * * *
 * * * *
* * * * *
 * * * *
  * * *
   * *
    *
 */

public class Test04 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int a = 1; a < 5; a++) {
            for (int b = 1; b <= a; b++) {
                System.out.print(" ");
            }

            for (int c = 0; c < 5 - a; c++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
