package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResponse {
    private AdditionalParams additional_params;
    private Result result;

    @Getter
    @Setter
    public class AdditionalParams{
        private int lang_id;
        private int page;
        private int view_type_id;
        private String target;
        private String section;
        private String catalog_name;
        private boolean elastica;
        private boolean nodejs;
    }

    @Getter
    @Setter
    public class SearchResult{
        private List<String> ids;
        private int count;
        private int last_id;
    }

    @Getter
    @Setter
    public class Datum{
        private String id;
        private String type;
    }

    @Getter
    @Setter
    public class SearchResultCommon{
        private List<Datum> data;
        private int count;
        private int last_id;
    }

    @Getter
    @Setter
    public class Verified{
        @JsonProperty("VIN")
        private int vin;
    }

    @Getter
    @Setter
    public class All{
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
        private int page;
        private Object limit_page;
        private int countpage;
        private int last_id;
        private int last_search_id;
        private int saledParam;
        private int state_id;
        private int city_id;
        private int state_from;
        private int city_from;
        private List<Object> m_state;
        private List<Object> m_city;
        private List<Object> marka;
        private List<Object> model;
        private List<Object> mm_marka;
        private List<Object> mm_model;
        private List<Object> mm_marka_filtr;
        private List<Object> mm_model_filtr;
        private boolean useOrigAutoTable;
        private boolean withoutStatus;
        private boolean with_photo;
        private boolean with_video;
        private int under_credit;
        private int confiscated_car;
        private int with_exchange;
        private List<Object> exchange_filter;
        private int with_real_exchange;
        private boolean old_only;
        private int user_id;
        private int person_id;
        private boolean with_discount;
        private String auto_id_str;
        private int black_user_id;
        private int order_by;
        private boolean is_online;
        private boolean last_send_id;
        private boolean withoutCache;
        private boolean with_last_id;
        private int color;
        private int color_id;
        private List<String> gear_id;
        private int top;
        private int drive_type;
        private int country;
        private List<Object> mm_country;
        private List<Object> mm_country_exeption;
        private int currency;
        private int currency_id;
        private List<Object> currencies_arr;
        private int auto_repairs;
        private int power_name;
        private int powerFrom;
        private int powerTo;
        private List<Object> hide_black_list;
        private int fuelRateFrom;
        private int fuelRateTo;
        private int custom;
        private int abroad;
        private int damage;
        private List<Object> body_id;
        private List<Object> bodyStyleId;
        private int type;
        private int metallic;
        private int engineVolumeFrom;
        private int engineVolumeTo;
        private int raceTo;
        private int sid;
        private int star_auto;
        private String start_date;
        private int drive_id;
        private int door;
        private int price_ot;
        private int price_do;
        private int year;
        private int auto_ids_search_position;
        private int print_qs;
        private int last_auto_id;
        private int is_hot;
        private int deletedAutoSearch;
        private int can_be_checked;
        private int seatsFrom;
        private int seatsTo;
        private int wheelFormulaId;
        private int axleId;
        private int carryingTo;
        private int carryingFrom;
        private int company_id;
        private int company_type;
        private int matched_country;
        private String q;
        private Object sellerType;
        private Object purpose;
        @JsonProperty("class")
        private Object _class;
        private Verified verified;
        private int auctionPossible;
    }

    @Getter
    @Setter
    public class Cleaned{
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

    @Getter
    @Setter
    public class SearchParams{
        private All all;
        private Cleaned cleaned;
    }

    @Getter
    @Setter
    public class Additional{
        private List<Object> user_auto_positions;
        private SearchParams search_params;
        private String query_string;
    }

    @Getter
    @Setter
    public class Result{
        private SearchResult search_result;
        private SearchResultCommon search_result_common;
        private boolean isCommonSearch;
        private Object active_model;
        private Object active_state;
        private Object active_city;
        private Object revies;
        private Additional additional;
    }

}
