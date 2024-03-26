package com.sinem.repository.entity;

public class Officer extends Employee{
    private ESeniority seniority;

    public ESeniority getSeniority() {
        return seniority;
    }

    public void setSeniority(ESeniority seniority) {
        this.seniority = seniority;
    }

    @Override
    public int calculateWage(short hourlyRate, short workingHour) {
        return super.calculateWage(hourlyRate, workingHour);
    }
}
