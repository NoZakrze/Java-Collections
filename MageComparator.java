package org.example;

import java.util.Comparator;

public class MageComparator implements Comparator<Mage> {

    @Override
    public int compare(Mage o1, Mage o2)
    {
        if(o1.getLevel() > o2.getLevel())
        {
            return -1;
        }
        if(o1.getLevel() < o2.getLevel())
        {
            return 1;
        }
        else    //2 kryterium
        {
            if(o1.getName().compareTo(o2.getName()) < 0)
                return -1;
            else  if(o1.getName().compareTo(o2.getName()) > 0)
                return 1;
            else    //3 kryterium
            {
                if(o1.getPower() > o2.getPower())
                    return -1;
                else if(o1.getPower() < o2.getPower())
                    return 1;
                else
                    return 0;
            }

        }
    }
}
