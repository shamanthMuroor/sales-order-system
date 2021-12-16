//package salesordersystem.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import salesordersystem.model.Customer;
//import salesordersystem.model.Item;
//import salesordersystem.model.Order;
//
//import salesordersystem.model.*;
//import salesordersystem.service.*;
//
//@Controller
//public class ControllerSOS {
//
//	@RequestMapping(value="/", method = RequestMethod.GET)
//	public String index() {
//		return "index";
//	}
//	
//	@RequestMapping(value="/create-order", method = RequestMethod.POST)
//	public String newOrderCustomerDetails(@ModelAttribute("customer") Customer customer, Model model) {
//		try {
//			Order order = new Order();
//			order.insertToCustomer(customer);
//			model.addAttribute("customer", customer);
//			return "create-order-menu";
//		} 
//		catch(Exception e) {
//			System.out.println("Could not insert data into database");
//			model.addAttribute("error", "Error: Could not create new order!!!");
//			return "customer-details";
//		}
//	}
//	
//	@RequestMapping(value="/payment-details", method = RequestMethod.POST)
//	public String newOrderItemDetails(@ModelAttribute("item") Item item, Model model) {
//		try {
//			Order order = new Order();
//			order.insertToItem(item);
//			model.addAttribute("item", item);
//			return "order-created";
//		} 
//		catch(Exception e) {
//			System.out.println("Could not insert data into database");
//			model.addAttribute("error", "Error: Could not create new order!!!");
//			return "create-order-menu";
//		}
//	}
//	
//
//	@RequestMapping(value="/display", method = RequestMethod.POST)
//	public String displayOrderDetails(Model model) {
//		try {
//			Order order = new Order();
//			List<Object> cusArrList = order.display();
//			
//			System.out.println("Customer: " + cusArrList.get(0));
//			System.out.println("Items: " + cusArrList.get(1));
//			Customer cust = (Customer) cusArrList.get(0);
//			Item it = (Item) cusArrList.get(1);
////			for(Customer c : cust) {
////				System.out.println(c);
////			}
//			model.addAttribute("cust", cust);
////			model.addAttribute("items", it);
//			
//			return "display";
//		} 
//		catch(Exception e) {
//			System.out.println("err");
//			e.printStackTrace();
////			model.addAttribute("error", "Error: Could not create new order!!!");
//			return "index";
//		}
//	}
//	
//}
//
//
//
////<!-- <c:forEach items="${cusArrList}" var="customer">
////	<c:forEach items="${customer}" var="cus">
////	<tr>      
////    	<td>${cus.customerID}</td>
////    	<td>${cus.cusName}</td>
////	</tr>
////	<br>
////</c:forEach>
////</c:forEach> --> 	