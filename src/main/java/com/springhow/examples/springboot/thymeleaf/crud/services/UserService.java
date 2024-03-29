package com.springhow.examples.springboot.thymeleaf.crud.services;

import com.springhow.examples.springboot.thymeleaf.crud.domain.entities.UserInfo;
import com.springhow.examples.springboot.thymeleaf.crud.domain.repositories.UserInfoRepository;
import com.springhow.examples.springboot.thymeleaf.crud.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserInfoRepository userInfoRepository;
    private Integer counter=0;

    public UserService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfo getUser(Integer id) {
        return userInfoRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public UserInfo createUser(UserInfo userInfo) {
        userInfo.setId(++counter);
        return userInfoRepository.save(userInfo);
    }

    public List<UserInfo> getUsers() {
        return userInfoRepository.findAll();
    }

    public UserInfo updateUser(Integer id, UserInfo request) {
        UserInfo fromDb = getUser(id);
        fromDb.setFirstName(request.getFirstName());
        fromDb.setLastName(request.getLastName());
        fromDb.setRole(request.getRole());
        fromDb.setUpdatedAt(LocalDateTime.now());
        fromDb.setWillDelete(false);
        return userInfoRepository.save(fromDb);
    }

    public UserInfo deleteUser(Integer id){
        return userInfoRepository.delete(id);
    }
}
