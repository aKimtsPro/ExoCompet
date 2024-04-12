package be.tftic.java.repository;

import be.tftic.java.AbstractRepository;
import be.tftic.java.entity.athlete.AthleteIndiv;
import be.tftic.java.utils.EMFHolder;
import jakarta.persistence.EntityManagerFactory;

public class AthleteIndivRepository extends AbstractRepository<AthleteIndiv, Long> {
    public AthleteIndivRepository() {
        super(EMFHolder.getInstance().getEntityManager(), AthleteIndiv.class);
    }
}
