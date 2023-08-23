package com.example.form.model;

//import com.example.form.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="formmodel")
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class formmodel {
    
    @Id
    public String email;
    public String name;
    public String password;
    public String cnfmpassword;
}
