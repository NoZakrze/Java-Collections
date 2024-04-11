package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {

        Set<Mage> mags;
        Set<Mage> app1;
        Set<Mage> app2;
        Map<Mage,Integer> map;
        Mage mag1 = new Mage("Marek",12, 2.0);
        Mage mag2 = new Mage("Czarek",12, 3.0);
        Mage mag3 = new Mage("Jarek",11, 2.0);
        Mage mag4 = new Mage("Pawel",2, 1.0);
        Mage mag5 = new Mage("Piotrek",6, 5.0);
        Mage mag6 = new Mage("Medi",8, 3.0);
        Mage mag7 = new Mage("Bolek",13, 9.0);
        Mage mag8 = new Mage("Karol",6, 2.0);
        Mage mag9 = new Mage("Alek",1, 3.0);
        Mage mag10 = new Mage("Boleslaw",3, 6.0);
        if (Objects.equals(args[0], "1"))
        {
            mags = new  TreeSet<Mage>();
            app1 = new  TreeSet<Mage>();
            app2 = new  TreeSet<Mage>();
            map = new   TreeMap<Mage,Integer>();
        }
         else if (Objects.equals(args[0], "2"))
        {
            MageComparator comp = new MageComparator();
            mags = new  TreeSet<Mage>(comp);
            app1 = new  TreeSet<Mage>(comp);
            app2 = new  TreeSet<Mage>(comp);
            map = new   TreeMap<Mage,Integer>(comp);

        }
       else
        {
            mags = new  HashSet<Mage>();
            app1 = new  HashSet<Mage>();
            app2 = new  HashSet<Mage>();
            map = new   HashMap<Mage,Integer>();
        }
        mags.add(mag1);
        mags.add(mag2);
        mags.add(mag3);
        mags.add(mag9);
        mags.add(mag10);
        app1.add(mag4);
        app1.add(mag5);
        app1.add(mag6);
        app2.add(mag7);
        app2.add(mag8);
        mag1.setApprentices(app1);
        mag4.setApprentices(app2);

        for (Mage m:mags)
        {
            m.addToMap(map);
            m.Print(1);
        }

        System.out.println("Map:");
        for (Map.Entry<Mage, Integer> m: map.entrySet())
        {
            System.out.println(m.getKey() + " " + m.getValue() );
        }

    }
}