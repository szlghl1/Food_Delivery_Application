package demo.restController;

import demo.domain.Menu;
import demo.domain.Restaurant;
import demo.service.RestaurantService;
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
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    Page<Restaurant> findAll(@RequestParam(value = "page") int page,
                             @RequestParam(value = "size", required = false) Integer size) {
        return restaurantService.findAll(new PageRequest(page, size == null ? 10 : size));
    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET)
    Restaurant findById(@RequestParam(value = "id") int id) {
        return restaurantService.findById(id);
    }

    @RequestMapping(value = "/restaurants/{name}", method = RequestMethod.GET)
    List<Restaurant> findByName(@RequestParam(value = "name") String name) {
        return restaurantService.findByName(name);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    List<Restaurant> upload(@RequestBody List<Restaurant> restaurants) {
        return restaurantService.saveRestaurants(restaurants);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.DELETE)
    void deleteAll() {
        restaurantService.deleteAll();
    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.DELETE)
    void deleteById(@RequestParam(value = "id") int id) {
        restaurantService.deleteById(id);
    }

    @RequestMapping(value = "/restaurants/{id}/menus", method = RequestMethod.GET)
    List<Menu> findMenus(@RequestParam(value = "id") int id) {
        return restaurantService.findById(id).getMenus();
    }

//    @RequestMapping(value = "/restaurants", method = RequestMethod.PUT)
//    ResponseEntity<RestaurantController> update(@RequestBody Restaurant restaurant) {
//        if(restaurantService.update(restaurant) == true) {
//            return ResponseEntity.status(HttpStatus.OK).body(null);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
}
