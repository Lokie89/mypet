package com.example.mypet.service.converter;

import com.example.mypet.service.filter.FilterTypeBoard;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FilterBoardConverter implements Converter<String, FilterTypeBoard> {
    @Override
    public FilterTypeBoard convert(String filterType) {
        return FilterTypeBoard.valueOf(filterType.toUpperCase());
    }
}
