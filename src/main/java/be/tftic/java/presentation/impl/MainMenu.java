package be.tftic.java.presentation.impl;

import be.tftic.java.entity.Team;
import be.tftic.java.entity.athlete.AthleteIndiv;
import be.tftic.java.entity.compet.Competition;
import be.tftic.java.entity.compet.CompetitionIndiv;
import be.tftic.java.entity.compet.CompetitionStatus;
import be.tftic.java.entity.compet.CompetitionTeam;
import be.tftic.java.entity.participation.ParticipationId;
import be.tftic.java.entity.participation.ParticipationIndiv;
import be.tftic.java.entity.participation.ParticipationTeam;
import be.tftic.java.presentation.AbstractMenu;
import be.tftic.java.presentation.Option;
import be.tftic.java.dal.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class MainMenu extends AbstractMenu {

    private final CompetRepository competRepo = new CompetRepository();
    private final TeamRepository teamRepo = new TeamRepository();
    private final AthleteIndivRepository athleteIndivRepo = new AthleteIndivRepository();
    private final ParticipationTeamRepository participationTeamRepo = new ParticipationTeamRepository();
    private final ParticipationIndivRepository participationIndivRepo = new ParticipationIndivRepository();

    public MainMenu() {
        super("Competition Handler");
    }

    @Override
    protected Map<String, Option> initOptions() {
        Map<String, Option> options = super.initOptions();
        options.put("1", new Option("new inscription", this::handleInscription));
        options.put("2", new Option("cancel inscription", this::handleCancelInscription));
        options.put("3", new Option("conclude competition", this::handleConclude));
        options.put("4", new Option("cancel competition", this::handleCancelCompetition));
        options.put("5", new Option("display competition", this::handleDisplay));
        return options;
    }

    private void handleInscription(){
        Long competId = askForValue(Long.class, "> compet id: ");
        Competition competition = this.competRepo.findById(competId)
                .orElseThrow();// TODO specify

        LocalDateTime inscriptionDate = LocalDateTime.now();
        if( inscriptionDate.isAfter(competition.getInscriptionLimit()) )
            throw new RuntimeException(); // TODO specify

        if( competition.getStatus().isHappened() )
            throw new RuntimeException(); // TODO specify

        if( competition.getMaxInscription() <= competition.getParticipants().size() )
            throw new RuntimeException(); // TODO specify

        if( competition instanceof CompetitionIndiv cIndiv){
            Long athleteId = askForValue(Long.class, "> athlete id: ");
            AthleteIndiv athlete = athleteIndivRepo.findById(athleteId)
                    .orElseThrow();// TODO specify


            ParticipationIndiv participation = new ParticipationIndiv();
            participation.setParticipant(athlete);
            participation.setCompetition(cIndiv);
            participation.setDateInscription(inscriptionDate);
            participationIndivRepo.insert(participation);
        }
        else if( competition instanceof CompetitionTeam cTeam){
            Long teamId = askForValue(Long.class, "> team id:");
            Team team = teamRepo.findById(teamId)
                    .orElseThrow(); // TODO specify

            ParticipationTeam participation = new ParticipationTeam();
            participation.setParticipant(team);
            participation.setCompetition(cTeam);
            participation.setDateInscription(inscriptionDate);
            participationTeamRepo.insert(participation);
        }
        else {
            throw new RuntimeException("Invalid compet id"); // TODO specify
        }
    }

    private void handleCancelInscription() {
        Long competId = askForValue(Long.class, "> compet id: ");
        Competition competition = this.competRepo.findById(competId)
                .orElseThrow();// TODO specify

        LocalDateTime inscriptionDate = LocalDateTime.now();
        if( inscriptionDate.isAfter(competition.getInscriptionLimit()) )
            throw new RuntimeException(); // TODO specify

        if( competition.getStatus().isHappened() )
            throw new RuntimeException(); // TODO specify

        if( competition instanceof CompetitionIndiv cIndiv ){
            Long athleteId = askForValue(Long.class, "> athlete id: ");
            ParticipationId id = new ParticipationId(competId, athleteId);
            participationIndivRepo.delete(id);
        }
        else if( competition instanceof CompetitionTeam cTeam ){
            Long teamId = askForValue(Long.class, "> team id:");
            ParticipationId id = new ParticipationId(competId, teamId);
            participationTeamRepo.delete(id);
        }
        else {
            throw new RuntimeException("Invalid compet id"); // TODO specify
        }
    }

    private void handleConclude(){
        Long competId = askForValue(Long.class, "> compet id: ");
        Competition competition = this.competRepo.findById(competId)
                .orElseThrow();// TODO specify

        if(competition.getDate().isAfter(LocalDateTime.now()))
            throw new RuntimeException(); // TODO specify

        if( competition.getStatus().isHappened() )
            throw new RuntimeException(); // TODO specify

        if( competition.getParticipants().size() < competition.getMinInscription() )
            throw new RuntimeException(); // TODO specify

        if( competition instanceof CompetitionIndiv cIndiv ){
            cIndiv.getParticipants().forEach(p -> {
                int position = askForValue(Integer.class, STR."> position of \"\{p.getParticipant().getFirstname()}\" \"\{p.getParticipant().getLastname()}\": ");
                p.setPosition(position);
            });
        } else if (competition instanceof CompetitionTeam cTeam) {
            cTeam.getParticipants().forEach(p -> {
                int position = askForValue(Integer.class, STR."> position of \"\{p.getParticipant().getName()}\": ");
                p.setPosition(position);
            });
        }

        competition.setStatus(CompetitionStatus.CONCLUDED);
        competRepo.update(competition);
    }

    private void handleCancelCompetition(){
        long competId = askForValue(Long.class, "> compet id: ");
        Competition competition = competRepo.findById(competId)
                .orElseThrow(); // TODO specify

        if( competition.getStatus().isHappened() )
            throw new RuntimeException(); // TODO specify

        competition.setStatus(CompetitionStatus.CANCELLED);
        competRepo.update(competition);
    }

    private void handleDisplay(){
        List<Competition> competitions = competRepo.findAll();

        for (Competition competition : competitions) {
            System.out.println(
                    "name: " + competition.getTitle() +
                    ", status: "+ competition.getStatus()+
                    ", participants: " + competition.getParticipants().size()
            );
        }
    }

    @Override
    protected boolean handleError(Exception e) {
        if( e instanceof IllegalStateException ){
            System.out.println("state invalid");
            return true;
        }
        return false;
    }
}
