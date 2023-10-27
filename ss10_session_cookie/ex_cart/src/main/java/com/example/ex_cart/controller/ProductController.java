package com.example.ex_cart.controller;

import com.example.ex_cart.dto.CartDTO;
import com.example.ex_cart.dto.ProductDTO;
import com.example.ex_cart.model.Product;
import com.example.ex_cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDTO initCart(){
        return new CartDTO();
    }
    @Autowired
    private IProductService service;

    @GetMapping("")
    public ModelAndView showListProduct(Model model, @CookieValue(value = "id", defaultValue = "-1") Integer id){
        if(id!=-1){
            model.addAttribute("historyProduct", service.findById(id).get());
        } else {
            model.addAttribute("historyProduct", service.findById(1).get());
        }
        return new ModelAndView("home", "list", service.showList());
    }
    @GetMapping("{id}/add")
    public String addToCart(@PathVariable Integer id,
                            @SessionAttribute("cart") CartDTO cartDTO
                            ){
        Optional<Product> productOptional=service.findById(id);
        if(productOptional.isPresent()){
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productOptional.get(), productDTO);
            cartDTO.addProduct(productDTO);
        }
        return "redirect:/cart";
    }
    @GetMapping("{id}/detail")
    public String showDetailProduct(@PathVariable Integer id, Model model, HttpServletResponse response){
        Cookie cookie=new Cookie("id", id+"");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", service.findById(id).get());
        return "detail";
    }
}
