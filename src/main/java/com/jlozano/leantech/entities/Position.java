package com.jlozano.leantech.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@NamedQuery(name = "Position.findAllOrderByEmployeeDesc", query = "SELECT p FROM Position p INNER JOIN Employee e ON (p.id = e.position.id) ORDER BY e.salary DESC")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POSITION_ID", updatable = false, nullable = false)
    @JsonProperty("id")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    @JsonProperty("name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonProperty("employees")
    private List<Employee> employees;
}
