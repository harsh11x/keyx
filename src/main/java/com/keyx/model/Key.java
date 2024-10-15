package com.keyx.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "keys")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Key {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key_value", nullable = false)
    private String keyValue;

    @Column(name = "description")
    private String description;
}
