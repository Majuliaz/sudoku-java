import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        
        int[][] values = new int[9][9];
        boolean[][] fixed = new boolean[9][9];

        values[0][0] = 5; fixed[0][0] = true;
        values[1][3] = 6; fixed[1][3] = true;
        values[4][4] = 7; fixed[4][4] = true;
        values[7][8] = 9; fixed[7][8] = true;

        board.initialize(values, fixed);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.printBoard();
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir número");
            System.out.println("2 - Remover número");
            System.out.println("3 - Sair");
            int option = scanner.nextInt();

            if (option == 3) {
                System.out.println("Saindo...");
                break;
            }

            System.out.print("Informe a linha (0-8): ");
            int row = scanner.nextInt();
            System.out.print("Informe a coluna (0-8): ");
            int col = scanner.nextInt();

            if (row < 0 || row > 8 || col < 0 || col > 8) {
                System.out.println("Linha ou coluna inválida!");
                continue;
            }

            if (option == 1) {
                System.out.print("Informe o número (1-9): ");
                int value = scanner.nextInt();
                if (value < 1 || value > 9) {
                    System.out.println("Número inválido!");
                    continue;
                }
                if (!board.setValue(row, col, value)) {
                    System.out.println("Não pode alterar um número fixo!");
                }
            } else if (option == 2) {
                board.clearValue(row, col);
            }
        }

        scanner.close();
    }
}
