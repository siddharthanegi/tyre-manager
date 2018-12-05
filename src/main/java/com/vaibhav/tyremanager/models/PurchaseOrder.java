package com.vaibhav.tyremanager.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.Data;

@Entity(name = "PURCHASE_ORDER")
@Data
public class PurchaseOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PURCHASE_ORDER_SEQ")
	@SequenceGenerator(name = "PURCHASE_ORDER_SEQ", sequenceName = "PURCHASE_ORDER_SEQ", allocationSize = 1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "BRAND_ID")
	private TyreBrand brand;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
	@Transient
	private String orderDateStr;
	
	@PrePersist
	private void setDateFromString() {
		if(null != orderDateStr) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				this.orderDate = sdf.parse(orderDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
