package dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Additional {

    private List<Object> user_auto_positions;
    private SearchParams search_params;
    private String query_string;
}
