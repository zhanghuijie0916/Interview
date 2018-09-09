package exam;

import java.io.UnsupportedEncodingException;

public class ZiJie3 {
    public static boolean isUTF8(String key){
        try {
            key.getBytes("utf-8");
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
        byte[][] bytes = {
// 00110001
                {(byte)0x31},
// 11000000 10110001
                {(byte)0xC0,(byte)0xB1},
// 11100000 10000000 10110001
                {(byte)0xE0,(byte)0x80,(byte)0xB1},
// 11110000 10000000 10000000 10110001
                {(byte)0xF0,(byte)0x80,(byte)0x80,(byte)0xB1},
// 11111000 10000000 10000000 10000000 10110001
                {(byte)0xF8,(byte)0x80,(byte)0x80,(byte)0x80,(byte)0xB1},
// 11111100 10000000 10000000 10000000 10000000 10110001
                {(byte)0xFC,(byte)0x80,(byte)0x80,(byte)0x80,(byte)0x80,(byte)0xB1},
        };
        for (int i = 0; i < 6; i++) {
            String str = new String(bytes[i], "UTF-8");
            System.out.println("原数组长度：" + bytes[i].length +
                    "/t转换为字符串：" + str +
                    "/t转回后数组长度：" + str.getBytes("UTF-8").length);
        }
    }
}