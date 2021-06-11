package in.sankarvinoth.service;

import java.util.List;

import in.sankarvinoth.dao.AnalyticsDAO;
import in.sankarvinoth.model.Analytics;

public class AnalyticsService {

	private AnalyticsService() {

	}

	private static final AnalyticsDAO dao = new AnalyticsDAO();

	/**
	 * method to get all the productname and their sold quantity data from database
	 * 
	 * @return
	 */

	public static List<Analytics> getAllSoldItemsService() {
		return dao.getAllPlacedOrders();
	}
	
	
}

