package se.iths.stefan.demogooglelogin.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

@Service
public class GenerateTextFromTextInput {
    private final QNAService service;

    public GenerateTextFromTextInput(QNAService service) {
        this.service = service;
    }

    public String runPrompt(String input) {
        Client client = new Client();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3-flash-preview",
                        input,
                        null);
        service.save(input, response.text());

        return response.text();
    }
}