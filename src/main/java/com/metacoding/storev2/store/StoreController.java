package com.metacoding.storev2.store;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StoreController {
    private final StoreService storeService;

    // Save
    @PostMapping("store/save")
    public String save(StoreRequest.saveDTO saveDTO) {
        storeService.save(saveDTO);
        return "redirect:/store/list";
    }

    // SavePage
    @GetMapping("store/save-form")
    public String saveForm() {
        return "store/save-form";
    }

    // ListPage
    @GetMapping("store/list")
    public String list(HttpServletRequest request) {
        List<Store> storeList = storeService.storeList();
        request.setAttribute("models", storeList);
        return "store/list";
    }

}
