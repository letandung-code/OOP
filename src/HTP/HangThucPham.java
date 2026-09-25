package HTP;

import java.time.LocalDate;

public class HangThucPham implements Comparable<HangThucPham> {
	private int id;
	private String maHang;
	private String tenHang;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;
	private float gia;
	
	private static int demSL = 0;
	
	//----CONSTRUCTOR MAC DINH
	public HangThucPham() {
		this.id = ++demSL;
		this.maHang = "mac dinh";
		this.tenHang = "Hang mac dinh";
		this.ngaySanXuat = LocalDate.now();
		this.ngayHetHan = LocalDate.now().plusDays(7);
		this.gia = 1.0f;
	}
	
	//-----CONSTRUCTOR CO THAM SO
	public HangThucPham(String maHang, String tenHang, LocalDate NgaySanXuat, LocalDate NgayHetHan, float gia) {
		if (maHang == null || maHang.trim().isEmpty()) throw new IllegalArgumentException("Mã hàng không được để trống");
		if (tenHang == null || tenHang.trim().isEmpty()) throw new IllegalArgumentException("Tên hàng không được để trống");
		if (gia <= 0) throw new IllegalArgumentException("Giá phải lớn hơn 0!");
		if (!KTNgaySX(NgaySanXuat)) throw new IllegalArgumentException("Ngày SX không được là tương lai!");
		if (!KTNgayHH(NgaySanXuat, NgayHetHan)) throw new IllegalArgumentException("Ngày HH không được trước ngày SX!");
		
		this.id = ++demSL;
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.ngaySanXuat = NgaySanXuat;
		this.ngayHetHan = NgayHetHan;
		this.gia = gia;
	}
	
	//-----------KIEM TRA NGAY (Đã sửa logic)
	private boolean KTNgaySX(LocalDate ngaySX) {
		return ngaySX != null && !ngaySX.isAfter(LocalDate.now());
	}
	
	private boolean KTNgayHH(LocalDate ngaySX, LocalDate ngayHH) {
		return ngaySX != null && ngayHH != null && !ngayHH.isBefore(ngaySX);
	}
	
	//---------------GETTER
	public int getID() {
		return id;
	}
	public String getMaHang() {
		return maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}
	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}
	public float getGia() { // Bổ sung Getter cho gia
		return gia;
	}
	
	//---------------------SETTER------------------------
	public void setTenHang(String tenHang) {
		if (tenHang == null || tenHang.trim().isEmpty()) throw new IllegalArgumentException("Tên hàng không được để trống");
		this.tenHang = tenHang;
	}
	
	public void setNgaySanXuat(LocalDate ngaySX) {
		if (!KTNgaySX(ngaySX)) throw new IllegalArgumentException("Ngày sản xuất không được là tương lai");
		if (!KTNgayHH(ngaySX, ngayHetHan)) throw new IllegalArgumentException("Ngày SX không được sau ngày hết hạn");
		this.ngaySanXuat = ngaySX;
	}
	
	public void setNgayHetHan(LocalDate ngayHH) {
		if (this.ngaySanXuat == null) throw new IllegalArgumentException("Ngày sản xuất không tồn tại");
		if (!KTNgayHH(this.ngaySanXuat, ngayHH)) throw new IllegalArgumentException("Ngày hết hạn không được trước ngày SX");
		this.ngayHetHan = ngayHH;
	}
	
	public void setGia(float gia) {
		if (gia <= 0) throw new IllegalArgumentException("Giá không được bé hơn hoặc bằng 0");
		this.gia = gia;
	}
	
	//----------------KIEM TRA NGAY HET HAN----------------
	public boolean KTHetHan() {
		return LocalDate.now().isAfter(this.ngayHetHan);
	}
	
	public String trangThai() {
		LocalDate today = LocalDate.now();
		if (today.isBefore(this.ngaySanXuat)) return "Chưa sản xuất";
		if (today.isAfter(this.ngayHetHan)) return "Hết hạn";
		if (today.isEqual(this.ngayHetHan)) return "Hết hạn hôm nay";
		long remain = this.ngayHetHan.toEpochDay() - today.toEpochDay();
		return "Còn " + remain + " ngày";
	}
	
	//------NGAN CHAN CLONE-----------
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Không thể sao chép hàng thực phẩm!");
	}
	
	@Override
	public int compareTo(HangThucPham o) {
		return Integer.compare(this.id, o.id);
	}
	
	@Override
	public String toString() {
		return String.format(
			"| %-4d | %-10s | %-18s | %-12s | %-12s | %-10.0f |",
			id, maHang, tenHang, ngaySanXuat, ngayHetHan, gia
		);
	}
}