package com.example.joshua.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.joshua.Model.Users;
import com.example.joshua.ServiceInterface.UsersServiceInterface;

@RestController
public class UsersController {

  @Autowired
  private UsersServiceInterface usersServiceInterface;

  @PostMapping("/userCreation")
  Object createUsers(@RequestBody Users usersDTO) {
    return this.usersServiceInterface.createUsers(usersDTO);
  }

  @RequestMapping("/userDataById")
  public Object getUserDataById(@RequestParam String id) {
    return this.usersServiceInterface.getUserDataById(id);
  }

  @PutMapping("/updateEmailUserData")
  public Object updateUserData(@RequestBody Users users) {
    return this.usersServiceInterface.updateUserData(users);
  }

  @PatchMapping("/updateUserName")
  Object updateUserNameData(@RequestBody Users users) {
    return this.usersServiceInterface.updateUserNameData(users);
  }

}
