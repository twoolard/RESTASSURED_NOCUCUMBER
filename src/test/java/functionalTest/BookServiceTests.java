package functionalTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import model.googleBooksService.Books;
import response.AssertableResponse;
import services.GoogleBooks;
import utils.properties.TestConstant;
import utils.properties.TestProperties;


public class BookServiceTests {

	private GoogleBooks books = new GoogleBooks();

	@BeforeClass
	static void setUp() {
		RestAssured.baseURI = TestProperties.getProperty(TestConstant.GOOGLE_URL);
	}

	@Test
	public void testGetByISBN(){
		String isbn = "isbn:9781451648546";

		AssertableResponse response = books.getBookByIsbn(isbn);
		response.assertStatus(HttpStatus.SC_OK);

		Books books = response.getResponseBody(Books.class);

		assertThat(books.getTotalItems(), equalTo(1));
		assertThat(books.getKind(), equalTo("books#volumes"));
		assertThat(books.getItems().size(), equalTo(1));
		assertThat(books.getItems().get(0).getVolumeInfo().getTitle(), equalTo("Steve Jobs"));
		List<String> authors = books.getItems().get(0).getVolumeInfo().getAuthors();
		Assert.assertTrue(authors.contains("Walter Isaacson"));
		assertThat(books.getItems().get(0).getVolumeInfo().getPublisher(), equalTo("Simon and Schuster"));
		assertThat(books.getItems().get(0).getVolumeInfo().getPageCount(), equalTo(630));
	}

}
