package be.tftic.java.dal;

import be.tftic.java.AbstractRepository;
import be.tftic.java.entity.participation.ParticipationId;
import be.tftic.java.entity.participation.ParticipationTeam;
import be.tftic.java.utils.EMFHolder;

public class ParticipationTeamRepository extends AbstractRepository<ParticipationTeam, ParticipationId> {
    public ParticipationTeamRepository() {
        super(EMFHolder.getInstance().getEntityManager(), ParticipationTeam.class);
    }
}
