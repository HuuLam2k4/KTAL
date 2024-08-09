//package com.poly.websitegaminggear.controller;
//
//import com.poly.websitegaminggear.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class LoginController {
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/login")
//    public String loginPage(@RequestParam(value = "error", required = false) String error,
//                            @RequestParam(value = "logout", required = false) String logout,
//                            Model model) {
//        if (error != null) {
//            model.addAttribute("error", "Tên người dùng hoặc mật khẩu không chính xác.");
//        }
//        if (logout != null) {
//            model.addAttribute("message", "Bạn đã đăng xuất thành công.");
//        }
//        return "pages/login";
//    }
//    // Trang đăng nhập thất bại
//    @RequestMapping("/login/failed")
//    public String loginFailed(Model model) {
//        model.addAttribute("error", "Đăng nhập không thành công. Vui lòng thử lại.");
//        return "pages/login";
//    }
//
//    // Trang thông báo lỗi truy cập bị từ chối
//    @RequestMapping("/auth/access/denied")
//    public String accessDenied(Model model) {
//        model.addAttribute("message", "Bạn không có quyền truy cập trang này.");
//        return "pages/404";
//    }
//
//    // Trang đăng xuất thành công
//    @RequestMapping("/auth/logoff/success")
//    public String logoutSuccess(Model model) {
//        model.addAttribute("message", "Bạn đã đăng xuất thành công.");
//        return "pages/login";
//    }
//
//    // Trang chính của người dùng sau khi đăng nhập thành công
//    @RequestMapping("/user/index")
//    public String userIndex(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = authentication.getPrincipal();
//        String username;
//        // Kiểm tra nếu principal là một instance của UserDetails
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails) principal).getUsername();
//        } else {
//            username = principal.toString();
//        }
//        model.addAttribute("username", username);
//        return "user/index";
//    }
//}
