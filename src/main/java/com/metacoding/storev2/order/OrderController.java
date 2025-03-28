package com.metacoding.storev2.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class OrderController {
    private final OrderService orderService;
}
