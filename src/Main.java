import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int numero = r.nextInt(5)+1;

        System.out.println("El numero es: "+numero);

    }
}