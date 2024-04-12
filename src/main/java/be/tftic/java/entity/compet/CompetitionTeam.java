package be.tftic.java.entity.compet;

import be.tftic.java.entity.Team;
import be.tftic.java.entity.participation.ParticipationTeam;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class CompetitionTeam extends Competition {

    @OneToMany(mappedBy = "competition", fetch = FetchType.EAGER)
    private Set<ParticipationTeam> participants;

}
