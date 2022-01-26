package lk.coop.eliezer.service;

import lk.coop.eliezer.dto.request.DepartmentSaveRequest;
import lk.coop.eliezer.dto.request.DepartmentUpdateRequest;
import lk.coop.eliezer.dto.response.DepartmentResponse;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<DepartmentResponse> getAll();

    DepartmentResponse getById(String id);

    DepartmentResponse save(DepartmentSaveRequest departmentSaveRequest);

    DepartmentResponse update(DepartmentUpdateRequest departmentUpdateRequest);

    void delete(String id);

}
