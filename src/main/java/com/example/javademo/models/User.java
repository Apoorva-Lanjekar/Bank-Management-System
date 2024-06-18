package com.example.javademo.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int userId; 


	public User(int userId, String name, String address, Set<BankAccount> bankAccount) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.bankAccount = bankAccount;
	}


	@Column(name = "name")
	 private String name;
	
	@Column(name = "address")
	private String address;
	
	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<BankAccount> bankAccount;

	public Set<BankAccount> getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Set<BankAccount> bankAccount) {
		this.bankAccount = bankAccount;
	}

}
