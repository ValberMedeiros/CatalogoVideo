package com.valbermedeiros.catalogovideo.application.usecase.category.create;

import com.valbermedeiros.catalogovideo.application.usecase.category.common.CategoryOutputData;
import com.valbermedeiros.catalogovideo.domain.entity.Category;
import com.valbermedeiros.catalogovideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateCategoryUseCase implements ICreateCategoryUseCase{

    private ICategoryRepository repository;

    @Override
    public CategoryOutputData execute(CreateCategoryInputData input) {
        var created = repository.create(toDomain(input));
        return CategoryOutputData.fromDomain(created);
    }

    private Category toDomain(CreateCategoryInputData input) {
        return new Category(
                input.getName(),
                input.getDescription(),
                input.getIsActive()
        );
    }
}
