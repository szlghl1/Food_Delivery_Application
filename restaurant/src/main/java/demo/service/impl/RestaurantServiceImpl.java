package demo.service.impl;

import demo.domain.Restaurant;
import demo.domain.RestaurantRepo;
import demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepo repo;

    @Override
    public Page<Restaurant> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Restaurant findById(int id) {
        return repo.findOne(id);
    }

    @Override
    public Page<Restaurant> findByName(String name, Pageable pageable) {
        return repo.findAllByName(name, pageable);
    }

    @Override
    public List<Restaurant> saveRestaurants(List<Restaurant> restaurants) {
        return repo.save(restaurants);
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return repo.save(restaurant);
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
