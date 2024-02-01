package com.springhow.examples.springboot.thymeleaf.crud.domain.repositories;

import com.springhow.examples.springboot.thymeleaf.crud.domain.entities.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserInfoRepository {
    Map<Integer,UserInfo> users = new HashMap<>();

    public UserInfo save(UserInfo userInfo){
        return users.put(userInfo.getId(),userInfo);
    }

    public List<UserInfo> findAll(){
        return users.values().stream().toList();
    }

    public Optional<UserInfo> findById(Integer id){
        return users.values().stream().filter(userInfo -> userInfo.getId().equals(id)).findFirst();
    }

    public UserInfo delete(Integer id){
        return users.remove(id);
    }
}
