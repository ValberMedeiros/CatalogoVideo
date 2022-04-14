package com.valbermedeiros.catalogovideo.application.category;

import com.valbermedeiros.catalogovideo.application.usecase.category.get.FindByIdUseCase;
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
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
class FindByIdUseCaseTests {

    @InjectMocks
    private FindByIdUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase() {
        this.useCase = new FindByIdUseCase(repository);
    }

    @Test
    void executeReturnsFindByIdCategory() {
        Category category = new Category(
                "Action",
                "Action Description",
                true
        );

        Optional<Category> opCategory = Optional.of(category);

        doReturn(opCategory)
                .when(repository)
                .findById(category.getId());

        var actual = useCase.execute(category.getId());

        repository.findById(category.getId());

        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(category.getName());
    }
}
