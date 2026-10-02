package com.example.joshua.ServiceInterface;

import com.example.joshua.Model.Users;

public interface UsersServiceInterface {

  Object createUsers(Users usersDTO);

  Object getUserDataById(String id);

  Object updateUserData(Users users);

  Object updateUserNameData(Users users);

}
