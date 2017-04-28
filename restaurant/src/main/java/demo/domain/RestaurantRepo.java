package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ling on 4/27/17.
 */
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
    Page<Restaurant> findAllByName(String name, Pageable pageable);
}
