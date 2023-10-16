package mx.com.mms.marvel.service.app.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LOGS")
public class Log extends Auditory {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "log_id", updatable = false, nullable = false, columnDefinition = "VARCHAR(100)")
    private String logId;

    @Column(name = "start_MarvelApi_request", nullable = false, updatable = false)
    private LocalDateTime startMarvelApiRequest;

    @Column(name = "end_MarvelApi_request", nullable = false, updatable = false)
    private LocalDateTime endMarvelApiRequest;

    @Column(name = "start_Internal_request", nullable = false, updatable = false)
    private LocalDateTime startInternalRequest;

    @Column(name = "end_Internal_request", nullable = false, updatable = false)
    private LocalDateTime endInternalRequest;
}
