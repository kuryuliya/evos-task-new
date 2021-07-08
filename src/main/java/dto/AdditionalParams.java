package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditionalParams {

    private int lang_id;
    private int page;
    private int view_type_id;
    private String target;
    private String section;
    private String catalog_name;
    private boolean elastica;
    private boolean nodejs;
}
