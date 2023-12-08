package com.dnanh01.backend.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dnanh01.backend.model.Cart;
import com.dnanh01.backend.model.User;
import com.dnanh01.backend.service.CartServiceImplementation;
import com.dnanh01.backend.service.UserServiceImplementation;
import com.dnanh01.backend.service.VNPayService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private VNPayService vnPayService;
    @Autowired
    private CartServiceImplementation cartServiceImplementation;
    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @PostMapping("/submitOrder")
    @ResponseBody
    public ResponseEntity<?> submidOrder(
            @RequestParam("orderInfo") String orderInfo,
            HttpServletRequest request, Principal principal) {

        principal.getName();
        User user = userServiceImplementation.getUserByEmail(principal.getName());

        Cart cart = cartServiceImplementation.findUserCart(user.getId());
        BigDecimal total = new BigDecimal(cart.getTotalDiscountedPrice());
        // trang frontend cấu hình
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder(total, orderInfo, baseUrl);
        return ResponseEntity.ok(vnpayUrl);
    }

    @GetMapping("/vnpay-payment")
    public String GetMapping(HttpServletRequest request, Model model) {
        int paymentStatus = vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        model.addAttribute("orderId", orderInfo);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("paymentTime", paymentTime);
        model.addAttribute("transactionId", transactionId);

        return paymentStatus == 1 ? "ordersuccess" : "orderfail";
    }
}
