package com.btc.trade.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.btc.sys.utils.Constants;
import com.btc.test.entity.User;
import com.btc.trade.dao.MarketDao;
import com.btc.trade.entity.Trade;

@Controller
public class MarketController {

	@Autowired
	MarketDao marketDao;
	
	@RequestMapping(value = "/goMarket", method = RequestMethod.GET)
	public String goMarket(Model model) {
		model.addAttribute("msg", "jimmy's msg");
		return "market";
	}

	@RequestMapping(value = "/doBiz", method = RequestMethod.POST)
	@ResponseBody
	public String doBiz(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "price", required = true) String price,
			@RequestParam(value = "qty", required = true) String qty,
			HttpSession session) {
		Trade newOppo = new Trade();
		User currentUser = (User) session.getAttribute("currentUser");
		if (type != null && type.equals(Constants.TRADE_BUY)) {
			newOppo.setStatus(Constants.TRADE_BUY);
			newOppo.setBuyer(currentUser.getId());
			newOppo.setInitbid(Float.valueOf(price));
			newOppo.setQty(Float.valueOf(qty));
			newOppo.setBidtime(new Date());
		} else {
			newOppo.setStatus(Constants.TRADE_SELL);
			newOppo.setSeller(currentUser.getId());
			newOppo.setInitbid(Float.valueOf(price));
			newOppo.setQty(Float.valueOf(qty));
			newOppo.setBidtime(new Date());
		}
		
		return marketDao.tryToMakeDeal(newOppo);
	}

	public MarketDao getMarketDao() {
		return marketDao;
	}

	public void setMarketDao(MarketDao marketDao) {
		this.marketDao = marketDao;
	}
}
