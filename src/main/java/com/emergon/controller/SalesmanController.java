package com.emergon.controller;

import com.emergon.entities.Salesman;
import com.emergon.entities.Salesman;
import com.emergon.service.SuperService;
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
@RequestMapping("/salesman")
public class SalesmanController {

    @Autowired
    SuperService<Salesman> service;

    @GetMapping("/list")
    public ModelAndView listSalesmen(ModelAndView model) {
        List<Salesman> list = service.findAll();
        model.setViewName("salesman/listSalesman");
        model.addObject("listOfSalesmen", list);
        return model;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView getSalesmanForm(ModelAndView model) {
        model.setViewName("salesman/formSalesman");
        Salesman p = new Salesman();
        model.addObject("salesman", p);//bind form data with this Salesman object
        return model;
    }

    /**
     * * check redirect-attributes
     * https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/redirect-attributes.html
     * https://www.baeldung.com/spring-redirect-and-forward
     * @param c Salesman Object
     * @param result BindingResult
     * @param model
     * @return 
     */
    @PostMapping("/create")
    public ModelAndView addSalesman(
            @ModelAttribute("salesman") @Valid Salesman c,BindingResult result//BindingResult must be after Valid salesman
            , ModelAndView model) {
        if(result.hasErrors()){
            model.setViewName("salesman/formSalesman");
            return model;
        }
        service.save(c);
        model.setViewName("redirect:/salesman/list");
        return model;
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("salesmanId") int id, Model model) {
        Salesman c = service.findById(id);
        model.addAttribute("salesman", c);
        return "salesman/formSalesman";
    }

    @GetMapping("/delete")
    public String deleteSalesman(@RequestParam("salesmanId") int id, ModelAndView model) {
        service.remove(id);
        return "redirect:/salesman/list";
    }

    @GetMapping("/search")
    public String searchSalesmen(@RequestParam("searchName") String searchName,
            Model theModel) {
        List<Salesman> salesmans = service.search(searchName);
        theModel.addAttribute("listOfSalesmen", salesmans);
        return "salesman/listSalesman";
    }

}
