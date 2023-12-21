package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.customer.CreateCustomerController;
import controller.customer.CreatePetController;
import controller.customer.DeleteCustomerController;
import controller.customer.DeletePetController;
import controller.customer.LoginCustomerController;
import controller.customer.LogoutCustomerController;
import controller.customer.UpdateCustomerController;
import controller.customer.UpdatePetController;
import controller.customer.UpdateReservationController;
import controller.customer.ViewCustomerController;
import controller.customer.ViewReservationController;
import controller.recommand.SelectionStoreController;
import controller.reservation.AddReservationController;
import controller.reservation.ReservationController;
import controller.seller.CreateSellerController;
import controller.seller.DeleteSellerController;
import controller.seller.LoginSellerController;
import controller.seller.LogoutSellerController;
import controller.seller.UpdateSellerController;
import controller.seller.ViewSellerController;
import controller.review.*;

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
        mappings.put("/user/cutomer_update", new ForwardController("/user/customer_update.jsp"));
        mappings.put("/user/seller", new ForwardController("/user/seller.jsp"));
        mappings.put("/user/seller_update", new ForwardController("/user/seller_update.jsp"));
        mappings.put("/user/list", new ForwardController("/user/list.jsp"));
        
        //customer
        mappings.put("/customer/register", new CreateCustomerController());
        mappings.put("/customer/login", new LoginCustomerController());    
        mappings.put("/customer/login", new LogoutCustomerController());    
        mappings.put("/customer/update", new UpdateCustomerController());
        mappings.put("/customer/delete", new DeleteCustomerController());
        mappings.put("/customer/view", new ViewCustomerController());

        //seller
        mappings.put("/seller/register", new CreateSellerController());
        mappings.put("/seller/login", new LoginSellerController());
        mappings.put("/seller/login", new LogoutSellerController());
        mappings.put("/seller/update", new UpdateSellerController());
        mappings.put("/seller/update", new DeleteSellerController());
        mappings.put("/seller/view", new ViewSellerController());
        
        //pet
        mappings.put("/pet/register", new ForwardController("/user/pet_RegisterForm.jsp")); //임시 추후 CreatePetController()
        mappings.put("/pet/update", new ForwardController("/user/pet_update.jsp")); //임시 추후 UpdatePetController()
        mappings.put("/pet/delete", new DeletePetController());
        
        //like
        mappings.put("/like/view", new ForwardController("/user/like_view.jsp"));
        
        //market
        mappings.put("/market/market", new ForwardController("/market/market.jsp"));
        mappings.put("/market/market_menu", new ForwardController("/market/market_menu.jsp"));
        mappings.put("/market/recommend", new SelectionStoreController("/market/market_menu.jsp"));
        
        //reservation
        mappings.put("/reservation/reservation", new ForwardController("/reservation/reservation.jsp"));
        mappings.put("/reservation/reservation_view", new ViewReservationController());
        mappings.put("/reservation/add", new AddReservationController());
        mappings.put("/reservation/reservation_update", new UpdateReservationController());

        
        //review
        mappings.put("/review/review_view", new ForwardController("/review/review_view.jsp"));
        mappings.put("/review/review_detail", new ForwardController("/review/review_detail.jsp"));
        mappings.put("/review/review_update", new UpdateReviewController());
        mappings.put("/review/review_write", new CreateReviewController()); 
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {  
        // 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}