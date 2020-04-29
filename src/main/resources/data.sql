CREATE TABLE folder (
    id INT(8) AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(512) NOT NULL,
    parent_folder_id INT(8),
    FOREIGN KEY (parent_folder_id)
        REFERENCES folder(id)
        ON DELETE CASCADE
);

CREATE TABLE file (
    id INT(8) AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(512) NOT NULL,
    mime_type VARCHAR(128) NOT NULL,
    size INT(4) NOT NULL,
    parent_folder_id INT(8) NOT NULL,
    FOREIGN KEY (parent_folder_id)
        REFERENCES folder(id)
        ON DELETE CASCADE
);

INSERT INTO folder(name) VALUES ('$ROOT$');
INSERT INTO folder(name, parent_folder_id) VALUES ('Folder_1', 1);
INSERT INTO folder(name, parent_folder_id) VALUES ('SubFolder_1', 2);
INSERT INTO folder(name, parent_folder_id) VALUES ('SubFolder_2', 2);
INSERT INTO folder(name, parent_folder_id) VALUES ('SubFolder_3', 2);
INSERT INTO folder(name, parent_folder_id) VALUES ('Folder_2', 1);
INSERT INTO file(name, mime_type, size, parent_folder_id) VALUES ('image1.gif', 'image/jpeg', 13406, 1);
INSERT INTO file(name, mime_type, size, parent_folder_id) VALUES ('image2.gif', 'image/gif', 3410, 1);
INSERT INTO file(name, mime_type, size, parent_folder_id) VALUES ('image3.gif', 'image/jpeg', 33756, 2);
INSERT INTO file(name, mime_type, size, parent_folder_id) VALUES ('image4.gif', 'image/png', 10024, 2);
INSERT INTO file(name, mime_type, size, parent_folder_id) VALUES ('readme.txt', 'text/plain', 511, 3);


