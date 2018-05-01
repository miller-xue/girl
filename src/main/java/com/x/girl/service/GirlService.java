package com.x.girl.service;

import com.x.girl.dao.GirlRepository;
import com.x.girl.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by miller on 2018/5/1
 */
@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;


    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl("F",1);
        Girl girlB = new Girl("GF",2);
        girlRepository.save(girlA);
        girlRepository.save(girlB);
    }
}
