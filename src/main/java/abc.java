import abc.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.nio.charset.Charset;
import java.io.*;	

public class abc {

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
	  String s = System.getProperty("file.encoding");
	  
	  String s1 = Charset.defaultCharset().toString();
	  System.out.println(s);
	  System.out.println(s1);
//	  String a = InputStreamReader.getEncoding().toString();
     
	  /*
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
  */
  }

}
