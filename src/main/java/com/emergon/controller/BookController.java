package com.emergon.controller;

import com.emergon.entities.Book;
import com.emergon.service.BookService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller//Used from Dispatcher Servlet to pass requests and get responses
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    /*
    GetMapping and PostMapping were added in Spring 4.3
     */
    @GetMapping("/list")//This method is invoked only for GET request at /book/list
    public ModelAndView listBooks(ModelAndView model) {
        List<Book> list = bookService.findAllBooks();
        model.setViewName("book/listBook");
        model.addObject("listOfBooks", list);
        return model;
    }

    @PostMapping("/list")
    public ModelAndView go(ModelAndView model) {
        List<Book> list = bookService.findAllBooks();
        model.setViewName("book/listBook");
        model.addObject("listOfBooks", list);
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView getBookForm(ModelAndView model) {
        model.setViewName("book/formBook");
        Book c = new Book();
        model.addObject("book", c);//bind form data with this Book object
        return model;
    }

    @PostMapping("/create")
    public ModelAndView addBook(
            @ModelAttribute("book") @Valid Book c,BindingResult result//BindingResult must be after Valid book
            , ModelAndView model) {
        
        if(result.hasErrors()){
            model.setViewName("book/formBook");
            return model;
        }
        bookService.saveBook(c);
        model.setViewName("forward:/book/list");
        return model;
    }
    
}
