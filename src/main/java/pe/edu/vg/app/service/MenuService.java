package pe.edu.vg.app.service;

import pe.edu.vg.app.exception.ResourceNotFoundException;
import pe.edu.vg.app.repository.MenuRepository;
import pe.edu.vg.app.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "dishID", id));
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, Menu menuDetails) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "dishID", id));

        menu.setDishName(menuDetails.getDishName());
        menu.setDescription(menuDetails.getDescription());
        menu.setPrice(menuDetails.getPrice());
        menu.setStatus(menuDetails.getStatus());
        menu.setCategoryID(menuDetails.getCategoryID());

        return menuRepository.save(menu);
    }

    public void deleteMenu(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "dishID", id));
        menuRepository.delete(menu);
    }

    public Menu changeStatus(Long id, String status) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "dishID", id));
        menu.setStatus(status);
        return menuRepository.save(menu);
    }
}