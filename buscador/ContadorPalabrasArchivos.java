package buscador;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ContadorPalabrasArchivos {

    private File file;
    private String targetPalabra;


    public ContadorPalabrasArchivos(File file, String targetPalabra){
        this.file = file;
        this.targetPalabra = targetPalabra;
    }
    
    public int Contador(){
        int contador = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                contador += countWordInLine(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return contador;
    }

    
    // Método privado para contar la cantidad de veces que aparece la palabra en una línea
    private int countWordInLine(String line) {
        int count = 0;
        String cleanedLine = line.replace("\"", "");//Quita las "" y las vuelve espacio vacio
        String[] words = cleanedLine.split("\\W+"); // Dividir usando caracteres no alfanuméricos

        // Iterar a través de las palabras y contar las ocurrencias de la palabra objetivo
        for (String word : words) {
            if (word.equalsIgnoreCase(targetPalabra)) {
                count++;
            }
        }

        return count;
    }

    public String getFileName() {
        return file.getName();
    }
    

}

