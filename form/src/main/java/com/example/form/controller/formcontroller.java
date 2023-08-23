package com.example.form.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.form.model.formmodel;
import com.example.form.repo.formrepo;
import com.example.form.service.formservice;

@Controller
@RequestMapping

public class formcontroller {
    
    @Autowired
    private formservice formservice;

    @Autowired
    private formrepo formrepo;

    @GetMapping(path="/mouni")
    @ResponseBody
    public String mouni() {
        return "mouni";
    }

    @GetMapping(path="/formcheck")
    public String userlogin(formmodel formmodel) {
        return "loginform";
    }

    @GetMapping(path="/registercheck")
    public String userregistering(formmodel formmodel) {
        return "registrationform";
    }

   

    /*@PostMapping(path="/signup")
    @ResponseBody
    public String saving(@RequestParam String name , @RequestParam String email) {
        return formservice.save(name , email);
        
    }*/
 
   /*  @PostMapping(path = "/signup")
         // @ResponseBody
     public String saving(@ModelAttribute("formmodel") formmodel formmodel) {
        return formservice.save(formmodel);
     }*/

    @PostMapping(path="/signup")
    @ResponseBody
     public String saving(@ModelAttribute("formmodel") formmodel formmodel) {
        return formservice.save(formmodel);
       
     }

    @GetMapping(path="/getUsers")
    @ResponseBody
    public List<formmodel> getUsers() {
        return formservice.getUsers();
    }
    
     @GetMapping(path="/formdelete")

    public String deleting(formmodel formmodel) {
        return "deletionform";
    }

    @PostMapping(path="/deleteUser")
    @ResponseBody
    public String deleteUser(@ModelAttribute("email") String email) {    
    return formservice.deleteUser(email);

    }

    @PostMapping(path="/login")
    @ResponseBody
    public String logincheck(@RequestParam String name , @RequestParam String password) {
        return formservice.logincheck(name , password);
    }
    
    @GetMapping(path="/updatecheck")
    public String updatecheck() {
        return "updation";
    }

    @GetMapping(path="/getAllUsers")
	public ModelAndView getAllEmployees() {
		//ModelAndView mav = new ModelAndView("usertable");
		//mav.addObject("employees", formrepo.findAll());
		return formservice.getAllEmployees();
	}

    

   @PostMapping(path="/updateUser")
    @ResponseBody
    public String updateUser(@ModelAttribute("formmodel") formmodel formmodel) {
    return formservice.updateUser(formmodel);

    }
}
