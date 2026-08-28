package Bai2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SinhVien sv1 = new SinhVien(25664630,"Dung",9,8.5);
		SinhVien sv2 = new SinhVien(25664632,"An",8.5,6);
		SinhVien sv3 = new SinhVien();
		
		System.out.println("Nhap ma sinh vien sv3: ");
		int ma = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Nhap ten sinh vien sv3: ");
		String ten = sc.nextLine();
		
		System.out.println("Nhap diem LT sinh vien sv3: ");
		double diemLT = sc.nextDouble();
		
		System.out.println("Nhap diem TH sinh vien sv3: ");
		double diemTH = sc.nextDouble();
		
		sv3.setMaSV(ma);
		sv3.setTenSV(ten);
		sv3.setDiemLT(diemLT);
		sv3.setDiemTH(diemTH);
		
		System.out.println("\n" + "=".repeat(70));
        System.out.printf("%10s %10s %15s %10s %10s\n", "MSSV", "      Ho va Ten", "Diem LT", "   Diem TH", "    Diem TB");
        System.out.println("=".repeat(70));
        
        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);
	}

}
