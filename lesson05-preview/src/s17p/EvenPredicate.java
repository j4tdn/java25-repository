package s17p;

public class EvenPredicate implements Predicate {
	
	@Override
	public boolean test(int val) {
		return val % 2 == 0;
	}
	
}
