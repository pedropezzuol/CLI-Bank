package CLI;

import Model.UserAccount;
import Service.AuthService;

import java.util.Optional;
import java.util.Scanner;

public class CLI {
    public void start(){
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();

        while(true){
            System.out.println("=====CLI Bank=====");
            System.out.println("1. Create account");
            System.out.println("2. Login");
            System.out.println("3. Accounts");
            System.out.println("4. Exit");
            System.out.print("-> ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    UserAccountDTO userCreateAccount = CLI.createAccountCLI();
                    authService.createAccount(userCreateAccount);
                       break;
                case "2":
                    UserAccountDTO userLogin = loginCLI();
                    Optional<UserAccount> userLoginAuth = authService.login(userLogin);
                    userLoginAuth.ifPresentOrElse(
                            CLI::userLoggedCLI,
                            () -> System.out.println("User not found")
                        );
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("Leaving...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static UserAccountDTO createAccountCLI(){
        Scanner scanner = new Scanner(System.in);
        String email;
        String password;

        while (true) {
            System.out.println("\nChoose an email");
            System.out.print("->");
            String input = scanner.nextLine();

            if(!input.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("wrong email");
                continue;
            }
            email = input;
            break;
        }

        while(true) {
            System.out.println("\nEnter your password (letters and numbers only, at least 6 characters)");
            System.out.print("->");
            String input = scanner.nextLine();

            if(!input.matches("^[a-zA-Z0-9]$") && input.length() < 6){
                System.out.println("Invalid password");
                continue;
            }
            password = input;
            break;
        }
        return new UserAccountDTO(email, password);
    }

    private static UserAccountDTO loginCLI(){
        Scanner scanner = new Scanner(System.in);
        String email;
        String password;

        System.out.println("Enter your email");
        System.out.print("->");
        email = scanner.nextLine();

        System.out.println("Enter your password");
        System.out.print("->");
        password = scanner.nextLine();

        return new UserAccountDTO(email, password);
    }

    private static void userLoggedCLI(UserAccount user){
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("===== Welcome Back " + user.getEmail() + " =====");
            System.out.println("1. transfer");
            System.out.println("2. view balance");
            System.out.println("3. account details");
            System.out.println("4. Back");
            System.out.println("5. Exit");
            System.out.print("-> ");

            String option = scanner.nextLine();

            switch(option){
                case "1":
                    transferCLI();
                    break;
                case "2":
                    System.out.println("Balance: " + user.getBalance());
                    break;
                case "3":
                    System.out.println("Email: " + user.getEmail());
                    System.out.println("Password: " + user.getPassword());
                    System.out.println("IBAN: " + user.getIban());
                    break;
                case "4":
                    return;
                case "5":
                    System.out.println("Leaving...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void transferCLI(){
        Scanner scanner = new Scanner(System.in);
        int iban;
        double amount;

        System.out.println("Enter recipient IBAN:");
        System.out.print("->");
        iban = scanner.nextInt();

        System.out.println("Enter amount");
        System.out.print("->");
        amount = scanner.nextDouble();
    }
}
