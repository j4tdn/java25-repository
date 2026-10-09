package view;

import connection.DbConnection;

public class Ex01TestConnection {
	
	public static void main(String[] args) {
		System.out.println("Connection: " + DbConnection.getConnection());
	}
	
}
