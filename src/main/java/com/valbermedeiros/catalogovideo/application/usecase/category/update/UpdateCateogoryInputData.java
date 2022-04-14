package com.valbermedeiros.catalogovideo.application.usecase.category.update;

import lombok.Data;

@Data
public class UpdateCateogoryInputData {
    private String name;
    private String description;
    private Boolean isActive;
}
