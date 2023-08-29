package buscador;

import java.util.Scanner;

public class BuscadorPalabras {
public static void main (String [ ] args) {

 Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la ruta de la carpeta: ");
        String folderPath = scanner.nextLine();

        System.out.print("Ingrese la palabra que desea contar: ");
        String targetWord = scanner.nextLine();

        scanner.close();

        ContadorPalabrasCarpetas folderCounter = new ContadorPalabrasCarpetas(folderPath, targetWord);
        folderCounter.printWordCountsInFiles();

        }
        }