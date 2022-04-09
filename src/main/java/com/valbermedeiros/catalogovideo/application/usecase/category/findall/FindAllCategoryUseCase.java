package com.valbermedeiros.catalogovideo.application.usecase.category.findall;

import com.valbermedeiros.catalogovideo.application.usecase.category.common.CategoryOutputData;
import com.valbermedeiros.catalogovideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FindAllCategoryUseCase implements IFindAllCategoryUseCase{

    private ICategoryRepository repository;

    @Override
    public List<CategoryOutputData> execute() {
        var list = repository.findAll();
        return list.stream()
                .map(CategoryOutputData::fromDomain)
                .collect(Collectors.toList());
    }
}
