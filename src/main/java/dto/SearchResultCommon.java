package dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResultCommon{
    private List<Datum> data;
    private int count;
    private int last_id;
}
