package com.x.girl.controller;

import com.x.girl.repository.GirlRepository;
import com.x.girl.domain.Girl;
import com.x.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by miller on 2018/5/1
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     *
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public String girlAdd(@RequestParam(value = "cupSize") String cupSize,
                          @RequestParam(value = "age") Integer age) {
        Girl girl = new Girl(cupSize, age);
        return girlRepository.save(girl).toString();
    }

    /**
     * 查询一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).get();
    }

    /**
     * 更新一个女生
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl putGirl(@PathVariable("id") Integer id,
                        @RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl(id, cupSize, age);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     */
    @DeleteMapping(value = "/girls/{id}")
    public void delete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }


    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }
}
