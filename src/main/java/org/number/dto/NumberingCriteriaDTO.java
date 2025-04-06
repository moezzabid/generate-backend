package org.number.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NumberingCriteriaDTO {
  private String type;  // Exemple : "first_name", "last_name", "birth_date", "counter"
  private String prefix;
  private String suffix;
  private Integer length;
  private Integer order;
}
