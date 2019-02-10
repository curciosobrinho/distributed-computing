package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;

@Controller
@RequestMapping("/purchase")
public class Purchase {

	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ... instantiate and set order object with items to display
		Item item1 = new Item();
		item1.setName("Cup Wonder");
		item1.setPrice("5.90");

		Item item2 = new Item();
		item2.setName("Cup Magic");
		item2.setPrice("4.90");

		Item item3 = new Item();
		item3.setName("Cup Dad Rocks");
		item3.setPrice("6.10");

		Item item4 = new Item();
		item4.setName("Cup Follow Steps");
		item4.setPrice("5.80");

		Order order = new Order();
		List<Item> orderList = new ArrayList<Item>();
		orderList.add(item1);
		orderList.add(item2);
		orderList.add(item3);
		orderList.add(item4);

		order.setItems(orderList);

		request.setAttribute("order", order);
		
		request.setAttribute("pageTitle", "Order");
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		
		List <Item> newList = new ArrayList <Item>();
		
		for (Item item : order.getItems()) {
			
			if (Integer.parseInt(item.getQuantity()) > 0 ) {
				newList.add(item);
			}
		}
		
		order.setItems(newList);
		
		request.setAttribute("order", order);
		
		request.getSession().setAttribute("order", order);
		
		return "redirect:/purchase/paymentEntry";
	}

	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());
		Order order = (Order) request.getSession().getAttribute("order");
		request.setAttribute("order", order);
		
		return "PaymentEntryForm";
	}

	// Save the payment info to Session
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) {
		request.getSession().setAttribute("payment", payment);
		return "redirect:/purchase/shippingEntry";
	}

	// redirect to shipping
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("shipping", new ShippingInfo());
		
		Order order = (Order) request.getSession().getAttribute("order");
		request.setAttribute("order", order);

		return "ShippingEntryForm";
	}

	// Save the shipping info to Session
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShippingInfo(@ModelAttribute("shipping") ShippingInfo shipping, HttpServletRequest request) {
		request.getSession().setAttribute("shipping", shipping);
		return "redirect:/purchase/viewOrder";
	}

	// redirect to view Order
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) {

		Order order = (Order) request.getSession().getAttribute("order");
		request.setAttribute("order", order);

		PaymentInfo payment = (PaymentInfo) request.getSession().getAttribute("payment");
		request.setAttribute("payment", payment);

		ShippingInfo shipping = (ShippingInfo) request.getSession().getAttribute("shipping");
		request.setAttribute("shipping", shipping);

		return "ViewOrder";
	}

	// Save the shipping info to Session
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request, HttpServletResponse response) {

		// here we would save all the session values to DB
		// for now, lets just save to session as well
		String orderNumber = "1";
		
		if (request.getSession().getAttribute("orderNumber") != null) {
			orderNumber = request.getSession().getAttribute("orderNumber").toString();
		}
		
		int c = Integer.valueOf(orderNumber);
		orderNumber = String.valueOf(++c);
		
		request.getSession().setAttribute("orderNumber", orderNumber);
		
		return "redirect:/purchase/viewConfirmation";
	}

	// redirect to view Order
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) {

		// here we would return the order number from DB
		Order order = (Order) request.getSession().getAttribute("order");
		request.setAttribute("order", order);

		PaymentInfo payment = (PaymentInfo) request.getSession().getAttribute("payment");
		request.setAttribute("payment", payment);

		ShippingInfo shipping = (ShippingInfo) request.getSession().getAttribute("shipping");
		request.setAttribute("shipping", shipping);

		String orderNumber = "1";
		
		if (request.getSession().getAttribute("orderNumber") != null) {
			orderNumber = request.getSession().getAttribute("orderNumber").toString();
		}
		
		return "Confirmation";
	}

}
