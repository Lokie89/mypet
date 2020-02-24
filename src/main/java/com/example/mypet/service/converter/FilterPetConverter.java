package com.example.mypet.service.converter;

import com.example.mypet.service.filter.FilterTypePet;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FilterPetConverter implements Converter<String, FilterTypePet> {
    @Override
    public FilterTypePet convert(String filterType) {
        return FilterTypePet.valueOf(filterType.toUpperCase());
    }
}
