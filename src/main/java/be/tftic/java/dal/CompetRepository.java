package be.tftic.java.dal;

import be.tftic.java.AbstractRepository;
import be.tftic.java.entity.compet.Competition;
import be.tftic.java.entity.compet.CompetitionStatus;
import be.tftic.java.utils.EMFHolder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class CompetRepository extends AbstractRepository<Competition, Long> {

    public CompetRepository() {
        super(EMFHolder.getInstance().getEntityManager(), Competition.class);
    }

    public List<Competition> getWaiting(){
        String query = "SELECT c FROM Competition c WHERE c.status = :status";

        return getEm().createQuery(query, Competition.class)
                .setParameter("status", CompetitionStatus.WAITING)
                .getResultList();
    }

    public List<Competition> findAll(Integer minPart, Integer maxPart){
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Competition> query = cb.createQuery(Competition.class);

        Root<Competition> root = query.from(Competition.class);

        List<Predicate> predicates = new ArrayList<>();
        if( maxPart != null )
            predicates.add( cb.le( root.get("maxInscription"), maxPart ) );

        if( minPart != null )
            predicates.add( cb.ge( root.get("minInscription"), minPart ) );

        query = query.select(root).where( cb.and( predicates.toArray(new Predicate[0]) ));

        return getEm().createQuery(query)
                .getResultList();
    }

    public List<Competition> getInSameCity(Long sportifId){
        String query = """
                SELECT ci
                FROM CompetitionIndiv ci
                    JOIN ParticipationIndiv pi ON pi.competition = ci
                    JOIN AthleteIndiv ai ON pi.participant = ai
                WHERE ci.address.city = ai.address.city AND ai.id = :sId
                """;

        return getEm().createQuery(query, Competition.class)
                .setParameter("sId", sportifId)
                .getResultList();
    }

}
