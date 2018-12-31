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
public class VolumeInfo{

	@JsonProperty("industryIdentifiers")
	private List<IndustryIdentifiersItem> industryIdentifiers;

	@JsonProperty("pageCount")
	private int pageCount;

	@JsonProperty("printType")
	private String printType;

	@JsonProperty("readingModes")
	private ReadingModes readingModes;

	@JsonProperty("previewLink")
	private String previewLink;

	@JsonProperty("canonicalVolumeLink")
	private String canonicalVolumeLink;

	@JsonProperty("description")
	private String description;

	@JsonProperty("language")
	private String language;

	@JsonProperty("title")
	private String title;

	@JsonProperty("imageLinks")
	private ImageLinks imageLinks;

	@JsonProperty("averageRating")
	private double averageRating;

	@JsonProperty("publisher")
	private String publisher;

	@JsonProperty("ratingsCount")
	private int ratingsCount;

	@JsonProperty("publishedDate")
	private String publishedDate;

	@JsonProperty("categories")
	private List<String> categories;

	@JsonProperty("maturityRating")
	private String maturityRating;

	@JsonProperty("allowAnonLogging")
	private boolean allowAnonLogging;

	@JsonProperty("contentVersion")
	private String contentVersion;

	@JsonProperty("authors")
	private List<String> authors;

	@JsonProperty("infoLink")
	private String infoLink;
}