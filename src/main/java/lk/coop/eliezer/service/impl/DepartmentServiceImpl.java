package lk.coop.eliezer.service.impl;

import lk.coop.eliezer.dto.request.DepartmentSaveRequest;
import lk.coop.eliezer.dto.request.DepartmentUpdateRequest;
import lk.coop.eliezer.dto.request.EmployeeSaveRequest;
import lk.coop.eliezer.dto.response.DepartmentResponse;
import lk.coop.eliezer.entity.Department;
import lk.coop.eliezer.entity.Employee;
import lk.coop.eliezer.enums.Status;
import lk.coop.eliezer.repository.DepartmentRepository;
import lk.coop.eliezer.repository.EmployeeRepository;
import lk.coop.eliezer.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DepartmentResponse> getAll() {
        return departmentRepository.findAll().stream().map(DepartmentServiceImpl::convert).collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse getById(String id) {
        return departmentRepository.findById(id).map(DepartmentServiceImpl::convert).orElse(null);
    }

    @Override
    public DepartmentResponse save(DepartmentSaveRequest departmentSaveRequest) {

        Department department = new Department();

        department.setAlias(departmentSaveRequest.getAlias());
        department.setName(departmentSaveRequest.getName());
        department.setCreatedBy(departmentSaveRequest.getCreatedBy());
        department.setModifiedBy(departmentSaveRequest.getModifiedBy());
        department.setStatus(Status.ACTIVE);

        Department departmentSave = departmentRepository.save(department);

        if(departmentSaveRequest.getEmployeeSaveRequestList() != null) {

            List<EmployeeSaveRequest> employeeSaveRequestList = departmentSaveRequest.getEmployeeSaveRequestList();
            employeeSaveRequestList.forEach(employeeSaveRequest -> {

                Employee employee = new Employee();

                employee.setFirstName(employeeSaveRequest.getFirstName());
                employee.setLastName(employeeSaveRequest.getLastName());
                employee.setEpf(employeeSaveRequest.getEpf());
                employee.setDob(employeeSaveRequest.getDob());
                employee.setCreatedBy(employeeSaveRequest.getCreatedBy());
                employee.setModifiedBy(employeeSaveRequest.getModifiedBy());
                employee.setStatus(Status.ACTIVE);
                employee.setDepartment(departmentSave);

                employeeRepository.save(employee);

            });

        }

        return convert(departmentSave);

    }

    @Override
    public DepartmentResponse update(DepartmentUpdateRequest departmentUpdateRequest) {

        Department department = new Department();

        department.setId(departmentUpdateRequest.getId());
        department.setAlias(departmentUpdateRequest.getAlias());
        department.setName(departmentUpdateRequest.getName());
        department.setModifiedBy(departmentUpdateRequest.getModifiedBy());
        department.setStatus(departmentUpdateRequest.getStatus() == null ? Status.ACTIVE : departmentUpdateRequest.getStatus());

        Department update = departmentRepository.save(department);

        return convert(update);

    }

    @Override
    public void delete(String id) {
        departmentRepository.deleteById(id);
    }

    public static DepartmentResponse convert(Department department) {

        DepartmentResponse departmentResponse = new DepartmentResponse();

        departmentResponse.setId(department.getId());
        departmentResponse.setName(department.getName());
        departmentResponse.setAlias(department.getAlias());
        departmentResponse.setCreatedBy(department.getCreatedBy());
        departmentResponse.setModifiedBy(department.getModifiedBy());
        departmentResponse.setCreatedDateTime(department.getCreatedDateTime());
        departmentResponse.setModifiedDateTime(department.getModifiedDateTime());
        departmentResponse.setStatus(department.getStatus());

        return departmentResponse;

    }
}
