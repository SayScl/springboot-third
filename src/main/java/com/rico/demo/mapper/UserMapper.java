package com.rico.demo.mapper;

import com.rico.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rico on 2017/6/16.
 */
@Component
@Mapper
public interface UserMapper {

    List<User> selectAllUsers();
}
