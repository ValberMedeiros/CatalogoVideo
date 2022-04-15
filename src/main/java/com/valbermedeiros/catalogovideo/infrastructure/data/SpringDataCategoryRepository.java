package com.valbermedeiros.catalogovideo.infrastructure.data;

import com.valbermedeiros.catalogovideo.infrastructure.persistence.CategoryPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCategoryRepository extends JpaRepository<CategoryPersistence, UUID> {
}
