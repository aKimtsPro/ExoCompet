package be.tftic.java.repository;

import be.tftic.java.AbstractRepository;
import be.tftic.java.entity.participation.ParticipationId;
import be.tftic.java.entity.participation.ParticipationIndiv;
import be.tftic.java.utils.EMFHolder;

public class ParticipationIndivRepository extends AbstractRepository<ParticipationIndiv, ParticipationId> {
    public ParticipationIndivRepository() {
        super(EMFHolder.getInstance().getEntityManager(), ParticipationIndiv.class);
    }
}
