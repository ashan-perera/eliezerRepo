package lk.coop.eliezer.controller;

import lk.coop.eliezer.dto.request.DepartmentSaveRequest;
import lk.coop.eliezer.dto.request.DepartmentUpdateRequest;
import lk.coop.eliezer.dto.response.DepartmentResponse;
import lk.coop.eliezer.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("Department")
@RestController
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    public ResponseEntity<List<DepartmentResponse>> getAll(){

        List<DepartmentResponse> departmentResponses = departmentService.getAll();
        return ResponseEntity.ok(departmentResponses);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DepartmentResponse> getById(String id){

        DepartmentResponse departmentResponse = departmentService.getById(id);
        return ResponseEntity.ok(departmentResponse);
    }

    @PostMapping()
    public ResponseEntity<DepartmentResponse> save(@RequestBody DepartmentSaveRequest request) {

        DepartmentResponse save = departmentService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping()
    public ResponseEntity<DepartmentResponse> update(@RequestBody DepartmentUpdateRequest request) {

        DepartmentResponse update = departmentService.update(request);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{delete}/{id}")
    public void delete(@PathVariable("id") String id){

        departmentService.delete(id);
    }

}
