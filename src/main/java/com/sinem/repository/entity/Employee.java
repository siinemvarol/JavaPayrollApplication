package com.sinem.repository.entity;

public abstract class Employee {
    private String name;
    private String surname;

    public int calculateWage(short hourlyRate, short workingHour) {
        int wage = hourlyRate * workingHour;
        return wage;
    }

}
