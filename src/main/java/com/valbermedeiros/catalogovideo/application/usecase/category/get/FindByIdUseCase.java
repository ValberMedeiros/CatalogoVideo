package com.valbermedeiros.catalogovideo.application.usecase.category.get;

import com.valbermedeiros.catalogovideo.application.exception.NotFoundException;
import com.valbermedeiros.catalogovideo.application.usecase.category.common.CategoryOutputData;
import com.valbermedeiros.catalogovideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class FindByIdUseCase implements IFindByIdUseCase{

    private ICategoryRepository repository;

    @Override
    public CategoryOutputData execute(UUID id) {
        return repository.findById(id)
                .map(CategoryOutputData::fromDomain)
                .orElseThrow(() -> new NotFoundException("Category %s not found", id));
    }
}
