package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import demo.service.RestaurantService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<MenuItem> menuItems = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

//    @JsonCreator
//    public Menu(@JsonProperty("id") int id,
//                @JsonProperty("restaurant_id") int restaurantId) {
//        this.id = id;
//    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
}
