package com.sinem.util;

import com.sinem.repository.entity.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ReadFile {

    public static List<Employee> readJsonFile(String fileName) {
        List<Employee> employeeList = new ArrayList<>();
        Payroll payrollOpr = new Payroll();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileName));
            JSONArray jsonObjects = (JSONArray) obj;
            Scanner scanner = new Scanner(System.in);

            for (Object o : jsonObjects) {
                JSONObject jsonObject = (JSONObject) o;

                String name = (String) jsonObject.get("name");
                String surname = (String) jsonObject.get("surname");
                String role = (String) jsonObject.get("role");

                if (role.equals("Manager")) {
                    Employee currentManager = new Manager();
                    currentManager.setName(name);
                    currentManager.setSurname(surname);
                    employeeList.add(currentManager);

                    boolean rateGreaterThan500;
                    short managerHourlyRate;

                    do {
                        System.out.println("Name Surname: " + currentManager.getName() + " " + currentManager.getSurname());
                        System.out.println("Please enter hourly rate of manager: ");
                        managerHourlyRate = Short.valueOf(scanner.nextLine());
                        if (managerHourlyRate < 500) {
                            rateGreaterThan500 = false;
                            System.out.println("Hourly rate of manager cannot be less than 500!");
                        } else {
                            rateGreaterThan500 = true;
                        }
                    } while (!rateGreaterThan500);
                    System.out.println("Please enter working hour of manager: ");
                    short managerWorkingHour = Short.valueOf(scanner.nextLine());
                    System.out.println("Please enter bonus payment of manager: ");
                    short managerBonusPayment = Short.valueOf(scanner.nextLine());
                    payrollOpr.createManagerPayroll(currentManager, managerHourlyRate, managerWorkingHour, managerBonusPayment);
                }
                if (role.equals("Officer")) {
                    Employee currentOfficer = new Officer();
                    currentOfficer.setName(name);
                    currentOfficer.setSurname(surname);
                    employeeList.add(currentOfficer);

                    boolean isSeniorityValid;
                    String officerSeniorityString;
                    ESeniority officerSeniority = null;

                    do {
                        System.out.println("Name Surname: " + currentOfficer.getName() + " " + currentOfficer.getSurname());
                        System.out.println("Please enter seniority of officer: (JUNIOR, MID, SENIOR) ");
                        officerSeniorityString = scanner.nextLine();
                        if (officerSeniorityString.equals("JUNIOR") ||
                                officerSeniorityString.equals("MID") ||
                                officerSeniorityString.equals("SENIOR")) {
                            officerSeniority = ESeniority.valueOf(officerSeniorityString);
                        }
                        if (officerSeniority == null) {
                            isSeniorityValid = false;
                            System.out.println("Seniority is not valid!");
                        } else {
                            isSeniorityValid = true;
                        }
                    } while (!isSeniorityValid);

                    System.out.println("Please enter working hour of officer: ");
                    short officerWorkingHour = Short.valueOf(scanner.nextLine());
                    payrollOpr.createOfficerPayroll(currentOfficer, officerSeniority, officerWorkingHour);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
