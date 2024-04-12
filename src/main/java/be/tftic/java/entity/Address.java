package be.tftic.java.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
public class Address implements Serializable {

    private String street;
    private int number;
    private String city;
    private int zipcode;
    private String country;

}
