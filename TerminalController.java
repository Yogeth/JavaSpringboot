package com.ide.webide.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/terminal")
public class TerminalController {

    @PostMapping("/exec")
    public String executeCommand(@RequestBody String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader stdOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        StringBuilder output = new StringBuilder();
        String line;

        // Read standard output
        while ((line = stdOutput.readLine()) != null) {
            output.append(line).append("\n");
        }

        // Read standard error
        while ((line = stdError.readLine()) != null) {
            output.append("[ERROR] ").append(line).append("\n");
        }

        return output.toString();
    }
}
  