package com.metacoding.storev2.store;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StoreController {
    private final StoreService storeService;

    @GetMapping("store/list")
    public String list(HttpServletRequest request) {
        List<Store> storeList = storeService.storeList();
        request.setAttribute("models", storeList);
        return "store/list";
    }
}
