package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Ling on 5/3/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemAndAmountPair {
    public Item item;
    public int amount = 0;
    public ItemAndAmountPair(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }
}