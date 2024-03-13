package fr.norsys.gestionlivresapi.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AuthorDto {


private int id;

private String name;

private String email;


public AuthorDto(String name, String email) {
    this.name = name;
    this.email = email;
}

public AuthorDto() {
}



public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}
}
