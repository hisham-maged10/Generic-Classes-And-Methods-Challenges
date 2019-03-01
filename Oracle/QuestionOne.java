package Oracle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public final class QuestionOne{

    public static <T> int countIf(Collection<T> collection)
    {
        int count=0;
        Integer temp=null;
        for(Iterator<T> it=collection.iterator();it.hasNext();)
            if((temp=(Integer)it.next())%2==1 || (temp.toString().length()>1 &&new StringBuilder(temp.toString()).reverse().toString().equals(temp.toString())))
                ++count;
        return count;
    }
    public static <T> boolean exchange(T[] arr,int from,int to)
    {
        if(from<0 || from>=arr.length || to<0 || to>=arr.length || to==from)
            return false;
        else
        {
            T temp=arr[from];
            arr[from]=arr[to];
            arr[to]=temp;
            return true;
        }
    }
    public static <T extends Comparable<T>> T findMax(List<? extends T> elements,int begin,int end)
    {
        if(begin<0 || begin>=elements.size() || end<0 || end>=elements.size() || end<begin)
            return null;
        if(begin==end)
            return elements.get(begin);
        T max=elements.get(begin);
        for(T e:elements.subList(begin+1,end+1))
        {
            if(max.compareTo(e)<0)
                max=e;
        }
        return max;
    }
    public static <T extends Comparable<T>> void sortPrint(List<? extends T> list)
    {
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
    public static void main(String[] args)
    {
        // QuestionOne.one();
        // QuestionOne.two();
        QuestionOne.three();
        // QuestionOne.four();
    }
    public static void one()
    {
        System.out.println(countIf(new ArrayList<Integer>(Arrays.asList(new Integer[]{2,3,4,5,7,111,121,454,122,352,788}))));
    }
    public static void two()
    {
        String[] x={"Hisham","is","Awesome","Ya","Zmely"};
        System.out.println(exchange(x,0,4));
        for(String e:x)
            System.out.println(e);
    }
    public static void three()
    {
        List<Integer> list2=Arrays.asList(new Integer[]{9,5,10,42,58,234,8345,934,2,5,6,9,9,8,7,6,5,4,4,5,6,7,6,8,5,4,34,5});
        List<String> list=new ArrayList<>(Arrays.asList(new String[]{"a","b","c","d","e","f","g","h","i","j","k"}));
        System.out.println(findMax(list,5,list.size()-1));
        System.out.println(findMax(list2,0,list2.size()-1));
    }
    public static void four()
    {
        List<Integer> list=Arrays.asList(new Integer[]{9,5,10,42,58,234,8345,934,2,5,6,9,9,8,7,6,5,4,4,5,6,7,6,8,5,4,34,5});
        sortPrint(list);
    }
}