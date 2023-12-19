package controller.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.StoreDTO;
import model.service.SearchStoreManager;

public class SearchStoreController implements Controller{
	 private SearchStoreManager searchStoreManager;

	    public SearchStoreController() {
	        searchStoreManager = SearchStoreManager.getInstance();
	    }

	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        String storeName = request.getParameter("storeName");

	        try {
	            List<StoreDTO> searchResults = searchStoreManager.searchStore(storeName);
	            request.setAttribute("searchResults", searchResults);

	            return "/market/market_menu.jsp";
	        } catch (Exception e) {     
	            request.setAttribute("exception", e);
	            return "/home/home.jsp";
	        }
	    }
}
