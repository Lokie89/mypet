package com.example.mypet.service.converter;

import com.example.mypet.service.sort.SortTypeBoard;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SortBoardConverter implements Converter<String, SortTypeBoard> {
    @Override
    public SortTypeBoard convert(String filterType) {
        return SortTypeBoard.valueOf(filterType.toUpperCase());
    }
}
