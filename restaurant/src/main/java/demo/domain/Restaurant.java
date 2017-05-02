package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
@Entity
@Table(name = "RESTAURANT")
@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Restaurant {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus = new ArrayList<>();

    private String owner;

    private String description;

    private String address;

    @JsonCreator
    public Restaurant(@JsonProperty("name") String name,
                      @JsonProperty("owner") String owner,
                      @JsonProperty("description") String description,
                      @JsonProperty("address") String address) {
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.address = address;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }
}
