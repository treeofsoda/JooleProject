package com.Joole.demo.Controller;

import com.Joole.demo.Entity.Project;
import com.Joole.demo.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/Project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/addProject")
    public ResponseEntity<?> Create(@RequestParam(name = "project_id") int project_id) {
        Project projectToAdd = new Project(project_id);
        projectToAdd.setTime_created(LocalDateTime.now());
        try {
            projectService.create(projectToAdd);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"something wrong happens when creating new project!\"}",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectToAdd,HttpStatus.CREATED);
    }

    @GetMapping("/findOne")
    public ResponseEntity<?> findByOneId(@RequestParam(name = "project_id") int id){
        Project projectToFind = projectService.findByOneId(id);
        if (projectToFind == null) {
            return new ResponseEntity<>("{\"error\":\"project not found!\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectToFind.toString() + "is found", HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> readAll(){
        List<Project> projectList;
        try {
            projectList = projectService.readAll();
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"cannot read!\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectList.toString(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> Update(@RequestBody Project projectToUpdate){
        try {
            projectService.create(projectToUpdate);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"something wrong happens when updating project!\"}",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectToUpdate,HttpStatus.OK);
    }

    @DeleteMapping("/deleteOne")
    public ResponseEntity<?> Delete(@RequestParam("project_id") int id){
        Project projectToDelete = projectService.findByOneId(id);
        if (projectToDelete == null) {
            return new ResponseEntity<>("{\"error\":\"project not found!\"}", HttpStatus.BAD_REQUEST);
        }
        projectService.delete(id);
        return new ResponseEntity<>(projectToDelete.toString() + "is deleted", HttpStatus.OK);
    }
}
