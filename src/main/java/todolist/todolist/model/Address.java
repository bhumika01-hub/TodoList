package todolist.todolist.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   // @OneToMany(cascade = CascadeType.ALL)
    private int zip;
    private String city;
    private String state;
}
