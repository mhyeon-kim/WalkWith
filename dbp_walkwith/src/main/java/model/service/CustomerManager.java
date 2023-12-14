package model.service;

import java.sql.SQLException;

import model.dao.CustomerDAO;

public class CustomerManager {
    private static CustomerManager cusMan = new CustomerManager();
    private CustomerDAO cusDAO;
    
    private CustomerManager() {
        try {
            cusDAO = new CustomerDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static CustomerManager getInstance() {
        return cusMan;
    }
    
    
}