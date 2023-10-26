package com.example.ex_book.controller;

import com.example.ex_book.model.Book;
import com.example.ex_book.model.Card;
import com.example.ex_book.service.IServiceBook;
import com.example.ex_book.service.IServiceCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class BookController {
    @Autowired
    private IServiceBook serviceBook;
    @Autowired
    private IServiceCard serviceCard;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ModelAndView("home", "list", serviceBook.showList(pageable));
    }

    @GetMapping("{id}/detail")
    public String showDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("book", serviceBook.detail(id));
        return "order";
    }

    @PostMapping("/order")
    public String success(@ModelAttribute Book book, Model model) {
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            serviceBook.save(book);
            int number = (int) (Math.random() * 100000);
            serviceCard.saveCode(new Card(number, serviceBook.detail(book.getId())));
            model.addAttribute("message", "Mã số mượn sách của bạn là: " + number);
            return "success";
        } else {
            return "error_order";
        }
    }

    @GetMapping("/delete")
    public String showPage(Model model) {
        model.addAttribute("card", new Card());
        return "return_book";
    }

    @PostMapping("/delete")
    public String payBook(@ModelAttribute Card card) {
        Card cardPay = serviceCard.detail(card.getCode());
        if (cardPay != null) {
            serviceCard.delete(cardPay);
            Integer id = cardPay.getBook().getId();
            Book book = serviceBook.detail(id);
            book.setQuantity(book.getQuantity() + 1);
            serviceBook.save(book);
            return "success_pay";
        } else {
            return "error";
        }
    }

    @GetMapping("/book")
    public ModelAndView showMyBook() {
        return new ModelAndView("my_book", "list", serviceCard.showMyBook());
    }
}
