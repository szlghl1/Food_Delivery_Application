package demo.service;

import demo.domain.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
public interface MenuService {
    Page<Menu> findAll(Pageable pageable);
    Menu findById(int id);
    Page<Menu> findByRestaurantId(int restaurantId, Pageable pageable);
    List<Menu> saveMenus(List<Menu> menus);
    Menu saveMenu(Menu menu);
    void deleteById(int id);
    void deleteAll();
    boolean update(Menu menu);
}
