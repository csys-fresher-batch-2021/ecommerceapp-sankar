package in.sankarvinoth.service;

import java.util.List;

import in.sankarvinoth.dao.AnalyticsDao;
import in.sankarvinoth.model.Analytics;

public class AnalyticsService {

	private AnalyticsService() {

	}

	private static final AnalyticsDao dao = new AnalyticsDao();

	/**
	 * method to get all the productname and their sold quantity data from database
	 * 
	 * @return
	 */

	public static List<Analytics> getAllSoldItemsService() {
		return dao.getAllPlacedOrders();
	}

}
