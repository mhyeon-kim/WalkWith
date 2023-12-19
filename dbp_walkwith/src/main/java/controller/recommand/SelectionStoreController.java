package controller.recommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.CustomerDTO;
import model.service.CustomerManager;

public class SelectionStoreController implements Controller {
    private CustomerManager cusManager;

    private String referringPage; // 어느 페이지에서 요청되었는지 저장
    public SelectionStoreController(String referringPage) {
        this.referringPage = referringPage;
        cusManager = CustomerManager.getInstance();
    }

    // redirection할 url 결정
    private String determineSuccessRedirectUrl() {
        if ("/home/home.jsp".equals(referringPage)) {
            return "/home/home.jsp";
        } else if ("/market/market_menu.jsp".equals(referringPage)) {
            return "/market/market_menu.jsp";
        } else {
            return "/home/home.jsp";
        }
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CustomerDTO customer = new CustomerDTO(request.getParameter("userId"), null, null, null, null, null, null);

        try {
            cusManager.mySelectionStore(customer.getUserId());
            // log.debug(customer.getUserId());

            String successRedirectUrl = determineSuccessRedirectUrl();
            return successRedirectUrl;
        } catch (Exception e) {
            request.setAttribute("UpdateFailed", true);
            request.setAttribute("exception", e);
            return "/home/home.jsp";
        }
    }
}