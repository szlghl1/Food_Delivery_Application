package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import demo.service.MenuService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    Menu menu;

    private String description;
    private String name;
    private float price;

    public MenuItem(String name, String description, float price) {
        this.description = description;
        this.name = name;
        this.price = price;
    }
}
