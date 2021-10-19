import java.io.InputStream;
import java.io.*;

public class CharacterExample {
 /*   Создать проект, позволяющий из одного текстового
  файла, содержащего несколько строк (тип String) заранее подготовленного текста на русском языке,
  построчно переписать в другой текстовый файл слова, отвечающие некоторому условию.
  Требования:
   – слова из предложения выделять методом split();
   – в новом файле следует указать номер строки, в которой искомые слова находились в исходном файле;
   – для каждой строки указать количество выбранных слов.*/
    /*
    Вариант 8. Переписать в результирующий файл слова с числом букв больше 5.
     */
    public static void main(String[] args) throws IOException{
        //Для чтения
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;
        // Для записи
        OutputStream out = null;
        Writer wr = null;
        try{
            in = new FileInputStream("C:\\Java\\src.txt");
            file = new InputStreamReader(in,"utf-8");
            buf = new BufferedReader(file);

            File f1 = new File("C:\\Java\\out.txt");
            if(f1.exists()) f1.delete();
            f1.createNewFile();
            out = new FileOutputStream(f1);
            wr = new OutputStreamWriter(out,"utf-8");
            String line = "";
            String [] words;
            while((line = buf.readLine())!=null){
                words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].length()>5){
                        System.out.print(words[i] + " ");
                        wr.append(words[i] + " ");
                    }
                }
                System.out.println("");
                wr.append("\n");
            }
        }
        catch (IOException io){
            io.printStackTrace();
        }
        finally {
            in.close();
            file.close();
            buf.close();
            wr.flush();
            wr.close();
            out.close();
        }
    }
}
