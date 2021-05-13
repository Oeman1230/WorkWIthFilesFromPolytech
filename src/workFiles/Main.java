package workFiles;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here\
        String FILE_NAME = "some.txt";

        readFileToConsole(FILE_NAME);
    }

    public static void readFileToConsole(String fileName)throws IOException {

        /*Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).forEach(System.out::println);
        Files.createDirectory(Paths.get(fileName));
        Files.createDirectories(Paths.of(fileName));
        Files.createTempDirectory();
        Files.delete();
        Files.move();
        Files.copy();
        Files.isDirectory();
        Files.exists();
        Files.readString();
        Files.readAllLines();
        Files.write();
        Files.writeString();
        DirectoryStream<String> directoryStream = Files.newDirectoryStream();*/

        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("."))){
            directoryStream.forEach(System.out::println);
        }catch (IOException e){
            System.out.println("ai");
        }
        //Сериализация
       /* try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("User.dat"))){
            String user = "UserName";
            oos.writeObject(user);
        }catch (IOException e)
        {

        }*/
        //десериализация
        try(ObjectInputStream inp = new ObjectInputStream(new FileInputStream("user.dat"))){
            String o = (String) inp.readObject();
            System.out.println(o);
        }catch(Exception e){

        }
    }

    public static String readFile (String fileName)
    {

        BufferedReader bufferedReader = null;
        try
        {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), Charset.forName("UTF-8")));
            String line;
            StringBuilder bf = new StringBuilder();
            while((line = bufferedReader.readLine())!= null)
            {
                bf.append(line);
            }
            return bf.toString();
        } catch (IOException e)
        {

        }
        finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                }catch (IOException e)
                {

                }
            }
        }
       return "Darova" ;
    }
    /*public String readFile(String filename){
    InputStreamReader in = null;
    try {
    in = new InputStreamReader(new FileInputStream(new File(filename)), Charset.UTP_8;
    LineIterator it = new LineIterator(in);
    StringBuilder sb = bew StringBuilder();
    While(it.hasNext()){
    sb.append(it.NextLine());
    }
    return sb.toString;
    }catch (IOException ex){
    }
    finally{
    IOFile.close
    */
    public String readFileJava7(String filename) {
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filename), StandardCharsets.UTF_8))){
            String line;
            StringBuilder bf = new StringBuilder();
            while((line = bufferedReader.readLine())!= null)
            {
                bf.append(line);
            }

        }catch (IOException e)
        {

        }
        return "Privet";
    }
    public String readFileJava7_1(String fileName){
        try{
            StringBuilder sb = new StringBuilder();
            List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            for(String line: lines)
            {
                sb.append(line);
            }
        }catch (IOException e)
        {

        }
        return "Kak dela?";
    }


}
