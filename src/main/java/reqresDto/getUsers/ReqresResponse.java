package reqresDto.getUsers;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqresResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Datum> data;
    private Support support;
}
