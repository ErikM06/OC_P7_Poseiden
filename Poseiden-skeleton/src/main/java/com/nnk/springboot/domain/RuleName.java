package com.nnk.springboot.domain;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "rulename")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RuleName {
	
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
}
