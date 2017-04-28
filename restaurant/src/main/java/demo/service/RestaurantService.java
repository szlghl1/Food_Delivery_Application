package demo.service;

import demo.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
public interface RestaurantService {
    Page<Restaurant> findAll(Pageable pageable);
    Restaurant findById(int id);
    Page<Restaurant> findByName(String name, Pageable pageable);
    List<Restaurant> findByName(String name);
    List<Restaurant> saveRestaurants(List<Restaurant> restaurants);
    Restaurant saveRestaurant(Restaurant restaurant);
    void deleteById(int id);
    void deleteAll();
    boolean update(Restaurant restaurant);
}