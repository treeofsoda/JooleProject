package com.Joole.demo.Service;

import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.TechnicalDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TechnicalDetailService {
    @Transactional
    TechnicalDetail create(TechnicalDetail technicalDetail);

    TechnicalDetail findByOneId(int id);

    List<TechnicalDetail> readAll();

    TechnicalDetail update(TechnicalDetail technicalDetail);

    void delete(int id);
}
