package SocketCode;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/4 15:19
 */
public class URLTest1 {
    public static void main(String[] args) {

        HttpsURLConnection urlConnection = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            URL url = new URL("https://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/d50735fae6cd7b89d4db9a290a2442a7d8330ee0.jpg");

            urlConnection = (HttpsURLConnection) url.openConnection();

            urlConnection.connect();

            is = urlConnection.getInputStream();

            bos = new BufferedOutputStream(new FileOutputStream("URL下载.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }



    }
}
