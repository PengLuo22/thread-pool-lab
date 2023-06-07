package com.locke.threadpool.hippo4j.service;

import com.locke.threadpool.hippo4j.service.entity.User;

import java.util.List;

/**
 * 用户服务
 *
 * @author PengLuo22
 * @date 2023/6/7
 * @since 0.0.1
 */
public interface UserService {

    int batchInsert(List<User> userList);

}
