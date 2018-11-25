package com.okta.developer.spring_boot_postgressql.service;

import com.okta.developer.spring_boot_postgressql.dao.TeacherDAO;
import com.okta.developer.spring_boot_postgressql.entities.Review;
import com.okta.developer.spring_boot_postgressql.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@Service
public class SimpleTeacherService implements TeacherService {

    private final TeacherDAO teacherDAO;

    @Autowired
    public SimpleTeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addReview(String teacherID, Review review) {
        Objects.requireNonNull(teacherID);
        Objects.requireNonNull(review);

        Teacher teacher = teacherDAO
                .findById(UUID.fromString(teacherID))
                .orElseThrow(() -> new EntityNotFoundException(teacherID));

        review.setDate(LocalDate.now());

        if(teacher.getReviews() == null){
            teacher.setReviews(new ArrayList<>());
        }

        teacher.getReviews().add(review);

        teacherDAO.save(teacher);

    }
}
