package Bai4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Vehicle s1 = new Vehicle("Dung","Vario", 125, 45000000);
		Vehicle s2 = new Vehicle("Dũng","SH",350,150000000);
		Vehicle s3 = new Vehicle();
		
		System.out.println("Nhập tên chủ xe: ");
		String ten = sc.nextLine();
		
		System.out.println("Nhập loại xe: ");
		String loaiXe = sc.nextLine();
		
		System.out.println("Nhập dung tích: ");
		int dungTich = sc.nextInt();
		
		System.out.println("Nhập trị giá xe: ");
		int triGia = sc.nextInt();
		
		s3.setChuXe(ten);
		s3.setLoaiXe(loaiXe);
		s3.setDungTich(dungTich);
		s3.setTriGiaXe(triGia);
		
		System.out.printf("%-15s %-10s %-10s %-10s %-10s\n","Tên chủ xe","Loại xe","Dung Tích","Trị giá","Thuế");
		System.out.printf("===========================================================\n");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
