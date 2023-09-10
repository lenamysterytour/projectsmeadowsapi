package online.automationintesting.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadMessageResponse {

        private String error, errorMessage, errorCode;
        private List<String> fieldErrors;

}
