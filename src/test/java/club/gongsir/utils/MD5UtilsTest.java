package club.gongsir.utils;

import java.io.UnsupportedEncodingException;

public class MD5UtilsTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String pass = "123456";
        System.out.println(MD5Utils.md5("123456"));
        System.out.println(MD5Utils.md5(pass));
    }
}