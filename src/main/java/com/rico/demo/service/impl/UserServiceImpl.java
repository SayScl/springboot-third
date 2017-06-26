package com.rico.demo.service.impl;

import com.rico.demo.domain.User;
import com.rico.demo.mapper.UserMapper;
import com.rico.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rico on 2017/6/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUserList() {
        return this.userMapper.selectAllUsers();
    }
}
