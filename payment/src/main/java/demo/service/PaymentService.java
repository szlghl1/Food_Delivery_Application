package demo.service;

import demo.domain.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Ling on 5/4/17.
 */
public interface PaymentService {
    public Payment findById(int id);
    public Page<Payment> findAll(Pageable pageable);
    public void deleteAll();

    public Payment createPayment(String orderId,
                                 float price,
                                 String cardNumber,
                                 String expirationDate,
                                 String securityCode);
    public List<Payment> createMultiPayment(List<Payment> paymentList);

    //possible to update to observable
    public void notifyWhenPaid(Payment payment);
    public void notifyOrderServiceWhenPayed(Payment payment);

    public void pay(Payment payment);
}
