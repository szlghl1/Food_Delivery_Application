package demo.service.impl;

import demo.domain.MenuItem;
import demo.domain.MenuItemRepo;
import demo.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Ling on 4/27/17.
 */
public class MenuItemServiceImpl implements MenuItemService {
    @Autowired
    MenuItemRepo repo;

    @Override
    public Page<MenuItem> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Page<MenuItem> findByMenuId(int menuId, Pageable pageable) {
        return repo.findByMenuId(menuId, pageable);
    }

    @Override
    public MenuItem findById(int id) {
        return repo.findOne(id);
    }

    @Override
    public void deleteAll() {
        repo.deleteAll();
    }

    @Override
    public void deleteById(int id) {
        repo.delete(id);
    }
}
