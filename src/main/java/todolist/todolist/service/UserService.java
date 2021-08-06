package todolist.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolist.todolist.model.UserModel;
import todolist.todolist.repo.UserRepo;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    public List<UserModel> getAllUser(){
       return repo.findAll();
    }
}
