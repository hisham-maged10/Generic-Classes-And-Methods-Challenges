package Generics;
public class TestRunner{
    public static void main(String[] args)
    {
        TestRunner.initialize();
    }

    public static void initialize()
    {
        Team<FootballPlayer> footballTeam1=new Team<>("The FB team",new FootballPlayer[]{new FootballPlayer("zozo",1),new FootballPlayer("zozo",2),new FootballPlayer("zizoi",3)});
        Team<FootballPlayer> footballTeam2=new Team<>("The FB Team 2",new FootballPlayer[]{new FootballPlayer("zozo",1),new FootballPlayer("zozo",2),new FootballPlayer("zizoi",3)});
        Team<BaseballPlayer> baseballTeam1=new Team<>("The BB Team",new BaseballPlayer[]{new BaseballPlayer("zozo",1),new BaseballPlayer("zozo",2),new BaseballPlayer("zizoi",3)});
        Team<BaseballPlayer> baseballTeam2=new Team<>("The BB Team 2",new BaseballPlayer[]{new BaseballPlayer("zozo",1),new BaseballPlayer("zozo",2),new BaseballPlayer("zizoi",3)});
        Team<HandballPlayer> handballTeam1=new Team<>("The HB Team",new HandballPlayer[]{new HandballPlayer("zozo",1),new HandballPlayer("zozo",2),new HandballPlayer("zizoi",3)});
        Team<HandballPlayer> handballTeam2=new Team<>("The HB Team 2",new HandballPlayer[]{new HandballPlayer("zozo",1),new HandballPlayer("zozo",2),new HandballPlayer("zizoi",3)});
        
        League<Team<FootballPlayer>> league1=new League<>("The knuckles FB");
        League<Team<BaseballPlayer>> league2=new League<>("The knuckles BB");
        League<Team<HandballPlayer>> league3=new League<>("The knuckles HB");

        league1.addTeam(footballTeam1);
        league1.addTeam(footballTeam2);
        league2.addTeam(baseballTeam1);
        league2.addTeam(baseballTeam2);
        league3.addTeam(handballTeam1);
        league3.addTeam(handballTeam2);

        for(int i=0;i<100;i++)
        {
            footballTeam1.compete(footballTeam2);
            baseballTeam1.compete(baseballTeam2);
            handballTeam1.compete(handballTeam2);
        }

        league1.printTeams();
        league2.printTeams();
        league3.printTeams();
        
        

    }
}