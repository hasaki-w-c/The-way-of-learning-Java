package reflection.knowledge2;

import java.io.Serializable;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/5 16:52
 */
public class Creatuer<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }
}
