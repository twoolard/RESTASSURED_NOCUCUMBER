package model.userService;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Generated("com.robohorse.robopojogenerator")
public class Page {

    @JsonProperty("per_page")
    private int perPage;

    @JsonProperty("total")
    private int total;

    @JsonProperty("data")
    private List<User> data;

    @JsonProperty("page")
    private int page;

    @JsonProperty("total_pages")
    private int totalPages;
}