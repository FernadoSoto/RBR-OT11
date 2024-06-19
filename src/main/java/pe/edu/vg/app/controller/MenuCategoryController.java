package pe.edu.vg.app.controller;

import pe.edu.vg.app.model.MenuCategory;
import pe.edu.vg.app.service.MenuCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/menu-categories")
public class MenuCategoryController {

    @Autowired
    private MenuCategoryService menuCategoryService;

    @GetMapping
    public List<MenuCategory> getAllMenuCategories() {
        return menuCategoryService.getAllMenuCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuCategory> getMenuCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(menuCategoryService.getMenuCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<MenuCategory> createMenuCategory(@RequestBody MenuCategory menuCategory) {
        MenuCategory createdMenuCategory = menuCategoryService.createMenuCategory(menuCategory);
        return ResponseEntity.ok(createdMenuCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuCategory> updateMenuCategory(@PathVariable Long id, @RequestBody MenuCategory menuCategoryDetails) {
        MenuCategory updatedMenuCategory = menuCategoryService.updateMenuCategory(id, menuCategoryDetails);
        return ResponseEntity.ok(updatedMenuCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuCategory(@PathVariable Long id) {
        menuCategoryService.deleteMenuCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<MenuCategory> changeStatus(@PathVariable Long id, @RequestBody String status) {
        MenuCategory updatedMenuCategory = menuCategoryService.changeStatus(id, status);
        return ResponseEntity.ok(updatedMenuCategory);
    }
}