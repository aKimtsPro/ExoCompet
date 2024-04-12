package be.tftic.java.dal;

import be.tftic.java.AbstractRepository;
import be.tftic.java.entity.Team;
import be.tftic.java.utils.EMFHolder;

public class TeamRepository extends AbstractRepository<Team, Long> {
    public TeamRepository() {
        super(EMFHolder.getInstance().getEntityManager(), Team.class);
    }
}
