package salesordersystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import salesordersystem.model.*;
import salesordersystem.service.*;

@Controller
public class OrderDetailsController {

		@Autowired
		private OrderDetailsService orderDetailsService;
		@Autowired
		private CustomerService customerService;
		@Autowired
		private ItemService itemService;
		
		
		@RequestMapping("/")
		public String index(Model model) {
			List<OrderDetailsModel> orderdetailsmodel = orderDetailsService.getOrderDetailsList();
//			System.out.println("order details fetched : " + orderdetailsmodel);
			model.addAttribute("orderdetails", orderdetailsmodel);
			List<CustomerModel> customers = customerService.getCustomerList();
			List<ItemModel> items = itemService.getItemList();
			model.addAttribute("customers", customers);
			model.addAttribute("items", items);
			return "index";
		}
		
		@RequestMapping(value = "/payment")
		public RedirectView payment(@ModelAttribute OrderDetailsModel orderDetailsModel, HttpServletRequest request, Model model) {
//			List<CustomerModel> customers = customerService.getCustomerList();
//			model.addAttribute("customers", customers);
//			float amount = orderDetailsModel.getQty() * orderDetailsModel.get
//			orderDetailsService.insertOrderDetails(orderDetailsModel);
			List<OrderDetailsModel> orderDetails = orderDetailsService.getOrderDetailsList();
			model.addAttribute("orderDetails", orderDetails);

			RedirectView redirectView = new RedirectView();
			if(orderDetailsModel.getPayStatus() == "Completed") {
				redirectView.setUrl(request.getContextPath() + "/orderdetails");
			}
			else {
				redirectView.setUrl(request.getContextPath() + "/payment");
			}
			return redirectView;
		}
		
		
		@RequestMapping(value = "/orderdetails")
		public String orderDetails(@ModelAttribute OrderDetailsModel orderDetailsModel, Model model) {
			List<OrderDetailsModel> orderDetails = orderDetailsService.getOrderDetailsList();
			model.addAttribute("orderDetails", orderDetails);
			System.out.println("order details: "+ orderDetails);
			return "orderdetails";
		}


//		@RequestMapping("/deletecustomer/{cid}")
//		public RedirectView deleteHandler(@PathVariable("cid") int cid, HttpServletRequest request, Model model) {
//			customerService.deleteCustomer(cid);
//			RedirectView redirectView = new RedirectView();
//			redirectView.setUrl(request.getContextPath() + "/customer");
//			return redirectView;
//		}
//		
//		@RequestMapping("/editcustomer/{cid}")
//		public String editcustomer(@PathVariable("cid") int cid, Model model) {
//			CustomerModel customer = customerService.getSingleCustomer(cid);
//			model.addAttribute("customer", customer);
//			return "customer";
//		}
}
