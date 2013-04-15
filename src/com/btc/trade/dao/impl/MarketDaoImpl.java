package com.btc.trade.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.btc.sys.utils.Constants;
import com.btc.sys.utils.LogUtil;
import com.btc.trade.dao.MarketDao;
import com.btc.trade.entity.Trade;

@Repository
public class MarketDaoImpl implements MarketDao{

	@Autowired
	public SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public String tryToMakeDeal(Trade oppo) {
		Session session = this.getSessionFactory().openSession();
		session.beginTransaction();
		
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("from Trade t where t.status ='");
		if (oppo.getStatus().equals(Constants.TRADE_BUY)) {
			sqlBuffer.append( Constants.TRADE_SELL);
			sqlBuffer.append("' and t.initbid <=");
			sqlBuffer.append(oppo.getInitbid());
			sqlBuffer.append(" order by t.initbid asc");
		} else {
			sqlBuffer.append( Constants.TRADE_BUY);
			sqlBuffer.append("' and t.initbid >=");
			sqlBuffer.append(oppo.getInitbid());
			sqlBuffer.append(" order by t.initbid desc");

		}
		@SuppressWarnings("unchecked")
		List<Trade> rs = session.createQuery(sqlBuffer.toString()).list();
		LogUtil.getLogger().info(rs.size()+" qualifed.");
		
		String resulString = "";
		if (rs.size()>0) {
			//success, finish the deal
			Trade bestMatchTrade =  rs.get(0);
			if (oppo.getStatus().equals(Constants.TRADE_BUY)) {
				bestMatchTrade.setBuyer(oppo.getBuyer());
				bestMatchTrade.setDealprice(oppo.getInitbid());
				bestMatchTrade.setDealtime(new Date());
				bestMatchTrade.setStatus(Constants.TRADE_SUCCESS);
				resulString = "Buy "+oppo.getQty() + " BTC successfully .";
			} else {
				bestMatchTrade.setSeller(oppo.getSeller());
				bestMatchTrade.setDealprice(oppo.getInitbid());
				bestMatchTrade.setDealtime(new Date());
				bestMatchTrade.setStatus(Constants.TRADE_SUCCESS);
				resulString = "Sell "+oppo.getQty() + " BTC successfully .";
			}
		} else {
			//fail, we need to store the bid/offer for future
			session.save(oppo);
		}
		session.getTransaction().commit();
		session.close();
		return resulString;
	}

}
