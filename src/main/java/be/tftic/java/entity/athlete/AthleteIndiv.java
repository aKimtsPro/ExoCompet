package be.tftic.java.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class AthleteIndiv extends Athlete{

    @ManyToMany(mappedBy = "participants")
    private Set<CompetitionIndiv> competitions;

}
