package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.customer.CreateCustomerController;
import controller.recommand.SelectionStoreController;
import controller.seller.CreateSellerController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        
        //home
        mappings.put("/home", new ForwardController("/home/home.jsp"));
        
        //login
        mappings.put("/login/loginForm", new ForwardController("/login/loginForm.jsp"));
        
        //register
        mappings.put("/register/registerForm", new ForwardController("/register/registerForm.jsp"));
        
        //user
        mappings.put("/user/customer", new ForwardController("/user/customer.jsp"));
        mappings.put("/user/cutomer_update", new ForwardController("/user/cutomer_update.jsp"));
        mappings.put("/user/seller", new ForwardController("/user/seller.jsp"));
        mappings.put("/user/seller_update", new ForwardController("/user/seller_update.jsp"));
        mappings.put("/user/list", new ForwardController("/user/list.jsp"));
        
        //customer
        mappings.put("/customer/register", new CreateCustomerController());
        
        //seller
        mappings.put("/seller/register", new CreateSellerController());
        
        //pet
        mappings.put("/user/pet_RegisterForm", new ForwardController("/user/pet_RegisterForm.jsp"));
        mappings.put("/user/pet_update", new ForwardController("/user/pet_update.jsp"));
        
        //like
        mappings.put("/user/like_view", new ForwardController("/user/like_view.jsp"));
        
        //market
        mappings.put("/market/market", new ForwardController("/market/market.jsp"));
        mappings.put("/market/market_menu", new ForwardController("/market/market_menu.jsp"));
        mappings.put("/market/market_update", new ForwardController("/market/market_update.jsp"));
        mappings.put("/market/recommend", new SelectionStoreController("/market/market_menu.jsp"));
        //mappings.put("/market/market_view", new ) marketView 컨트롤러 잇나요..? 잇어야 됨..
        
        //reservation
        mappings.put("/reservation/reservation", new ForwardController("/reservation/reservation.jsp"));
        mappings.put("/reservation/reservation_view", new ForwardController("/reservation/reservation_view.jsp"));
        mappings.put("/reservation/reservation_update", new ForwardController("/reservation/reservation_update.jsp"));
        
        //review
        mappings.put("/review/review_view", new ForwardController("/review/review_view.jsp"));
        mappings.put("/review/review_detail", new ForwardController("/review/review_detail.jsp"));
        mappings.put("/review/review_update", new ForwardController("/review/review_update.jsp"));
        mappings.put("/review/review_write", new ForwardController("/review/review_write.jsp"));
        
        //기본틀 복붙해서 쓰세요
        mappings.put("/", new ForwardController("/.jsp"));
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}