package com.okta.developer.spring_boot_postgressql.service;

import com.okta.developer.spring_boot_postgressql.entities.Review;

import javax.validation.constraints.NotNull;


public interface TeacherService {

    /**
     *
     * @param teacherID
     * @param review
     * @throws javax.persistence.EntityNotFoundException
     */
    void addReview(@NotNull String teacherID, @NotNull Review review);
}
