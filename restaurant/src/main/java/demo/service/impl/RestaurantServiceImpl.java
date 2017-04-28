package demo.service.impl;

import demo.domain.MenuItem;
import demo.domain.Restaurant;
import demo.domain.RestaurantRepo;
import demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepo repo;

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
    public List<Restaurant> findByName(String name) {
        return repo.findAllByName(name, new PageRequest(0,Integer.MAX_VALUE)).getContent();
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

    @Override
    public boolean update(Restaurant restaurant) {
        if(repo.findOne(restaurant.getId()) == null) {
            return false;
        } else {
            repo.save(restaurant);
            return true;
        }
    }
}
