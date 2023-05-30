package br.com.biblioteca.service;

import br.com.biblioteca.exceptions.ProjectDeleteException;
import br.com.biblioteca.exceptions.ResourceNotFoundException;
import br.com.biblioteca.model.dto.ProjectDTO;
import br.com.biblioteca.model.entity.Project;
import br.com.biblioteca.model.mapper.ProjectMapper;
import br.com.biblioteca.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;
    private final ProjectMapper mapper;
    public List<ProjectDTO> findAll() {
        log.info("Projects - findAll");

        return mapper.toProjectDTOList(repository.findAll());
    }

    public ProjectDTO merge(ProjectDTO projectDTO) {
        String operation = Objects.isNull(projectDTO.getId()) ? "Project - Create {}" : "Projects - Update {}";
        String logMessage = operation.concat("Project info id : {} name : {}");
        log.info(logMessage ,System.getProperty("line.separator"), projectDTO.getId(), projectDTO.getName());

        return mapper.toDTO(repository.save(mapper.toEntity(projectDTO)));
    }

    public ProjectDTO find(Long projectId){
        log.info("Project - find id : {}", projectId);

        Project project = repository.findById(projectId)
                                .orElseThrow(() -> new ResourceNotFoundException("Project not found for id : " + projectId));

        log.info("Project found with name : {}", project.getName());

        return mapper.toDTO(project);
    }
    @Transactional
    public void delete(Long projectId) {
        log.info("Project - delete id : {}", projectId);

        Project project = repository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for id : " + projectId));

        if(project.deletable()) {
            repository.deleteById(projectId);
            return;
        }

        log.info("Could not delete project with id {} and status {}", projectId, project.getStatus().getDescription());

        throw new ProjectDeleteException(String.format("Can not delete project %d with status %s", projectId, project.getStatus().name()), project);
    }
}
