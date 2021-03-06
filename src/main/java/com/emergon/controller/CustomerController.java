package com.emergon.controller;

import com.emergon.entities.Customer;
import com.emergon.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /*
    GetMapping and PostMapping were added in Spring 4.3
     */
    @GetMapping("/list")//This method is invoked only for GET request at /customer/list
    public ModelAndView listCustomers(ModelAndView model) {
        List<Customer> list = customerService.findAllCustomers();
        model.setViewName("customer/listCustomer");
        model.addObject("listOfCustomers", list);
        return model;
    }

    @PostMapping("/list")
    public ModelAndView go(ModelAndView model) {
        List<Customer> list = customerService.findAllCustomers();
        model.setViewName("customer/listCustomer");
        model.addObject("listOfCustomers", list);
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView getCustomerForm(ModelAndView model) {
        model.setViewName("customer/formCustomer");
        Customer c = new Customer();
        model.addObject("customer", c);//bind form data with this Customer object
        return model;
    }

    /**
     * * check redirect-attributes
     * https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/redirect-attributes.html
     * https://www.baeldung.com/spring-redirect-and-forward
     * @param c Customer Object
     * @param result BindingResult
     * @param model
     * @return 
     */
    @PostMapping("/create")
    public ModelAndView addCustomer(
            @ModelAttribute("customer") @Valid Customer c,BindingResult result//BindingResult must be after Valid customer
            , ModelAndView model) {
        //System.out.println("c====="+c);
        System.out.println("result===="+result);
        if(result.hasErrors()){
            model.setViewName("customer/formCustomer");
            return model;
        }
        customerService.saveCustomer(c);
//        model.addObject("message", "Customer created successfully");//For some reason, it cannot be rendered in html
        model.setViewName("redirect:/customer/list");
//        model.setViewName("forward:/customer/list");
        return model;
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("customerId") int id, Model model) {
        Customer c = customerService.findById(id);
        model.addAttribute("customer", c);//This goes to modelAttribute
        return "customer/formCustomer";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id, ModelAndView model) {
        customerService.removeCustomer(id);
//        model.setViewName("redirect:/customer/list");
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName,
            Model theModel) {
        // search customers from the service
        List<Customer> customers = customerService.searchCustomers(searchName);
        // add the customers to the model
        theModel.addAttribute("listOfCustomers", customers);
        return "customer/listCustomer";
    }

}
