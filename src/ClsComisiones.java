import java.util.Random;
import java.util.Scanner;

public class ClsComisiones {

    private static final String[][] comi = new String[5][11];
    public static final int NOMBRE = 0;
    public static final int ENERO = 1;
    public static final int FEBRERO = 2;
    public static final int MARZO = 3;
    public static final int ABRIL = 4;
    public static final int TVENTAS = 5;
    public static final int Comision20 = 6;
    public static final int Comision35 = 7;
    public static final int TVenyComision = 8;
    public static final int ISR = 9;
    public static final int LIQUIDO = 10;

    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public static void cargaInformacion() {
        comi[0][NOMBRE] = "Mario";
                    comi[0][ENERO] = String.valueOf(generateRandomIntIntRange(300,600));
                    comi[0][FEBRERO] = String.valueOf(generateRandomIntIntRange(300,600));
                    comi[0][MARZO] = String.valueOf(generateRandomIntIntRange(300,600));
                    comi[0][ABRIL] = String.valueOf(generateRandomIntIntRange(300,600));

                    comi[1][NOMBRE] = "Henry";
                    comi[1][ENERO] = String.valueOf(generateRandomIntIntRange(600,900));
                    comi[1][FEBRERO] = String.valueOf(generateRandomIntIntRange(600,900));
                    comi[1][MARZO] = String.valueOf(generateRandomIntIntRange(600,900));
                    comi[1][ABRIL] = String.valueOf(generateRandomIntIntRange(600,900));

                    comi[2][NOMBRE] = "Luisa";
                    comi[2][ENERO] = String.valueOf(generateRandomIntIntRange(200,500));
                    comi[2][FEBRERO] = String.valueOf(generateRandomIntIntRange(200,500));
                    comi[2][MARZO] = String.valueOf(generateRandomIntIntRange(200,500));
                    comi[2][ABRIL] = String.valueOf(generateRandomIntIntRange(200,500));

                    comi[3][NOMBRE] = "Omar";
                    comi[3][ENERO] = String.valueOf(generateRandomIntIntRange(500,800));
                    comi[3][FEBRERO] = String.valueOf(generateRandomIntIntRange(500,800));
                    comi[3][MARZO] = String.valueOf(generateRandomIntIntRange(500,800));
                    comi[3][ABRIL] = String.valueOf(generateRandomIntIntRange(500,800));

                    comi[4][NOMBRE] = "Jorge";
                    comi[4][ENERO] = String.valueOf(generateRandomIntIntRange(300,600));
                    comi[4][FEBRERO] = String.valueOf(generateRandomIntIntRange(300,600));
                    comi[4][MARZO] = String.valueOf(generateRandomIntIntRange(300,600));
                    comi[4][ABRIL] = String.valueOf(generateRandomIntIntRange(300,600));
    }
    public static void imprimirDecorado() {
        for (String[] strings : comi) {
            System.out.print("|");
            for (int y = 0; y < strings.length; y++) {
                System.out.print(strings[y]);
                if (y != strings.length - 1) {
                    System.out.print("\t\t");
                }
            }
            System.out.println("|");
        }
    }
    public static Float max = 0f;
    public static Float min = 1000000f;
    public static void Calculos(){
        int totalv;
        for (int i = 0; i < 5; i++) {
            totalv = Integer.parseInt(comi[i][ENERO]);
            totalv += Integer.parseInt(comi[i][FEBRERO]);
            totalv += Integer.parseInt(comi[i][MARZO]);
            totalv += Integer.parseInt(comi[i][ABRIL]);
            comi[i][TVENTAS] = String.valueOf(totalv);
            if(totalv <= 2000){
                comi[i][Comision20] = String.valueOf((totalv * 20)/100);
                comi[i][TVenyComision] = String.valueOf(totalv + Integer.parseInt(comi[i][Comision20]));
            } else if (totalv > 2000) {
                comi[i][Comision35] = String.valueOf((totalv * 35)/100);
                comi[i][TVenyComision] = String.valueOf(totalv + Integer.parseInt(comi[i][Comision35]));
            }
            comi[i][ISR] = String.valueOf(Double.parseDouble(comi[i][TVenyComision])*5/100);
            comi[i][LIQUIDO] = String.valueOf(Double.parseDouble(comi[i][TVenyComision])-Double.parseDouble(comi[i][ISR]));
        if(Float.parseFloat(comi[i][LIQUIDO])>max){
            max = Float.parseFloat(comi[i][LIQUIDO]);
        } else if (Float.parseFloat(comi[i][LIQUIDO])< min) {
            min = Float.parseFloat(comi[i][LIQUIDO]);
        }
        }
        MayorMenor(max, min);
    }
    public static void ingresoDatos(){
            cargaInformacion();
    }
    public static void MayorMenor(float may, float min){
        System.out.println("La ganancia mayor de vendedores es de: "+ may );
        System.out.println("La ganancia menor de vendedores es de: "+ min);
    }

    public static void main(String[] args) {
        int op = 0;
        Scanner t = new Scanner(System.in);
        while(op!=3) {
            System.out.println();
            System.out.println("***MENU RESULTADOS***");
            System.out.println("1. Calcular los resultados.");
            System.out.println("2. Mostrar los resultados.");
            System.out.println("3. Salir.");
            System.out.println("Digite una opcion: ");
            op = t.nextInt();
            switch (op) {
                case 1 -> {
                    ingresoDatos();
                    Calculos();
                    System.out.println("Resultados calculados con exito.");
                }
                case 2 -> imprimirDecorado();
                case 3 -> {
                    System.out.println("¡Fue un placer!");
                    System.exit(op);
                }
            }
        }
    }
}
