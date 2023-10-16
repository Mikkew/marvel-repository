package mx.com.mms.marvel.service.app.models.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse<T> {

    private int status;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a", timezone = "America/Mexico_City")
    private LocalDateTime time;
    private String path;
    private T errors;

    public ResponseEntity<Object> createResponse(HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}
