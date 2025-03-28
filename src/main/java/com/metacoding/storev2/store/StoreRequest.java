package com.metacoding.storev2.store;

import lombok.Data;

public class StoreRequest {

    @Data
    public static class saveDTO {
        String name;
        Integer stock;
        Integer price;
    }
}
