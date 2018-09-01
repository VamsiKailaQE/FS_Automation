import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ProductServices{

	@Test
	public getProducts(){

	try{

		conn.setRequestMethod("GET");
		

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);

		conn.disconnect();
		}
	}

	catch (Exception e)
	e.printStackTrace();
		
	}



@BeforeMethod
public getConnection(){


	try {

		URL url = new URL("https://qa-api.fastspring.com/products");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String username="ZRPDETN3R-YJERGUWOG95G", password="0QzCOcCGS4mgUWveTjmmTQ";
		String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));  //Java 8
		conn.setRequestProperty("Authorization", "Basic "+encoded);
		conn.setRequestProperty("Accept", "application/json");

	  } 

	  catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
}




}