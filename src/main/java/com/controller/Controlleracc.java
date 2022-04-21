package com.controller;

import com.pojo.Books;
import com.pojo.BooksExample;
import com.service.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @param
 * @BelongsProject: SSM_CRUD
 * @BelongsPackage: com.controller
 * @Date: 2022/4/18 0:31
 * @Description: TODO
 * @return
 */
@Controller
public class Controlleracc {

    private ModelAndView modelAndView=new ModelAndView();

    @Autowired
    @Qualifier("BookServiceImpl")
    private BooksServiceImpl booksService;



    @GetMapping("/book")
    private ModelAndView selectAllBook(){
        List<Books> books = booksService.selectByExample(null);
        modelAndView.addObject("books",books);
        modelAndView.setViewName("select");
        return modelAndView;
    }

    @PostMapping("/book")
    private ModelAndView addBook(Books books){
        booksService.insert(books);
        modelAndView.setViewName("redirect:/book");
        return modelAndView;
    }

    @DeleteMapping("/book/{id}")
    private ModelAndView deleteBook(@PathVariable("id") Integer id){
        BooksExample booksExample = new BooksExample();
        booksExample.createCriteria().andBookidEqualTo(id);
        booksService.deleteByExample(booksExample);
        modelAndView.setViewName("redirect:/book");
        return modelAndView;
    }

    @GetMapping("/book/{id}")
    private ModelAndView selectBook(@PathVariable("id")Integer id){
        BooksExample booksExample = new BooksExample();
        booksExample.createCriteria().andBookidEqualTo(id);
        List<Books> book = booksService.selectByExample(booksExample);
        modelAndView.addObject("book",book);
        modelAndView.setViewName("updata");
        return modelAndView;
    }
    @PutMapping("/book")
    private ModelAndView updataBookById(Books books){
        BooksExample booksExample=new BooksExample();
        booksExample.createCriteria().andBookidEqualTo(books.getBookid());
        booksService.updateByExampleSelective(books,booksExample);
        modelAndView.setViewName("redirect:/book");
        return modelAndView;
    }
}
