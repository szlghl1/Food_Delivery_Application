package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ling on 4/27/17.
 */
public interface MenuRepo extends JpaRepository<Menu, Integer> {
    Page<Menu> findAllByRestaurantId(int restaurantId, Pageable pageable);
}
