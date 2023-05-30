package br.com.biblioteca.exceptions;


import br.com.biblioteca.model.entity.Project;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ProjectDeleteException extends RuntimeException
{
    private final Project project;
    public ProjectDeleteException(String message, Project project)
    {
        super(message);
        this.project = project;
    }
}