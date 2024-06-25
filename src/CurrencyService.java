import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyService {
    double conversion_result;
    static String Key = "568c04ddfeed46240bf3fddc";
    static String URL = "https://v6.exchangerate-api.com/v6/" + Key + "/pair/";

    public CurrencyService(Response response) {
        this.conversion_result = response.conversion_result();
    }

    public static void getValue(String base, String conversion, double value) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + base + "/" + conversion + "/" + value))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        Response jsonResponse = gson.fromJson(json, Response.class);

        CurrencyService currencyService = new CurrencyService(jsonResponse);
        System.out.printf("%.2f %s convertido em %s é: %.2f%n", value, base, conversion, currencyService.conversion_result);

        FileWriter converted = new FileWriter("conversion.json");
        converted.write(gson.toJson(currencyService));
        converted.close();
    }
}
