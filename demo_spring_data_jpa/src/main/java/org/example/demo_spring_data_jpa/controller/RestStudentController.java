package org.example.demo_spring_data_jpa.controller;

import org.example.demo_spring_data_jpa.dto.StudentDto;
import org.example.demo_spring_data_jpa.entity.Student;
import org.example.demo_spring_data_jpa.exception.DuplicateAdminException;
import org.example.demo_spring_data_jpa.service.IClassService;
import org.example.demo_spring_data_jpa.service.IStudentService;
import org.example.demo_spring_data_jpa.validation.StudentValidate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/students")
public class RestStudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassService classService;

    // viết api trả về list
//    @GetMapping("")
//    public ResponseEntity<List<Student>> getAll() {
//        List<Student> studentList = studentService.findAll();
//        if (studentList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204
//        }
//        return new ResponseEntity<>(studentList, HttpStatus.OK);// 200
//    }

    @GetMapping("")
    public ResponseEntity<Page<Student>> showList(@RequestParam(name = "page",
                                                              required = false,
                                                              defaultValue = "0") int page
                                                                                        ) {
        Pageable pageable = PageRequest.of(page, 2);

        Page<Student> studentPage = studentService.findAll(pageable);
        if (studentPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204
        }
        return new ResponseEntity<>(studentPage, HttpStatus.OK);// 200
    }

    // trả về student theo id
    @GetMapping("/{id}")
    public ResponseEntity<Student> detail(@PathVariable(name = "id") int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
        return new ResponseEntity<>(student, HttpStatus.OK);// 200
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody StudentDto studentDto, BindingResult bindingResult) throws DuplicateAdminException {
        Map<String, String> map = new LinkedHashMap<>();
        StudentValidate validate = new StudentValidate();
        validate.validate(studentDto,bindingResult);
        if (bindingResult.hasErrors()) {
            // kiểm những lỗi nào?
            // ví dụ lỗi tên
            map.put("name", "Tên không đúng định dạng");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST); // 400
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.add(student);
        return new ResponseEntity<>(HttpStatus.CREATED); // 201
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
        // gọi service để xoá
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody StudentDto studentDto
                                    ) throws DuplicateAdminException {
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
        BeanUtils.copyProperties(studentDto,student);
        studentService.add(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204
    }
    @ExceptionHandler(DuplicateAdminException.class)
    public ResponseEntity<?> handleException(){
        return new ResponseEntity<>(Map.of(
                "name", "Tên trung admin"
        ),HttpStatus.BAD_REQUEST); // 400
    }
}
