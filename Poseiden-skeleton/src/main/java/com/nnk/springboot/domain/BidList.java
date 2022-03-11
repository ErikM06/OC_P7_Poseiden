package com.nnk.springboot.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.sql.Timestamp;

@Entity
@Table(name = "bidlist")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@DynamicUpdate
@SelectBeforeUpdate
public class BidList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name= "bidListId")
	Integer BidListId;
	@Column (name = "account")
	String account;
	@Column (name = "type")
	String type;
	@Column (name = "bidQuantity")
	Double bidQuantity;
	@Column(name = "askQuantity")
	Double askQuantity;
	@Column (name = "bid")
	Double bid;
	@Column (name = "ask")
	Double ask;
	@Column (name = "benchmark")
	String benchmark;
	@Column (name = "bidListDate")
	Timestamp bidListDate;
	@Column (name = "commentary")
	String commentary;
	@Column (name = "security")
	String security;
	@Column (name = "status")
	String status;
	@Column (name = "trader")
	String trader;
	@Column (name = "book")
	String book;
	@Column (name = "creationName")
	String creationName;
	@Column (name = "creationDate")
	Timestamp creationDate;
	@Column (name = "revisionName")
	String revisionName;
	@Column (name = "revisionDate")
	Timestamp revisionDate;
	@Column (name = "dealName")
	String dealName;
	@Column (name = "dealType")
	String dealType;
	@Column (name = "sourceListId")
	String sourceListId;
	@Column (name = "side")
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
