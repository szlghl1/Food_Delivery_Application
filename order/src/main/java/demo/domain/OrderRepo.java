package demo.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Ling on 5/3/17.
 */
public interface OrderRepo extends MongoRepository<Order, String> {

}
