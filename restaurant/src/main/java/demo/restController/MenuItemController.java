package demo.restController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import demo.domain.Menu;
import demo.domain.MenuItem;
import demo.service.MenuItemService;
import demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ling on 4/28/17.
 */
@RestController
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private MenuService menuService;

    //find by menu id should by put in menu controller since the url should be foo.com/restaurant/{id}/menus

    @RequestMapping(value = "/menu_items", method = RequestMethod.GET)
    Page<MenuItem> findAll(@RequestParam(value = "page") int page,
                           @RequestParam(value = "size", required = false) Integer size) {
        return menuItemService.findAll(new PageRequest(page, size == null ? 10 : size));
    }

    @RequestMapping(value = "/menu_items/{id}", method = RequestMethod.GET)
    MenuItem findById(@PathVariable("id") int id) {
        return menuItemService.findById(id);
    }

    @RequestMapping(value = "/menu_items/{id}/price", method = RequestMethod.GET)
    float getPrice(@PathVariable("id") int id) {
        return menuItemService.findById(id).getPrice();
    }

    @RequestMapping(value = "/menu_items", method = RequestMethod.DELETE)
    void deleteAll() {
        menuItemService.deleteAll();
    }

    @RequestMapping(value = "/menu_items/{id}", method = RequestMethod.DELETE)
    void deleteById(@PathVariable("id") int id) {
        menuItemService.deleteById(id);
    }

    @RequestMapping(value = "/menu_items", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    List<MenuItem> upload(@RequestBody List<ObjectNode> objectNodes) {
        List<MenuItem> res = new ArrayList<MenuItem>();
        for(ObjectNode objectNode : objectNodes) {
            int menuId = objectNode.get("menu_id").asInt();
            String menuItemDescription = objectNode.get("description").toString();
            String menuItemName = objectNode.get("name").toString();
            float menuItemPrice = (float)objectNode.get("price").asDouble();
            Menu menu = menuService.findById(menuId);
            MenuItem menuItem = new MenuItem(menuItemName, menuItemDescription, menuItemPrice);
            menuItem.setMenu(menu);
            menu.addMenuItem(menuItem);
            res.add(menuItem);
        }
        menuItemService.saveMenuItems(res);
        return res;
    }

//    @RequestMapping(value = "/menu_items", method = RequestMethod.PUT)
//    ResponseEntity<MenuItemController> update(@RequestBody MenuItem menuItem) {
//        if(menuItemService.update(menuItem) == true) {
//            return ResponseEntity.status(HttpStatus.OK).body(null);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
}
