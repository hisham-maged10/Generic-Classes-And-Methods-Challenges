package Generics;
import java.util.InputMismatchException;
public abstract class Player{
    private String name;
    private int number;
    public Player(String name,int number)
    {
        if(name==null)
            throw new NullPointerException("Name can't be null");
        if(name.matches(".*[//d//W_]+.*") ||name.length() <2 || number<0)
            throw new InputMismatchException("Incorrect input, name must be of 2 letters(can't have any digits or symbols or underscore) atleast & number must be positive");
        this.name=name;
        this.number=number;
    }

    public String getName()
    {
        return this.name;
    }
    public int getNumber()
    {
        return this.number;
    }
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Player))
            return false;
        if(this==o)
            return true;
        return ((Player)o).getNumber()==this.number;
    }
}