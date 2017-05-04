package demo.restController;

import com.fasterxml.jackson.databind.JsonNode;
import demo.domain.IdAndAmountPair;
import demo.domain.Order;
import demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ling on 5/2/17.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    Page<Order> findAll(@RequestParam(value = "size", required = false) Integer size,
                        @RequestParam(value = "page") Integer page) {
        PageRequest pageRequest = new PageRequest(page, size == null ? 10 : size);
        return orderService.findAll(pageRequest);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    Order findById(@PathVariable("id") String id) {
        return orderService.findById(id);
    }

    @RequestMapping(value = "/orders/{id}/is_paid", method = RequestMethod.GET)
    boolean getOrderIsPaid(@RequestParam("id") String orderId) {
        return orderService.findById(orderId).isPayed();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    List<Order> createOrders(@RequestBody JsonNode ordersParasArrNode) {
        boolean inputIsValid = true;
        if(ordersParasArrNode.isArray()) {
            List<Order> orders = new ArrayList<>();
            for(JsonNode orderPara : ordersParasArrNode) {
                String description = orderPara.get("description").asText();
                JsonNode itemIdsAndAmount = orderPara.get("item_ids_and_amount");
                if(itemIdsAndAmount.isArray()) {
                    List<IdAndAmountPair> idAndAmountPairList = new ArrayList<>();
                    for(JsonNode itemIdAndAmount : itemIdsAndAmount) {
                        int id = itemIdAndAmount.get("id").asInt();
                        int amount = itemIdAndAmount.get("amount").asInt();
                        idAndAmountPairList.add(new IdAndAmountPair(id, amount));
                    }
                    Order order = orderService.createOrder(idAndAmountPairList, description);
                    orders.add(order);
                } else {
                    inputIsValid = false;
                    break;
                }
            }
            if(inputIsValid){
                return orders;
            }
        }
        return null;
    }

    @RequestMapping(value = "/orders/{id}/is_paid", method = RequestMethod.PUT)
    void setOrderPaid(@PathVariable("id") String orderId) {
        orderService.findById(orderId).setPayed(true);
    }

    @RequestMapping(value = "/orders/{id}/is_cancelled", method = RequestMethod.PUT)
    void cancelOrder(@PathVariable("id") String orderId) {
        orderService.findById(orderId).setCanceled(true);
    }
}
