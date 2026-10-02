package com.example.joshua.ServiceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.Tuple;

import com.example.joshua.Model.Users;
import com.example.joshua.Repository.UsersRepository;
import com.example.joshua.ServiceInterface.UsersServiceInterface;

@Service
public class UsersServiceImpl implements UsersServiceInterface {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public Object createUsers(Users usersDTO) {

    this.usersRepository.save(usersDTO);

    return "Data Inserted";

  }

  @Override
  public Object getUserDataById(String id) {

    Optional<Users> uTuple = this.usersRepository.getUserDataById(Integer.parseInt(id));

    if (!uTuple.isPresent()) {
      return "No record found";
    }
    return uTuple;
  }

  @Override
  public Object updateUserData(Users users) {

    Optional<Users> uOptional = this.usersRepository.findById(users.getId().intValue());

    Users users2 = uOptional.get();

    users2.setEmail(users.getEmail());
    users2.setUsername(users.getUsername());

    return this.usersRepository.save(users2);// this save() method help us to create the new data or update the data.

  }

  @Override
  public Object updateUserNameData(Users users) {

    Optional<Users> uOptional = this.usersRepository.findById(users.getId().intValue());

    Users users2 = uOptional.get();

    users2.setUsername(users.getUsername());

    return this.usersRepository.save(users2);// this save() method help us to create the new data or update the data.

  }

}
