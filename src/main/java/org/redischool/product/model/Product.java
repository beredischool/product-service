package org.redischool.product.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

/**
 * Created by avramesc on 11/4/2016.
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "id" })
@Builder(toBuilder = true)
@Getter //@value
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private Set<Categories> categories;
}

