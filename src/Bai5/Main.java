package Bai5;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // LocalDate.parse() mặc định hiểu định dạng yyyy-MM-dd
        LocalDate ngaySX = LocalDate.parse("2018-07-10");
        LocalDate ngayHH = LocalDate.parse("2027-07-16");
        
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %-15s","Mã Hàng","Tên hàng","Đơn giá","Ngày SX","Ngày HH","Ghi chú");
        System.out.println("\n------------------------------------------------------------------------------------");
     
        HangThucPham s1 = new HangThucPham("001", "Gạo", 100000, ngaySX, ngayHH);
        
        LocalDate ngaySX1 = LocalDate.parse("2018-07-10");
        LocalDate ngayHH1 = LocalDate.parse("2019-07-16");
        HangThucPham s2 = new HangThucPham("002","Mì",5000,ngaySX1,ngayHH1);
        HangThucPham s3 = new HangThucPham("003");
        HangThucPham s4 = new HangThucPham("");
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        //System.out.println(s4);
    }
    
}
