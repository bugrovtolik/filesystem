package com.abuhrov.filesystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "folder")
public class Folder {
    @Id
    @JsonIgnore
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_folder_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<File> files;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_folder_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Folder> folders;
}
