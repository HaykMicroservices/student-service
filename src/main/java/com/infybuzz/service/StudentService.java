package com.infybuzz.service;

import com.infybuzz.entity.Student;
import com.infybuzz.feignclients.AddressFeignClient;
import com.infybuzz.repository.StudentRepository;
import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.response.AddressResponse;
import com.infybuzz.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressFeignClient addressFeignClient;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());

        student.setAddressId(createStudentRequest.getAddressId());
        student = studentRepository.save(student);
        AddressResponse addressResponse = getAddressResponseById(createStudentRequest.getAddressId());
        return new StudentResponse(student, addressResponse);
    }

    public StudentResponse getById(long id) {
        Student student = studentRepository.findById(id).get();
        AddressResponse addressResponse = getAddressResponseById(student.getAddressId());
        return new StudentResponse(student, addressResponse);
    }

    public AddressResponse getAddressResponseById(long addressId) {
        AddressResponse addressResponse = addressFeignClient.getById(addressId);
        return addressResponse;
    }
}
