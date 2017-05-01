package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;


/**
 * Created by Ling on 4/27/17.
 */
@Data
@NoArgsConstructor
@Entity
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class payment {
    @Id
    @GeneratedValue
    private int id;

    private int orderId;
    private float price;
    private Date timestamp;
    private boolean isPayed;

    //should not store in real world
    private String cardNumber;
    private String expirationDate;
    private String securityCode;

    @JsonCreator
    public payment(@JsonProperty("order_id") int orderId,
                   @JsonProperty("price") float price,
                   @JsonProperty("card_number") String cardNumber,
                   @JsonProperty("expiration_date") String expirationDate,
                   @JsonProperty("security_code") String securityCode) {
        this.orderId = orderId;
        this.price = price;
        this.timestamp = new Date();
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;

        isPayed = pay();
    }

    //pretending we are talking with the bank
    private boolean pay() {
        return true;
    }
}
