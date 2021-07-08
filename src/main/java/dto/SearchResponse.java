package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResponse {

    private AdditionalParams additional_params;
    private Result result;
}
