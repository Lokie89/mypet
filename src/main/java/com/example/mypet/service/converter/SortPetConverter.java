package com.example.mypet.service.converter;

import com.example.mypet.service.sort.SortTypePet;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SortPetConverter implements Converter<String, SortTypePet> {
    @Override
    public SortTypePet convert(String filterType) {
        return SortTypePet.valueOf(filterType.toUpperCase());
    }
}
