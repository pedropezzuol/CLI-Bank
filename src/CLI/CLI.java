package CLI;

import Service.AuthService;

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
                    UserAccountDTO user = CLI.createAccountCLI();
                    authService.createAccount(user);
                    break;
                case "2":
                    CLI.loginCLI();
                    authService.login();
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
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
}
