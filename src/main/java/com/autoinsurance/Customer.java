/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: uengine
 * License Type: Purchased
 */
package com.autoinsurance;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.metaworks.annotation.*;
import org.metaworks.multitenancy.persistence.TenantProperties;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Customer")
//@Multitenant
//@TenantDiscriminatorColumn(
//		name = "TENANTID",
//		contextProperty = "tenant-id"
//)
public class Customer implements Serializable{
	public Customer() {
	}
	
	@Column(name="Id", nullable=false, length=19)	
	@Id	
	@GeneratedValue(generator="COM_AUTOINSURANCE_CUSTOMER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_AUTOINSURANCE_CUSTOMER_ID_GENERATOR", strategy="native")	
	private Long id;
	
	@Column(name="FirstName", nullable=true, length=255)
	private String firstName;
	
	@Column(name="LastName", nullable=true, length=255)
	private String lastName;
	
	@Column(name="Address", nullable=true, length=255)
	private String address;

	@Column(name="Age", nullable=false, length=10)
	private int age;

	@Column(name="BirthDay", nullable=true)
	@Temporal(TemporalType.DATE)
	private java.util.Date birthDay;

	@OneToMany(mappedBy="customer", targetEntity=com.autoinsurance.Vehicle.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set vehicles = new java.util.HashSet();

	private void setId(long value) {
		setId(new Long(value));
	}

	public void setId(Long value) {
		this.id = value;
	}

	@org.metaworks.annotation.Id
	@Hidden
	public Long getId() {
		return id;
	}

	public Long getORMID() {
		return getId();
	}

	public void setFirstName(String value) {
		this.firstName = value;
	}

	@Order(1)
	@Group(name="Default Information")
	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String value) {
		this.lastName = value;
	}

	@Order(2)
	@Group(name="Default Information")
	public String getLastName() {
		return lastName;
	}

	public void setAddress(String value) {
		this.address = value;
	}

	@Order(3)
	@Face(displayName = "주소")
	@Group(name="Default Information")
	public String getAddress() {
		return address;
	}

	public void setAge(int value) {
		this.age = value;
	}

	@Order(4)
	@Face(displayName = "나이")
	@Group(name="Bio Information")
	public int getAge() {
		return age;
	}

	public void setBirthDay(java.util.Date value) {
		this.birthDay = value;
	}

	@Order(5)
	@Face(displayName = "생년월일")
	@Group(name="Bio Information")
	public java.util.Date getBirthDay() {
		return birthDay;
	}

	@Hidden
	public void setVehicles(java.util.Set value) {
		this.vehicles = value;
	}

	public java.util.Set getVehicles() {
		return vehicles;
	}


	public String toString() {
		return String.valueOf(getId());
	}

	@ServiceMethod
	public void subscribe(){
		//...
	}

}
