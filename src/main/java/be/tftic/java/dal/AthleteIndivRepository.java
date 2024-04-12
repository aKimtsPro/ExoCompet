package be.tftic.java.dal;

import be.tftic.java.AbstractRepository;
import be.tftic.java.entity.athlete.AthleteIndiv;
import be.tftic.java.utils.EMFHolder;

public class AthleteIndivRepository extends AbstractRepository<AthleteIndiv, Long> {
    public AthleteIndivRepository() {
        super(EMFHolder.getInstance().getEntityManager(), AthleteIndiv.class);
    }
}
