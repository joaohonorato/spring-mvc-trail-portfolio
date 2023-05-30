package br.com.biblioteca.service;

import br.com.biblioteca.model.dto.ProjectDTO;
import br.com.biblioteca.model.entity.Project;
import br.com.biblioteca.model.mapper.ProjectMapper;
import br.com.biblioteca.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {
    @InjectMocks
    private ProjectServiceImpl projectService;
    @Mock
    private  ProjectRepository repository;
    @Mock
    private  ProjectMapper mapper;

    @Test
    public void shouldFindAll() {
        when(mapper.toProjectDTOList(anyList())).thenReturn(List.of());
        when(repository.findAll()).thenReturn(List.of());
        projectService.findAll();
        verify(repository, times(1)).findAll();
    }

    @Test
    public void shouldMerge() {
        Project entity = new Project();
        ProjectDTO dto = new ProjectDTO();
        when(repository.save(any())).thenReturn(entity);
        when(mapper.toEntity(any())).thenReturn(entity);
        when(mapper.toDTO(any())).thenReturn(dto);
        projectService.merge(dto);
        verify(repository, times(1)).save(any());
    }


}