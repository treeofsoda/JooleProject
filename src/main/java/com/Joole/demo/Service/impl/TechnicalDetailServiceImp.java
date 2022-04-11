package com.Joole.demo.Service.impl;

import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.TechnicalDetail;
import com.Joole.demo.Repository.TechnicalDetailRepository;
import com.Joole.demo.Service.TechnicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TechnicalDetailServiceImp implements TechnicalDetailService {
    @Autowired
    TechnicalDetailRepository technicalDetailRepository;

    @Transactional
    public TechnicalDetail create(TechnicalDetail technicalDetail){
        return technicalDetailRepository.save(technicalDetail);
    }


    @Override
    public TechnicalDetail findByOneId(int id) {
        return technicalDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<TechnicalDetail> readAll(){
        List<TechnicalDetail> list = technicalDetailRepository.findAll();
        return list;
    }

    @Override
    public TechnicalDetail update(TechnicalDetail technicalDetail) {
        return technicalDetailRepository.save(technicalDetail);
    }


    @Override
    public void delete(int id) {
        technicalDetailRepository.deleteById(id);
    }
}
