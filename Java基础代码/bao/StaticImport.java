package bao;

import java.lang.annotation.Target;
import java.util.Arrays;

import static java.lang.annotation.ElementType.*;
import static java.util.Arrays.*;

/*
import导包：
 1.import 包.类名；
 2.import 包.*；
 3.import static 包.类名.静态成员；
 3.import static 包.类名.*；
 */
public class StaticImport {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

@Target({METHOD,FIELD,TYPE,LOCAL_VARIABLE})
@interface A {

}