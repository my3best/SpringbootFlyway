package com.flywaycrudsample;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/flywaycrud")
public class StudentController {
@Autowired
private StudentRepository studentRepository;
@RequestMapping(value="/student", method=RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
public List<Student> getStudents(){
	return studentRepository.findAll();
}
@RequestMapping(value="/student",method=RequestMethod.GET)
public Student getStudent(@PathVariable Integer id)
{
	return studentRepository.findOne(id);
}
@RequestMapping(value="/student",method=RequestMethod.POST)
public Student createStudent(@RequestBody Student student)
{
	return studentRepository.save(student);
}
@RequestMapping(value="/student/{id}",method=RequestMethod.PUT)
public Student updateStudent(@PathVariable Integer id,@RequestBody Student student)
{
	Student existingStudent=studentRepository.getOne(id);
	BeanUtils.copyProperties(student, existingStudent);
	return studentRepository.save(student);
	
}
@RequestMapping(value="/student",method=RequestMethod.DELETE)
public  void deleteStudent(@PathVariable Integer id)
{
	Student existingStudent=studentRepository.findOne(id);
	studentRepository.delete(existingStudent);
}
}
