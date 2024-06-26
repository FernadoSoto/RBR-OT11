package pe.edu.vg.app.repository;

import pe.edu.vg.app.model.TableCL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableCL, Long> {
}