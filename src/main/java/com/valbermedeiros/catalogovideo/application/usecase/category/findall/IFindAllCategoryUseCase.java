package com.valbermedeiros.catalogovideo.application.usecase.category.findall;

import com.valbermedeiros.catalogovideo.application.usecase.category.common.CategoryOutputData;

import java.util.List;

public interface IFindAllCategoryUseCase {
    List<CategoryOutputData> execute();
}
