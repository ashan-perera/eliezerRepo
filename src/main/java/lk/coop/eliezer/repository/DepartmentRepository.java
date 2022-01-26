package lk.coop.eliezer.repository;

import lk.coop.eliezer.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
