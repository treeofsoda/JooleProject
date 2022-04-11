package com.Joole.demo.Controller;

import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.User;
import com.Joole.demo.Service.ProjectSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Project")
public class ProjectController {
    @Autowired
    private ProjectSerivce projectService;

    @PostMapping("/Create")
    public Project Create() {
        return projectService.Create();
    }

    @PostMapping("/findOne")
    public Project findByUsername(@RequestParam("project_id") Long id){
        return projectService.findByOneId(id);
    }

    @RequestMapping("/ReadAll")
    public String readAll(){
        return projectService.readAll();
    }

    @RequestMapping("/Update")
    public Project Update(@RequestBody Project project){
        return projectService.Update(project);
    }

    @RequestMapping("/Delete")
    public void Delete(@RequestParam("project_id") Long id){
        projectService.Delete(id);
    }
}
