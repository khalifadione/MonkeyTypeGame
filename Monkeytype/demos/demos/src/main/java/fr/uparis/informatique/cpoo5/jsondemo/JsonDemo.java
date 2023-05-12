package fr.uparis.informatique.cpoo5.jsondemo;

import com.google.gson.Gson;

class Truc {
    int a = 15;
    String b = "Hello";

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Truc: a is " + a + " and b is " + b;
    }
}

public class JsonDemo {
    public static void main(String[] args) {
        var gson = new Gson();

        // sérialisation
        var truc = new Truc();
        System.out.println(gson.toJson(truc));

        // dé-sérialisation
        Truc machin = gson.fromJson("{\"a\":56,\"b\":\"Bye\"}", Truc.class);
        System.out.println(machin);
    }
}
