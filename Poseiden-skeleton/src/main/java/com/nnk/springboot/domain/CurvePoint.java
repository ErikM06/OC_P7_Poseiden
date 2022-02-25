package com.nnk.springboot.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "curvepoint")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CurvePoint {
	
	
	Integer id;
	Integer curveId;
	Timestamp asOfDate;
	Double term;
	Double value;
	Timestamp creationDate;
	
	public CurvePoint(Integer curveId, Timestamp asOfDate, Double term, Double value,
			Timestamp creationDate) {
	
		this.curveId = curveId;
		this.asOfDate = asOfDate;
		this.term = term;
		this.value = value;
		this.creationDate = creationDate;
	}

	public CurvePoint(Integer curveId, Double term, Double value) {
		this.curveId = curveId; 
		this.term = term;
		this.value = value;
	}

}
