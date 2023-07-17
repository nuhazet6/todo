package org.nuhaempresario.service;

import org.nuhaempresario.model.User;
import org.nuhaempresario.model.dao.UserDao;
import org.nuhaempresario.utils.HashGenerator;
import org.nuhaempresario.utils.exception.BadRequestException;
import org.nuhaempresario.utils.exception.NotFoundException;

import java.util.List;

public class UserService {
    private final UserDao repository;
    private final HashGenerator hashGenerator;

    public UserService() {
        repository = new UserDao();
        hashGenerator = new HashGenerator();
    }

    public User create(User u) throws RuntimeException{
        try {
            u.setPassword(hashGenerator.generate(u.getPassword()));
            User user = repository.create(u);
            if (user == null){
                throw new BadRequestException();
            }
            return user;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public User findOneById(long id) throws RuntimeException{
        User user = repository.findOneById(id);
        if (user == null){
            throw new NotFoundException();
        }
        return user;
    }

    public List<User> findAll(){
        List<User> users = repository.findAll();
        if (users == null){
            throw new NotFoundException();
        }
        return users;
    }

    public void remove(long id) throws RuntimeException{
        User delete = findOneById(id);
        repository.remove(delete.getId());
    }

    public User update(long id, User user){
        User update = repository.update(id,user);
        if (update == null){
            throw new NotFoundException();
        }
        return update;
    }
}
