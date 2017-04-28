package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ling on 4/27/17.
 */
public interface MenuItemRepo extends JpaRepository<MenuItem, Integer> {
    Page<MenuItem> findByMenuId(int menuId, Pageable pageable);
}
