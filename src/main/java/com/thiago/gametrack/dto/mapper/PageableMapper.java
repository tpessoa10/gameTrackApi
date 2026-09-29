package com.thiago.gametrack.dto.mapper;

import com.thiago.gametrack.dto.PageableDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageableMapper {

    public static <T> PageableDto<T> toDto(Page<T> page) {

        PageableDto<T> dto = new PageableDto<>();

        dto.setContent(page.getContent());
        dto.setFirst(page.isFirst());
        dto.setLast(page.isLast());
        dto.setNumber(page.getNumber());
        dto.setSize(page.getSize());
        dto.setNumberOfElements(page.getNumberOfElements());
        dto.setTotalPages(page.getTotalPages());
        dto.setTotalElements((int) page.getTotalElements());

        return dto;
    }
}