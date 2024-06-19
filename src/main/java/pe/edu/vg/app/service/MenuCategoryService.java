package pe.edu.vg.app.service;

import pe.edu.vg.app.exception.ResourceNotFoundException;
import pe.edu.vg.app.model.MenuCategory;
import pe.edu.vg.app.repository.MenuCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuCategoryService {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    public List<MenuCategory> getAllMenuCategories() {
        return menuCategoryRepository.findAll();
    }

    public MenuCategory getMenuCategoryById(Long id) {
        return menuCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Category", "categoryID", id));
    }

    public MenuCategory createMenuCategory(MenuCategory menuCategory) {
        return menuCategoryRepository.save(menuCategory);
    }

    public MenuCategory updateMenuCategory(Long id, MenuCategory menuCategoryDetails) {
        MenuCategory menuCategory = menuCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Category", "categoryID", id));

        menuCategory.setCategoryName(menuCategoryDetails.getCategoryName());
        menuCategory.setStatus(menuCategoryDetails.getStatus());

        return menuCategoryRepository.save(menuCategory);
    }

    public void deleteMenuCategory(Long id) {
        MenuCategory menuCategory = menuCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Category", "categoryID", id));
        menuCategoryRepository.delete(menuCategory);
    }

    public MenuCategory changeStatus(Long id, String status) {
        MenuCategory menuCategory = menuCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Category", "categoryID", id));
        menuCategory.setStatus(status);
        return menuCategoryRepository.save(menuCategory);
    }
}
