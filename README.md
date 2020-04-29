# About

REST API for persisting a folder structure to a relational database

# Getting Started

* Install `MySQL`, `Java 8+`, `Gradle 6`. Project uses Lombok, please add this plugin to IDE. Create a database, example:
```
mysql> CREATE DATABASE filesystem;
```

# Using the API

* To use API, precede folder path with /api/, example:
```
http://localhost:8080/api/Folder_1/SubFolder_1
```
