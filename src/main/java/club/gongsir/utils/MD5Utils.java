package club.gongsir.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author gongsir
 */

public class MD5Utils {
    //加盐处理
    private static final String autograph = "alshdozw!@#$%^&*~!@#$%^&*(asdj阿松花大价钱**&^%$#oqwe";

    /**
     * 使用md5加密算法加密
     * @param planText 预加密的字符串
     * @return 返回加密后的字符串
     */
    public static String md5(String planText){
        planText += autograph;
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(planText.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("md5加密错误");
        }
        //转化为16进制
        String md5_code = new BigInteger(1,secretBytes).toString(16);
        // 如果生成数字未满32位，需要前面补0
        for (int i=0; i < 32-md5_code.length(); i++){
            md5_code = "0"+md5_code;
        }
        return md5_code;
    }
}
