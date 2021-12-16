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
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item")
	public String viewItem(Model model) {
		List<ItemModel> items = itemService.getItemList();
		System.out.println("items fetched : " + items);
		model.addAttribute("items", items);
		return "item";
	}
	
	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public RedirectView handleItem(@ModelAttribute ItemModel itemModel, HttpServletRequest request, Model model) {
		System.out.println(itemModel);
		model.addAttribute("item_added_msg", "Item added sucessfully...");
		itemService.insertItem(itemModel);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/item");
		return redirectView;
	}

	@RequestMapping("/deleteitem/{itemId}")
	public RedirectView deleteHandler(@PathVariable("itemId") int itemId, HttpServletRequest request, Model model) {
		itemService.deleteItem(itemId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/item");
		return redirectView;
	}
	
	@RequestMapping("/edititem/{itemId}")
	public String edititem(@PathVariable("itemId") int itemId, Model model) {
		ItemModel item = itemService.getSingleItem(itemId);
		model.addAttribute("item", item);
		return "item";
	}
}