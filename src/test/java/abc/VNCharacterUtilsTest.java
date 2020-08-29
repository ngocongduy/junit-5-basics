package abc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VNCharacterUtilsTest {

	@Test
	void test() {
		System.out.println("Test run!");
		String[] ss = { " 123456789 123456789 123456789 "};
		String[] expects = { "123456789 1 123456789"};
		int[] lengths = {21};
		for (int i = 0; i < ss.length; i++) {
			String r = VNCharacterUtils.removeAccent(ss[i]);
			String e = VNCharacterUtils.reduceName(r);
			int l = e.getBytes().length;
			System.out.println(e);
			System.out.println(expects[i]);
			System.out.println(l);
			System.out.println(lengths[i]);
			assertEquals(expects[i], e, "String are different");
			assertEquals(lengths[i], l, "Length are different");
		}
	}
	
	@Test
	void test_remove_accent_single() {
		String[] ss = {"À", "Á", "Â", "Ã", "È", "É", "Ê", "Ì", "Í", "Ò", "Ó", "Ô", "Õ",
				"Ù", "Ú", "Ý", "à", "á", "â", "ã", "è", "é", "ê", "ì", "í", "ò", "ó", "ô", "õ", "ù", "ú", "ý", "Ă", "ă",
				"Đ", "đ", "Ĩ", "ĩ", "Ũ", "ũ", "Ơ", "ơ", "Ư", "ư", "Ạ", "ạ", "Ả", "ả", "Ấ", "ấ", "Ầ", "ầ", "Ẩ", "ẩ", "Ẫ",
				"ẫ", "Ậ", "ậ", "Ắ", "ắ", "Ằ", "ằ", "Ẳ", "ẳ", "Ẵ", "ẵ", "Ặ", "ặ", "Ẹ", "ẹ", "Ẻ", "ẻ", "Ẽ", "ẽ", "Ế", "ế",
				"Ề", "ề", "Ể", "ể", "Ễ", "ễ", "Ệ", "ệ", "Ỉ", "ỉ", "Ị", "ị", "Ọ", "ọ", "Ỏ", "ỏ", "Ố", "ố", "Ồ", "ồ", "Ổ",
				"ổ", "Ỗ", "ỗ", "Ộ", "ộ", "Ớ", "ớ", "Ờ", "ờ", "Ở", "ở", "Ỡ", "ỡ", "Ợ", "ợ", "Ụ", "ụ", "Ủ", "ủ", "Ứ", "ứ",
				"Ừ", "ừ", "Ử", "ử", "Ữ", "ữ", "Ự", "ự", "Ỳ", "ỳ", "Ỵ", "ỵ", "Ỷ", "ỷ", "Ỹ", "ỹ"};
		String[] expects = { "A", "A", "A", "A", "E", "E", "E", "I", "I", "O", "O", "O","O",
				"U", "U", "Y", "a", "a", "a", "a", "e", "e", "e", "i", "i", "o", "o", "o", "o", "u", "u", "y", "A","a", 
				"D", "d", "I", "i", "U", "u", "O", "o", "U", "u", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A",
				"a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a","E","e","E","e","E","e","E","e",
				"E", "e", "E", "e", "E", "e", "E", "e", "I", "i", "I", "i", "O", "o", "O", "o", "O", "o", "O", "o","O",
				"o", "O", "o", "O", "o", "O", "o", "O", "o", "O", "o", "O", "o", "O", "o","U","u","U","u","U","u",
				"U","u","U","u","U","u","U","u","Y","y","Y","y","Y","y","Y","y"};
		for (int i = 0; i < ss.length; i++) {
			String r = VNCharacterUtils.removeAccent(ss[i]);
			assertEquals(expects[i], r, "String are different");
		}
	}
	@Test
	void test_remove_accent_number() {
		String[] ss = {"1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10"};
		String[] expects ={"1", "2", "3", "4", "5", "6",
	            "7", "8", "9", "10"};
		for (int i = 0; i < ss.length; i++) {
			String r = VNCharacterUtils.removeAccent(ss[i]);
			assertEquals(expects[i], r, "String are different");
		}
	}
	@Test
	void test_remove_accent_real_word() {
		String[] ss = {"Mẫu xe số phổ thông Honda Biz – cái tên nghe có vẻ xa lạ và có thể khiến nhiều người lầm tưởng với dòng xe tay ga Honda Beat đang được nhập khẩu phân phối tại Việt Nam, tuy nhiên Biz thực chất là dòng xe máy phổ thông bán chạy nhất của Honda ở châu Âu. Mới đây, bản mới nhất của Honda Biz với sự lột xác về kiểu dáng thiết kế vừa được hãng xe Nhật Bản bán ra tại các thị trường thuộc khu vực châu Âu.Hướng đến nhóm khác hàng trẻ, những người tìm kiếm một chiếc xe máy nhỏ gọn, hợp túi tiền để đi lại trong thành phố... Honda Biz 2021 sở hữu thiết kế đơn giãn nhưng không kém phần thời trang. Phần đầu xe được tạo dáng tương tự mẫu Future tại Việt Nam, đồng thời có thêm hai dải đèn định vị kích thước khá lớn. Thân xe liền lạc kết hợp với chi tiết được tạo dạng, phối màu tương tự phong cách Honda Vision.Theo thông số kỹ thuật nhà sản xuất công bố, Honda Biz 2021 có hai phiên bản 110 và 125 phân khối, thiết kê tương tự nhau. Kích thước thân xe (dài x rộng x cao) ở mức 1.894 x 714 x 1.085 (mm), chiều dài cơ sở 1.264mm, chiều cao yên 753mm và trọng lượng xe chỉ 100kg.Tương tự các dòng xe máy số phổ thông tại Việt Nam, Honda Biz 2021 được thiết kế bình xăng dung tích 5,1 lít, kết hợp cùng hộc chứa đồ bố trí dưới yên xe. Xe sử dụng phuộc ống ống ở phía trước kết hợp bộ mâm đúc trên cả hai bánh. Honda trang bị phanh tang trống cho phiên bản Biz 110, trong khi bản Biz 125 sử dụng phanh đĩa trước, phanh sau loại tang trống. Các tiện ích khác trên xe bào gồm nút đề khởi động, bảng đồng hồ analog hiển thị thông số và 1 cổng sạc điện 12V.Phiên bản Honda Biz 110i trang bị động cơ xi-lanh đơn, 4 thì, làm mát bằng không khí, dung tích 109,1cc, cho công suất tối đa 8,33 mã lực tại 7.250 vòng/phút. Tromg khi đó, bản Honda Biz 125i dùng máy xi-lanh đơn, 4 thì, dung tích 124,9 cc kết hợp hệ thống phun xăng điện tử PGM Fi, cho công suất 9,2 mã lực tại 7.500 vòng/phút. Cả hai phiên bản đều sử dụng hộp số 4 cấp.Tại thị trường châu Âu, hai phiên bản của dòng xe máy số phổ thông Honda Biz có giá bán dự kiến khoảng 1.900 USD (tương đương 44,18 triệu đồng) cho bản 110i và trong khi bản 125i có giá khoảng 2.300 USD (53,48 triệu đồng). Honda chưa phân phối Biz tại thị trường châu Á khi những sản phẩm tương tự như Honda Wave hay Future vẫn đang bán chạy."};
		
		String[] expects ={"Mau xe so pho thong Honda Biz – cai ten nghe co ve xa la va co the khien nhieu nguoi lam tuong voi dong xe tay ga Honda Beat dang duoc nhap khau phan phoi tai Viet Nam, tuy nhien Biz thuc chat la dong xe may pho thong ban chay nhat cua Honda o chau Au. Moi day, ban moi nhat cua Honda Biz voi su lot xac ve kieu dang thiet ke vua duoc hang xe Nhat Ban ban ra tai cac thi truong thuoc khu vuc chau Au.Huong den nhom khac hang tre, nhung nguoi tim kiem mot chiec xe may nho gon, hop tui tien de di lai trong thanh pho... Honda Biz 2021 so huu thiet ke don gian nhung khong kem phan thoi trang. Phan dau xe duoc tao dang tuong tu mau Future tai Viet Nam, dong thoi co them hai dai den dinh vi kich thuoc kha lon. Than xe lien lac ket hop voi chi tiet duoc tao dang, phoi mau tuong tu phong cach Honda Vision.Theo thong so ky thuat nha san xuat cong bo, Honda Biz 2021 co hai phien ban 110 va 125 phan khoi, thiet ke tuong tu nhau. Kich thuoc than xe (dai x rong x cao) o muc 1.894 x 714 x 1.085 (mm), chieu dai co so 1.264mm, chieu cao yen 753mm va trong luong xe chi 100kg.Tuong tu cac dong xe may so pho thong tai Viet Nam, Honda Biz 2021 duoc thiet ke binh xang dung tich 5,1 lit, ket hop cung hoc chua do bo tri duoi yen xe. Xe su dung phuoc ong ong o phia truoc ket hop bo mam duc tren ca hai banh. Honda trang bi phanh tang trong cho phien ban Biz 110, trong khi ban Biz 125 su dung phanh dia truoc, phanh sau loai tang trong. Cac tien ich khac tren xe bao gom nut de khoi dong, bang dong ho analog hien thi thong so va 1 cong sac dien 12V.Phien ban Honda Biz 110i trang bi dong co xi-lanh don, 4 thi, lam mat bang khong khi, dung tich 109,1cc, cho cong suat toi da 8,33 ma luc tai 7.250 vong/phut. Tromg khi do, ban Honda Biz 125i dung may xi-lanh don, 4 thi, dung tich 124,9 cc ket hop he thong phun xang dien tu PGM Fi, cho cong suat 9,2 ma luc tai 7.500 vong/phut. Ca hai phien ban deu su dung hop so 4 cap.Tai thi truong chau Au, hai phien ban cua dong xe may so pho thong Honda Biz co gia ban du kien khoang 1.900 USD (tuong duong 44,18 trieu dong) cho ban 110i va trong khi ban 125i co gia khoang 2.300 USD (53,48 trieu dong). Honda chua phan phoi Biz tai thi truong chau A khi nhung san pham tuong tu nhu Honda Wave hay Future van dang ban chay."};
		for (int i = 0; i < ss.length; i++) {
			String r = VNCharacterUtils.removeAccent(ss[i]);
			System.out.println(r.length());
			System.out.println(expects[i].length());
			assertEquals(expects[i], r, "String are different");
		}
	}


}
