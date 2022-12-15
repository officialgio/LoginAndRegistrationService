# LoginAndRegistrationService
Login and Registration Backend System using Spring Boot.



# Registering User
<p align="center">
    <img width="600" src="./img/register.png">
</p>


#### Database Lookup: Once user register the user must confirm its email. Once User confirms enabled will turn true. Each User will also return a token in which it must confirmed - it will be shown in the `confrimation_token` table as `confirmed_at`.
<p align="center">
    <img width="600" src="./img/dblookup.png">
</p>

* Check Package `com.example.demo.registration` for the Registration Service implementation.	




# Confirmation Email
* Used `Java Mail Sender` and `Java Mime Message` to send emails.
* Used [MailDev](https://github.com/maildev/maildev) to test email verifications.

<p align="center">
    <img width="600" src="./img/maildev.png">
</p>
<p align="center">
    <img width="600" src="./img/maildevemail.png">
</p>
<p align="center">
    <img width="600" src="./img/confirmedtoken.png">
</p>


#### Sending Confirmation Email
* See `EmailService.java` for MailSender and Mime Message implementation and check `RegistrationService.java` for usage.
* Check `applications.yml` for configuration.
* See docs: [Link](https://www.jhipster.tech/tips/011_tip_configuring_email_in_jhipster.html)




#### Database Lookup: Once fully registered and confirmed.
<p align="center">
    <img width="600" src="./img/fullyregistered.png">
</p>

#### Logging In
<p align="center">
    <img width="600" src="./img/endpoint.png">
</p>
* Fully logged in. Error shows indication of no further mapping to the endpoint after logging in.



# Technologies
- Java
- SpringBoot/Spring JPA/Spring Security
- PostgreSQL
- Postman
- YAML