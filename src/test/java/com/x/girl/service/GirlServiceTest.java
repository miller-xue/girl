package com.x.girl.service;

import com.x.girl.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(GirlServiceTest.class);
    @Autowired
    private GirlService service;

    @Test
    public void findOneTest(){
       Girl girl =  service.findOne(1);
        Assert.assertEquals(new Integer(13),girl.getAge());
    }
}
