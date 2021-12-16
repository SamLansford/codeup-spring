package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String showDicePage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String diceOutPut(@PathVariable int n, Model model) {
        int random = (int) (Math.random() * (7 - 1) + 1);
        model.addAttribute("randomDiceRoll", "Dice roll is " + random);
        model.addAttribute("userGuess", "Your guess is " + n);
        boolean rightGuess = random == n;
        boolean wrongGuess = !rightGuess;
        model.addAttribute("rightGuess", rightGuess);
        model.addAttribute("wrongGuess", wrongGuess);
        return "/roll-dice";
    }
}
