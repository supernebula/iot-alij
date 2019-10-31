package evol.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {

    public static String DecodeBase64(String base64Str){
        if(base64Str == null || base64Str.isEmpty())
            return null;
        final Base64.Decoder decoder = Base64.getDecoder();
        try {
            String unBase64Str = new String(decoder.decode(base64Str), "UTF-8");
            return unBase64Str;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String EncodeBase64(String str){
        if(str == null || str.isEmpty())
            return null;
        final Base64.Encoder encoder = Base64.getEncoder();

        try {
            byte[] strByte = str.getBytes("UTF-8");
            String encodedText = encoder.encodeToString(strByte);
            return encodedText;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
