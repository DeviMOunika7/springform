package com.example.form.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import com.example.form.model.formmodel;
import com.example.form.repo.formrepo;

@Service
public class formservice {

    @Autowired
    private formrepo formrepo;

   /*public String save(String name ,String email) {
        /*Optional<formmodel> user = formrepo.findByEmail(formmodel.getEmail());
        if(user.isPresent())
        return "user already exists..Please login";*/
        formmodel user = new formmodel();
      /* user.setEmail(email);
       user.setName(name);
       formrepo.save(user);
        return "user data saved successfully";
        
    }*/

  public String save(formmodel formmodel)
 {
    formrepo.save(formmodel);
    return "done";
 }

    
    public List<formmodel> getUsers() {
       return formrepo.findAll();
    }

   public String deleteUser(String name) {
      Optional<formmodel> op = formrepo.findByName(name);
      if(op.isPresent()) {
         formmodel deletedUser = op.get();
         formrepo.delete(deletedUser);
         return name+" is deleted";
      }
      return "user doesnot exists";
      
    }

    


    
}
