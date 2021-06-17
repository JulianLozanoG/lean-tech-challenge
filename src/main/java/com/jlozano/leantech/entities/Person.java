package com.jlozano.leantech.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID", updatable = false, nullable = false)
    @JsonProperty("id")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "LASTNAME", nullable = false)
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "ADDRESS", nullable = false)
    @JsonProperty("address")
    private String address;

    @Column(name = "CELLPHONE", nullable = false)
    @JsonProperty("cellphone")
    private String cellphone;

    @Column(name = "CITY_NAME", nullable = false)
    @JsonProperty("cityName")
    private String cityName;

    @OneToOne(mappedBy = "person")
    @JsonBackReference
    private Employee employee;

}
