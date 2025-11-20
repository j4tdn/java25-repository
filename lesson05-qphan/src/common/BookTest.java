package common;

import bean.Book;

@FunctionalInterface
public interface BookTest {
	
	boolean isMatch(Book book);
	
}
