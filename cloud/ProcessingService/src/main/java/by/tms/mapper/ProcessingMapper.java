package by.tms.mapper;

import by.tms.domain.Processing;
import by.tms.dto.ProcessingDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProcessingMapper {

    ProcessingDto toDto(Processing entity);
}
