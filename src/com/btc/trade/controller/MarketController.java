package com.btc.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MarketController {

	@RequestMapping(value = "/goMarket", method = RequestMethod.GET)
	public String goMarket(Model model) {
		model.addAttribute("msg", "jimmy's msg");

		return "market";
	}

	@RequestMapping(value = "/doBiz", method = RequestMethod.POST)
	public String doBiz(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "price", required = true) String price,
			@RequestParam(value = "qty", required = true) String qty,
			Model model) {
		
		
		
		return "market";
	}
}
