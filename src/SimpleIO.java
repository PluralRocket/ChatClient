import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SimpleIO {

    public static void main(String[] args) /*throws IOException*/ {

        /*
        System.out.print("Enter letter: ");
        int letter = 0;
        while ((letter = System.in.read()) != '\n') {
            System.out.println(letter);
            System.out.println((char) letter);
        }*/

        /*int test = 97;

        // "" -> String literal
        // '' -> char ('abc' [x], "abc" [ok])
        if ((test) == 'a') {System.out.println("True");}

        System.out.println((test = test + 3) + 3);*/

        /* Input stream reads bytes returns int
        int letter1 = System.in.read();
        int letter2 = System.in.read();
        int letter3 = System.in.read();
        System.out.println(letter1);
        System.out.println(letter2);
        System.out.println(letter3);
        */

        /*InputStreamReader isr = new InputStreamReader(System.in);
        System.out.println("Enter letter: ");
        int letter = 0;
        while((letter = isr.read())!='\n'){
            System.out.println(letter);
            System.out.println((char) letter);
        }
        isr.close();
        */

        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter sentence: ");
        String sentence = br.readLine(); // readLine() returns String
        System.out.print("Enter letter: ");
        int letter = br.read(); // read() returns int
        System.out.println(sentence);
        System.out.println(letter);
        br.close();*/

        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)){   //try-with-resources
            osw.write("String");
            osw.append(" append");
            osw.write(97);
            osw.write('a');

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


