package todolist.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist.todolist.model.UserModel;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {

    @Transactional
    public List<UserModel> deleteByDescription(String description);
}
