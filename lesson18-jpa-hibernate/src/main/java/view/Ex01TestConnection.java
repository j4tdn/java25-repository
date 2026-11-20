package view;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import connection.DbConnection;
import dao.HibernateItemGroupDao;
import dao.ItemGroupDao;
import persistence.ItemGroup;

public class Ex01TestConnection {

	public static void main(String[] args) {
		SessionFactory sessionFactory = DbConnection.getSessionFactory();
		System.out.println("sessionFactory: " + sessionFactory);

		Session s1 = sessionFactory.openSession();
		Session s2 = sessionFactory.openSession();
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);

		System.out.println("\n");

		Session s3 = sessionFactory.getCurrentSession();
		Session s4 = sessionFactory.getCurrentSession();
		System.out.println("s3: " + s3);
		System.out.println("s4: " + s4);
		
		// Thực tế, sử dụng getCurrentSession
		// Chỉ khi nào có những bài toán cần nhiều thead chạy song song cần nhiều
		// session mới dùng openSession
		
		// Lúc học: demo openSession trước
		
		System.out.println("\n");
		ItemGroupDao dao = new HibernateItemGroupDao();
		List<ItemGroup> groups = dao.getAll();
		groups.forEach(System.out::println);
	}
}
