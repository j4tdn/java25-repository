package functional;

import bean.Apple;

@FunctionalInterface
public interface AppleCondition {
	boolean test(Apple a);
}
