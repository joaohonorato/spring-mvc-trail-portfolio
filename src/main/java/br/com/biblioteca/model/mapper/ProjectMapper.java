package br.com.biblioteca.model.mapper;

import br.com.biblioteca.model.dto.ProjectDTO;
import br.com.biblioteca.model.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
@Mapper(componentModel= MappingConstants.ComponentModel.SPRING,
	uses = {
		PersonMapper.class
	})
public interface ProjectMapper {

    ProjectDTO toDTO(Project entity);

	Project toEntity(ProjectDTO dto);

	List<ProjectDTO> toProjectDTOList(List<Project> list);


}
