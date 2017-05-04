package demo.service;

import demo.domain.IdAndAmountPair;
import demo.domain.Item;
import demo.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Ling on 5/3/17.
 */
public interface OrderService {
    Page<Order> findAll(Pageable pageable);

    Order findById(String id);

    boolean getOrderIsPaidById(String id);

    Order save(Order order);

    List<Order> save(List<Order> orders);

    Order createOrder(List<IdAndAmountPair> idAndAmountPairList, String description);

    List<Item> getItemsByIds(List<Integer> itemIdList);

    Item getItemById(int id);

    void setOrderPaidById(String id);

    void cancelOrderById(String id);

    void deleteAll();
}
