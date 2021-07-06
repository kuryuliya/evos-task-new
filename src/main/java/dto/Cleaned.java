package dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cleaned {

    private List<String> bodystyle;
    private String category_id;
    private List<String> marka_id;
    private List<String> gearbox;
    private String raceFrom;
    private List<String> model_id;
    private List<Object> s_yers;
    private List<Object> po_yers;
    private List<Object> brandOrigin;
    private List<Object> excludeMM;
    private List<Object> state;
    private List<Object> city;
    private List<Object> auto_options;
    private String target;
    private String event;
    private int lang_id;
    private int countpage;
    private List<Object> m_state;
    private List<Object> m_city;
    private List<Object> marka;
    private List<Object> model;
    private List<Object> mm_marka;
    private List<Object> mm_model;
    private List<Object> mm_marka_filtr;
    private List<Object> mm_model_filtr;
    private List<Object> exchange_filter;
    private List<String> gear_id;
    private List<Object> mm_country;
    private List<Object> mm_country_exeption;
    private int currency;
    private List<Object> currencies_arr;
    private List<Object> hide_black_list;
    private int custom;
    private int abroad;
    private List<Object> body_id;
    private List<Object> bodyStyleId;
    private int matched_country;
    private Verified verified;
}
