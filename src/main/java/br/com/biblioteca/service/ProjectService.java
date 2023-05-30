package br.com.biblioteca.service;

import br.com.biblioteca.model.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> findAll();
    ProjectDTO merge(ProjectDTO projectDTO);
    ProjectDTO find(Long projectId);
    void delete(Long projectId);
}
