package HTP;

import java.time.LocalDate;

public class HangThucPham implements Comparable<HangThucPham>{
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
	public HangThucPham(String maHang, String tenHang, LocalDate NgaySanXuat,LocalDate NgayHetHan, float gia) {
		if(maHang == null) throw new IllegalArgumentException("Ma hang khong duoc de trong");
		if(tenHang == null) throw new IllegalArgumentException("Ten hang khong duoc de trong");
		if(gia <= 0) throw new IllegalArgumentException("Gia phai lon hon 0!");
		if(!KTNgaySX(NgaySanXuat)) throw new IllegalArgumentException("Ngay SX khong duoc la tuong lai");
		if(!KTNgayHH(NgaySanXuat, NgayHetHan)) throw new IllegalArgumentException("Ngay HH khong duoc truoc ngay SX");
		
		this.id = ++demSL;
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.ngaySanXuat = NgaySanXuat;
		this.ngayHetHan = NgayHetHan;
		this.gia = gia;
	}
	
	
	//-----------KIEM TRA NGAY
	private boolean KTNgaySX(LocalDate ngaySX) {
		return ngaySX != null && ngaySX.isAfter(LocalDate.now());
	}
	
	private boolean KTNgayHH(LocalDate ngaySX, LocalDate ngayHH) {
		return ngaySX != null && ngayHH != null && ngayHH.isAfter(ngaySX);
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
	
	//---------------------SETTER------------------------
	public void setTenHang(String tenHang) {
		if(tenHang == null) throw new IllegalArgumentException("Ten hang khong duoc de trong");
		this.tenHang = tenHang;
	}
	
	public void setNgaySanXuat(LocalDate ngaySX) {
		if(!KTNgaySX(ngaySX)) throw new IllegalArgumentException("Ngay san xuat khong duoc la tuong lai");
		if(!KTNgayHH(ngaySX, ngayHetHan)) throw new IllegalArgumentException("Ngay SX khong duoc sau ngay het han");
		this.ngaySanXuat = ngaySX;
	}
	
	public void setNgayHetHan(LocalDate ngayHH) {
		if(this.ngaySanXuat == null) throw new IllegalArgumentException("Ngay san xuat khong ton tai");
		if(!KTNgayHH(this.ngaySanXuat, ngayHH)) throw new IllegalArgumentException("Ngay het han khong duoc truoc ngay sx");
		this.ngayHetHan = ngayHH;
	}
	
	public void setGia(float gia) {
		if(gia <= 0) throw new IllegalArgumentException("Gia khong duoc be hon 0");
		this.gia = gia;
	}
	
	//----------------KIEM TRA NGAY HET HAN----------------
	public boolean KTHetHan(){
		return LocalDate.now().isAfter(this.ngayHetHan);
	}
	
	public String trangThai() {
		LocalDate today = LocalDate.now();
		if(today.isBefore(this.ngaySanXuat)) return "Chua san xuat";
		if(today.isAfter(this.ngayHetHan)) return "het han";
		if(today.isEqual(this.ngayHetHan)) return "het han hom nay";
		long remain = this.ngayHetHan.toEpochDay() - today.toEpochDay();
		return "con " + remain + " ngay";
	}
	
	//------NGAN CHAN CLONE-----------
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Khong the sao chep hang thuc pham");
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
