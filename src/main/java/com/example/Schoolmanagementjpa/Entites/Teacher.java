package com.example.Schoolmanagementjpa.Entites;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Teacher {
    @Id
    @NotEmpty(message = "id cannot be empty")
    private Integer id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotEmpty(message = "salary cannot be empty")
    private Integer salary;
}
