package Bai4;

public class Vehicle {
	private String chuXe;
	private String loaiXe;
	private int dungTich;
	private int triGiaXe;
	
	public Vehicle() {
		this.chuXe = "";
		this.loaiXe = "";
		this.dungTich = 0;
		this.triGiaXe = 0;
	}
	
	public Vehicle(String chuXe, String loaiXe, int dungTich, int triGiaXe) {
		this.chuXe = chuXe;
		this.loaiXe = loaiXe;
		setDungTich(dungTich);
		setTriGiaXe(triGiaXe);
	}
	
	public String getChuXe() {
		return chuXe;
	}
	public void setChuXe(String chuXe) {
		this.chuXe = chuXe;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public int getTriGiaXe() {
		return triGiaXe;
	}
	
	public void setTriGiaXe(int triGiaXe) {
		if(triGiaXe >= 0) {
			this.triGiaXe = triGiaXe;			
		}
		else {
			this.triGiaXe = 0;
		}
	}
	
	public int getDungTich() {
		return dungTich;
	}
	public void setDungTich(int dungTich) {
		if(dungTich >= 0) {
			this.dungTich = dungTich;			
		}
		else {
			this.dungTich = 0;
		}
	}
	
	public double thue() {
		if(dungTich < 100) {
			return (triGiaXe / 100.0 * 1);
		}
		else if(dungTich <= 200) {
			return (triGiaXe / 100.0 * 3);
		}
		else return triGiaXe /100.0 * 5;
	}
	
	@Override
	public String toString() {
		return String.format("%-15s %-10s %-10d %-10d %-10.2f", chuXe,loaiXe, dungTich, triGiaXe, thue());
	}
	
}
