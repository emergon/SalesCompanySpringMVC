package com.emergon.controller;

import com.emergon.entities.Product;
import com.emergon.service.ProductService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller//Used from Dispatcher Servlet to pass requests and get responses
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public ModelAndView listProducts(ModelAndView model) {
        List<Product> list = productService.findAll();
        model.setViewName("product/listProduct");
        model.addObject("listOfProducts", list);
        return model;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView getProductForm(ModelAndView model) {
        model.setViewName("product/formProduct");
        Product p = new Product();
        model.addObject("product", p);//bind form data with this Product object
        return model;
    }

    /**
     * * check redirect-attributes
     * https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/redirect-attributes.html
     * https://www.baeldung.com/spring-redirect-and-forward
     * @param c Product Object
     * @param result BindingResult
     * @param model
     * @return 
     */
    @PostMapping("/create")
    public ModelAndView addProduct(
            @ModelAttribute("product") @Valid Product c,BindingResult result//BindingResult must be after Valid product
            , ModelAndView model) {
        if(result.hasErrors()){
            model.setViewName("product/formProduct");
            return model;
        }
        productService.save(c);
        model.setViewName("redirect:/product/list");
        return model;
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("productId") int id, Model model) {
        Product c = productService.findById(id);
        model.addAttribute("product", c);
        return "product/formProduct";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int id, ModelAndView model) {
        productService.remove(id);
        return "redirect:/product/list";
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam("searchName") String searchName,
            Model theModel) {
        List<Product> products = productService.search(searchName);
        theModel.addAttribute("listOfProducts", products);
        return "product/listProduct";
    }

}
