package demo.restController;

import demo.domain.Payment;
import demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Ling on 5/4/17.
 */
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "payments", method = RequestMethod.GET)
    public Page<Payment> findAll(@RequestParam(value = "page") int page,
                                 @RequestParam(value = "size", required = false) Integer size){
        return paymentService.findAll(new PageRequest(page, size == null ? 10 : size));
    }

    @RequestMapping(value = "payments/{id}", method = RequestMethod.GET)
    public Payment findById(@PathVariable("id") int id) {
        return paymentService.findById(id);
    }

    @RequestMapping(value = "payments", method = RequestMethod.POST)
    public List<Payment> upload(@RequestBody List<Payment> paymentList) {
        return paymentService.createMultiPayment(paymentList);
    }
}
