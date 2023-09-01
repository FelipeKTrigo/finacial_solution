package com.util.financialbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name can't be null")
    @NotBlank(message = "name can't be blank")
    private String name;
    @NotNull(message = "salary can't be null")
    @NotBlank(message = "salary can't be blank")
    private Double salary;
    private Boolean deleted;
    @OneToMany
    @JoinColumn(name = "client_id")
    private List<Spent> spents;
}
