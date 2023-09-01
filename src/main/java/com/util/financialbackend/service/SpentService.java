package com.util.financialbackend.service;

import com.util.financialbackend.model.Spent;
import com.util.financialbackend.repository.SpentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpentService {

    @Autowired
    private SpentRepository repository;

    public Spent find(Long id) throws Exception {
        var temp = repository.findById(id);
        if(temp.isEmpty()){
            throw new Exception("Spent not found by id:"+id);
        }
        return temp.get();
    }
}
