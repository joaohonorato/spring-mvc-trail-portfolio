package br.com.biblioteca.controller;

import br.com.biblioteca.exceptions.ProjectDeleteException;
import br.com.biblioteca.model.dto.ProjectDTO;
import br.com.biblioteca.model.enums.RiskEnum;
import br.com.biblioteca.model.enums.StatusEnum;
import br.com.biblioteca.service.PersonService;
import br.com.biblioteca.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Objects;

import static br.com.biblioteca.constants.Constants.ADDED_PROJECT_ATTR;
import static br.com.biblioteca.constants.Constants.DELETED_PROJECT_ATTR;
import static br.com.biblioteca.constants.Constants.MANAGER_LIST_ATTR;
import static br.com.biblioteca.constants.Constants.PROJECT_ATTR;
import static br.com.biblioteca.constants.Constants.PROJECT_FORM_VIEW;
import static br.com.biblioteca.constants.Constants.PROJECT_LIST_ATTR;
import static br.com.biblioteca.constants.Constants.PROJECT_LIST_VIEW;
import static br.com.biblioteca.constants.Constants.PROJECT_STATUS_ATTR;
import static br.com.biblioteca.constants.Constants.REDIRECT_PROJECT_LIST;
import static br.com.biblioteca.constants.Constants.RISK_LIST_ATTR;
import static br.com.biblioteca.constants.Constants.SAVED_PROJECT_ATTR;
import static br.com.biblioteca.constants.Constants.STATUS_LIST_ATTR;

@Controller
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final PersonService personService;

    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute(PROJECT_LIST_ATTR,  projectService.findAll());

        return PROJECT_LIST_VIEW;
    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute(PROJECT_ATTR,  new ProjectDTO());
        model.addAttribute(STATUS_LIST_ATTR, StatusEnum.values());
        model.addAttribute(RISK_LIST_ATTR, RiskEnum.values());
        model.addAttribute(MANAGER_LIST_ATTR, personService.findEmployees());

        return PROJECT_FORM_VIEW;
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model){

        var project = projectService.find(id);

        model.addAttribute(PROJECT_ATTR, Objects.nonNull(project) ? project : new ProjectDTO());
        model.addAttribute(STATUS_LIST_ATTR, StatusEnum.values());
        model.addAttribute(RISK_LIST_ATTR, RiskEnum.values());
        model.addAttribute(MANAGER_LIST_ATTR, personService.findEmployees());

        return PROJECT_FORM_VIEW;
    }
    @PostMapping("/{id}")
    public String merge(@Valid @ModelAttribute(PROJECT_ATTR) ProjectDTO project, BindingResult result, RedirectAttributes redirectAttributes, Model model){

        if (result.hasErrors()) {
            model.addAttribute(STATUS_LIST_ATTR, StatusEnum.values());
            model.addAttribute(RISK_LIST_ATTR, RiskEnum.values());
            model.addAttribute(MANAGER_LIST_ATTR, personService.findEmployees());
            return PROJECT_FORM_VIEW;
        }

        ProjectDTO savedProject = projectService.merge(project);
        redirectAttributes.addFlashAttribute(SAVED_PROJECT_ATTR, savedProject);
        redirectAttributes.addFlashAttribute(ADDED_PROJECT_ATTR, true);
        redirectAttributes.addFlashAttribute(PROJECT_LIST_ATTR,  projectService.findAll());

        return REDIRECT_PROJECT_LIST;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){

        try {
            projectService.delete(id);
        } catch (ProjectDeleteException ex) {
            redirectAttributes.addFlashAttribute(DELETED_PROJECT_ATTR, true);
            redirectAttributes.addFlashAttribute(PROJECT_STATUS_ATTR, ex.getProject().getStatus().getDescription());
        }

        return REDIRECT_PROJECT_LIST;
    }

}
