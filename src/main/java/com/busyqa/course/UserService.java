package com.busyqa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busyqa.course.springboot_course_4_soap.User;

@Service
public class UserService{
	
	@Autowired
	UserRepository userRepository;

    @Transactional(readOnly=true)
    public User findUser(int idUser){
    	
    	com.busyqa.course.User userRep = this.userRepository.findById(idUser).orElse(null);
    	
    	User user = new User();
    	
    	user.setIdUser(userRep.getIdUser());
    	user.setFirstName(userRep.getFirstName());
    	user.setLastName(userRep.getLastName());
    	user.setUsername(userRep.getUsername());
    	//user.setBirth(userRep.getBirth()());
    	user.setStatus(userRep.getStatus());
    	
        return user;
    }
    
}
