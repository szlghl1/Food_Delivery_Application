package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Ling on 5/3/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
    public String description;
    public String name;
    public float price;
}
