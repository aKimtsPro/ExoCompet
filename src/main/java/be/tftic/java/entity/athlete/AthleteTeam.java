package be.tftic.java.entity.athlete;

import be.tftic.java.entity.Team;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class AthleteTeam extends Athlete {

    @ManyToOne
    @JoinColumn(name = "athlete_t_team")
    private Team team;

}
