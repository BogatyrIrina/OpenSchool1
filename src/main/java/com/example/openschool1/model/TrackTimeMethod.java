package com.example.openschool1.model;

import com.example.openschool1.constant.ColumnConstant;
import com.example.openschool1.constant.TableConstant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = TableConstant.TRACK_TIME_METHOD_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class TrackTimeMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnConstant.ID)
    private Long id;

    @Column(name = ColumnConstant.CLASS_NAME)
    private String className;

    @Column(name = ColumnConstant.METHOD_NAME)
    private String methodName;

    @Column(name = ColumnConstant.EXECUTION_TIME)
    private Long executionTime;

    @Column(name = ColumnConstant.CALL_TIME)
    private LocalDateTime callTime;
}
