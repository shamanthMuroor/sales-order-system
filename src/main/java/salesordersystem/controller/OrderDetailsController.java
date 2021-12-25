package salesordersystem.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		@Autowired
		private ChequeService chequeService;
		
		
		@RequestMapping(value = "/")
		public String index(Model model) {
			List<OrderDetailsModel> orderdetailsmodel = orderDetailsService.getOrderDetailsList();
			model.addAttribute("orderdetails", orderdetailsmodel);
			List<CustomerModel> customers = customerService.getCustomerList();
			List<ItemModel> items = itemService.getItemList();
			model.addAttribute("customers", customers);
			model.addAttribute("items", items);
			return "index";
		}

		
		@RequestMapping(value = "/payment")
		public String addOrderDetails(@ModelAttribute("orderDetailsModel") OrderDetailsModel orderDetailsModel, @RequestParam String cusname, @RequestParam String itemName, HttpServletRequest request, Model model) {
			orderDetailsModel.setCusname(cusname);
			orderDetailsModel.setItemName(itemName);
			List<ItemModel> item = itemService.getItemList();
			float amt = 0;
			for(ItemModel it : item) {
				if(it.getItemName().equals(itemName)) {
					amt = it.getPrice(); 
					break;
				}
			}
			orderDetailsModel.setAmount(orderDetailsModel.getQty() * amt);
			orderDetailsService.insertOrderDetails(orderDetailsModel);
			System.out.println(orderDetailsModel.getAmount());
			model.addAttribute("orderDetailsModel", orderDetailsModel);
			return "payment";
		}
		
		
		@RequestMapping(value = "/orderdetails")
		public String orderDetails(@ModelAttribute OrderDetailsModel orderDetailsModel, Model model) {
			List<OrderDetailsModel> orderDetails = orderDetailsService.getOrderDetailsList();
			model.addAttribute("orderDetails", orderDetails);
//			System.out.println("order details: "+ orderDetails); 
			return "orderdetails";
		}

		
		@RequestMapping(value = "/transaction", method=RequestMethod.POST)
		public String payment(@ModelAttribute ChequeModel cheque, @RequestParam int orderId, Model model) {
			OrderDetailsModel odm = orderDetailsService.getSingleOrderDetails(orderId);
			odm.setPayStatus("PAID");
			orderDetailsService.insertOrderDetails(odm);
			return "success";
		}
		
//		@RequestMapping(value = "/transaction/cheque", method=RequestMethod.POST)
//		public String payment(@ModelAttribute ChequeModel cheque, @RequestParam int orderId, Model model) {
////			chequeService.insertCheque(cheque);
//			OrderDetailsModel odm = orderDetailsService.getSingleOrderDetails(orderId);
//			odm.setPayStatus("PAID");
//			orderDetailsService.insertOrderDetails(odm);
//			return "success";
//		}

		@RequestMapping(value = "/deleteorderdetails/{orderDetailsId}")
		public RedirectView deleteHandler(@PathVariable("orderDetailsId") int orderDetailsId, HttpServletRequest request, Model model) {
			orderDetailsService.deleteOrderDetails(orderDetailsId);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/orderdetails");
			return redirectView;
		}
		
//		@RequestMapping(value = "/editorderdetails/{orderDetailsId}")
//		public RedirectView editcustomer(@PathVariable("orderDetailsId") int orderDetailsId, HttpServletRequest request, Model model) {
//			CustomerModel customer = customerService.getSingleCustomer(cid);
//			model.addAttribute("customer", customer);
//			return "index";
//		}
}
