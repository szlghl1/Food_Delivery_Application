package demo.service.impl;

import demo.domain.MenuItem;
import demo.domain.MenuItemRepo;
import demo.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
@Service
public class MenuItemServiceImpl implements MenuItemService {
    @Autowired
    private MenuItemRepo repo;

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

    @Override
    public List<MenuItem> saveMenuItems(List<MenuItem> menuItems) {
        return repo.save(menuItems);
    }

    @Override
    public MenuItem saveMenuItem(MenuItem menuItem) {
        return repo.save(menuItem);
    }

    @Override
    public boolean update(MenuItem menuItem) {
        MenuItem findResult = repo.findOne(menuItem.getId());
        if(findResult == null) {
            return false;
        } else {
            saveMenuItem(menuItem);
            return true;
        }
    }
}
