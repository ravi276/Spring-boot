package com.Spring.boot.practice.Practice.User.UserResource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{

}
