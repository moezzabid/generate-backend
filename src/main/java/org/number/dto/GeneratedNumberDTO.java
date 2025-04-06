package org.number.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneratedNumberDTO {
  private Long configurationId;    // ID de la configuration utilisée
  private String firstName;        // Prénom de l'utilisateur
  private String lastName;         // Nom de l'utilisateur
  private String birthDate;        // Date de naissance (au format YYYY-MM-DD)
  private Integer counter;         // Compteur, s'il est fourni
}
