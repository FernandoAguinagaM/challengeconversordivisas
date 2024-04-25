import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorDivisas {


    private final Gson gson;

    public ConversorDivisas() {

        this.gson = new Gson();
    }

    public double convertirDivisa(String de, String a, double cantidad) {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/b61fd77a1da061bfe220cb86/latest/" + de);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                JsonObject jsonResponse = gson.fromJson(reader, JsonObject.class);

                // Conversión
                double tipoCambio = jsonResponse.getAsJsonObject("conversion_rates").get(a).getAsDouble();
                return cantidad * tipoCambio;
            } else {
                System.out.println("Error al obtener la tasa de cambio. Código de respuesta: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
}