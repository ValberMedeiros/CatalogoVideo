package com.valbermedeiros.catalogovideo.application.category;

import com.valbermedeiros.catalogovideo.application.usecase.category.delete.DeleteCategoryUseCase;
import com.valbermedeiros.catalogovideo.domain.entity.Category;
import com.valbermedeiros.catalogovideo.domain.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class RemoveCategoryUseCaseTests {

    @InjectMocks
    private DeleteCategoryUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase() {
        this.useCase = new DeleteCategoryUseCase(repository);
    }

    @Test
    void executeReturnsDeleteCategory() {
        Category category = new Category(
                "Action",
                "Action Description",
                true
        );

        Optional<Category> opCategory = Optional.of(category);

        doNothing()
                .when(repository)
                .remove(category.getId());

        useCase.execute(category.getId());
        repository.remove(category.getId());

        assertThat(category)
                .isNotNull();

        verify(repository, times(2)).remove(category.getId());
    }
}
