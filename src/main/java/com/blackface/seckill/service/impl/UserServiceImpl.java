package com.blackface.seckill.service.impl;

import com.blackface.seckill.domain.SecUser;
import com.blackface.seckill.redis.RedisService;
import com.blackface.seckill.redis.prefix.AccToken;
import com.blackface.seckill.result.CodeMsg;
import com.blackface.seckill.service.UserService;
import com.blackface.seckill.util.MD5Util;
import com.blackface.seckill.util.UUIDUtil;
import com.blackface.seckill.vo.LoginVo;
import com.blackface.seckill.dao.SecUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/8
 * Time:22:42
 **/
@Service
public class UserServiceImpl implements UserService {

    public static final String COOKIE_NAME_TOKEN = "token";



    @Autowired
    SecUserMapper userMasterMapper;

    @Autowired
    SecUserMapper userMapper;

    @Autowired
    RedisService redisService;

    @Override
    public SecUser getUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Override
    public CodeMsg login(HttpServletResponse response, LoginVo loginVo) {

        if (loginVo == null) {
            return CodeMsg.SERVER_ERROR;
        }
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        if (StringUtils.isEmpty(mobile)) {
            return CodeMsg.MOBILE_NOT_EXIST;
        }

        //验证是否存在手机号
        SecUser user = null;
        try {
            user = getUserById(Long.parseLong(mobile));
            if (user == null) {
                return CodeMsg.MOBILE_NOT_EXIST;
            }

        } catch (Exception e) {  //防止手机号 类型转换错误
            return CodeMsg.MOBILE_NOT_EXIST;
        }

        //验证密码
        String salt = user.getSalt();
        String dbPassword = user.getPassword();
        String calc = MD5Util.formPassToDBPass(password, salt);
        if (!calc.equals(dbPassword)) {
            return CodeMsg.PASSWORD_ERROR;
        }

        //加入cookie
        String token = UUIDUtil.uuid();
        addCookie(response,token,user);
        return CodeMsg.SUCCESS;
    }


    private void addCookie(HttpServletResponse response, String token, SecUser user) {
        redisService.set(AccToken.getToken, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(AccToken.getToken.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 缓存中获取用户
     * @param token
     * @return
     */
    public SecUser getUserByToken(HttpServletResponse response,String token) {

        if (StringUtils.isEmpty(token)) {
            return null;
        }
        SecUser user =  redisService.get(AccToken.getToken,token,SecUser.class);
        //延长有效期
        if(user != null) {
            addCookie(response, token, user);
        }
        return user;
    }


}
