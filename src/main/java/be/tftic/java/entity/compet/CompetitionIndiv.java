package be.tftic.java.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class CompetitionIndiv extends Competition {

    @ManyToMany
    private Set<AthleteIndiv> participants;

}
