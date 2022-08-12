package magar.atul.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_list")
public class Product {
    
	//properties
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id; 
	
	@Column(name="name")
	private String name; 
	
	@Column(name="price")
	private double price; 
	
	@Column(name="description")
	private String desc; 
	
	@Column(name="created_at")
	private Date createdAt; 
	
	@Column(name="modified_at")
	private Date modifiedAt;
	
	//constructor
	public Product() { }
	
	public Product(  String name,double price, String desc) {
		super();
		
		this.price = price;
		this.name = name;
		this.desc = desc;
		this.createdAt = new Date();
		this.modifiedAt = new Date();
	
	}
	
	public Product(int id,String name,double price, String desc) {
		super();
		this.id =id;
		this.price = price;
		this.name = name;
		this.desc = desc;
		this.createdAt = new Date();
		this.modifiedAt = new Date();
	
	}
	
	public Product(int id) {
		
		this.id =id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", name=" + name + ", desc=" + desc + ", createdAt="
				+ createdAt + ", modifiedAt=" + modifiedAt + "]";
	}
	
	
}
	
	
