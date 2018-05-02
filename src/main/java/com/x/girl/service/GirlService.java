package com.x.girl.service;

import com.x.girl.enums.ResultEnum;
import com.x.girl.exception.GirlException;
import com.x.girl.repository.GirlRepository;
import com.x.girl.domain.Girl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public void getAge(Integer id) throws GirlException{
        Girl girl = girlRepository.findById(id).get();
        int age = girl.getAge();
        if(age < 10){
            //你还在上小学
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //你可能在上初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过ID查询一个女生信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findById(id).get();
    }
}
