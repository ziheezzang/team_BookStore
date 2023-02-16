package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.dto.Orders;
import com.test.service.OrderService;

@Controller
@RequestMapping("/order/")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/getOrderList")
	public String getOrderList(Model model,
			@RequestParam(required = false, defaultValue = "0", value = "page") int page) {
		Page<Orders> orderList = orderService.getOrderList(page);

		int totalPage = orderList.getTotalPages();

		model.addAttribute("orderList", orderList.getContent());
		model.addAttribute("totalPage", totalPage);
		return "order/getOrderList";

	}

	@PostMapping("/updateOrder")
	public String updateOrder(Orders order) {
		orderService.updateOrder(order);
		return "redirect:getOrderList";
	}

	@GetMapping("/getOrder")
	public String getOrder(Orders order, Model model) {
		model.addAttribute("orders", orderService.getOrder(order));
		return "order/getOrder";
	}

	@GetMapping("/deleteOrder")
	public String deleteQna(Orders order) {

		return "redirect:getOrder";
	}

}
