package com.valbermedeiros.catalogovideo.domain.entity;

import com.valbermedeiros.catalogovideo.domain.exception.DomainException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryTests {

    @Test
    void throwDomainExceptionWhenNameIsNull() {
        assertThrows(DomainException.class, () -> new Category(null, "Description"));
    }

    @Test
    void throwDomainExceptionWhenNameIsBlank() {
        assertThrows(DomainException.class, () -> new Category("", "Description"));
    }

    @Test
    void createCategoryWithNameAndDescriptionIsNull() {
        final Category entity = new Category(
                "Name 1",
                null
        );
        assertNotNull(entity);
        assertEquals("Name 1", entity.getName());
        assertNull(entity.getDescription());
    }

    @Test
    void createCategoryWithNameAndDescription() {
        final Category entity = new Category(
                "Name 1",
                "Description 2"
        );
        assertNotNull(entity);
        assertEquals("Name 1", entity.getName());
        assertEquals("Description 2", entity.getDescription());
    }

    @Test
    void createCategoryAndActive() {
        final Category entity = new Category(
                "Name 1",
                "Description 2"
        );
        assertNotNull(entity);
        assertTrue(entity.getIsActive());
    }

    @Test
    void createCategoryAndDeactivate() {
        final Category entity = new Category(
                "Name 1",
                "Description 2"
        );
        entity.deactivate();
        assertNotNull(entity);
        assertFalse(entity.getIsActive());
    }

    @Test
    void createCategoryAndUpdate() {
        final Category entity = new Category(
                "Name 1",
                "Description 2"
        );
        assertNotNull(entity);
        assertEquals("Name 1", entity.getName());
        assertEquals("Description 2", entity.getDescription());
        assertTrue(entity.getIsActive());

        entity.update("Name 2", "Desc", false);

        assertNotNull(entity);
        assertEquals("Name 2", entity.getName());
        assertEquals("Desc", entity.getDescription());
        assertFalse(entity.getIsActive());
    }
}
