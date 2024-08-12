package com.poly.websitegaminggear.service;


import com.poly.websitegaminggear.model.User;
import com.poly.websitegaminggear.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender emailSender;


    public List<User> getAllUser () {
        return userRepository.findAll();
    }
    public User getUserByID(String username) {
        return userRepository.findById(username).orElse(null);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(String username, User userDetails) {
        User user = userRepository.findById(username).orElse(null);
        if (user != null) {
            user.setPasswordHash(userDetails.getPasswordHash());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setAddress(userDetails.getAddress());
            user.setAvatar(userDetails.getAvatar());
            user.setStatus(userDetails.getStatus());
            return userRepository.save(user);
        }
        return null;
    }
    public void deleteUser(@PathVariable String username) {
        userRepository.deleteById(username);
    }



    public User changePassword(String username, String newPassword) {
        User user = userRepository.findById(username).orElse(null);
        if (user != null) {
            user.setPasswordHash(newPassword);
            return userRepository.save(user);
        }
        return null;
    }




    private final Map<String, String> otpStore = new HashMap<>();

    // Phương thức gửi OTP qua email
    public void sendOtp(String email) {
        String otp = generateOtp();
        otpStore.put(email, otp);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);

        try {
            emailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace(); // Xử lý lỗi gửi email
        }
    }

    // Phương thức kiểm tra OTP
    public boolean verifyOtp(String email, String otp) {
        return otp.equals(otpStore.get(email));
    }

    // Phương thức đổi mật khẩu
    public User changePassword(String email, String otp, String newPassword) {
        if (verifyOtp(email, otp)) {
            User user = userRepository.findByEmail(email);
            if (user != null) {
                user.setPasswordHash(newPassword); // Mã hóa mật khẩu nếu cần
                otpStore.remove(email); // Xóa OTP sau khi thành công
                return userRepository.save(user);
            }
        }
        return null;
    }

    // Tạo OTP ngẫu nhiên
    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Tạo OTP 6 chữ số
        return String.valueOf(otp);
    }
}

