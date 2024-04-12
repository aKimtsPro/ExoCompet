package be.tftic.java.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "compet_id")
    private Long id;

    @Column(name = "compet_edition")
    private int edition;

    @Column(name = "compet_min_inscription", nullable = false)
    private int minInscription;
    @Column(name = "compet_max_inscription", nullable = false)
    private int maxInscription;

    @Column(name = "competition_date", nullable = false)
    private LocalDateTime date;

    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "compet_street", nullable = false)),
            @AttributeOverride(name = "number", column = @Column(name = "compet_number", nullable = false)),
            @AttributeOverride(name = "city", column = @Column(name = "compet_city", nullable = false)),
            @AttributeOverride(name = "zipcode", column = @Column(name = "compet_zipcode", nullable = false)),
            @AttributeOverride(name = "country", column = @Column(name = "compet_country", nullable = false)),
    })
    private Address address;
}
