package be.tftic.java.entity.athlete;

import be.tftic.java.entity.compet.CompetitionIndiv;
import be.tftic.java.entity.participation.ParticipationIndiv;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class AthleteIndiv extends Athlete{

    @OneToMany(mappedBy = "participant")
    private Set<ParticipationIndiv> participations;

}
