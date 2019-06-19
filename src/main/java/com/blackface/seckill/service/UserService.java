package com.blackface.seckill.service;

import com.blackface.seckill.domain.SecUser;
import com.blackface.seckill.result.CodeMsg;
import com.blackface.seckill.vo.LoginVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/8
 * Time:22:40
 **/
@Service
public interface UserService {

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    SecUser getUserById(long id);


    /**
     * 登陆接口
     * @param loginVo
     * @return
     */
     CodeMsg login(HttpServletResponse response, LoginVo loginVo);
}
