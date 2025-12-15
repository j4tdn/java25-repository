package view.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class Ex01 {

    public static void main(String[] args) {
       SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
       Scanner sc = new Scanner(System.in);
       
       try {
    	   System.out.println("Nhap ngay bat dau yeu (dd/mm/yyyy HH:mm:ss): ");
    	   Date start = sdf.parse(sc.nextLine());
    	   
    	   Date end;
    	   System.out.println("Ban da chia tay Chua(y/n)");
    	   String chon = sc.nextLine();
    	   if(chon.equalsIgnoreCase("y")) {
    		   System.out.println("Nhap ngay ctay (dd/mm/yyyy HH:mm:ss):  ");
    		   end = sdf.parse(sc.nextLine());
    		   
    	   }else {
    		   end = new Date();
    	   }
    	   
    	   long tong = end.getTime() - start.getTime();
    	   
    	   long giay = tong / 1000 % 60;
    	   long phut = tong / (1000 * 60) % 60;
    	   long gio = tong / (1000 * 60 * 60) % 24;
    	   long ngay = tong / (1000 * 60 * 60 * 24);
    	   long thang = ngay / 30;
    	   long nam = thang / 12;
    	   
    	   
    	   System.out.printf( "Tổng thời gian yêu: %d năm %d tháng %d ngày %d giờ %d phút %d giây\n", 
    			   nam, thang % 12, ngay % 30, gio, phut, giay );
    	   
       }catch(ParseException e) {
    	   System.out.println("Ghi sai dinh dang muoi h, vui long nhap lai dd/MM/yyyy HH:mm:ss");
       }
       
    }
}
