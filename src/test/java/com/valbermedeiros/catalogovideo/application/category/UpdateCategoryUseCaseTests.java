package com.valbermedeiros.catalogovideo.application.category;

import com.valbermedeiros.catalogovideo.application.usecase.category.update.UpdateCategoryUseCase;
import com.valbermedeiros.catalogovideo.application.usecase.category.update.UpdateCateogoryInputData;
import com.valbermedeiros.catalogovideo.domain.entity.Category;
import com.valbermedeiros.catalogovideo.domain.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UpdateCategoryUseCaseTests {
    @InjectMocks
    private UpdateCategoryUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase() {
        this.useCase = new UpdateCategoryUseCase(repository);
    }

    @Test
    void executeReturnsUpdateCategory() {
        Category category = new Category(
                "Action",
                "Action Description",
                true
        );

        Category expected = new Category(
                "Action 2",
                "Description",
                true
        );

        Optional<Category> opCategory = Optional.of(category);

        when(repository.findById(category.getId()))
                .thenReturn(opCategory);

        UpdateCateogoryInputData input = new UpdateCateogoryInputData();
        input.setName("Action 2");
        input.setDescription("Description");
        input.setIsActive(category.getIsActive());

        category.update(
                input.getName(),
                input.getDescription(),
                input.getIsActive()
        );

        doNothing()
                .when(repository)
                .update(category);

        useCase.execute(category.getId(), input);

        assertEquals(expected.getName(), category.getName());
        assertEquals(expected.getDescription(), category.getDescription());
        assertEquals(expected.getIsActive(), category.getIsActive());
    }
}
