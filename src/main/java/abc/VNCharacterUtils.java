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

	public static String reduceName2(String str) {
		int limit = 26;
		str = str.trim();
		if (str.getBytes().length <= limit) {
			return str;
		} else {
			String split[] = str.split(" ");
			// Use list to remove empty elements
			List<String> list = new ArrayList<String>(Arrays.asList(split));
			list.removeAll(Arrays.asList("", null));

			split = list.toArray(new String[0]);
			String splitLR[] = split.clone();
			if (split.length <= 1) {
				str = Character.toString(split[0].charAt(0));
				return str;
			} else {
				int numberOfmiddleNameWords = split.length - 2;
				int numberOfWhiteSpace = numberOfmiddleNameWords + 1;

				// First time must not satisfied
				boolean isSatisfied = false;
				boolean isTwoWord = split.length == 2;
				System.out.println(isTwoWord);
				// Index start from the last - 1
				int index = split.length - 1 - 1;
//					while(!isSatisfied) {
//						// Reduce from right to left
//						
//						split[index] = Character.toString(split[index].charAt(0));	
//						
//						// Total is actual bytes required for the future string
//						int total = numberOfWhiteSpace;
//						for (int i = 0; i < split.length; i++) {
//							total += split[i].getBytes().length;
//						}
//						isSatisfied = total <= limit;
//						System.out.println("Total bytes: " + total);
//						index -= 1;
//						// Break when index = 0 mean reaching the first word
//						if (index < 1) break;
//					}
//					// Print to test
//					String test = arrayToStringWithSpace(split);
//					System.out.println("Logic 1 R-L: " + test);
				if (!isSatisfied & !isTwoWord) {
					index = 1;
					while (!isSatisfied) {
						// Reduce from left to right
						splitLR[index] = Character.toString(splitLR[index].charAt(0));

						// Total is actual bytes required for the future string
						int total = numberOfWhiteSpace;
						for (int i = 0; i < splitLR.length; i++) {
							total += splitLR[i].getBytes().length;
						}
						isSatisfied = total <= limit;
//							System.out.println("Total bytes: " + total);
						index += 1;
						// Break when index = 0 mean reaching the first word
						if (index >= splitLR.length - 1)
							break;
					}

					// Print to test
//						test = arrayToStringWithSpace(splitLR);
//						System.out.println("Logic 2 L-R: " + test);
					if (isSatisfied) {
						String res = arrayToStringWithSpace(splitLR);
						return res;
					}

				}

				// After reduce all middle words, if still failed, reduce the first word
				if (!isSatisfied) {
					split[0] = Character.toString(split[0].charAt(0));
					// Total is actual bytes required for the future string
					int total = numberOfWhiteSpace;
					for (int i = 0; i < split.length; i++) {
						total += split[i].getBytes().length;
					}
					isSatisfied = total <= limit;
				}
				if (!isSatisfied) {
					// Reduce the last word if still failed
					split[split.length - 1] = Character.toString(split[split.length - 1].charAt(0));
				}
				String res = arrayToStringWithSpace(splitLR);
				return res;
			}
		}
	}

	public static String reduceName(String inputStr) {
		int maxLength = 26;
		inputStr = inputStr.trim();
		// This array is to make the result
		String words[] = inputStr.split(" ");
		// Reduced middle words to 1 character
		for (int i = 1; i < words.length - 1; i++) {
			inputStr = arrayToStringWithSpace(words);
			if (inputStr.getBytes().length <= maxLength) {
				break;
			}
			words[i] = Character.toString(words[i].charAt(0));
		}

		for (int i = 1; i < words.length - 1; i++) {
			inputStr = arrayToStringWithSpace(words);
			if (inputStr.getBytes().length <= maxLength) {
				break;
			}
			words[i] = "";
		}
		if (inputStr.getBytes().length > maxLength) {
			words[0] = Character.toString(words[0].charAt(0));
		}
		inputStr = arrayToStringWithSpace(words);
		if (inputStr.getBytes().length > maxLength) {
			words[words.length - 1] = Character.toString(words[words.length - 1].charAt(0));
		}
		inputStr = arrayToStringWithSpace(words);
//			System.out.println(inputStr);
		return inputStr;
	}

	private static String arrayToStringWithSpace(String[] words) {
		String str = "";
		for (int j = 0; j < words.length; j++) {
			if (!words[j].equals("")) {
				str += words[j];
				if (j < words.length - 1) {
					str += ' ';
				}
			}
		}
		return str;
	}
}
