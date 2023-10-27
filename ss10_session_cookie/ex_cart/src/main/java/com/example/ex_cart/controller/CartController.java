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

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private IProductService service;
    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute (value = "cart",required = false) CartDTO cartDTO, Model model){
        Double total= cartDTO.totalPrice();
        if(total==0.0){
            model.addAttribute("total", 0);
        } else {
            model.addAttribute("total", total);
        }
        return new ModelAndView("cart","cart",cartDTO);
    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Integer id,@SessionAttribute (value = "cart",required = false) CartDTO cartDTO){
        Product product=service.findById(id).get();
        ProductDTO productDTO=new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        cartDTO.deleteProduct(productDTO);
        return "redirect:/cart";
    }
    @GetMapping("{id}/increase")
    public String increaseProduct(@PathVariable Integer id, @SessionAttribute (value = "cart",required = false) CartDTO cartDTO){
        Product product=service.findById(id).get();
        ProductDTO productDTO=new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        cartDTO.increaseProduct(productDTO);
        return "redirect:/cart";
    }

    @GetMapping("{id}/decrease")
    public String decreaseProduct(@PathVariable Integer id, @SessionAttribute (value = "cart",required = false) CartDTO cartDTO){
        Product product=service.findById(id).get();
        ProductDTO productDTO=new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        cartDTO.descreaseProduct(productDTO);
        return "redirect:/cart";
    }

}
