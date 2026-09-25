package HTP;

import java.time.LocalDate;

public class QuanLyThucPham {
	//-------------ATTRIBUTE-----------
	private HangThucPham[] ds;
	private int soLuong;
	private int khaNang;
	
	private final int SIZE_BAN_DAU = 5;
	
	//------CONSTRUCTOR--------
	public QuanLyThucPham() {
		this.khaNang = SIZE_BAN_DAU;
		this.ds = new HangThucPham[khaNang];
		this.soLuong = 0;
	}
	
	public QuanLyThucPham(int sucChua) {
		this.khaNang = (sucChua > 0) ? sucChua : SIZE_BAN_DAU;
		this.ds = new HangThucPham[this.khaNang];
		this.soLuong = 0;
	}
	
	//------------MO RONG MANG--------
	private void moRongMang() {
		int kichThuocMoi = khaNang * 2;
		HangThucPham[] dsMoi = new HangThucPham[kichThuocMoi];
		System.arraycopy(ds, 0, dsMoi, 0, soLuong); // Copy dữ liệu cũ sang mảng mới
		khaNang = kichThuocMoi;
		ds = dsMoi;
		System.out.println("Đã mở rộng mảng lên " + khaNang + " phần tử.");
	}
	
	//-----------TIM VI TRI THEO MA---------
	public int timVTtheoMa(String maHang) {
		for(int i = 0; i < soLuong; i++) { // Sửa i = 0 thay vì i = 1
			if(ds[i] != null && ds[i].getMaHang().equalsIgnoreCase(maHang)) return i;
		}
		return -1;
	}
	
	public int timVTtheoID(int id) {
		for(int i = 0; i < soLuong; i++) {
			if(ds[i] != null && ds[i].getID() == id) return i;
		}
		return -1;
	}
	
	//-----------THEM (CHONG TRUNG + TU DONG MO RONG)---------------
	public boolean Them(HangThucPham h) {
		if(h == null) return false;
		if(timVTtheoMa(h.getMaHang()) != -1) {
			System.out.println("LỖI! Mã hàng " + h.getMaHang() + " đã tồn tại!");
			return false;
		}
		if(soLuong == khaNang) moRongMang();
		ds[soLuong] = h;
		soLuong++;
		return true;
	}
	
	//-----------XÓA THEO ID---------------
	public boolean xoaTheoID(int id) {
		int pos = timVTtheoID(id);
		if(pos == -1) {
			System.out.println("Không tìm thấy ID!");
			return false;
		}
		for(int i = pos; i < soLuong - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds[soLuong-1] = null;
		soLuong--;
		return true;
	}
	
	//-----------SỬA THEO ID---------------
	public boolean suaTheoID(int id, String tenMoi, LocalDate ngaySXMoi, LocalDate ngayHHMoi, float giaMoi) {
		int pos = timVTtheoID(id);
		if(pos == -1) {
			System.out.println("Không tìm thấy ID!");
			return false;
		}
		ds[pos].setTenHang(tenMoi);
		ds[pos].setNgaySanXuat(ngaySXMoi);
		ds[pos].setNgayHetHan(ngayHHMoi);
		ds[pos].setGia(giaMoi);
		return true;
	}
	
	//-----------TÌM THEO ID (TRẢ VỀ ĐỐI TƯỢNG)---------------
	public HangThucPham timTheoID(int id) {
		int pos = timVTtheoID(id);
		return (pos == -1) ? null : ds[pos];
	}
	
	//-----------SẮP XẾP THEO GIÁ---------------
	public void sapXepTheoGia(boolean tangDan) {
		for(int i = 0; i < soLuong - 1; i++) {
			for(int j = i + 1; j < soLuong; j++) {
				boolean canDoi = tangDan 
					? ds[i].getGia() > ds[j].getGia() 
					: ds[i].getGia() < ds[j].getGia();
				if(canDoi) {
					HangThucPham temp = ds[i];
					ds[i] = ds[j];
					ds[j] = temp;
				}
			}
		}
		System.out.println("✔ Đã sắp xếp theo giá " + (tangDan ? "tăng dần" : "giảm dần"));
	}
	
	//-----------SẮP XẾP THEO NGÀY SẢN XUẤT---------------
	public void sapXepTheoNgaySanXuat(boolean tangDan) {
		for(int i = 0; i < soLuong - 1; i++) {
			for(int j = i + 1; j < soLuong; j++) {
				boolean canDoi = tangDan 
					? ds[i].getNgaySanXuat().isAfter(ds[j].getNgaySanXuat()) 
					: ds[i].getNgaySanXuat().isBefore(ds[j].getNgaySanXuat());
				if(canDoi) {
					HangThucPham temp = ds[i];
					ds[i] = ds[j];
					ds[j] = temp;
				}
			}
		}
		System.out.println("✔ Đã sắp xếp theo ngày SX " + (tangDan ? "tăng dần" : "giảm dần"));
	}
	
	//-----------SẮP XẾP THEO NGÀY HẾT HẠN---------------
	public void sapXepTheoNgayHetHan(boolean tangDan) {
		for(int i = 0; i < soLuong - 1; i++) {
			for(int j = i + 1; j < soLuong; j++) {
				boolean canDoi = tangDan 
					? ds[i].getNgayHetHan().isAfter(ds[j].getNgayHetHan()) 
					: ds[i].getNgayHetHan().isBefore(ds[j].getNgayHetHan());
				if(canDoi) {
					HangThucPham temp = ds[i];
					ds[i] = ds[j];
					ds[j] = temp;
				}
			}
		}
		System.out.println("✔ Đã sắp xếp theo ngày HH " + (tangDan ? "tăng dần" : "giảm dần"));
	}
	
	//-----------TÌM KIẾM / TRÍCH LỌC CÁC PHƯƠNG THỨC---------------
	public QuanLyThucPham timTheoTienTo(String tuKhoa) {
		QuanLyThucPham ketQua = new QuanLyThucPham();
		String tk = tuKhoa.toLowerCase();
		for(int i = 0; i < soLuong; i++) {
			if(ds[i].getTenHang().toLowerCase().startsWith(tk)) {
				ketQua.Them(ds[i]);
			}
		}
		return ketQua;
	}
	
	public QuanLyThucPham timTheoHauTo(String tuKhoa) {
		QuanLyThucPham ketQua = new QuanLyThucPham();
		String tk = tuKhoa.toLowerCase();
		for(int i = 0; i < soLuong; i++) {
			if(ds[i].getTenHang().toLowerCase().endsWith(tk)) {
				ketQua.Them(ds[i]);
			}
		}
		return ketQua;
	}
	
	public QuanLyThucPham timGanGiong(String tuKhoa) {
		QuanLyThucPham ketQua = new QuanLyThucPham();
		String tk = tuKhoa.toLowerCase();
		for(int i = 0; i < soLuong; i++) {
			if(ds[i].getTenHang().toLowerCase().contains(tk)) {
				ketQua.Them(ds[i]);
			}
		}
		return ketQua;
	}
	
	public QuanLyThucPham trichLocTheoNgaySanXuat(LocalDate tuNgay, LocalDate denNgay) {
		QuanLyThucPham ketQua = new QuanLyThucPham();
		for(int i = 0; i < soLuong; i++) {
			LocalDate ngaySX = ds[i].getNgaySanXuat();
			if(!ngaySX.isBefore(tuNgay) && !ngaySX.isAfter(denNgay)) {
				ketQua.Them(ds[i]);
			}
		}
		return ketQua;
	}
	
	public QuanLyThucPham trichLocTheoNgayHetHan(LocalDate tuNgay, LocalDate denNgay) {
		QuanLyThucPham ketQua = new QuanLyThucPham();
		for(int i = 0; i < soLuong; i++) {
			LocalDate ngayHH = ds[i].getNgayHetHan();
			if(!ngayHH.isBefore(tuNgay) && !ngayHH.isAfter(denNgay)) {
				ketQua.Them(ds[i]);
			}
		}
		return ketQua;
	}
	
	//-----------THỐNG KÊ---------------
	public int tinhTongSoLuong() {
		return soLuong;
	}
	
	public double tinhTongGiaTri() {
		double tong = 0;
		for(int i = 0; i < soLuong; i++) {
			tong += ds[i].getGia();
		}
		return tong;
	}
	
	public void thongKeTheoThang() {
		if(soLuong == 0) {
			System.out.println("Danh sách trống.");
			return;
		}
		int[] demTheoThang = new int[13];
		for(int i = 0; i < soLuong; i++) {
			int thang = ds[i].getNgaySanXuat().getMonthValue();
			demTheoThang[thang]++;
		}
		System.out.println("📊 THỐNG KÊ SẢN PHẨM THEO THÁNG SẢN XUẤT:");
		for(int t = 1; t <= 12; t++) {
			if(demTheoThang[t] > 0) {
				System.out.println("  Tháng " + t + ": " + demTheoThang[t] + " sản phẩm");
			}
		}
	}
	
	//-----------HIỂN THỊ CÁC PHƯƠNG THỨC---------------
	public void hienThiDanhSach() {
		if(soLuong == 0) {
			System.out.println("Danh sách trống.");
			return;
		}
		System.out.println("\n+------+------------+--------------------+--------------+--------------+------------+");
		System.out.println("|  ID  | Mã hàng    |      Tên hàng      |   Ngày SX    |   Ngày HH    |    Giá     |");
		System.out.println("+------+------------+--------------------+--------------+--------------+------------+");
		for(int i = 0; i < soLuong; i++) {
			System.out.println(ds[i]);
		}
		System.out.println("+------+------------+--------------------+--------------+--------------+------------+");
		System.out.println("Tổng cộng: " + soLuong + " sản phẩm.");
	}
	
	public int getSoLuong() {
		return soLuong;
	}
}