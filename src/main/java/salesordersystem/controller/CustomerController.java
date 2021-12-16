package salesordersystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import salesordersystem.model.*;
import salesordersystem.service.*;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
//	@RequestMapping("/")
//	public String index() {
//		return "index";
//	}
	
	@RequestMapping("/customer")
	public String viewCustomer(Model model) {
		List<CustomerModel> customers = customerService.getCustomerList();
		System.out.println("customers fetched : " + customers);
		model.addAttribute("customers", customers);
		return "customer";
	}
	
	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public RedirectView handleCustomer(@ModelAttribute CustomerModel customerModel, HttpServletRequest request, Model model) {
		System.out.println(customerModel);
		model.addAttribute("customer_added_msg", "Customer added sucessfully...");
		customerService.insertCustomer(customerModel);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/customer");
		return redirectView;
	}

	@RequestMapping("/deletecustomer/{cid}")
	public RedirectView deleteHandler(@PathVariable("cid") int cid, HttpServletRequest request, Model model) {
		customerService.deleteCustomer(cid);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/customer");
		return redirectView;
	}
	
	@RequestMapping("/editcustomer/{cid}")
	public String editcustomer(@PathVariable("cid") int cid, Model model) {
		CustomerModel customer = customerService.getSingleCustomer(cid);
		model.addAttribute("customer", customer);
		return "customer";
	}
}