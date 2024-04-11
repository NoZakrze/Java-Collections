package org.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Mage implements Comparable<Mage>
{
    private String name;
    private int level;
    private double power;
    private Set<Mage> apprentices;

    public Mage(String name, int level, double power)
    {
        this.name = name;
        this.level = level;
        this.power = power;
        this.apprentices = null;
    }

    public void setApprentices(Set<Mage> apprentices) {
        this.apprentices = apprentices;
    }

    public String getName()
    {
        return this.name;
    }

    public double getPower()
    {
        return power;
    }

    public int getLevel()
    {
        return level;
    }
    public Set<Mage> getApprentices()
    {
        return apprentices;
    }

    @Override
    public int hashCode()
    {
        int dhs = Double.hashCode(power);
        int hash =  name.hashCode() + dhs + level*13903 + 23;
        return hash;
    }

    public boolean equals(Mage m)
    {
        if(m.hashCode() == this.hashCode())
        {
            for (Mage m1:apprentices)
            {
                boolean czy = false;
                for(Mage m2:m.getApprentices())
                {
                   if(m1.equals(m2))
                       czy= true;

                }
                if (!czy)
                {
                    return  false;
                }
            }
            return true;
        }
        else
            return false;
    }

    @Override
    public int compareTo(Mage o)
    {
        if(this.name.compareTo(o.getName()) < 0)
        {
            return -1;
        }
        if(this.name.compareTo(o.getName()) > 0)
        {
            return 1;
        }
        else    //2 kryterium
        {
            if(this.level > o.getLevel())
                return -1;
            else if(this.level < o.getLevel())
                return 1;
            else    //3 kryterium
            {
                if(this.power > o.getPower())
                    return -1;
                else if(this.power < o.getPower())
                    return 1;
                else
                    return 0;
            }

        }
    }
    public String toString()
    {
        return "Mage{name=" + name + ", level=" + level + ", power=" + power + "}";
    }

    public void Print(int glebia)
    {
        String output = "";
        for(int i=0;i<glebia;i++)
        {
            output=output + "-";
        }
        output = output + this.toString();
        System.out.println(output);
        if(apprentices != null)
        {
            for (Mage m : apprentices) {
                m.Print(glebia + 1);
            }
        }
    }

    public int childrens()
    {
        int w = 0;
        if(apprentices != null)
        {
            for (Mage a : apprentices) {
                w = w + 1 + a.childrens();
            }
        }
        return w;
    }

    public void addToMap(Map<Mage, Integer> map)
    {
        map.put(this,this.childrens());
        if(apprentices != null) {
            for (Mage a : apprentices) {
                a.addToMap(map);
            }
        }
    }

}
