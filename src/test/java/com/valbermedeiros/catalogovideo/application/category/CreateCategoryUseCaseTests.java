package com.valbermedeiros.catalogovideo.application.category;

import com.valbermedeiros.catalogovideo.application.usecase.category.common.CategoryOutputData;
import com.valbermedeiros.catalogovideo.application.usecase.category.create.CreateCategoryInputData;
import com.valbermedeiros.catalogovideo.application.usecase.category.create.CreateCategoryUseCase;
import com.valbermedeiros.catalogovideo.domain.entity.Category;
import com.valbermedeiros.catalogovideo.domain.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CreateCategoryUseCaseTests {

    @InjectMocks
    private CreateCategoryUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase() {
        this.useCase = new CreateCategoryUseCase(repository);
    }

    @Test
    void executeResturnsCreatedCategory() {
        final Category category = new Category(
                "Action",
                "Action Category"
        );

        when(repository.create(any(Category.class)))
                .thenReturn(category);

        CreateCategoryInputData input = new CreateCategoryInputData(
                category.getName(),
                category.getDescription(),
                category.getIsActive()
        );

        CategoryOutputData actual = useCase.execute(input);
        repository.create(category);
        assertThat(actual.getName()).isEqualTo(category.getName());
    }

}
