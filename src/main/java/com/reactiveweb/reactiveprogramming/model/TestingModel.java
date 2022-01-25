package com.reactiveweb.reactiveprogramming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("TESTING")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TestingModel {

    @Id @Column("testing_id")
    public Integer id;
    @Column("testing_name")
    public String name;
}
