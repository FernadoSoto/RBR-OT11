package pe.edu.vg.app.repository;

import pe.edu.vg.app.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}

