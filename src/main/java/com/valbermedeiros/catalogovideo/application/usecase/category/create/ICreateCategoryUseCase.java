package com.valbermedeiros.catalogovideo.application.usecase.category.create;

import com.valbermedeiros.catalogovideo.application.usecase.category.common.CategoryOutputData;

public interface ICreateCategoryUseCase {
    CategoryOutputData execute(CreateCategoryInputData input);
}
