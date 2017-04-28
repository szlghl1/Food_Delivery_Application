package demo.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ling on 4/27/17.
 */
@Table(name = "MENU_ITEM")
@Data
public class MenuItem {
    @Id
    @GeneratedValue
    private final int id;
    private String description;
    private String name;
    private float price;
}
