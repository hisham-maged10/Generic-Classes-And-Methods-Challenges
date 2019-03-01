package Generics;
import java.util.Set;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.InputMismatchException;
public class Team<T extends Player> implements Comparable<Team<T>>{
    private Set<T> players;
    private int score;
    private int won;
    private int lost;
    private String name;
    public Team(String name,T[] players)
    {
        this.players=players==null?
        new LinkedHashSet<>():
        new LinkedHashSet<>(Arrays.asList(players));
         if(name==null)
            throw new NullPointerException("Name can't be null");
        if(name.length()<2)
            throw new InputMismatchException("Name can't be less than 2 letters");
        this.name=name;
        this.won=0;
        this.lost=0;
    }

    public Team(String name)
    {
        this(name,null);
    }

    public String getName()
    {
        return this.name;
    }

    private int computeScore()
    {
        return this.score=won*2-lost;
    }

    public int getScore()
    {
        return this.score;
    }
    public boolean containsPlayer(T player)
    {
        return this.players.contains(player);
    }

    public Set<T> getPlayers()
    {
        return this.players;
    }

    public boolean addPlayer(T player)
    {
        return this.players.add(player);
    }
    public void win()
    {
        ++this.won;
        this.computeScore();
    }
    public void lose()
    {
        ++this.lost;
        this.computeScore();
    }

    public boolean compete(Team<T> anotherTeam)
    {
        if(Math.random()>0.5)
        {
            this.win();
            anotherTeam.lose();
            return true;
        }
        else{
            this.lose();
            anotherTeam.win();
            return false;
        }
    }

    public boolean removePlayer(T player)
    {
        return this.players.remove(player);
    }

    public Iterator<T> iterator()
    {
        return this.players.iterator();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o)
    {
        return ((Team<T>)o).getPlayers().equals(this.players);
    }

    @Override
    public String toString()
    {
        return this.name+": "+this.score;
    }

    @Override
    public int hashCode()
    {
        return this.players.hashCode();
    }

    @Override
    public int compareTo(Team<T> anotherTeam)
    {
        return Integer.compare(this.score,anotherTeam.score);
    }

}