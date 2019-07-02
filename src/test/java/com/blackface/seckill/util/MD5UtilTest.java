package com.blackface.seckill.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/13
 * Time:22:28
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class MD5UtilTest {
    @Test
    public void inputPassToDbPass() throws Exception {


        String dbPassword = MD5Util.inputPassToDbPass("123456", "1a2b3c4d");
        System.out.println(dbPassword);
    }

}