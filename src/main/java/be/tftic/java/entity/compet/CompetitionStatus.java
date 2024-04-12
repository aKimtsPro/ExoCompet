package be.tftic.java.entity.compet;

import lombok.Getter;

@Getter
public enum CompetitionStatus {
    WAITING(false),
    CONCLUDED(true),
    CANCELLED(true);

    private final boolean happened;

    CompetitionStatus(boolean happened) {
        this.happened = happened;
    }
}
