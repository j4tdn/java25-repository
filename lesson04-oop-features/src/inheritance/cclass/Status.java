package inheritance.cclass;

// KDL đối tượng
// NEW --> là một giá trị của KDL enum Status

// Status NEW = new Status();

// Với class mình có thể khởi tạo thêm đối tượng ở bất kỳ đâu --> constructor mặc định là public
// Với enum luôn chứa danh sách các giá trị ko đổi bên trong enum của nó --> constructor mặc định là private
public enum Status {
	NEW, OLD
}
