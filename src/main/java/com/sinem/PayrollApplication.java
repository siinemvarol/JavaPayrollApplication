package com.sinem;

import com.sinem.util.ReadFile;

public class PayrollApplication {
    public static void main(String[] args) {
        ReadFile.readJsonFile("employee.json");
    }
}