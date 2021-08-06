package todolist.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todolist.todolist.model.UserModel;
import todolist.todolist.repo.UserRepo;
import todolist.todolist.service.UserService;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    public HelloController(UserRepo userRepo, UserService service) {
        this.userRepo = userRepo;
        this.service = service;
    }

    private final UserRepo userRepo;
    private UserService service;

    @RequestMapping("/hello")
    public String sayHello(){
        return "Namaste";

    }

//    @PostMapping("/employees")
//  Employee newEmployee(@RequestBody Employee newEmployee) {
//    return repository.save(newEmployee);
//  }
    @PostMapping(value = "/save")
//    public String saveMethod(@RequestBody UserModel user){
//        userRepo.save(user);
//        return "Sucess";
//    }


    UserModel newUser(@RequestBody UserModel newUser){
        return userRepo.save(newUser);
    }


    @GetMapping(value = "/users")
    public List<UserModel> getuser(){

        return service.getAllUser();
    }

//    @DeleteMapping("/employees/{id}")
//  void deleteEmployee(@PathVariable Long id) {
//    repository.deleteById(id);
//  }

    @DeleteMapping("UserModel/{id}")
    public void deleteUserModel(@PathVariable Integer id){
        userRepo.deleteById(id);
    }

    @DeleteMapping("UserModel/delete/{des}")
    public List<UserModel> deleteUserModel(@PathVariable String des){
        return userRepo.deleteByDescription(des);
    }

//    @PutMapping("/employees/{id}")
//  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//    return repository.findById(id)
//      .map(employee -> {
//        employee.setName(newEmployee.getName());
//        employee.setRole(newEmployee.getRole());
//        return repository.save(employee);
//      })
//      .orElseGet(() -> {
//        newEmployee.setId(id);
//        return repository.save(newEmployee);
//      });
//  }

    @PutMapping("/UserModel/{id}")
    UserModel replaceUser(@RequestBody UserModel newUser, @PathVariable Integer id){
        return userRepo.findById(id).map(t -> {
            t.setName(newUser.getName());
            t.setDescription(newUser.getDescription());
            return  userRepo.save(t);
        }).orElseGet(() -> {
            newUser.setId(id);
            return userRepo.save(newUser);
        });
    }





}
