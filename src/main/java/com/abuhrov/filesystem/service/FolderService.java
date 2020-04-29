package com.abuhrov.filesystem.service;

import com.abuhrov.filesystem.domain.Folder;
import com.abuhrov.filesystem.repo.FolderRepo;
import org.springframework.stereotype.Service;

@Service
public class FolderService {
    private final FolderRepo folderRepo;

    public FolderService(FolderRepo folderRepo) {
        this.folderRepo = folderRepo;
    }

    public Folder getRoot() {
        return folderRepo.findRoot();
    }

    public Folder getFromPath(String requestURI) {
        String[] folders = requestURI.split("/");
        Folder root = getRoot();

        for (String name : folders) {
            root = root.getFolders().stream().filter(folder -> name.equals(folder.getName())).findFirst().orElse(null);
            if (root == null) {
                return null;
            }
        }

        return root;
    }
}
