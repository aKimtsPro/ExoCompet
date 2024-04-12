package be.tftic.java.entity.compet;

import be.tftic.java.WithId;
import be.tftic.java.entity.Address;
import be.tftic.java.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
public abstract class Competition extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compet_id")
    private Long id;

    @Column(name = "compet_title")
    private String title;

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

    @Column(name = "competition_inscription_limit", nullable = false)
    private LocalDateTime inscriptionLimit;

    @Enumerated(EnumType.STRING)
    @Column(name = "competition_status", nullable = false)
    private CompetitionStatus status;

    public abstract <T extends BaseEntity<Long>> Set<T> getParticipants();
}
