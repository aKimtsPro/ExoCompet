package be.tftic.java.entity.participation;

import be.tftic.java.entity.BaseEntity;
import be.tftic.java.entity.Team;
import be.tftic.java.entity.compet.Competition;
import be.tftic.java.entity.compet.CompetitionTeam;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class ParticipationTeam extends BaseEntity<ParticipationId> {
    @Id
    private ParticipationId id = new ParticipationId();

    @MapsId("competId")
    @ManyToOne
    private CompetitionTeam competition;

    @MapsId("participantId")
    @ManyToOne
    private Team participant;

    @Column(name = "particip_t_inscription_date", nullable = false, updatable = false)
    private LocalDateTime dateInscription;
    @Column(name = "particip_t_position", insertable = false)
    private Integer position;
}
