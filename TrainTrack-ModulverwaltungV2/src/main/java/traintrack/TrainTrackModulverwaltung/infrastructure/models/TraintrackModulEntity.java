package traintrack.TrainTrackModulverwaltung.infrastructure.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModulStatus;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class TraintrackModulEntity {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TraintrackModulEntity_seq"
    )
    @SequenceGenerator(
            name = "TraintrackModulEntity_seq",
            sequenceName = "TraintrackModulEntity_seq"
    )
    private int id;

    @Column(name = "TRAINTRACKMODULENTITY_NAME")
    private String titel;

    @Column(name = "TRAINTRACKMODULENEITY_STATUS")
    @Enumerated(EnumType.ORDINAL)
    private TraintrackModulStatus status;

    @Column(name = "TRAINTRACKMODULENEITY_ZUSAMMENFASSUNG")
    private String zusammenfassung;

    @Column(name = "TRAINTRACKMODULENEITY_TEILNEHMERZAHL")
    private int teilnehmerzahl;

    @Column(name = "TRAINTRACKMODULENEITY_DAUER")
    private float dauer;

    @Column(name = "TRAINTRACKMODULENEITY_ART")
    private String art;

    @Column(name = "TRAINTRACKMODULENEITY_MIT_PRUEFUNG")
    private boolean mitPruefung;
}
