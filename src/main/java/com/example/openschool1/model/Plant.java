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

@Table(name = TableConstant.PLANT_NAME)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnConstant.ID)
    private Long id;

    @Column(name = ColumnConstant.NAME)
    private String name;

    @Column(name = ColumnConstant.TYPE)
    private String type;
}
