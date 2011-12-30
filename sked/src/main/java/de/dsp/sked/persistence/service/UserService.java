package de.dsp.sked.persistence.service;

import java.util.List;

import de.dsp.sked.persistence.model.User;

public interface UserService {

	public void addUser(User user);
	public void updateUser(User kunde);
	public List<User> listUser();
	public void deleteUser(int id);
	public User getUser(int id);
	
	public User findUserByUsername(String username);
	public List<User> findUserByAutocomplete(String query);
	public User findUserByEmail(String email);
	
}