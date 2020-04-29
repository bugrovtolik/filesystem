package com.abuhrov.filesystem.controller;

import com.abuhrov.filesystem.domain.Folder;
import com.abuhrov.filesystem.service.FolderService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class MainController {
    private final FolderService folderService;

    public MainController(FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping("/api/**")
    public HttpEntity<Folder> getFromPath(HttpServletRequest request) {
        //check if we have a path after '/api/', if not return root
        if (request.getRequestURI().length() < 6) {
            return ok(folderService.getRoot());
        }

        //extract path and retrieve result
        Folder result = folderService.getFromPath(request.getRequestURI().substring(5));

        //if not found return 404
        if (result == null) {
            return notFound().build();
        }

        return ok(result);
    }
}
