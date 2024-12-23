package com.rps.spring_boot_rock_paper_scissors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class ScoreController {

    static Score score = new Score(30, 20, 10);

    @GetMapping("/health-check")
    public String getHealthCheck() {
        return "Situation Normal All Fired Up!";
    }

    @GetMapping("/score/{attribute}")
    public Object getScore(@PathVariable String attribute) {
        if (attribute.equalsIgnoreCase("wins")) {
            return score.wins;
        } else if (attribute.equalsIgnoreCase("ties")) {
            return score.ties;
        } else if (attribute.equalsIgnoreCase("losses")) {
            return score.losses;
        } else {
            return score;
        }
    }

    @PostMapping("/score/increase/{attribute}")
    public Score increaseWins(@PathVariable String attribute) {
        if (attribute.equalsIgnoreCase("wins"))
            score.wins++;
        else if (attribute.equalsIgnoreCase("ties"))
            score.ties++;
        else if (attribute.equalsIgnoreCase("losses"))
            score.losses++;
        return score;
    }

    @PatchMapping("/score/{attribute}/{value}")
    public Score updateScore(@PathVariable String attribute, @PathVariable int value) {
        if (attribute.equalsIgnoreCase("wins"))
            score.wins = value;
        else if (attribute.equalsIgnoreCase("ties"))
            score.ties = value;
        else if (attribute.equalsIgnoreCase("losses"))
            score.losses = value;
        return score;
    }

    @PutMapping("/score/replace")
    public Score replaceScore(@RequestBody Score newScore) {
        score = newScore;

        return score;
    }

    @DeleteMapping("/score/reset")
    public void resetScore() {

        score = null;
    }
}
