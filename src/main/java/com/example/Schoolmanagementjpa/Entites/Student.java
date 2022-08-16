package com.example.Schoolmanagementjpa.Entites;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @NotNull(message = "id cannot be empty")
    private Integer id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull(message = "Age cannot be empty")
    private Integer Age;
    @NotEmpty(message = "major cannot be empty")
    @Column(columnDefinition = "varchar(10) check (major='CS' or major='MATH' or major='Engineer') ")
    private String major;

}
