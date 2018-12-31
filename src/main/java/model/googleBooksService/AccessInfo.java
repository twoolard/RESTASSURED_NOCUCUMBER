package model.googleBooksService;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("com.robohorse.robopojogenerator")
public class AccessInfo{

	@JsonProperty("accessViewStatus")
	private String accessViewStatus;

	@JsonProperty("country")
	private String country;

	@JsonProperty("viewability")
	private String viewability;

	@JsonProperty("pdf")
	private Pdf pdf;

	@JsonProperty("webReaderLink")
	private String webReaderLink;

	@JsonProperty("epub")
	private Epub epub;

	@JsonProperty("publicDomain")
	private boolean publicDomain;

	@JsonProperty("quoteSharingAllowed")
	private boolean quoteSharingAllowed;

	@JsonProperty("embeddable")
	private boolean embeddable;

	@JsonProperty("textToSpeechPermission")
	private String textToSpeechPermission;
}