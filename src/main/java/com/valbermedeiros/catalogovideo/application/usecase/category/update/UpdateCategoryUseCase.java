package com.valbermedeiros.catalogovideo.application.usecase.category.update;

import com.valbermedeiros.catalogovideo.application.exception.NotFoundException;
import com.valbermedeiros.catalogovideo.domain.entity.Category;
import com.valbermedeiros.catalogovideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class UpdateCategoryUseCase implements IUpdateCategoryUseCase{

    private ICategoryRepository repository;

    @Override
    public void execute(UUID uuid, UpdateCateogoryInputData input) {
        Category category = repository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Category %s not found", uuid));

        category.update(
                input.getName(),
                input.getDescription(),
                input.getIsActive()
        );

        repository.update(category);
    }
}
