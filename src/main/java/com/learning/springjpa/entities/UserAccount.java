package com.learning.springjpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "USER_ACCOUNT_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    @SequenceGenerator(name = "seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
    @Id
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL_ID")
    private String emailID;
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;
    @Column(name = "COUNTRY")
    private String country;



}
