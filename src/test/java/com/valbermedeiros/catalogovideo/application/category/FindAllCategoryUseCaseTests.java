package com.valbermedeiros.catalogovideo.application.category;

import com.valbermedeiros.catalogovideo.application.usecase.category.common.CategoryOutputData;
import com.valbermedeiros.catalogovideo.application.usecase.category.findall.FindAllCategoryUseCase;
import com.valbermedeiros.catalogovideo.domain.entity.Category;
import com.valbermedeiros.catalogovideo.domain.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith({SpringExtension.class})
class FindAllCategoryUseCaseTests {

    @InjectMocks
    private FindAllCategoryUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase() {
        this.useCase = new FindAllCategoryUseCase(repository);
    }

    @Test
    void executeReturnsFindAllCategory() {
        List<Category> categories = Arrays.asList(
            new Category(
                "Action",
                "Action Description",
                true
            ),
            new Category(
                "Suspense",
                "Suspense Description",
                true
            ),
            new Category(
                "Horror",
                "Horror Description",
                true
            )
        );

        doReturn(categories)
                .when(repository)
                .findAll();

        List<CategoryOutputData> actual = useCase.execute();
        repository.findAll();

        assertThat(categories)
                .isNotNull()
                .hasSize(3);
        verify(repository, times(2)).findAll();

        assertThat(actual)
                .isNotNull()
                .hasSize(3);
    }
}
