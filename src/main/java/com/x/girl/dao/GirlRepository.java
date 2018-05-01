package com.x.girl.dao;

import com.x.girl.pojo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by miller on 2018/5/1
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
