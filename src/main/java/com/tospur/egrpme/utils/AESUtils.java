package com.tospur.egrpme.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * <p>
 * 参数加密解密工具，不要和DESEncrypt弄混了
 * </p>
 *
 * @author ZhaoHang
 * @date 2017-09-1 11:55
 */
public class AESUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(AESUtils.class);

    private static final String AES = "AES";

    private static final String CRYPT_KEY = "y2W89L6BkRAFljhN";
   // private static final byte[] CRYPT_KEY_BYTE={121,50,87,56,57,76,54,66,107,82,65,70,108,106,104,78};

    private static final String IV_STRING = "dMitHORyqbeYVE0o";
   // private static final byte[] IV_STRING_BYTE ={100,77,105,116,72,79,82,121,113,98,101,89,86,69,48,111};

    /**
     * 加密
     *
     * @param content 加密内容
     * @return 密文
     * @throws Exception e
     */
    public static String encrypt(String content)  {
        byte[] encryptedBytes = new byte[0];
        try {
            byte[] byteContent = content.getBytes("utf-8");
            // 注意，为了能与 iOS 统一
            // 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
            byte[] enCodeFormat = CRYPT_KEY.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, AES);
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            encryptedBytes = cipher.doFinal(byteContent);
        } catch (Exception e) {
            LOGGER.error("AES encrypt Exception,content = {},Exception = {}", content, e);

            /* MyException(ErrorEnums.RESPONSE_BODY_ENCRYPT_ERROR,ErrorEnums.RESPONSE_BODY_ENCRYPT_ERROR.getDesc())*/;

        }
        // 同样对加密后数据进行 base64 编码
        return new BASE64Encoder().encode(encryptedBytes);
    }

    /**
     * 解密
     *
     * @param content 密文
     * @return 明文
     * @throws Exception e
     */
    public static String decrypt(String content) throws Exception {
        try {
            // base64 解码
            byte[] encryptedBytes = new BASE64Decoder().decodeBuffer(content);
            byte[] enCodeFormat = CRYPT_KEY.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, AES);
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] result = cipher.doFinal(encryptedBytes);
            /*return parseByte2HexStr(result);*/
            return new String(result, "utf-8");
        } catch (Exception e) {
            LOGGER.error("AES decrypt Exception,content = {},Exception = {}", content, e);
            //throw new MyException(ErrorEnums.REQUEST_PARAMS_DECRYPT_ERROR,ErrorEnums.REQUEST_PARAMS_DECRYPT_ERROR.getDesc());
          throw new Exception(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
//            String a = encrypt("{\"orderId\":\"\",\"buildingName\":\"\",\"customerName\":\"\",\"stewardName\":\"\",\"startTime\":\"\",\"endTime\":\"\",\"page\":1,\"rows\":500,\"appName\":\"web_back\",\"appVersion\":\"1.0\",\"orderStatus\":\"3\"}");
        	String b = decrypt("UgO3e5Py8ExY5zu12W7EdvenrTE9cYAvd6+qQiWReovvihX+L68NiqhjFzEHQtZDGsA4NFULmHiDAhMIapnF5czUygMOBnS75kt3O7UmrcBQdaOse+JsLY7YnPEyf5lvlgjaXvrKVvO6NF7mXZnAqULd1n2wX2za8YV8Oa9ya8M=");
//           System.out.println(a.replace("\\n",""));
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}