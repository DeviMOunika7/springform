package com.example.form.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
     if(formmodel.getPassword().equals(formmodel.getCnfmpassword()))
     {
    formrepo.save(formmodel);
    return "done";
     }
     else {
      return "password and cnfmpassword are not matching";
     }
 }

    
    public List<formmodel> getUsers() {
       return formrepo.findAll();
    }


   public String deleteUser(String email) {
      Optional<formmodel> op = formrepo.findByEmail(email);
      if(op.isPresent()) {
         formmodel deletedUser = op.get();
         formrepo.delete(deletedUser);
         return deletedUser.getName()+" is deleted";
      }
      return "user doesnot exists";
      
    }

    

    public String logincheck(String name, String password) {
      Optional<formmodel> opname = formrepo.findByName(name);
       if(opname.isPresent()) {
         formmodel person = opname.get();
         if(person.getPassword().equals(password))
         return "login successfully";
         else {
            return "incorrect password";
         }
       }
      
         return "user doesnot exists";
       
    }


   /* public String updateUser(String email ,formmodel formmodel) {
   Optional<formmodel>op = formrepo.findByEmail(email);
   if(op.isPresent()) {
      formmodel person = op.get();
      
      person.setEmail(formmodel.getEmail());
      person.setName(formmodel.getName());
      person.setPassword(formmodel.getPassword());
      person.setCnfmpassword(formmodel.getCnfmpassword());
      formrepo.save(person);
      return person.getName()+" updated successfully";
   }
   return "user doesnot exists";
   }*/

    public String updateUser(formmodel formmodel) {
   Optional<formmodel>op = formrepo.findByEmail(formmodel.getEmail());
   if(op.isPresent()) {
      formmodel person = op.get();
      person.setName(formmodel.getName());
      person.setPassword(formmodel.getPassword());
      person.setCnfmpassword(formmodel.getCnfmpassword());
      formrepo.save(person);
      return person.getName()+" updated successfully";
   }
   return "user doesnot exists";
   
}
   

public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView("usertable");
		mav.addObject("employees", formrepo.findAll());
		return mav;
	}
    
}
