package de.dsp.sked.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.dsp.sked.persistence.dao.UserDAO;
import de.dsp.sked.persistence.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Transactional
	public List<User> listUser() {
		return userDAO.listUser();
	}

	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	@Transactional
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Transactional
	public User findUserByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	@Transactional
	public List<User> findUserByAutocomplete(String query) {
		return userDAO.findByAutocomplete(query);
	}

	@Transactional
	public User findUserByEmail(String email) {
		return userDAO.findByEmail(email);
	}


}