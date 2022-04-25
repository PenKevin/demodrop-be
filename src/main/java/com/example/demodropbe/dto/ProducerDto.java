package com.example.demodropbe.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ProducerDto {
    private final Long id;

    @NotBlank
    @Size(min=2, max=128, message="Voornaam moet minimaal 2 en maximaal 128 letters bevatten.")
    private final String firstName;

    @NotBlank
    @Size(min=2, max=128, message="Achternaam moet minimaal 2 en maximaal 128 letters bevatten.")
    private final String lastName;

    @NotBlank
    private final String adres;

    @NotBlank
    private final String postcode;

    @NotBlank
    private final String city;

    @NotBlank
    private final String country;

    @NotBlank
    @Email
    private final String email;

    @NotBlank
    @Size(min=2, max=128, message="Gebruikersnaam moet minimaal 2 en maximaal 128 tekens letters bevatten.")
    private final String username;

    @NotBlank
    @Size(min=2, max=128, message="Wachtwoord moet minimaal 2 en maximaal 128 tekens bevatten.")
   private final String password;


}
