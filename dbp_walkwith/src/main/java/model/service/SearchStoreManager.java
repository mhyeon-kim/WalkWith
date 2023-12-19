package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.store_reviewDAO;
import model.dto.StoreDTO;

public class SearchStoreManager {
    private static SearchStoreManager instance = new SearchStoreManager();
    private store_reviewDAO storeReviewDAO;

    private SearchStoreManager() {
        storeReviewDAO = new store_reviewDAO();
    }

    public static SearchStoreManager getInstance() {
        return instance;
    }

    public List<StoreDTO> searchStore(String storeName) throws SQLException {
        return storeReviewDAO.searchStore(storeName);
    }
}