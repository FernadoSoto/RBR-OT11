package pe.edu.vg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.vg.app.exception.ResourceNotFoundException;
import pe.edu.vg.app.model.Order;
import pe.edu.vg.app.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "orderID", id));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "orderID", id));

        order.setEmployeeID(orderDetails.getEmployeeID());
        order.setTableID(orderDetails.getTableID());
        order.setDateTime(orderDetails.getDateTime());
        order.setStatus(orderDetails.getStatus());

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "orderID", id));
        orderRepository.delete(order);
    }

    public Order changeStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "orderID", id));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
