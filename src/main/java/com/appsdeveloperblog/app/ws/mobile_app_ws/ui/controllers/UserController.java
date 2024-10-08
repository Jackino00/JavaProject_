package com.appsdeveloperblog.app.ws.mobile_app_ws.ui.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.mobile_app_ws.service.UserService;
import com.appsdeveloperblog.app.ws.mobile_app_ws.shared.dto.UserDto;
import com.appsdeveloperblog.app.ws.mobile_app_ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.mobile_app_ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserRest retunValue = new UserRest();
        UserDto userDto = new UserDto();

        //COPIA LE PROPERTIES DELLA REQUEST (oggetto) userDetails dentro userDto
        BeanUtils.copyProperties(userDetails, userDto);
        
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, retunValue);

        return retunValue;
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
