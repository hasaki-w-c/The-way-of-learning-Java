/*
使用二维数组打印一个10行的杨辉三角
【提示】
1.第一行有一个元素，第n行有n个元素。
2.每一行的第一个元素和最后一个元素都是1.
3.从第三行开始，对于非第一个和最后一个元素的元素：
    yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
 */

public class Test07 {
    public static void main(String[] args){
        int[][] yanghui = new int[10][];

        for (int i =0; i < yanghui.length; i ++){
            yanghui[i] = new int[i + 1];

            //给二维数组元素赋值
            yanghui[i][0] = yanghui[i][i] = 1;
            if (i > 1){
                for (int j = 1; j < yanghui[i].length - 1; j ++){
                    yanghui[i][j] = yanghui[i - 1][j] + yanghui[i - 1][j - 1];
                }
            }
        }

        //遍历数组
        for (int i = 0;i < yanghui.length; i ++){
            for (int j = 0; j < yanghui[i].length; j ++){
                System.out.print(yanghui[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
