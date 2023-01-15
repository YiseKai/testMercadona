package com.mercadona.test.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@Table(name = "Ean" , uniqueConstraints = @UniqueConstraint(columnNames = "eanNumber"))
public class Ean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String eanNumber;

    public Ean(String ean) {
        this.eanNumber = ean;
    }
}
