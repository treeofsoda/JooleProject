package com.Joole.demo.Repository;

import com.Joole.demo.Entity.TechnicalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalDetailRepository
        extends JpaRepository<TechnicalDetail, Integer> {
}
