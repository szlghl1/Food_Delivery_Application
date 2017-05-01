package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
@Entity
@Table(name = "MENU")
@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Menu {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @OneToMany(mappedBy = "menu")
    private List<MenuItem> menuItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    @JsonCreator
    public Menu(@JsonProperty("id") int id,
                @JsonProperty(value = "menuItems", required = false) List<MenuItem> menuItems,
                @JsonProperty("restaurant") Restaurant restaurant) {
        this.id = id;
        if(menuItems != null)
            this.menuItems = menuItems;
        this.restaurant = restaurant;
    }
}
