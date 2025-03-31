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

    //Update
    public void updateById(StoreRequest.saveDTO saveDTO, Integer id) {
        Query query = em.createNativeQuery("update store_tb set name=?,stock=?,price=? where id=?");
        query.setParameter(1, saveDTO.name);
        query.setParameter(2, saveDTO.stock);
        query.setParameter(3, saveDTO.price);
        query.setParameter(4, id);
        query.executeUpdate();
    }

    // List
    public List<Store> findAll() {
        Query query = em.createNativeQuery("select * from store_tb ORDER BY id", Store.class);
        List<Store> storeList = query.getResultList();
        return storeList;
    }

    // Save
    public void save(StoreRequest.saveDTO saveDTO) {
        Query query = em.createNativeQuery("insert into store_tb (name, stock, price) values (?, ?, ?)");
        query.setParameter(1, saveDTO.name);
        query.setParameter(2, saveDTO.stock);
        query.setParameter(3, saveDTO.price);
        query.executeUpdate();
    }

    // Detail
    public Store findById(int userId) {
        Query query = em.createNativeQuery("select * from store_tb WHERE id=? ORDER BY id", Store.class);
        query.setParameter(1, userId);
        return (Store) query.getSingleResult();
    }
}
