package be.tftic.java.entity.participation;

import be.tftic.java.entity.BaseEntity;
import be.tftic.java.entity.athlete.AthleteIndiv;
import be.tftic.java.entity.compet.CompetitionIndiv;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class ParticipationIndiv extends BaseEntity<ParticipationId> {

    @EmbeddedId
    private ParticipationId id = new ParticipationId();

    @MapsId("participantId")
    @ManyToOne
    private AthleteIndiv participant;

    @MapsId("competId")
    @ManyToOne
    private CompetitionIndiv competition;


    @Column(name = "particip_i_inscription_date", nullable = false, updatable = false)
    private LocalDateTime dateInscription;
    @Column(name = "particip_i_position", insertable = false)
    private Integer position;

}
