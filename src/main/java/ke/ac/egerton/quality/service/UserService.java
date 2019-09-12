
package ke.ac.egerton.quality.service;


import ke.ac.egerton.quality.model.User;

public interface UserService {

	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);
}

