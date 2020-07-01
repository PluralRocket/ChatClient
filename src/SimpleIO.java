import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

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

//        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)){   //try-with-resources
//            osw.write("String");
//            osw.append(" append");
//            osw.append(" NEWAPPEND");
//            osw.write(97);
//            osw.write('a');
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String s = "abcde";
//        int i = s.charAt(0);
//        System.out.println(i);

//        List<String> ll = new LinkedList<String>();
//        ll.add("one");
//        ll.add("two");
//        ll.add("three");
//        ll.add("abc");
//
//        List<Integer> intList = new LinkedList<Integer>();
//        intList.add(7);
//        intList.add(2);
//        intList.add(5);
//        intList.add(4);
//
////        System.out.println(ll.contains("one"));
////        ll.sort(Comparator.reverseOrder());
////        intList.sort(Comparator.naturalOrder());
//////        Iterator iterator = ll.listIterator();
////        Iterator intIterator = intList.listIterator();
//////        while (iterator.hasNext()){
//////            System.out.println(iterator.next());
//////        }
////        while (intIterator.hasNext()){
////            System.out.println(intIterator.next());
////        }
//
//        TreeSet<Integer> tree = new TreeSet<>();
//        tree.add(1);
//        tree.add(2);
//        tree.add(3);
//        tree.add(4);
//        tree.add(5);

        Integer[] array = new Integer[5];

        for (int i = 0; i<5;i++){
            array[i] = i+1;
        }

        int position = 0;

        for (Integer i : array) {
            System.out.println(array[position++]); // <- post-increment operator, starts at 0 not 1!
        }

//
//        Iterator treeIterator = tree.iterator();
//
//        while (treeIterator.hasNext()){
//            System.out.println(treeIterator.next());
//        }
//
//        System.out.println(tree.size());
//        System.out.println(tree.first());
//        System.out.println(tree.higher(3));
//        System.out.println(tree.lower(3));
//        tree.clear();
//        System.out.println(tree.size());


//        int x = 11;
//        int y = 9;
//
//        System.out.println(x&y);
//        System.out.println(x==0 && y==0);

    }

}


