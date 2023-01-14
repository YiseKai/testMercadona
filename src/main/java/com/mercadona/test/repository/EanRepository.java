package com.mercadona.test.repository;

import com.mercadona.test.model.Ean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EanRepository extends JpaRepository<Ean, Integer> {
    Ean findByEanNumber(String eanNumber);
}
