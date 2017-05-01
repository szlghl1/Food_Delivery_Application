package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Ling on 4/27/17.
 */
@Entity
@Table(name = "MENU_ITEM")
@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.ALWAYS)
public class MenuItem {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID")
    Menu menu;

    private String description;
    private String name;
    private float price;

    @JsonCreator
    public MenuItem(@JsonProperty(value = "menu", required = false) Menu menu,
                    @JsonProperty("description") String description,
                    @JsonProperty("name") String name,
                    @JsonProperty("price") float price,
                    @JsonProperty(value = "id", required = false) Integer id) {
        if(id != null) {
            this.id = id;
        }
        this.menu = menu;
        this.description = description;
        this.name = name;
        this.price = price;
    }
}
