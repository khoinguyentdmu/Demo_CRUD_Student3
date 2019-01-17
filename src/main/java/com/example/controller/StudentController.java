package com.example.controller;

import java.util.List;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/Student" )
public class StudentController {

    private IStudentService studentService;
    
    public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	/**
     * Get all students
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Student> getAllStudents() {

    	/*ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	IStudentService service = (IStudentService) context.getBean("studentService");
        return service.getAllStudents();*/
    	
    	return studentService.getAllStudents();
    }

    /**
     * Get student by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int id) {

        return studentService.getStudentById(id);
    }

    /**
     * Create a student
     * @param student
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void createStudent(@RequestBody Student student) {

        studentService.createStudent(student);
    }

    /**
     * Update a student
     * @param student
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateStudent(@RequestBody Student student, @PathVariable int id) {

        studentService.updateStudent(student, id);
    }

    /**
     * Delete a student
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int id) {

    	studentService.deleteStudent(id);
    }
}