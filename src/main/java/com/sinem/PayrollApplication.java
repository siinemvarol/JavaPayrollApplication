package com.sinem;

import com.sinem.repository.entity.Payroll;
import com.sinem.util.ReadFile;

import java.io.FileWriter;
import java.io.IOException;

public class PayrollApplication {
    public static void main(String[] args) {

        ReadFile.readJsonFile("employee.json");

        try (FileWriter file = new FileWriter("payrolls.json")) {
            file.write(Payroll.payrollList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}