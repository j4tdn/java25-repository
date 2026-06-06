package calculation.processor;

/**
 * Xử lý cho 1 bước tính toán
 * R: Kết quả trả về sau mỗi bước tính toán
 */
public interface Processor<R> {
	
	R process();
	
}
