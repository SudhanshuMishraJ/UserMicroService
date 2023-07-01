package com.user.service.UserService.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private String userId;

    @Column(name = "NAME", length = 25, nullable = false)
    private String name;

    @Column(name = "EMAIL")
    private String emailId;

    @Column(name = "ABOUT")
    private String about;

    /*We do not want to store rating details in database here so can use below annotation.
    transient will ignore this simply.
    */
    @Transient
    private List<Rating> ratings = new ArrayList<>();


}
