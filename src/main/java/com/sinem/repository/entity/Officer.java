package com.sinem.repository.entity;

public class Officer extends Employee{
    @Override
    public int calculateWage(short hourlyRate, short workingHour) {
        return super.calculateWage(hourlyRate, workingHour);
    }
}
