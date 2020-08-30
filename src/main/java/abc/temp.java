import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.nio.charset.Charset;
import java.io.*;

public class HelloWorld{
        public static class UnicodeFormatter  {
        
           static public String byteToHex(byte b) {
              // Returns hex String representation of byte b
              char hexDigit[] = {
                 '0', '1', '2', '3', '4', '5', '6', '7',
                 '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
              };
              char[] array = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
              return new String(array);
           }
        
           static public String charToHex(char c) {
              // Returns hex String representation of char c
              byte hi = (byte) (c >>> 8);
              byte lo = (byte) (c & 0xff);
              return byteToHex(hi) + byteToHex(lo);
           }
        
        } // class
    
        private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

        private static String decodeUTF8(byte[] bytes) {
            return new String(bytes, UTF8_CHARSET);
        }
        
        private static byte[] encodeUTF8(String string) {
            return string.getBytes(UTF8_CHARSET);
        }
        public static void printBytes(byte[] array, String name) {
            for (int k = 0; k < array.length; k++) {
                System.out.println(name + "[" + k + "] = " + "0x" +
                UnicodeFormatter.byteToHex(array[k]));
            }
        }

     public static void main(String []args){
        
        
        char a = 'ẳ';
        char as[] = {'a','á','ả','ạ','ẳ'};
        List<Integer> nums = new ArrayList<Integer>();
        for (char c : as) 
        { 
            nums.add((int)c);
            byte[] encoded = encodeUTF8(Character.toString(c));
            String decoded = decodeUTF8(encoded);
            String charToHex = UnicodeFormatter.charToHex(c);
            //String str = new String(encoded, UTF8_CHARSET);
            //printBytes(encoded,"Encoded represented as hex: ");
            System.out.println(charToHex);
            System.out.println(decoded);
        }
        Collections.sort(nums);
        for (Integer n : nums) 
        { 
            System.out.println(n);
            
            String hex = Integer.toHexString(n);
            System.out.println(hex);
            int hexToInt = Integer.parseInt(hex, 16);
            char intToChar = (char)hexToInt;
            System.out.println(intToChar);
        }
        {24,24,24}{24,25,25}
         {"ỔỔỔỔỔỔỔỔ ","ỔỔỔỔ ỔỔỔỔ"," ỔỔỔỔ  ỔỔỔỔ "}
         {"ỔỔỔỔỔỔỔỔ","ỔỔỔỔ ỔỔỔỔ","ỔỔỔỔ ỔỔỔỔ"}
         {23,23}{26,26}
         {"ỔỔỔ 22 333 ỔỔỔ"," ỔỔỔ  4444   1  ỔỔỔ "}
         {"ỔỔỔ 22 333 ỔỔỔ"," ỔỔỔ 4444 1 ỔỔỔ"}
         {24,24,23,23,24,24,24}{25,25,26,26,23,23,25}
         {"ỔỔỔ 333 333 ỔỔỔ"," ỔỔỔ 333 333 ỔỔỔ ","ỔỔỔ 1 22 22 ỔỔỔ","ỔỔỔ 22 1 22 ỔỔỔ"," ỔỔỔ 55555 1 ỔỔỔ "," ỔỔỔ 1 55555 ỔỔỔ "," ỔỔỔ 22 333  1 ỔỔỔ "}
         {"ỔỔỔ 3 333 ỔỔỔ","ỔỔỔ 3 333 ỔỔỔ","ỔỔỔ 1 2 22 ỔỔỔ","ỔỔỔ 22 1 22 ỔỔỔ","ỔỔỔ 5 1 ỔỔỔ","ỔỔỔ 1 5 ỔỔỔ","ỔỔỔ 2 3 1 ỔỔỔ"}
         {30,48,48}{3,21,15}
         {" ỔỔỔỔỔỔỔỔỔỔ ","Ổ 5ỔỔỔỔỔ  4ỔỔỔỔ  3ỔỔỔ 2ỔỔ Ổ "," Ổ 2ỔỔ 3ỔỔỔ 4ỔỔỔỔ  5ỔỔỔỔỔ Ổ"}
         {"Ổ","Ổ 5 4 3 2ỔỔ Ổ","Ổ 2 3 4 5 Ổ"}
         {42,48}{25,7}
         {"ỔỔỔỔỔỔỔ  ỔỔỔỔỔỔỔ "," ỔỔỔỔỔỔỔỔ  ỔỔỔỔỔỔỔỔ"}
         {"Ổ ỔỔỔỔỔỔỔ","Ổ Ổ"}
     }
}