package edu.iuh.fit.bai01;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dob;
    private String gender;
}
