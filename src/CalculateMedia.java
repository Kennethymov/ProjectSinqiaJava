import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculateMedia {
    public static void main(String[] args) {
        String typeMedia;
        double quantityNumber, result = 0;
        List<Double> numbers = new ArrayList<Double>();

        System.out.println("Esta aplicação calcula media ARITMETICA ou HARMONICA");
        System.out.println("Digite ARITMETICA para calculo da media aritmetica ou HARMONICA para calculo da media harmonica");

        Scanner getTyoeMedia = new Scanner(System.in);
        typeMedia = getTyoeMedia.nextLine().toUpperCase();

        while (!typeMedia.equals("ARITMETICA") && !typeMedia.equals("HARMONICA")) {
            System.out.println("Media invalida!! Digite ARITMETICA para calculo da media aritmetica ou HARMONICA para calculo da media harmonica ");
            typeMedia = getTyoeMedia.nextLine().toUpperCase();
        }

        quantityNumber = getQuantity();
        while (quantityNumber <= 0) {
            System.out.println("Digito um numero positivo maior que 0");
            quantityNumber = getQuantity();
        }

        for (int i = 1; i <= quantityNumber; i+=1) {
            double number = getNumber(i);
            while (typeMedia.equals("HARMONICA") && number <= 0){
                System.out.println("Digito um numero positivo maior que 0");
                number = getNumber(i);
            }
            numbers.add(number);
        }

        if (typeMedia.equals("ARITMETICA")) {
            result = aritmetica(numbers);
        }
        if (typeMedia.equals("HARMONICA")) {
            result = harmonica((numbers));
        }

        System.out.printf("A media " + typeMedia + " dos numeros " + numbers + " é %.2f", result);

    }

    private static int getQuantity() {
        try {
            Scanner quantity = new Scanner((System.in));
            System.out.println("Digite a quantidade de numeros para calculo da media escolhida.");
            return quantity.nextInt();
        } catch (InputMismatchException e) {
            Scanner quantity = new Scanner((System.in));
            System.out.println("Quantidade invalida!!! Digito um numero inteiro!");
            return getQuantity();
        }
    }

    private static double getNumber(int i) {
        try {
            Scanner number = new Scanner((System.in));
            System.out.println("Digite o " + i + "° número");
            return number.nextDouble();
        } catch (InputMismatchException e) {
            Scanner number = new Scanner((System.in));
            System.out.println("Numero invalido!! Digite um numero valido!");
            return getNumber(i);
        }
    }

    private static double aritmetica(List<Double> numbers) {
       if(numbers.size() == 0) {
           return 0;
       }

        double result = 0;

        for (double number: numbers) {
            result += number;
        }

        return result/numbers.size();
    }

    private static double harmonica(List<Double> numbers) {
        if(numbers.size() == 0) {
            return 0;
        }

        double result = 0;

        for (double number: numbers) {
            result += 1/number;
        }

        if (result == 0) {
            return 0;
        }

        return numbers.size()/result;
    }
}
