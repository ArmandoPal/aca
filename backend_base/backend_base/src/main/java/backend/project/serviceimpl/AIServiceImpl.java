package backend.project.serviceimpl;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl {
    private static final String API_URL = "https://models.inference.ai.azure.com/v1/completions";
    private static final String TOKEN = "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";

    public String sendMessageToAI(String userMessage) {
        try {
            URL url = new URL(API_URL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");

            connection.setRequestProperty("Authorization", "Bearer " + TOKEN);
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setDoOutput(true);

            String jsonInputString = "{"
                    + "\"messages\": ["
                    + "{ \"role\": \"system\", \"content\": \"\" },"
                    + "{ \"role\": \"user\", \"content\": \"" + userMessage + "\" }"
                    + "],"
                    + "\"model\": \"gpt-4o\","
                    + "\"temperature\": 1,"
                    + "\"max_tokens\": 4096,"
                    + "\"top_p\": 1"
                    + "}";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
