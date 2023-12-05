package org.example.app.entity;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    private Long id;
    private String first_name;
    private String last_name;
    private String gender;
    private String phone;
    private String position;
    private Double salary;
    private String city;

}
