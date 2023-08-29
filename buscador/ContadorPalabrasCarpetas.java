package buscador;

import java.io.File;

public class ContadorPalabrasCarpetas {

    private File folder;
    private String targetWord;

    // Constructor para inicializar la instancia con la carpeta y la palabra
    // objetivo
    public ContadorPalabrasCarpetas(String folderPath, String targetWord) {
        this.folder = new File(folderPath);
        this.targetWord = targetWord;
    }

    // Método para contar la cantidad total de veces que aparece la palabra en todos
    // los archivos de la carpeta
    public int countWordInFiles() {
        int totalCount = 0;

        // Iterar a través de los archivos en la carpeta
        if (folder != null && folder.isDirectory()) {
            File[] files = folder.listFiles(); // Obtener la lista de archivos
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isSupportedFileType(file.getName())) {
                        ContadorPalabrasArchivos fileCounter = new ContadorPalabrasArchivos(file, targetWord);
                        totalCount += fileCounter.Contador();
                    } else {
                        System.out.println("No se encontraron archivos de texto en la carpeta");
                    }
                }
            }
        }

        return totalCount;
    }

    // Método privado para verificar si el tipo de archivo es compatible
    private boolean isSupportedFileType(String fileName) {
        String lowerCaseFileName = fileName.toLowerCase();
        return lowerCaseFileName.endsWith(".txt")
                || lowerCaseFileName.endsWith(".xml")
                || lowerCaseFileName.endsWith(".json")
                || lowerCaseFileName.endsWith(".csv");
    }

    public void printWordCountsInFiles() {
        System.out.println("Resultados:");
        boolean folderFound = false;

        if (folder.exists() && folder.isDirectory()) {
            folderFound = true;

            for (File file : folder.listFiles()) {
                if (file.isFile() && isSupportedFileType(file.getName())) {
                    ContadorPalabrasArchivos fileCounter = new ContadorPalabrasArchivos(file, targetWord);
                    int fileWordCount = fileCounter.Contador();
                    System.out.println(fileCounter.getFileName() + ": " + fileWordCount + " veces");
                }
            }
        }

        int totalWordCount = countWordInFiles();

        if(!folderFound){
            System.out.println("No se encuentra la carpeta indicada.");
        }else{
        System.out.println("Total: " + totalWordCount + " veces");
        }
    }
}