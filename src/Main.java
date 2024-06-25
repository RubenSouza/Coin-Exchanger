import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double value = 0;
        Scanner input = new Scanner(System.in);
        Options options = new Options();
        options.options();

        int escolha = input.nextInt();
        input.nextLine();

        switch (escolha) {
            case 1 -> {
                System.out.println("Digite o valor que deseja converter: ");
                value = normalizeAndParseDouble(input.nextLine());
                try {
                    CurrencyService.getValue("BRL", "USD", value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 2 -> {
                System.out.println("Digite o valor que deseja converter: ");
                value = normalizeAndParseDouble(input.nextLine());
                try {
                    CurrencyService.getValue("USD", "BRL", value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 3 -> {
                System.out.println("Digite o valor que deseja converter: ");
                value = normalizeAndParseDouble(input.nextLine());
                try {
                    CurrencyService.getValue("BRL", "JPY", value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 4 -> {
                System.out.println("Digite o valor que deseja converter: ");
                value = normalizeAndParseDouble(input.nextLine());
                try {
                    CurrencyService.getValue("JPY", "BRL", value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 5 -> {
                System.out.println("Digite o valor que deseja converter: ");
                value = normalizeAndParseDouble(input.nextLine());
                try {
                    CurrencyService.getValue("BRL", "CNY", value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 6 -> {
                System.out.println("Digite o valor que deseja converter: ");
                value = normalizeAndParseDouble(input.nextLine());
                try {
                    CurrencyService.getValue("CNY", "BRL", value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 7 -> System.out.println("Programa encerrado.");
            default -> System.out.println("Opção inválida.");
        }
    }

    public static double normalizeAndParseDouble(String input) {
        return Double.parseDouble(input.replace(",", "."));
    }
}
