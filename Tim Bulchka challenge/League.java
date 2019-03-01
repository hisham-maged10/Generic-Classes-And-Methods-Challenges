package Generics;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.InputMismatchException;
import java.util.Collections;
public class League<T extends Team>{
    private List<T> leagueTeams;
    private T topTeam;
    private T bottomTeam;
    private String name;
    public League(String name,T[] teams)
    {
        leagueTeams=teams==null?
        new ArrayList<>():
        new ArrayList<>(Arrays.asList(teams));
        if(name==null)
            throw new NullPointerException("Name can't be null");
        if(name.length()<=2)
            throw new InputMismatchException("Name can't be less than 3 letters");
        this.name=name;
    }
    public League(String name)
    {
        this(name,null);
    }
    public String getName()
    {
        return this.name;
    }
    public List<T> getTeams()
    {
        return this.leagueTeams;
    }
    public boolean containsTeam(T anotherTeam)
    {
        return this.leagueTeams.contains(anotherTeam);
    }
    public ListIterator<T> listIterator()
    {
        return this.leagueTeams.listIterator();
    }
    public Iterator<T> iterator()
    {
        return this.leagueTeams.iterator();
    }
    public boolean addTeam(T team)
    {
        return this.leagueTeams.add(team);
    }
    public boolean removeTeam(T team)
    {
        return this.leagueTeams.remove(team);
    }
    //overload
    public T removeTeam(int index)
    {
        return this.leagueTeams.remove(index);
    }

    public T getBottomTeam()
    {
        return this.bottomTeam;
    }

    public T getTopTeam()
    {
        return this.topTeam;
    }
    
    public void printTeams()
    {
        Collections.sort(leagueTeams,Collections.reverseOrder());
        for(T e : this.leagueTeams)
        {
            System.out.println(e);
        }

    }
    public int size()
    {
        return this.leagueTeams.size();
    }
    @Override
    public String toString(){
        return this.name+": "+this.leagueTeams.toString();
    }

    @Override
    public int hashCode()
    {
        return this.leagueTeams.hashCode();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o)
    {
        if(!(o instanceof League))
            return false;
        else if(this==o)
            return true;
        else
            return ((League<T>)o).getTeams().equals(this.leagueTeams);
    }

}