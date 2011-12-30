package de.dsp.sked.persistence.dao;

import java.util.List;

import de.dsp.sked.persistence.model.User;

public interface UserDAO {

	public void addUser(User user);
	public void updateUser(User user);
	public List<User> listUser();
	public void deleteUser(int id);
	public User getUser(int id);
	
	public User findByUsername(String username);
	public List<User> findByAutocomplete(String query);
	public User findByEmail(String email);
	
	
}