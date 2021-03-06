package com.nnk.springboot.domain;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Entity
@Table(name = "trade")
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
@SelectBeforeUpdate
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer tradeId;
	String account;
	String type;
	Double buyQuantity;
	Double sellQuantity;
	Double buyPrice;
	Double sellPrice;
	String benchmark;
	Timestamp tradeDate;
	String security;
	String status;
	String trader;
	String book;
	String creationName;
	Timestamp creationDate;
	String revisionName;
	Timestamp revisionDate;
	String dealName;
	String dealType;
	String sourceListId;
	String side;

	public Trade(String account, String type, Double buyQuantity, Double sellQuantity, Double buyPrice,
			Double sellPrice, String benchmark, Timestamp tradeDate, String security, String status, String trader,
			String book, String creationName, Timestamp creationDate, String revisionName, Timestamp revisionDate,
			String dealName, String dealType, String sourceListId, String side) {
		this.account = account;
		this.type = type;
		this.buyQuantity = buyQuantity;
		this.sellQuantity = sellQuantity;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.benchmark = benchmark;
		this.tradeDate = tradeDate;
		this.security = security;
		this.status = status;
		this.trader = trader;
		this.book = book;
		this.creationName = creationName;
		this.creationDate = creationDate;
		this.revisionName = revisionName;
		this.revisionDate = revisionDate;
		this.dealName = dealName;
		this.dealType = dealType;
		this.sourceListId = sourceListId;
		this.side = side;
	}

	public Trade(String account, String type) {
		this.account = account;
		this.type = type;
	}

}
