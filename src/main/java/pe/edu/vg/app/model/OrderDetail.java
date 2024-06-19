package pe.edu.vg.app.model;

import lombok.Data;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Order_Details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal total;

    @Column(nullable = false)
    private Long dishId;
}

