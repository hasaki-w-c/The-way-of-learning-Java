package jiekou;
/*
此程序给出了定时器和监控器的操作行为。
在定时器启动以后，程序将弹出一个消息对话框，并等待用户点击OK按钮来终止程序的运行。
 */
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timertest {
    public static void main(String[] args)
    {
        ActionListener listener = new TimePrinter();

        Timer t = new Timer(5000,listener);    //Timer构造器的第一个参数是发出通告的时间间隔，单位是毫秒。第二个参数是监听器对象
        t.start();    //启动定时器

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener
{
    public void  actionPerformed(ActionEvent event)    //当到达指定的时间间隔时调用，需要注意ActionEvent后边的参数，这个参数提供了事件的相关信息
    {
        System.out.println("At the tonr, the timr is " + new Date());    //每隔指定秒数打印一条时间信息
        Toolkit.getDefaultToolkit().beep();    //响一声（等了登）
    }
}
