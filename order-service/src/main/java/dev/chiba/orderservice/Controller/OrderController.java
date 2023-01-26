package dev.chiba.orderservice.Controller;

import dev.chiba.basedomainsservice.Dto.Order;
import dev.chiba.basedomainsservice.Dto.OrderEvent;
import dev.chiba.orderservice.Service.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/send")
    public String sendOrder(@RequestBody Order order){
        order.setId(UUID.randomUUID().toString());
        OrderEvent orderEvent = OrderEvent.builder()
                .message("Order Is Sent")
                .status("Pending")
                .order(order)
                .build();
        orderProducer.sendMessage(orderEvent);
        return "Order Is Sent Successfully...";
    }
}
