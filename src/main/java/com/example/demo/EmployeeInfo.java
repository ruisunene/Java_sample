package com.example.demo;

import java.io.Serializable;
import lombok.Data;

@Data
public class EmployeeInfo implements Serializable {
 
	private static final long serialVersionUID = -9164735687539460765L;
	
	private String name;
    private String gender;
    private String department;
    private String title;
}

