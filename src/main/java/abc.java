import abc.*;

public class abc {

	public static void main(String[] args) {
		/*
		// TODO Auto-generated method stub
		String[] ss = { "  ĐÂY LÀ STRING RẤT  LẠ ", "ĐƯỜNG 123 ĐƯỜNGĐƯỜNG 12345 12345 CUOI","ĐƯỜN yy ĐƯỜ ĐƯỜNGĐƯỜNGĐƯỜNG ĐƯỜNG","ĐƯỜN ĐƯỜNGĐƯỜNGĐƯỜNG ĐƯỜ yy ĐƯỜNG",
				"ĐƯỜNGĐƯỜNGĐƯỜNGĐƯỜNGĐƯỜNGĐƯỜNGĐƯỜNGĐƯỜNG", "ĐƯỜNGĐƯỜNG ĐƯỜNGĐƯỜNG", " 123456789 123456789 123456789 ", ""};
		System.out.println("Test with no accent remove----");
		for (String s : ss) {

			System.out.println(s + ' ' + s.getBytes().length);
			String e = VNCharacterUtils.reduceName(s);
			System.out.println(e + ' ' + e.getBytes().length);
		}
		System.out.println("Test with accent removed----");
		for (String s : ss) {

//			System.out.println(s + ' ' + s.getBytes().length);
			String r = VNCharacterUtils.removeAccent(s);
			String e = VNCharacterUtils.reduceName(r);
			System.out.println(r + ' ' + r.getBytes().length);
			System.out.println(e + ' ' + e.getBytes().length);
		}
//		String[] ss = { " 123456789 123456789 123456789 ", "CHUỖI RẤT LÀ BÌNH THƯỜNG", "" };
//		for (String s : ss) {
//			s = s.trim();
//			String[] split = s.split(" ");
//			System.out.println("-----");
//			System.out.println(split[0].getBytes().length + split[split.length - 1].getBytes().length);
//			for (String string : split) {
//				System.out.println(string);
//				System.out.println(string.getBytes().length);
//			}
//		}
 */
		char[] chars = { 'À', 'Á', 'Â', 'Ã', 'È', 'É', 'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ',
			'Ù', 'Ú', 'Ý', 'à', 'á', 'â', 'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý', 'Ă', 'ă',
			'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ', 'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ',
			'ẫ', 'Ậ', 'ậ', 'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ', 'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế',
			'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ', 'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ',
			'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ', 'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ',
			'Ừ', 'ừ', 'Ử', 'ử', 'Ữ', 'ữ', 'Ự', 'ự', 'Ỳ', 'ỳ', 'Ỵ', 'ỵ', 'Ỷ', 'ỷ', 'Ỹ', 'ỹ' };
		for (char c : chars) {
			int n = c;
			System.out.println(c + "  " + n);
			System.out.println((char)n);
		}
	}
	

}
