package com.example.form.model;

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
    public String name;
    public String email;
}
