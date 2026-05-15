package se.iths.stefan.demogooglelogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.iths.stefan.demogooglelogin.service.GenerateTextFromTextInput;

@Controller
@RequestMapping("/")
public class GeminiController {
    private final GenerateTextFromTextInput prompt;

    public GeminiController(GenerateTextFromTextInput prompt) {
        this.prompt = prompt;
    }

    @GetMapping("/ask")
    public String askForm(Model model) {
        model.addAttribute("question", "");
        model.addAttribute("answer", null);
        return "ask";
    }

    @PostMapping("/ask")
    public String ask(@RequestParam(name = "input") String input, Model model) {
        model.addAttribute("question", input);
        if (input == null || input.isBlank()) {
            model.addAttribute("answer", null);
            return "ask";
        }
        model.addAttribute("answer", prompt.runPrompt(input));
        return "ask";
    }
}
