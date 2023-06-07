package com.locke.threadpool.hippo4j.api;

import com.locke.threadpool.hippo4j.service.UserService;
import com.locke.threadpool.hippo4j.service.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author PengLuo22
 * @date 2023/6/7
 * @since 0.0.1
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private ThreadPoolExecutor messageProduceDynamicExecutor;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/batchInsert")
    public String batchInsert() {
        List<User> userList = new ArrayList<>();
        // 开3个线程，每个线程生产10000个用户
        for (int i = 0; i < 3; i++) {
            messageProduceDynamicExecutor.execute(() -> {
                for (int j = 0; j < 10000; j++) {
                    User user = new User();
                    user.setId(UUID.randomUUID().toString());
                    user.setName("user_" + UUID.randomUUID());
                    userList.add(user);
                }
            });
        }

        userService.batchInsert(userList);
        return "ok";
    }

}
