package abc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VNCharacterUtils {
	private static final char[] SOURCE_CHARACTERS = { 'À', 'Á', 'Â', 'Ã', 'È', 'É', 'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ',
			'Ù', 'Ú', 'Ý', 'à', 'á', 'â', 'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý', 'Ă', 'ă',
			'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ', 'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ',
			'ẫ', 'Ậ', 'ậ', 'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ', 'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế',
			'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ', 'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ',
			'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ', 'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ',
			'Ừ', 'ừ', 'Ử', 'ử', 'Ữ', 'ữ', 'Ự', 'ự', 'Ỳ', 'ỳ', 'Ỵ', 'ỵ', 'Ỷ', 'ỷ', 'Ỹ', 'ỹ' };
	private static final char[] DESTINATION_CHARACTERS = { 'A', 'A', 'A', 'A', 'E', 'E', 'E', 'I', 'I', 'O', 'O', 'O','O',
			'U', 'U', 'Y', 'a', 'a', 'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u', 'y', 'A','a', 
			'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
			'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a','E','e','E','e','E','e','E','e',
			'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o','O',
			'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o','U','u','U','u','U','u',
			'U','u','U','u','U','u','U','u','Y','y','Y','y','Y','y','Y','y'};

	public static char removeAccent(char ch) {
//		Arrays.sort(SOURCE_CHARACTERS);
//		Arrays.sort(DESTINATION_CHARACTERS);
		int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
		if (index >= 0) {
			ch = DESTINATION_CHARACTERS[index];
		}
		return ch;
	}

	public static String removeAccent(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			sb.setCharAt(i, removeAccent(sb.charAt(i)));
		}
		return sb.toString();
	}

	public static String reduceName(String inputStr) {
		int maxLength = 26;
		inputStr = inputStr.trim();
		// This array is to make the result
		String words[] = inputStr.split(" ");
		
		// Remove empty string after split
		List<String> tempList = new ArrayList<String>(Arrays.asList(words));
		tempList.removeAll(Arrays.asList("", null));
		words = tempList.toArray(new String[0]);
		
		// Reduced middle words to 1 character
		for (int i = 1; i < words.length - 1; i++) {
			inputStr = arrayToStringWithSpace(words);
			if (inputStr.getBytes().length <= maxLength) {
				break;
			}
			words[i] = Character.toString(words[i].charAt(0));
		}
		
		// If reduced is not enough, remove middle words
		for (int i = 1; i < words.length - 1; i++) {
			// Have to clone due to inputStr element will be reduced if a word is set to ""
			String tempWords[] = words.clone();
			inputStr = arrayToStringWithSpace(tempWords);
			if (inputStr.getBytes().length <= maxLength) {
				break;
			}
			words[i] = "";
		}
		inputStr = arrayToStringWithSpace(words);
		if (inputStr.getBytes().length > maxLength) {
			words[0] = Character.toString(words[0].charAt(0));
		}
		inputStr = arrayToStringWithSpace(words);
		if (inputStr.getBytes().length > maxLength) {
			words[words.length - 1] = Character.toString(words[words.length - 1].charAt(0));
		}
		inputStr = arrayToStringWithSpace(words);
		return inputStr;
	}

//	private static String arrayToStringWithSpace(String[] words) {
//		String str = "";
//		for (int j = 0; j < words.length; j++) {
//			if (!words[j].equals("")) {
//				str += words[j];
//				if (j < words.length - 1) {
//					str += " ";
//				}
//			}
//		}
//		return str;
//	}
	private static String arrayToStringWithSpace(String[] words) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < words.length; j++) {
			if (!words[j].equals("")) {
				sb.append(words[j]);
				if (j < words.length - 1) {
					sb.append(" ");
				}
			}
		}
		return sb.toString();
	}
}
