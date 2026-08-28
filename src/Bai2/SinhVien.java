package Bai2;

public class SinhVien {
	private int maSV;
	private String tenSV;
	private double diemLT;
	private double diemTH;
	
	//constructor mac dinh
	public SinhVien() {
		this.maSV = 0;
		this.tenSV = "";
		this.diemLT = 0.0;
		this.diemTH = 0.0;
	}
	
	//consructor co tham so
	public SinhVien(int maSV, String tenSV, double diemLT, double diemTH) {
		setMaSV(maSV);
		setTenSV(tenSV);
		setDiemLT(diemLT);
		setDiemTH(diemTH);
	}
	
	
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		if(maSV > 0) {
			this.maSV = maSV;
		}
		else {
			this.maSV = 0;
		}
	}
	
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public double getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(double diemLT) {
		if (diemLT >= 0.0 && diemLT <= 10.0) {
            this.diemLT = diemLT;
        } else {
            this.diemLT = 0.0;
        }
	}
	public double getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(double diemTH) {
		if (diemTH >= 0.0 && diemTH <= 10.0) {
            this.diemTH = diemTH;
        } else {
            this.diemTH = 0.0;
        }
	}
	
	public double tinhTB() {
		return (getDiemLT() + getDiemTH()) / 2;
	}
	
	@Override
	public String toString() {
		return String.format("%10d | %15s | % 10.2f | %10.2f | %10.2f", maSV,tenSV,diemLT,diemTH,tinhTB());
	}
	
}
