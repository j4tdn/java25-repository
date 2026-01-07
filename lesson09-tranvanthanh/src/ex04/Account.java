package ex04;

import java.util.Scanner;

public class Account {
		public static void main(String[] args) {
			
			Scanner ip = new Scanner(System.in);
			boolean Acc = false;
			boolean Pass = false;
			
			do {
				System.out.println("Nhập tên tài khoản: ");
				String account = ip.nextLine();
				
				try {
					Acc = validateAccount(account);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				
			}while(!Acc);
			
			do {
				System.out.println("Nhập mật khẩu: ");
				String password = ip.nextLine();
				
				try {
					Pass = validatePassword(password);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				
			}while(!Pass);
			
			if(Pass) {
				System.out.println("Đăng kí tài khoản thành công.");
			}
			
			
		}
		
		private static boolean validateAccount(String account) {
			int count = 1;
			for(int i =1; i< account.length();i++) {
				if(account.charAt(i) == account.charAt(i-1)) {
					count++;
					if(count>3) {
						throw new IllegalArgumentException("Accout có 3 kí tự bị trùng.");
					}
				}else {
					count = 1;
				}
			}
			
			return true;
		}
		
	private static boolean validatePassword(String password) {
		
		int len = password.length();
		if(len < 8) {
			throw new IllegalArgumentException("Password nhỏ hơn 8 kí tự.");
		}
		 int count = 0;
		 for(char i ='0';i<='9';i++) {
			 if(password.contains(Character.toString(i))) {
				 count ++;
				 if(count == 1)
					 break;
			 }
		 }
		 if(count == 0) {
			 throw new IllegalArgumentException("Password phải chưa ít nhất 1 chữ số.");
		 }
		 
		boolean uppercaseCharacters = false;
		for(int i = 0;i < len; i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				uppercaseCharacters = true;
				break;
			}
		}
		if(!uppercaseCharacters) {
			throw new IllegalArgumentException("Phải chứa ít nhất 1 kí tự in hoa.");
			
		}
		
		count = 0;
		String[] specialCharacter = {"(","~","!","@","#","$","%","^","&","*",")"};
		for(int i =0 ; i<specialCharacter.length;i++) {
			if(password.contains(specialCharacter[i])) {
				count++;
				if(count==1)
					break;
			}
		}
		if(count==0) {
			throw new IllegalArgumentException("Phải chứa ít nhất 1 kis tự đặt biệt");
		}
		 
		return true;
	}
}
