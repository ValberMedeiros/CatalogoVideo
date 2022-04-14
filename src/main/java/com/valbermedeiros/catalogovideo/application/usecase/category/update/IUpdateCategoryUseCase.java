package com.valbermedeiros.catalogovideo.application.usecase.category.update;

import java.util.UUID;

public interface IUpdateCategoryUseCase {
    void execute(UUID uuid, UpdateCateogoryInputData input);
}
