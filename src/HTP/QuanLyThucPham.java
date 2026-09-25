package HTP;

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
	
	//------------MO RONG MANG--------
	private void moRongMang() {
		int kichThuocMoi = khaNang * 2;
		HangThucPham[] dsMoi = new HangThucPham[kichThuocMoi];
		khaNang = kichThuocMoi;
		ds = dsMoi;
		System.out.println("Da mo rong mang");
	}
	//-----------TIM VI TRI THEO MA---------
	public int timVTtheoMa(String maHang) {
		for(int i = 1; i <= soLuong	;i++) {
			if(ds[i].getMaHang().equalsIgnoreCase(maHang)) return i;
		}
		return -1;
	}
	
	public int timVTtheoID(int id) {
		for(int i = 0; i < soLuong; i++) {
			if(ds[i].getID() == id) return i;
		}
		return -1;
	}
	
	//-----------THEM (CHONG TRUNG + TU DONG MO RONG)---------------
	public boolean Them(HangThucPham h) {
		if(timVTtheoMa(h.getMaHang()) != -1) {
			System.out.println("LOI! Ma hang ma ton tai");
			return false;
		}
		if(soLuong == khaNang) moRongMang();
		ds[soLuong] = h;
		soLuong++;
		return true;
	}
	
	public boolean xoaTheoID(int id) {
		int pos = timVTtheoID(id);
		if(pos == -1) {
			System.out.println("Khong tim thay ID!");
			return false;
		}
		for(int i = pos; i < soLuong - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds[soLuong-1] = null;
		soLuong--;
		return true;
	}
	
	
}
