package com.hasaki.dayexer;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 题目要求:获取文本上每个字符出现的次数
 * 提示：遍历文本的每一个字符：字符以及出现的次数保存在Map中；将Map中数据写入文件
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/1 16:07
 */
public class Test43 {
    @Test
    public void testWordCount() {
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            //1.创建Map集合
            Map<Character, Integer> map = new HashMap();

            //2.遍历每一个字符，每一个字符出现的次数放到map中
            fr = new FileReader("G:\\LittlePractice\\src\\test.txt");
            int c;
            while ((c = fr.read()) != -1) {
                //int 还原 char
                char ch = (char) c;
                //判断char是否在map中第一次出现
                if (map.get(ch) == null) {
                    map.put(ch,1);
                }else {
                    map.put(ch, map.get(ch) + 1);
                }
            }

            //3.把map中数据存在文件count.txt
            //3.1 创建Writer
            bw = new BufferedWriter(new FileWriter("G:\\LittlePractice\\src\\worldCount.txt"));

            //3.2 遍历map,再写入数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                switch (entry.getKey()) {
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    //\t表示tab键字符
                    case '\t':
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车=" + entry.getValue());
                        break;
                    //\t表示tab键字符
                    case '\n':
                        bw.write("换行=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关流
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
