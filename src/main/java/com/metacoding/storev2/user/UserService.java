package com.metacoding.storev2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void join(UserRequest.JoinDTO joinDTO) {
        // 1. username 중복체크
        User user = userRepository.findByUsername(joinDTO.getUsername());
        // 2. 있으면 오류 터트리기
        if (user != null) throw new RuntimeException("username 중복");
        // 3. 없으면 회원가입
        userRepository.save(joinDTO);
    }
}
