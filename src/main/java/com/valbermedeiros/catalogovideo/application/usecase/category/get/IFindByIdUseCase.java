package com.valbermedeiros.catalogovideo.application.usecase.category.get;

import com.valbermedeiros.catalogovideo.application.usecase.category.common.CategoryOutputData;

import java.util.UUID;

public interface IFindByIdUseCase {
    CategoryOutputData execute(UUID id);
}
