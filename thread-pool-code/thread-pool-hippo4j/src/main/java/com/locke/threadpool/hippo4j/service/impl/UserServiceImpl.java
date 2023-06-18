package com.locke.threadpool.hippo4j.service.impl;

import com.locke.threadpool.hippo4j.service.UserService;
import com.locke.threadpool.hippo4j.service.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 用户服务实现
 *
 * @author PengLuo22
 * @date 2023/6/7
 * @since 0.0.1
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private ThreadPoolExecutor messageProduceDynamicExecutor2;

    @Override
    public int batchInsert(List<User> userList) {

        messageProduceDynamicExecutor2.execute(()-> {
            // 模拟做了insert操作
            for (User user : userList) {
//                System.out.println(user);
            }

            System.out.println("ok===========");
        });
        return userList.size();
    }
}
