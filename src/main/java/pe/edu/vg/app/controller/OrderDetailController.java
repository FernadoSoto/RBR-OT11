package pe.edu.vg.app.controller;

import pe.edu.vg.app.model.OrderDetail;
import pe.edu.vg.app.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/order-Details")
public class OrderDetailController {

    @Autowired
    private OrderDetailService service;

    @PostMapping
    public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail) {
        return service.createOrderDetail(orderDetail);
    }

    @GetMapping
    public List<OrderDetail> getAllOrderDetails() {
        return service.getAllOrderDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long id) {
        Optional<OrderDetail> orderDetail = service.getOrderDetailById(id);
        return orderDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable Long id, @RequestBody OrderDetail orderDetailDetails) {
        return ResponseEntity.ok(service.updateOrderDetail(id, orderDetailDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        service.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}