package com.metacoding.storev2.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO {
        String username;
        String password;
        String fullname;
    }

    @Data
    public static class LoginDTO {
        String username;
        String password;
    }

}
