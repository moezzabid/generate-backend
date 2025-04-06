package org.number.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "numbering_criteria")
public class NumberingCriteria extends TimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;  // Exemple : "first_name", "last_name", "birth_date", "counter"
    private String prefix;
    private String suffix;
    private Integer length;
  @Column(name = "order_number")
  private Integer order;

  @ManyToOne
  @JoinColumn(name = "configuration_id")
  private Configuration configuration;
}
