package demo.service;

import demo.domain.MenuItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Ling on 4/28/17.
 */
public interface MenuItemService {
    Page<MenuItem> findAll(Pageable pageable);
    Page<MenuItem> findByMenuId(int menuId, Pageable pageable);
    MenuItem findById(int id);
    void deleteAll();
    void deleteById(int id);
}
