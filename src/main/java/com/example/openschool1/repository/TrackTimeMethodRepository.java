package com.example.openschool1.repository;

import com.example.openschool1.model.TrackTimeMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrackTimeMethodRepository extends JpaRepository<TrackTimeMethod, Long> {
    List<TrackTimeMethod> findByMethodName(String methodName);
    List<TrackTimeMethod> findByClassName(String className);
    List<TrackTimeMethod> findByClassNameAndMethodName(String className, String methodName);
}
