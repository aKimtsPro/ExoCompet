package be.tftic.java.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
public class Athlete extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "athlete_id")
    private Long id;

    @Column(name = "athlete_firstname", nullable = false)
    private String firstname;
    @Column(name = "athlete_lastname", nullable = false)
    private String lastname;

    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "athlete_street", nullable = false)),
            @AttributeOverride(name = "number", column = @Column(name = "athlete_number", nullable = false)),
            @AttributeOverride(name = "city", column = @Column(name = "athlete_city", nullable = false)),
            @AttributeOverride(name = "zipcode", column = @Column(name = "athlete_zipcode", nullable = false)),
            @AttributeOverride(name = "country", column = @Column(name = "athlete_country", nullable = false)),
    })
    private Address address;

}
