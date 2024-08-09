package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.*;
import com.poly.websitegaminggear.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Transactional
    public void checkOut() {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(1).orElse(null);
        List<CartItem> cartItems = cartItemRepository.findAll();
        if (cartItems == null || cartItems.isEmpty()) {
            System.out.println("Khong co san pham trong gio hang");
        }
        if (shoppingCart != null) {
            for (CartItem cartItem : cartItems) {
                ProductDetail productDetail = cartItem.getProductDetail();
                Integer quantity = cartItem.getQuantity();
                productDetail.setQuantity(productDetail.getQuantity() - quantity);
                productDetailRepository.save(productDetail);
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(quantity);
                orderItem.setPrice(productDetail.getPrice());
//                totalAmount = totalAmount.add(productDetail.getPrice().multiply(BigDecimal.valueOf(quantity)));
            }
            Order order = new Order();
            order.setStatusOrder("Pending");
            order = ordersRepository.save(order);

            for (CartItem cartItem : cartItems) {
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(cartItem.getQuantity());
                orderItem.setPrice(cartItem.getProductDetail().getPrice());
//                orderItem.setProductDetail(cartItem.getProductDetail());
                orderItem.setOrder(order);
                orderItemsRepository.save(orderItem);
            }
            shoppingCartRepository.deleteById(shoppingCart.getCartId());
            cartItemRepository.deleteAll(cartItems);
        }
    }
}

