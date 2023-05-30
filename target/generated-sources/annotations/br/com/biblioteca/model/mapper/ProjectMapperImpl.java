package br.com.biblioteca.model.mapper;

import br.com.biblioteca.model.dto.ProjectDTO;
import br.com.biblioteca.model.entity.Project;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T21:22:05-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 13.0.14 (Azul Systems, Inc.)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public ProjectDTO toDTO(Project entity) {
        if ( entity == null ) {
            return null;
        }

        ProjectDTO.ProjectDTOBuilder projectDTO = ProjectDTO.builder();

        projectDTO.id( entity.getId() );
        projectDTO.name( entity.getName() );
        projectDTO.beginDate( entity.getBeginDate() );
        projectDTO.expectedEndDate( entity.getExpectedEndDate() );
        projectDTO.endDate( entity.getEndDate() );
        projectDTO.description( entity.getDescription() );
        projectDTO.status( entity.getStatus() );
        projectDTO.totalBudget( entity.getTotalBudget() );
        projectDTO.risk( entity.getRisk() );
        projectDTO.managerId( entity.getManagerId() );
        projectDTO.manager( personMapper.toDTO( entity.getManager() ) );

        return projectDTO.build();
    }

    @Override
    public Project toEntity(ProjectDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.name( dto.getName() );
        project.beginDate( dto.getBeginDate() );
        project.expectedEndDate( dto.getExpectedEndDate() );
        project.endDate( dto.getEndDate() );
        project.description( dto.getDescription() );
        project.status( dto.getStatus() );
        project.totalBudget( dto.getTotalBudget() );
        project.risk( dto.getRisk() );
        project.managerId( dto.getManagerId() );
        project.manager( personMapper.toEntity( dto.getManager() ) );

        return project.build();
    }

    @Override
    public List<ProjectDTO> toProjectDTOList(List<Project> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectDTO> list1 = new ArrayList<ProjectDTO>( list.size() );
        for ( Project project : list ) {
            list1.add( toDTO( project ) );
        }

        return list1;
    }
}
