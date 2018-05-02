package com.x.girl.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.x.girl.dto.Result;
import com.x.girl.exception.GirlException;
import com.x.girl.repository.GirlRepository;
import com.x.girl.domain.Girl;
import com.x.girl.service.GirlService;
import com.x.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by miller on 2018/5/1
 */
@RestController
public class GirlController {
    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

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
        logger.info("getList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     *
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
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


    /**
     * 根据年龄查询女生列表
     * @param age
     * @return
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }


    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws GirlException {
        girlService.getAge(id);
    }
}
