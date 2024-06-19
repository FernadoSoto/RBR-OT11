package pe.edu.vg.app.controller;

import pe.edu.vg.app.model.Menu;
import pe.edu.vg.app.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        return ResponseEntity.ok(menuService.getMenuById(id));
    }

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        Menu createdMenu = menuService.createMenu(menu);
        return ResponseEntity.ok(createdMenu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @RequestBody Menu menuDetails) {
        Menu updatedMenu = menuService.updateMenu(id, menuDetails);
        return ResponseEntity.ok(updatedMenu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Menu> changeStatus(@PathVariable Long id, @RequestBody String status) {
        Menu updatedMenu = menuService.changeStatus(id, status);
        return ResponseEntity.ok(updatedMenu);
    }
}