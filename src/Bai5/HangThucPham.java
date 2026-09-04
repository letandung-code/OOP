package Bai5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham {
	private String maHang;
	private String tenHang;
	private int donGia;
	private LocalDate ngaySX;
	private LocalDate ngayHH;
	
	public HangThucPham(String maHang) {
		setMaHang(maHang);
		this.tenHang = "xxx";
		this.donGia = 0;
		this.ngaySX = LocalDate.now();
		this.ngayHH = this.ngaySX;
	}
	
	public HangThucPham(String maHang, String tenHang, int donGia, LocalDate ngaySX, LocalDate ngayHH) {
		setMaHang(maHang);
		setTenHang(tenHang);
		setDonGia(donGia);
		setNgaySX(ngaySX);
		setNgayHH(ngayHH);
	}



	public String getMaHang() {
		return maHang;
	}
	private void setMaHang(String maHang) {
		if(maHang == null || maHang.trim().isEmpty()) {
			throw new IllegalArgumentException("Mã hàng không được để trống"); //giá trị mặc định nếu trống
		}
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if(tenHang == null || tenHang.trim().isEmpty()) {
			this.tenHang = "xxx";
		}
		else this.tenHang = tenHang;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		if(donGia >= 0) {
			this.donGia = donGia;			
		}
		else this.donGia = 0;
	}
	public LocalDate getNgaySX() {
		return ngaySX;
	}
	
	public void setNgaySX(LocalDate ngaySX) {
		if(ngaySX.isBefore(LocalDate.now())) {
			this.ngaySX = ngaySX;			
		}
		else this.ngaySX = LocalDate.now();
	}
	
	public LocalDate getNgayHH() {
		return ngayHH;
	}
	
	public void setNgayHH(LocalDate ngayHH) {
		if(ngayHH.isAfter(ngaySX)) {
			this.ngayHH = ngayHH;
		}
		else {
			this.ngayHH = ngaySX;
		}
	}
	
	public String checkDate() {
		if(ngayHH.isBefore(LocalDate.now())) {
			return "Hàng hết hạn";
		}
		else return "";
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-10s %-20d %-15s %-15s %-15s", maHang,tenHang,donGia,ngaySX,ngayHH,checkDate());
	}
	
	
}
