import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TestList {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("pierwszy");
        lista.add("drugi");
        lista.add("trzeci");

        List<String> subList2 = lista.stream().collect(toList()).subList(2,3);
        List<String> subList1 = lista.stream().collect(toList()).subList(0,2);

        System.out.println(lista);
        System.out.println(subList1);
        System.out.println(subList2);
        System.out.println();

        subList1.remove(0);
        System.out.println(lista);
        System.out.println(subList1);
        System.out.println(subList2);

    }

    public static void main2(String[] args) {
        //to nie dziala blad
        List<String> lista = new ArrayList<>();

        lista.add("pierwszy");
        lista.add("drugi");
        lista.add("trzeci");

        List<String> subLista1 = lista.subList(0,2);
        List<String> subLista2 = lista.subList(2,3);

        System.out.println(lista);
        System.out.println(subLista1);
        System.out.println(subLista2);
        System.out.println();

        subLista1.remove(0);
        System.out.println(lista);
        System.out.println(subLista1);
        System.out.println(subLista2);
    }
}
