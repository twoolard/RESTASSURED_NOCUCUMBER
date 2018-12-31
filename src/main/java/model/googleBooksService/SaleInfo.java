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
public class SaleInfo{

	@JsonProperty("country")
	private String country;

	@JsonProperty("isEbook")
	private boolean isEbook;

	@JsonProperty("saleability")
	private String saleability;
}