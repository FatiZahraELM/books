package fr.norsys.gestionlivresapi.exceptions;

public class ResourceUsedException extends RuntimeException {
    public ResourceUsedException(String s) {
        super(s);
    }
}
