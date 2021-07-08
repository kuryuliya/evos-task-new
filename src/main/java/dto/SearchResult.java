package dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResult{
    private List<String> ids;
    private int count;
    private int last_id;
}
