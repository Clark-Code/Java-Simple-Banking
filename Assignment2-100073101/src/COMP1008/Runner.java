package COMP1008;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        //ask user
        Scanner in = new Scanner(System.in);
        String input;
        System.out.println("Please enter Bank name");
        String bankName = in.nextLine();
        System.out.println("Please choose branch location\n 1. Barrie\n 2. toronto");
        String location = in.nextLine();
        while (!location.equalsIgnoreCase("barrie") && !location.equalsIgnoreCase("toronto")) {
            System.out.println("Please choose correct branch location\n 1. Barrie\n 2. toronto");
            location = in.nextLine();
        }
        Bank b = new Bank(bankName, location);
        System.out.println("Welcome to " + location + " branch of " + bankName);
        do {
            System.out.println("1. Add Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Account Details");
            System.out.println("4. Modify Account");
            System.out.println("5. Delete Account");
            System.out.println("6. Help");
            System.out.println("7. Summary");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Enter choice:");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();

            switch (input) {

                case "0":
                    System.out.println("Exiting Program...");
                    break;

                case "1":
                    b.addAccounts();
                    break;

                case "2":
                    b.viewAllAccounts();

                    break;

                case "3":
                    System.out.println("Please input “view ACCOUNT_NUMBER details");
                    String wholeString = in.nextLine();
                    String[] splitArray = wholeString.split(" ");
                    if (splitArray.length == 3 && splitArray[0].equalsIgnoreCase("view") && splitArray[2].equalsIgnoreCase("details")) {
                        b.viewAccountDetails(splitArray[1]);
                    } else {
                        System.out.println("Wrong input\n");
                    }

                    break;

                case "4":
                    System.out.println("Please input modify ACCOUNT_NUMBER\n or\n input “modify ACCOUNT_NUMBER OPTION");
                    String acc_num = in.nextLine();
                    String[] splitArr = acc_num.split(" ");
                    if (splitArr.length == 2 && splitArr[0].equalsIgnoreCase("modify")) {
                        b.modifyAccountDetails(splitArr[1]);
                    } else if (splitArr.length == 3 && splitArr[0].equalsIgnoreCase("modify") && (splitArr[2].equalsIgnoreCase("name") || splitArr[2].equalsIgnoreCase("number") || splitArr[2].equalsIgnoreCase("balance"))) {
                        b.modifyAccountDetails(splitArr[1], splitArr[2]);
                    } else {
                        System.out.println("Wrong input\n");
                    }
                    break;

                case "5":
                    System.out.println("Please input delete ACCOUNT_NUMBER");
                    String deleteInstruction = in.nextLine();
                    String[] deleteArray = deleteInstruction.split(" ");
                    if (deleteArray.length == 2 && deleteArray[0].equalsIgnoreCase("delete")) {
                        b.deleteAccount(deleteArray[1]);
                    } else {
                        System.out.println("Wrong input\n");
                    }
                    break;

                case "6":
                    b.help();
                    break;

                case "7":
                    b.summary();
                    break;

                default:
                    System.out.println("Wrong input\n");
                    break;
            }
        } while (!input.equals("0"));
    }

}

