package com.sinem.repository.entity;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Payroll {

     public static JSONArray payrollList = new JSONArray();

    public void createManagerPayroll(Employee manager, short managerHourlyRate, short managerWorkingHour, short managerBonusPayment) {
        Employee currentManager = new Manager();
        currentManager.setName(manager.getName());
        currentManager.setSurname(manager.getSurname());
        int wage = currentManager.calculateWage(managerHourlyRate, managerWorkingHour);
        wage += managerBonusPayment;
    }

    public void createOfficerPayroll(Employee officer, ESeniority officerSeniority, short officerWorkingHour) {
        Employee currentOfficer = new Officer();
        currentOfficer.setName(officer.getName());
        currentOfficer.setSurname(officer.getSurname());
        short officerHourlyRate;
        if(officerSeniority.equals(ESeniority.SENIOR)) {
            officerHourlyRate = 1000;
        } else if(officerSeniority.equals(ESeniority.MID)) {
            officerHourlyRate = 750;
        } else {
            officerHourlyRate = 500;
        }
        int wage = currentOfficer.calculateWage(officerHourlyRate, officerWorkingHour);

        JSONObject paymentDetails = new JSONObject();
        paymentDetails.put("mainWage", wage);
        
        short overtimeHours;
        int overtimePayment = 0;
        if(officerWorkingHour > 180) {
            overtimeHours = (short) (officerWorkingHour - 180);
            overtimePayment = currentOfficer.calculateWage((short) (officerHourlyRate * 0.5), overtimeHours);
            wage += overtimePayment;
        }
        paymentDetails.put("overtimePayment", overtimePayment);
        paymentDetails.put("totalPayment", wage);

        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("nameSurname", currentOfficer.getName() + " " + currentOfficer.getSurname());
        employeeDetails.put("workingHour", officerWorkingHour);
        employeeDetails.put("paymentDetails", paymentDetails);

        JSONObject payrollDetails = new JSONObject();
        payrollDetails.put("payroll", "MARCH 2024");
        payrollDetails.put("employeeDetails", employeeDetails);

        payrollList.add(payrollDetails);

    }
}
