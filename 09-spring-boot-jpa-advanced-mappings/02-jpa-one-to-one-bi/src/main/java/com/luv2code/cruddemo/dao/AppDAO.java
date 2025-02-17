package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theID);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theID);

    void deleteInstructorDetailById(int theId);
}
