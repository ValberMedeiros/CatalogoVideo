package com.valbermedeiros.catalogovideo.infrastructure.mysql;

import com.valbermedeiros.catalogovideo.domain.entity.Category;
import com.valbermedeiros.catalogovideo.infrastructure.data.SpringDataCategoryRepository;
import com.valbermedeiros.catalogovideo.infrastructure.persistence.CategoryPersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class MySqlCategoryRepositoryImplTests {

    @InjectMocks
    private MySqlCategoryRepositoryImpl repository;

    @Mock
    private SpringDataCategoryRepository springDataCategoryRepository;

    @Test
    void saveCategory() {
        Category expected = new Category(
                "Action",
                "Action description",
                true
        );

        Category input = new Category(
                "Action",
                "Action description",
                true
        );

        doReturn(CategoryPersistence.from(input))
                .when(springDataCategoryRepository)
                .save(any(CategoryPersistence.class));

        Category actual = repository.create(input);
        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(expected.getName());
    }

    @Test
    void findAllCategories() {
        Category entity1 = new Category(
                "Action",
                "Action description",
                true
        );

        Category entity2 = new Category(
                "Horror",
                "Horror description",
                true
        );

        List<CategoryPersistence> expected = new ArrayList<>();
        expected.add(CategoryPersistence.from(entity1));
        expected.add(CategoryPersistence.from(entity2));

        doReturn(expected)
                .when(springDataCategoryRepository)
                .findAll();

        var actual = repository.findAll();
        assertThat(actual)
                .isNotEmpty()
                .hasSize(2);

    }

    @Test
    void findByIdCategory() {
        Category entity = new Category(
                "Action",
                "Action description",
                true
        );

        CategoryPersistence input = CategoryPersistence.from(entity);

        doReturn(Optional.of(input))
                .when(springDataCategoryRepository)
                .findById(input.getId());

        var actual = repository.findById(input.getId());
        assertThat(actual)
                .isNotNull();
        assertThat(actual.get().getName())
                .isEqualTo(entity.getName());
    }

    @Test
    void deleteCategory() {
        Category entity = new Category(
                "Action",
                "Action description",
                true
        );

        doNothing()
                .when(springDataCategoryRepository)
                .deleteById(entity.getId());

        repository.remove(entity.getId());
        verify(springDataCategoryRepository)
                .deleteById(entity.getId());
    }

    @Test
    void updateCategory() {
        Category expected = new Category(
                "Horror",
                "Action description",
                false
        );

        Category input = new Category(
                "Action",
                "Action description",
                true
        );

        doReturn(CategoryPersistence.from(input))
                .when(springDataCategoryRepository)
                .save(any(CategoryPersistence.class));

        Category toUpdate = repository.create(input);

        toUpdate.update("Horror", toUpdate.getDescription(), false);

        doReturn(CategoryPersistence.from(toUpdate))
                .when(springDataCategoryRepository)
                        .save(any(CategoryPersistence.class));

        repository.update(toUpdate);

        assertThat(toUpdate).isNotNull();
        assertThat(toUpdate.getName()).isEqualTo(expected.getName());
        assertThat(toUpdate.getIsActive()).isEqualTo(expected.getIsActive());
    }
}
