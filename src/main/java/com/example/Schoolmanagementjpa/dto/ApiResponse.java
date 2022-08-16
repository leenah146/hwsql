package com.example.Schoolmanagementjpa.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private String msg;
    private  Integer stat;
}
