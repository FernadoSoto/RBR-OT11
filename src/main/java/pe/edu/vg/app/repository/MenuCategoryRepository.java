package pe.edu.vg.app.repository;

import pe.edu.vg.app.model.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
}
