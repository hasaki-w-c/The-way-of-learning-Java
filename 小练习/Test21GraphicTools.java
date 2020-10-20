package com.hasaki.dayexer;

import com.hasaki.dayexer.Test21Graphic;

public class Test21GraphicTools {
    public boolean compare(Test21Graphic g1, Test21Graphic g2){
        if (g1.getArea() == g2.getArea()) {
            return true;
        }else {
            return false;
        }
    }
}
