package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Payment {
    @Id
    @GeneratedValue
    private int id;

    private String orderId;
    private float price;
    private Date timestamp;
    private boolean isPayed;

    //should not store in real world
    private String cardNumber;
    private String expirationDate;
    private String securityCode;

    @JsonCreator
    public Payment(@JsonProperty("order_id") String orderId,
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
        this.isPayed = false;
    }
}
