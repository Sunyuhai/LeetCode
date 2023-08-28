package kylin;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class AESUtil {
    private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String ENCODING = "UTF-8";
    private static final String KEY = "qwertyuiopasdfgh";

    // 手机号加密
    public static String encrypt(String str) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encrypted = cipher.doFinal(str.getBytes(ENCODING));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // 手机号解密
    public static String decrypt(String str) throws Exception {
        byte[] encrypted = Base64.getDecoder().decode(str);
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return new String(decrypted, ENCODING);
    }
    // 测试
    public static void main(String[] args) {
        try {
            System.out.println(encrypt("15160770632"));
            System.out.println(decrypt("GU0HVwm08rOVkJVz2ziSGQ=="));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

