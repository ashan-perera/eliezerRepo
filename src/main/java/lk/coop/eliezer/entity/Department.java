package lk.coop.eliezer.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "DEPARTMENT")
public class Department extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "ALIAS", unique = true)
    private String alias;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

}
