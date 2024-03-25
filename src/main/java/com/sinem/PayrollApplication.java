package com.sinem;

import com.sinem.util.ReadFile;

public class PayrollApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ReadFile.readJsonFile("employee.json");
    }
}