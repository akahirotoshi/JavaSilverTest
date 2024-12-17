package com.example.app.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Problem {
	
	private Integer id;
	
	@NotBlank
	@Size(max=200)
	private String name;
	private LocalDateTime date;
	
	

}
