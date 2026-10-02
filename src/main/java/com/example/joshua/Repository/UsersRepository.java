package com.example.joshua.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.joshua.Model.Users;

import jakarta.persistence.Tuple;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

  @Query(value = "select * from new_schema_28.users where id=:ids", nativeQuery = true)
  Optional<Users> getUserDataById(@Param("ids") int ids);
}
