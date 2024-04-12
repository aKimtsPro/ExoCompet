package be.tftic.java.repository;

import be.tftic.java.AbstractRepository;
import be.tftic.java.entity.compet.Competition;
import be.tftic.java.utils.EMFHolder;

public class CompetRepository extends AbstractRepository<Competition, Long> {

    public CompetRepository() {
        super(EMFHolder.getInstance().getEntityManager(), Competition.class);
    }
}
