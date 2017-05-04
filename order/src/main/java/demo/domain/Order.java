package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */

//because orderedItems can have various length, it is better to use MongoDb
@Document
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    @Id
    private String id;
    private Date timestamp = new Date();
    private String description;
//    private int customerId;
//    private String customerName;
    private Date estimatedDeliveryTime = null;
    private boolean isPayed = false;
    private Integer paymentId = null;
    //order should not be able to delete, instead we mark it as cancelled
    private boolean isCanceled = false;

    private float balance;

    private List<ItemAndAmountPair> orderedItems = new ArrayList<>();

    public void addItem(Item item, int amount) {
        orderedItems.add(new ItemAndAmountPair(item, amount));
    }

    public Order(List<ItemAndAmountPair> itemAndAmountPairs,
                 String description) {
        this.description = description;
        this.orderedItems = new ArrayList<>(itemAndAmountPairs);
        this.timestamp = new Date();
        for(ItemAndAmountPair itemAndAmountPair : orderedItems) {
            balance += itemAndAmountPair.item.price * itemAndAmountPair.amount;
        }
    }
}
