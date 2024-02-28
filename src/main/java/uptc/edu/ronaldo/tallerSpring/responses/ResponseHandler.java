package uptc.edu.ronaldo.tallerSpring.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus httpStatus, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", httpStatus);
        map.put("data", data);

        return new ResponseEntity<>(map, httpStatus);
    }
}