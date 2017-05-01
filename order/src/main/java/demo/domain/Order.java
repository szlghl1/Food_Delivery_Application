package demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */

@Table
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue
    private int id;
    private Date timestamp;
    private String description;
    private int customerId;
    private String customerName;
    private Date estimatedDeliveryTime;
    private boolean isPayed;
    private int paymentId;

    @OneToMany
    private List<MenuItem> orderedItems;
}
