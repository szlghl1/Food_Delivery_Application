package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ling on 4/27/17.
 */
@Entity
@Table(name = "MENU_ITEM")
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MenuItem {
    @Id
    @GeneratedValue
    private final int id;
    private String description;
    private String name;
    private float price;
}
