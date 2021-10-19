import java.io.*;
import java.util.Scanner;
/*Требования:
        – слова из предложения выделять методом split();
        – в новом файле следует указать номер строки, в которой искомые слова находились в исходном файле;
        – для каждой строки указать количество выбранных слов.*/

/* Вариант 5
 Переписать в результирующий файл слова-палиндромы.*/

public class MyClass {
    public static boolean checkWordPal(String str) throws IOException{
        int len = str.length();
        for (int i = 0; i < len/2; ++i) {
            if(str.charAt(i)!=str.charAt(len-i-1)){
                return false;
            }
        }
        // String
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputStream in;
        Reader file = null;
        BufferedReader buf = null;

        OutputStream out = null;
        Writer wr = null;
        try {
            in = new FileInputStream("C:\\Java src\\src.txt");
            file = new InputStreamReader(in, "utf-8");
            buf = new BufferedReader(file);

            File f1 = new File("C:\\Java src\\result.txt");
            if (f1.exists()) f1.delete();
            f1.createNewFile();
            if (f1.exists()) {
                out = new FileOutputStream(f1);
                wr = new OutputStreamWriter(out);
                String line = " ";
                int numline = 1;
                String[] words;
                while ((line = buf.readLine()) != null) {
                    wr.write(numline);
                    words = line.split(" ");
                    int count = 0;
                    for (int i = 0; i < words.length; i++) {
                        if(checkWordPal(words[i])) {
                            System.out.println(words[i] + " ");
                            wr.write(words[i]);

                        }
                    }
                }
            }
        } catch (IOException e) {

        }
    }
}
