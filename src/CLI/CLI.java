package CLI;

import java.util.Scanner;

public class CLI {
    public static void start(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("=====CLI Bank=====");
            System.out.println("1. Create account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Criar Conta selecionado.");
                    break;
                case "2":
                    System.out.println("Login selecionado.");
                    break;
                case "3":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }

    }
}
