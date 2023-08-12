package ru.job4j.serialization.json;

public class Pet {
    private final int paws;

    public Pet(int paws) {
        this.paws = paws;
    }

    @Override
    public String toString() {
        return "Pet{"
                + "paws=" + paws + '}';
    }
}