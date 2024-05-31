package com.example.BuildPC.controller;

import com.example.BuildPC.Service.OrderDetailService;
import com.example.BuildPC.Service.OrderService;
import com.example.BuildPC.dtos.OrderDTO;
import com.example.BuildPC.dtos.UserDto;
import com.example.BuildPC.models.Order;
import com.example.BuildPC.models.OrderDetail;
import com.example.BuildPC.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller

public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @GetMapping("/ManagerDashBoard")
    public String showManagerDashBoard(Model model) {
        model.addAttribute("OrderList", orderService.listAllOrder());
        return "Manager/managerDashBoard";
    }

    public String showOrders(Model model) {
        List<OrderDTO> orderList = orderService.listAllOrder();
        model.addAttribute("orderList", orderList);
        return "ManagerDashBoard";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        orderDetailService.deleteByOrder(orderService.getOrderById(id)) ;
        orderService.deleteOrderById(id);
        return "redirect:/ManagerDashBoard";
    }

    @GetMapping("/detail/{id}")
    public String showOrderDetail(@PathVariable("id") int id, Model model) {
        Order order = orderService.getOrderById(id);
        List<OrderDetail> orderDetails = orderDetailService.findByOrder(order);
        model.addAttribute("order", order);
        model.addAttribute("orderDetails", orderDetails);
        return "Manager/orderdetail";
    }

    @PostMapping("order/save")
    public String saveOrder(@ModelAttribute("order") Order order) {
        orderService.saveOrder(order);
        return "redirect:/detail/" + order.getId();  // Redirect to the order detail page after saving
    }


}
