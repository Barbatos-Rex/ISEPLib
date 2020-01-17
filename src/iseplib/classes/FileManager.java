package iseplib.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {

    //Creation methods

    public static void mkDir(String relativePath) {
        new File(relativePath).mkdir();
    }

    public static void fileCreator(String relativePath, String name, String extention) throws IOException {
        File ficheiro = new File(relativePath + "/" + name + "." + extention);
        try {
            Scanner verificador = new Scanner(ficheiro);
        } catch (FileNotFoundException e) {
            ficheiro.createNewFile();
        }
    }

    //Manager methods

    public static int countTheNumberOfLines(String relativePath) throws IOException {
        File ficheiro = new File(relativePath);
        Scanner cont = new Scanner(ficheiro);
        int nLines = 0;
        while (cont.hasNextLine()) {
            nLines++;
            cont.nextLine();
        }
        return nLines;
    }

    public static boolean fileExist(String relativePath) throws IOException {
        File ficheiro = new File(relativePath);
        return !ficheiro.createNewFile();
    }

    public static void cat(String relativePath) throws IOException {
        File ficheiro = new File(relativePath);
        int nLines = countTheNumberOfLines(relativePath);
        String[] fileCont = new String[nLines];
        Scanner cont = new Scanner(ficheiro);
        for (int i = 0; i < nLines; i++) {
            fileCont[i] = cont.nextLine();
        }
        cont.close();
        for (String str : fileCont) {
            System.out.println(str);
        }

    }

    public static void clear(String relativePath) {
        File toClean = new File(relativePath);
        try {
            PrintWriter cleanner = new PrintWriter(toClean);
            cleanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("That file does not exist.");
        }
    }

    public static void fileWriter(String relativePath, String content) throws IOException {
        File ficheiro = new File(relativePath);
        int nLines = countTheNumberOfLines(relativePath);
        String[] fileCont = new String[nLines];
        Scanner cont = new Scanner(ficheiro);
        for (int i = 0; i < nLines; i++) {
            fileCont[i] = cont.nextLine();
        }
        cont.close();
        PrintWriter escritor = new PrintWriter(ficheiro);
        for (String line : fileCont) {
            escritor.println(line);
        }
        escritor.println(content);
        escritor.close();
    }

    public static void copyFile(String relativePathOldFile, String newDir, String newName, String newExtention) throws IOException {
        File oldFile = new File(relativePathOldFile);
        File newFile = new File(newDir + "/" + newName + "." + newExtention);
        Scanner cont = new Scanner(oldFile);
        PrintWriter escritor = new PrintWriter(newFile);
        while (cont.hasNextLine()) {
            escritor.println(cont.nextLine());
        }
        escritor.close();
        cont.close();
    }

    //Erase methods

    private static void rm(String relativePath) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Pretende eliminar este diretório, juntamente com todo o seu conteúdo? (s/n): ");
        String resposta = teclado.nextLine();
        switch (resposta.toLowerCase()) {
            case "s":
            case "sim":
            case "y":
            case "yes":
                System.out.println("A apagar todo o conteúdo do diretório...");
                File dir = new File(relativePath);
                String[] contentOfDir = dir.list();
                try {
                    for (String fileName : contentOfDir) {
                        File currentFile = new File(relativePath + "/" + fileName);
                        currentFile.delete();
                    }
                } catch (NullPointerException e) {
                    dir.delete();
                }
                dir.delete();
                System.out.println("Diretório apagado!");
                break;
            case "n":
            case "no":
            case "nao":
            case "não":
                break;
            default:
                System.out.println("Nenhuma opção válida!");
                System.out.println("O diretório não será apagado.");
        }
    }

    public static void lineEraser(String relativePath,int line) throws IOException{
        File ficheiro = new File(relativePath);
        int nLines=countTheNumberOfLines(relativePath);
        String[] fileCont = new String[nLines-1];
        Scanner cont = new Scanner(ficheiro);
        for(int i=0;i<line-1;i++){
            fileCont[i]=cont.nextLine();
        }
        cont.nextLine();
        for(int i=line-1;i<nLines-1;i++){
            fileCont[i] = cont.nextLine();
        }
        cont.close();
        PrintWriter escritor = new PrintWriter(ficheiro);
        for (String linha : fileCont) {
            escritor.println(linha);
        }
        escritor.close();

    }

    private static void fileDeleter(String filePath) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Are you sure you want to delete a file (y/n): ");
        String awnser = keyboard.nextLine();
        if ("y".equals(awnser)) {
            File file = new File(filePath);
            System.out.println(file.delete());

        }

    }
}