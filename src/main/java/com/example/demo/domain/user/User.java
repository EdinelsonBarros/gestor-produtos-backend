package com.example.demo.domain.user;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@NotNull
	private String login;
	
	@NotNull
	@Size(min=8)
	private String password;
	
	private UserRole role;
	
	public User(String login, String password, UserRole role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}

}
