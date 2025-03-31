package com.metacoding.storev2.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {
    private final StoreRepository storeRepository;

    //Update
    @Transactional
    public void update(StoreRequest.saveDTO saveDTO, Integer id) {
        storeRepository.updateById(saveDTO, id);
    }

    // Detail
    public Store detail(int userId) {
        Store store = storeRepository.findById(userId);
        return store;
    }

    // Save
    @Transactional
    public void save(StoreRequest.saveDTO saveDTO) {
        storeRepository.save(saveDTO);
    }

    // List
    public List<Store> storeList() {
        return storeRepository.findAll();
    }

    // Delete
    @Transactional
    public void delete(int id) {
        storeRepository.delete(id);
    }
}
