package demo.service.impl;

import demo.domain.Menu;
import demo.domain.MenuRepo;
import demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepo repo;

    @Override
    public Page<Menu> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Menu findById(int id) {
        return repo.findOne(id);
    }

    @Override
    public Page<Menu> findByRestaurantId(int restaurantId, Pageable pageable) {
        return repo.findAllByRestaurantId(restaurantId, pageable);
    }

    @Override
    public List<Menu> saveMenus(List<Menu> menus) {
        return repo.save(menus);
    }

    @Override
    public Menu saveMenu(Menu menu) {
        return repo.save(menu);
    }

    @Override
    public void deleteById(int id) {
        repo.delete(id);
    }

    @Override
    public void deleteAll() {
        repo.deleteAll();
    }
}
