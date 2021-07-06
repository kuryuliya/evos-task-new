package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    private SearchResult search_result;
    private SearchResultCommon search_result_common;
    private boolean isCommonSearch;
    private Object active_model;
    private Object active_state;
    private Object active_city;
    private Object revies;
    private Additional additional;
}
