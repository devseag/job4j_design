package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Animal {
    private final boolean isPet;
    private final int age;
    private final String nickName;
    private final Pet pet;
    private final String[] habits;

    public Animal(boolean isPet, int age, String nickName, Pet pet, String[] habits) {
        this.isPet = isPet;
        this.age = age;
        this.nickName = nickName;
        this.pet = pet;
        this.habits = habits;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "isPet=" + isPet
                + ", age=" + age
                + ", nickName='" + nickName + '\''
                + ", pet=" + pet
                + ", habits=" + Arrays.toString(habits) + '}';
    }

    public static void main(String[] args) {
        Animal animal = new Animal(true, 5, "Nick", new Pet(4), new String[]{"swim", "run", "eat"});
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(animal));
        String gsonAnimal = "{"
                + "\"isPet\":true,"
                + "\"age\":5,"
                + "\"nickName\":\"Nick\","
                + "\"pet\":"
                + "{\"paws\":4},"
                + "\"habits\":"
                + "[\"swim\",\"run\",\"eat\"]"
                + "}";
        System.out.println(gson.fromJson(gsonAnimal, Animal.class));
    }
}