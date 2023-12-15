package model.service;

public class PetNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public PetNotFoundException() {
        super();
    }

    public PetNotFoundException(String arg0) {
        super(arg0);
    }
}