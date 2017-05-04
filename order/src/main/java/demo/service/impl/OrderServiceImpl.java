package demo.service.impl;

import demo.domain.*;
import demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ling on 5/3/17.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepo;

    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Value("${URL.food-delivery-app-restaurant}")
    String menuItemUrl;

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepo.findAll(pageable);
    }

    @Override
    public Order findById(String id) {
        return orderRepo.findOne(id);
    }

    @Override
    public boolean getOrderIsPaidById(String id) {
        return findById(id).isPayed();
    }

    @Override
    public Order save(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public List<Order> save(List<Order> orders) {
        return orderRepo.save(orders);
    }

    @Override
    public Order createOrder(List<IdAndAmountPair> idAndAmountPairList, String description) {
        List<ItemAndAmountPair> itemAndAmountPairList = new ArrayList<>();
        for(IdAndAmountPair idAndAmountPair : idAndAmountPairList) {
            Item item = getItemById(idAndAmountPair.id);
            itemAndAmountPairList.add(new ItemAndAmountPair(item, idAndAmountPair.amount));
        }
        Order order = new Order(itemAndAmountPairList, description);
        return orderRepo.save(order);
    }

    @Override
    public List<Item> getItemsByIds(List<Integer> itemIdList) {
        List<Item> res = new ArrayList<>();
        for(int itemId : itemIdList) {
            Item item = getItemById(itemId);
            res.add(item);
        }
        return res;
    }

    @Override
    public Item getItemById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Item item = restTemplate.getForObject(menuItemUrl + "/menu_items/" + Integer.toString(id), Item.class);
        if(item == null) {
            logger.error("Got null item in getItemById");
        } else {
            logger.debug("Got not null item, item.name = " + item.name + " item.des = " + item.description);
        }
        return item;
    }

    @Override
    public void setOrderPaidById(String id) {
        findById(id).setPayed(true);
    }

    @Override
    public void cancelOrderById(String id) {
        findById(id).setCanceled(true);
    }

    @Override
    public void deleteAll() {
        orderRepo.deleteAll();
    }
}
