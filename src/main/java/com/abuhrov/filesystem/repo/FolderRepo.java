package com.abuhrov.filesystem.repo;

import com.abuhrov.filesystem.domain.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FolderRepo extends JpaRepository<Folder, Long> {
    @Query("from Folder where name = '$ROOT$'")
    Folder findRoot();
}