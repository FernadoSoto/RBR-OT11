package pe.edu.vg.app.service;

import pe.edu.vg.app.model.OrderDetail;
import pe.edu.vg.app.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository repository;

    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }

    public List<OrderDetail> getAllOrderDetails() {
        return repository.findAll();
    }

    public Optional<OrderDetail> getOrderDetailById(Long id) {
        return repository.findById(id);
    }

    public OrderDetail updateOrderDetail(Long id, OrderDetail orderDetailDetails) {
        return repository.findById(id).map(orderDetail -> {
            orderDetail.setOrderId(orderDetailDetails.getOrderId());
            orderDetail.setQuantity(orderDetailDetails.getQuantity());
            orderDetail.setTotal(orderDetailDetails.getTotal());
            orderDetail.setDishId(orderDetailDetails.getDishId());
            return repository.save(orderDetail);
        }).orElseGet(() -> {
            orderDetailDetails.setOrderDetailId(id);
            return repository.save(orderDetailDetails);
        });
    }

    public void deleteOrderDetail(Long id) {
        repository.deleteById(id);
    }
}