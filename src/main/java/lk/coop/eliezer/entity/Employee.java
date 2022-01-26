package lk.coop.eliezer.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends BaseEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EPF")
    private String epf;

    @Column(name = "DOB")
    private Date dob;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    private Department department;

}
