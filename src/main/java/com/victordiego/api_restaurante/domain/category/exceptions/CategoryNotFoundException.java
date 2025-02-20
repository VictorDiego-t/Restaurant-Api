package com.victordiego.api_restaurante.domain.category.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String id) {
        super("Categoria com id " + id + " Não Encontrada");
    }
}
