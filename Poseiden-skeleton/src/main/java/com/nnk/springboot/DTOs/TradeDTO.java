package com.nnk.springboot.DTOs;

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
public class TradeDTO {
	String account;
	String type;

	public TradeDTO(String account, String type) {
		this.account = account;
		this.type = type;
	}

}
