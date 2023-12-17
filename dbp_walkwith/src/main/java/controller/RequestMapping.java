package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        
        
        //market
        mappings.put("/market/menu", new ForwardController("/market/menu.jsp"));
        
        
        //reservation
        mappings.put("/reservation/reservation_view", new ForwardController("/reservation/reservation_view.jsp"));
        
        
        //review
        mappings.put("/review/review_view", new ForwardController("/review/review_view.jsp"));
       
        
        //기본틀 복붙해서 쓰세요
        mappings.put("/", new ForwardController("/.jsp"));
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}