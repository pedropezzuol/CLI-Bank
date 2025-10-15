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
            System.out.println("3. Exit");
            System.out.print("-> ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    CLI.createAccountCLI();
                    authService.createAccount();
                    break;
                case "2":
                    authService.login();
                    break;
                case "3":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void createAccountCLI(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an email");
            System.out.print("->");
            String email = scanner.nextLine();

            if(!email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("wrong email");
                continue;
            }
            break;
        }

        while(true) {
            System.out.println("Choose a password");
            System.out.print("->");
            String password = scanner.nextLine();

        }
    }
}
