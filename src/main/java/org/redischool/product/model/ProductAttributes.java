package org.redischool.product.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ReDI on 11/7/2016.
 */

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "id" })
@Builder
@Getter//@Value
public class ProductAttributes {

    @Id
    private Product product;

    @Id
    private Attributes attribute;

    private String value;
}
