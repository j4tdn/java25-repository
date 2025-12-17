package fa.mockproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import fa.mockproject.model.Book;
import fa.mockproject.model.Genre;
import fa.mockproject.service.BookService;
import fa.mockproject.service.GenreService;

@Controller
public class BookListController {
	@Autowired
	BookService bookService;
	@Autowired
	GenreService genreService;
	
	@GetMapping("/book_list")
	public String displayBookList(Model model) {
		List<Book> bookList = bookService.findAll();
		List<Genre> genreList = genreService.findAll();
		model.addAttribute("actionUrl", "book_list");
		model.addAttribute("books", bookList);
		model.addAttribute("genres", genreList);
		
		return "content/book_list";
	}
	
	@GetMapping("/book_list/search")
	public String displaySearchResult(HttpServletRequest req, Model model) {
		
		String sql = (addConditionGenre(req).isEmpty()) ? getQuerySearchWithPrice(req) + addConditionName(req)
			: getQuerySearchWithPrice(req)+ " and " + addConditionGenre(req)+ addConditionName(req);
		
		List<Book> bookList = bookService.findBooksByCondition(sql);
		List<Genre> genreList = genreService.findAll();
		if(req.getParameter("minPrice")!= null)
		{
			model.addAttribute("minPrice", req.getParameter("minPrice"));
		}
		if(req.getParameter("maxPrice")!= null)
		{
			model.addAttribute("maxPrice", req.getParameter("maxPrice"));
		}
		
		String[] options = req.getParameterValues("option");
		if(options != null)
		{
			String optionsString = String.join(",", options);
			model.addAttribute("options", optionsString);
			for (String string : options) {
				System.out.println(string);
			}
		}
		
		if(req.getParameter("all")!= null) {
			model.addAttribute("all", "on");
		}
		
		int totalBooksFound = (bookList == null)? 0 :bookList.size();
		if (bookList == null || bookList.isEmpty()) {
			
			sql = (addConditionGenre(req).isEmpty()) ? getQuerySearchWithPrice(req) 
			: (getQuerySearchWithPrice(req)+ " or " + addConditionGenre(req));
			
			
			bookList = bookService.findBooksByCondition(sql).size() < 1 ? bookService.findAll() : bookService.findBooksByCondition(sql);															
			}
		
		model.addAttribute("totalBooksFound", totalBooksFound);
		model.addAttribute("genres", genreList);
		model.addAttribute("books", bookList);
		
		return "content/book_list";
	}
	
	public String getQuerySearchWithPrice(HttpServletRequest req) {
		
		int minPrice = (req.getParameter("minPrice").isEmpty())? 0 : Integer.parseInt(req.getParameter("minPrice"));
		int maxPrice = (req.getParameter("maxPrice").isEmpty())? 999999999: Integer.parseInt(req.getParameter("maxPrice"));
				
		return "SELECT * FROM BOOK WHERE (price between " + minPrice + " and " + maxPrice +") " ;
	}
	
	public String addConditionGenre(HttpServletRequest req) {
		String genre=""; 
		String[] options = req.getParameterValues("option");
		 if (options == null || options.length == 0) {
		        return "";
		    }
		if(options!= null) {
			genre = String.join("', '", req.getParameterValues("option"));
		}
		
		return " genreId in('"+ genre + "')";
		
	}
	
	public String addConditionName(HttpServletRequest req) {
		String search_value = req.getParameter("search_value").trim().replaceAll("\\s+", " ");
		System.out.println(search_value);
		if(search_value != null) {
			return "and book_name COLLATE SQL_Latin1_General_CP1_CI_AI like '%" + search_value + "%'";
		} else {
			return "";
		}
	}
}