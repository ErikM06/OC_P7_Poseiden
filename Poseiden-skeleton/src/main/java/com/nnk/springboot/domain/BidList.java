package com.nnk.springboot.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bidlist")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BidList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer BidListId;
	String account;
	String type;
	Double bidQuantity;
	Double askQuantity;
	Double bid;
	Double ask;
	String benchmark;
	Timestamp bidListDate;
	String commentary;
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

	public BidList(Integer bidListId, String account, String type, Double bidQuantity, Double askQuantity, Double bid,
			Double ask, String benchmark, Timestamp bidListDate, String commentary, String security, String status,
			String trader, String book, String creationName, Timestamp creationDate, String revisionName,
			Timestamp revisionDate, String dealName, String dealType, String sourceListId, String side) {

		this.BidListId = bidListId;
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
		this.askQuantity = askQuantity;
		this.bid = bid;
		this.ask = ask;
		this.benchmark = benchmark;
		this.bidListDate = bidListDate;
		this.commentary = commentary;
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

	public BidList(String account, String type, double bidQuantity) {
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}
}
