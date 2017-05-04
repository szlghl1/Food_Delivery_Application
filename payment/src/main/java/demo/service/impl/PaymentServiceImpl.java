package demo.service.impl;

import demo.domain.Payment;
import demo.domain.PaymentRepo;
import demo.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Ling on 5/4/17.
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Value("${URL.food-delivery-app-order}")
    String orderServiceUrl;

    @Override
    public Payment findById(int id) {
        return paymentRepo.findOne(id);
    }

    @Override
    public Page<Payment> findAll(Pageable pageable) {
        return paymentRepo.findAll(pageable);
    }

    @Override
    public void deleteAll() {
        paymentRepo.deleteAll();
    }

    @Override
    public Payment createPayment(String orderId, float price, String cardNumber, String expirationDate, String securityCode) {
        Payment payment = paymentRepo.save(new Payment(orderId,price,cardNumber,expirationDate,securityCode));
        pay(payment);
        return payment;
    }

    @Override
    public List<Payment> createMultiPayment(List<Payment> paymentList) {
        for(Payment payment : paymentList) {
            pay(payment);
        }
        return paymentRepo.save(paymentList);
    }

    @Override
    public void notifyWhenPaid(Payment payment) {
        notifyOrderServiceWhenPayed(payment);
    }

    @Override
    public void notifyOrderServiceWhenPayed(Payment payment) {
        RestTemplate restTemplate = new RestTemplate();
        String url = orderServiceUrl + "/orders/" + payment.getOrderId() + "/is_paid";
        restTemplate.put(url, true);
        logger.debug("sent PUT request to " + url);
    }

    //pretending we are talking with the bank
    @Override
    public void pay(Payment payment) {
        payment.setPayed(true);
        notifyWhenPaid(payment);
    }
}
