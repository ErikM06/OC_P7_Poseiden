package com.nnk.springboot.domain;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rulename")
@NoArgsConstructor
@Data
@SelectBeforeUpdate
@DynamicUpdate
public class RuleName {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String description;
	String json;
	String template;
	String sqlStr;
	String sqlPart;

	public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {

		this.name = name;
		this.description = description;
		this.json = json;
		this.template = template;
		this.sqlStr = sqlStr;
		this.sqlPart = sqlPart;
	}

	public RuleName(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	
}
