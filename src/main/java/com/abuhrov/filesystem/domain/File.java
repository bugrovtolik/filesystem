package com.abuhrov.filesystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "file")
public class File {
    @Id
    @JsonIgnore
    private Long id;
    private String name;
    private String mimeType;
    private Integer size;
}
