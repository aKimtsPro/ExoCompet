package be.tftic.java.entity;

import be.tftic.java.entity.athlete.AthleteTeam;
import be.tftic.java.entity.participation.ParticipationTeam;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Team extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(name = "team_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "team")
    private List<AthleteTeam> members;

    @OneToMany(mappedBy = "participant")
    private Set<ParticipationTeam> participations;

}
