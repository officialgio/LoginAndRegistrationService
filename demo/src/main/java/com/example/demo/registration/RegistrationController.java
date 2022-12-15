package com.example.demo.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * This class serves to handle a request made by the client
 * @RequestMapping  Maps web request URL
 * @PostMapping HTTP Post
 * @RequestBody Get client request
 * @RequestParam must input the token to confirm
 */
@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    // localhost:8080/api/v1/registration/confirm?token=REPLACE_WITH_TOKEN
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
