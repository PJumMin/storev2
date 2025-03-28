package com.metacoding.storev2.store;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class StoreRepository {
    private final EntityManager em;

    public List<Store> findAll() {
        Query query = em.createNativeQuery("select * from store_tb ORDER BY id", Store.class);
        List<Store> storeList = query.getResultList();
        return storeList;
    }

    public void save(StoreRequest.saveDTO saveDTO) {
        Query query = em.createNativeQuery("insert into store_tb (name, stock, price) values (?, ?, ?)");
        query.setParameter(1, saveDTO.name);
        query.setParameter(2, saveDTO.stock);
        query.setParameter(3, saveDTO.price);
        query.executeUpdate();

    }

}
