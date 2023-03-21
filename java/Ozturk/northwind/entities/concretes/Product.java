package Ozturk.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get ve setleri oluşturur
@Entity // Bir veritabanının entitysi olmalı.
@Table(name="products") //veritabanı tablosunu belirtir.
@AllArgsConstructor //parametreli constructor
@NoArgsConstructor //parametresiz constructor
public class Product {
	
			@Id //primary key olduğunu
			@GeneratedValue(strategy = GenerationType.IDENTITY) //id nasıl olacak
			@Column(name="product_id") //hangi kolon olduğu
			private int id;
			
			//@Column(name="category_id")
			//private int categoryId;
			
			@Column(name="product_name")
			private String productName;
			
			@Column(name="unit_price")
			private double unitPrice;
			
			@Column(name="units_in_stock")
			private short unitsInStock;
			
			@Column(name="quantity_per_unit")
			private String quantityPerUnit;
			
			@ManyToOne()
			@JoinColumn(name="category_id")
			private Category category;

}
