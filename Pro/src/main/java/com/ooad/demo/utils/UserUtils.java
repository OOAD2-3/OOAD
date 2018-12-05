package com.ooad.demo.utils;

import com.ooad.demo.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: 17Wang
 * @Date: 19:41 2018/12/5
 * @Description: 获取当前用户
 */
public class UserUtils {
    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
