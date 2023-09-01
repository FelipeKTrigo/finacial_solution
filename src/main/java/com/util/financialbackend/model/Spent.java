package com.util.financialbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "tb_spent")
public class Spent {
    private Long id;
    private Double price;
    private Double percentage;
    private String name;
}
