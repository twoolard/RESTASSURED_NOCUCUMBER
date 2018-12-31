package model.googleBooksService;

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
public class ItemsItem{

	@JsonProperty("saleInfo")
	private SaleInfo saleInfo;

	@JsonProperty("searchInfo")
	private SearchInfo searchInfo;

	@JsonProperty("kind")
	private String kind;

	@JsonProperty("volumeInfo")
	private VolumeInfo volumeInfo;

	@JsonProperty("etag")
	private String etag;

	@JsonProperty("id")
	private String id;

	@JsonProperty("accessInfo")
	private AccessInfo accessInfo;

	@JsonProperty("selfLink")
	private String selfLink;
}