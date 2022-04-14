package com.valbermedeiros.catalogovideo.application.usecase.category.delete;

import com.valbermedeiros.catalogovideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DeleteCategoryUseCase implements IDeleteCategoryUseCase{

    private ICategoryRepository repository;

    @Override
    public void execute(UUID id) {
        repository.remove(id);
    }
}
