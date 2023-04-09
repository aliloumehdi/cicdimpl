package ma.learning.cicdimpl.services;

import ma.learning.cicdimpl.entities.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public User createUser(User user) ;

    public User updateUser(Long id, User user) ;

    public void deleteUser(Long id)  ;
}
