package demo.restController;

import demo.domain.Menu;
import demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ling on 4/28/17.
 */
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    //find by restaurant id should be in restaurant controller

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    Page<Menu> findAll(@RequestParam(value = "page") int page,
                           @RequestParam(value = "size", required = false) Integer size) {
        return menuService.findAll(new PageRequest(page, size == null ? 10 : size));
    }

    @RequestMapping(value = "/menus/{id}", method = RequestMethod.GET)
    Menu findById(@RequestParam(value = "id") int id) {
        return menuService.findById(id);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    List<Menu> saveMenus(@RequestBody List<Menu> menus) {
        return menuService.saveMenus(menus);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    Menu upload(@RequestBody Menu menu) {
        return menuService.saveMenu(menu);
    }

    @RequestMapping(value = "/menus", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.CREATED)
    void deleteAll() {
        menuService.deleteAll();
    }

    @RequestMapping(value = "/menus/{id}", method = RequestMethod.DELETE)
    void deleteById(@RequestParam("id") int id) {
        menuService.deleteById(id);
    }

    @RequestMapping(value = "/menus", method = RequestMethod.PUT)
    ResponseEntity<MenuItemController> update(@RequestBody Menu menu) {
        if(menuService.update(menu) == true) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
