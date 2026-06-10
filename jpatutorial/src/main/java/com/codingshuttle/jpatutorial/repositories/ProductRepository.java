package com.codingshuttle.jpatutorial.repositories;

import com.codingshuttle.jpatutorial.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByTitleOrderByPrice(String title);

    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findByTitle(String title, Pageable pageable);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}
