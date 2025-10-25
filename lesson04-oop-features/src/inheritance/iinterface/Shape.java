package inheritance.iinterface;

public interface Shape {

	// Tu 1.1 den 1.7
	// Interface: chua cac ham truu tuong(abstract method): ham chi co phan khai bao, k co body
	
	// Trong KDL con(class) thuc thi thi bat buoc phai override lai
	// Mac dinh: tu them tu khoa public abstract
	// Moi phan dinh nghia trong 1 class hinh la khac nhau
	public abstract void calcS();
	
	// Cac hinh hoc, can ham moi --> clear(xoa hinh)
	// Co phan thuc thu la giong nhau cho tat ca cac loai hinh hoc
	// Tu 1.8, ham trong interface co the chua body
	// Su dung khi co ham chung(khai bao, thuc thi) trong cac class -> dua no vao interface
	// - chung khai bao
	// - k bi trung code override o class con
	
	// default(public default)
	// static(public static)
	// private
	default void clear() {
		System.out.println("Shape#clear");
	}
}
