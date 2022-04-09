package com.Joole.demo.Controller;

import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.User;
import com.Joole.demo.Service.ProjectSerivce;
import com.Joole.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Project")
public class ProjectController {

    private ProjectSerivce projectService;

    @Autowired
    public ProjectController(ProjectSerivce projectService){
        this.projectService = projectService;
    }

    @PostMapping("/Create")
    public Project Create() {
        return projectService.Create();
    }

    @GetMapping("/findOne")
    public Project findByUsername(@RequestParam("project_id") Long id){
        return projectService.findByOneId(id);
    }

    @GetMapping("/ReadAll")
    public String readAll(){
        return projectService.readAll();
    }

    @PostMapping("/Update")
    public Project Update(@RequestBody Project project){
        return projectService.Update(project);
    }

    @DeleteMapping("/Delete")
    public void Delete(@RequestParam("project_id") Long id){
        projectService.Delete(id);
    }
}
