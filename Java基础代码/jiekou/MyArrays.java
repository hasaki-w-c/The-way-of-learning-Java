package jiekou;
/*
对象之间比较大小出了问题，该如何去比较对象之间的大小，而且不同对象之间的比较规则也不一样

我就可以为两个对象标胶大小指定一个标准，接口
Java中确实提供了这样的接口：java.lang.Comparable
                        java.util.Comparator
 */
public class MyArrays {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("张三", 89);
        students[1] = new Student("李四", 95);
        students[2] = new Student("王五", 92);

        sort(students);    //实参是students,形参arr

        for (int i = 0; i < students.length; i ++) {
            System.out.println(students[i]);
        }
    }
    //Object[]类型的形参，可以接受任意类型的对象数组
    public static void sort(Object[] arr){
        for (int i = 1; i < arr.length; i ++) {
            for (int j = 0; j < arr.length - i; j ++) {
                //if (...) {//(arr[j] > arr[j + 1]) {    //对象不能直接比较比较大小
                //以下这部一定注意，运用Arrays.sort也需要这个
                    Comparable pre = (Comparable) arr[j];    //如果这个位置运行没有报错，说明arr[j]这个元素的类型是实现了Comparable
                    if (pre.compareTo(arr[j + 1]) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1 ];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //用冒泡排序
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            for (int j = 0; j < arr.length - i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1 ];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
