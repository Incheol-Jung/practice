package com.example.practice.enums;

import com.example.practice.block.BlockService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Incheol Jung
 */
@Converter
public class EnumConverter implements AttributeConverter<Category, String> {
    private static Logger log = LoggerFactory.getLogger(EnumConverter.class);

    @Override
    public String convertToDatabaseColumn(Category category) {
        return category.getCode();
    }

    @Override
    public Category convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        try {
            return Category.valueOf(code);
        } catch (IllegalArgumentException e) {
            log.error("failure to convert cause unexpected code [{}]", code, e);
            throw e;
        }
    }
}
