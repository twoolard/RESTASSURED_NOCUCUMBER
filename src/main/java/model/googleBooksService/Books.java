package model.googleBooksService;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Generated("com.robohorse.robopojogenerator")
public class Books{

	@JsonProperty("totalItems")
	private int totalItems;

	@JsonProperty("kind")
	private String kind;

	@JsonProperty("items")
	private List<ItemsItem> items;
}