package be.tftic.java.entity.compet;

import be.tftic.java.entity.athlete.AthleteIndiv;
import be.tftic.java.entity.participation.ParticipationIndiv;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class CompetitionIndiv extends Competition {

    @OneToMany(mappedBy = "competition", fetch = FetchType.EAGER)
    private Set<ParticipationIndiv> participants;

}
