package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ling on 5/4/17.
 */
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}
