package demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.util.Date;


/**
 * Created by Ling on 4/27/17.
 */
@Data
@Document
public class payment {
    @Id
    @GeneratedValue
    private final int id;

    private final int orderId;
    private final float price;
    private final int customerId;
    private final String customerName;
    private final String cardNumber;
    private final String expirationDate;
    private final String securityCode;
    private final Date timestamp;
}
