package com.valbermedeiros.catalogovideo.infrastructure.persistence;

import com.valbermedeiros.catalogovideo.domain.entity.Category;
import com.valbermedeiros.catalogovideo.domain.exception.NotNullException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "VARBINARY(16")
    private UUID id;

    @Column
    @NotNull(message = "Name can not be null")
    @NotBlank(message = "Name can not be blank")
    private String name;

    @Column
    private String description;

    @Column
    private Boolean isActive = true;

    public static CategoryPersistence from(Category category) {
        if (category == null) {
            throw new NotNullException();
        }

        return new CategoryPersistence(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getIsActive()
        );
    }

    public Category fromThis(){
        return new Category(
                this.id,
                this.name,
                this.description,
                this.isActive
        );
    }

}
