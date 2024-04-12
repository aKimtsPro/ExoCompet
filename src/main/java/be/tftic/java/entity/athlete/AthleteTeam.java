package be.tftic.java.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class AthleteTeam extends Athlete {

    @ManyToOne
    @JoinColumn(name = "athlete_t_team")
    private Team team;

}
