import java.util.Scanner;

public class Fifo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        

        System.out.println("Digite a quantidade de processos: ");
        int[][] processos = new int[scan.nextInt()][2];

        for (int i = 0; i < processos.length; i++) {
            System.out.println("Digite o tempo de chegada do processo " + (i+1) + ": ");
            processos[i][0] = scan.nextInt();

            System.out.println("Digite o tempo de rajada do processo " + (i+1) + ": ");
            processos[i][1] = scan.nextInt();
        }

        for (int i = 0; i < processos.length; i++) {

            for (int j = 0; j < processos.length; j++) {
                if(processos[j][0] > processos[i][0]) {
                    
                    int aux[] = processos[j];
                    processos[j] = processos[i];
                    processos[i] = aux;
                }
            }
        }

        int tempoTotal = 0;
        int tmp = 0;
        int tme = 0;

        for (int i = 0; i < processos.length; i++) {
            tme += tempoTotal - processos[i][0];
            tempoTotal += processos[i][1];
            tmp += tempoTotal - processos[i][0];

        }

        System.out.println(tme/(double) processos.length + " " + (tmp/(double) processos.length));

    }
}