package org.redischool.product.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

/**
 * Created by ReDI on 11/7/2016.
 */

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "id" })
@Builder
@Getter//@Value
public class Category {

    @Id
    private String id;

    private String name;

    @Singular private Set<Product> products;
}
