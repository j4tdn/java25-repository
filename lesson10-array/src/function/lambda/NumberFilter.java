package function.lambda;

@FunctionalInterface
public interface NumberFilter {
	boolean test(long num);
}
