package com.nathan.flightreservation.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role extends AbstractEntity implements GrantedAuthority{
	private String name;
	@ManyToMany(mappedBy="roles")
	private Set<User> users;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
