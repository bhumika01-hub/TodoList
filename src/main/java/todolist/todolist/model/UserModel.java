package todolist.todolist.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserModel {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zip", nullable = false)

    private Address address;



}
