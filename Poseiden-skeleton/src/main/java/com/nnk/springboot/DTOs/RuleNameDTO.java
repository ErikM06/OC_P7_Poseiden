package com.nnk.springboot.DTOs;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Component
public class RuleNameDTO {
	@NotBlank (message = "name is mandatory")
	String name;
	@NotBlank (message = "description is mandatory")
	String description;
	
	public RuleNameDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

}
