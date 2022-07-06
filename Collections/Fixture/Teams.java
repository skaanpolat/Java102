package Fixture;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Teams {


    public Teams(){};


    public List<String> getTeamList() {
        return teamList;
    }

    List<String> teamList = new LinkedList<>();



    public void teamListGenerator(){

        teamList.add("Trabzonspor");
        teamList.add("Başakşehir");
        teamList.add("Beşiktaş");
        teamList.add("Galatasaray");
        teamList.add("Fenerbahçe");
        teamList.add("Bursaspor");
//        teamList.add("Gençlerbirliği");

        if (this.teamList.size()%2!=0){
            teamList.add("Bay");
        }

        Collections.shuffle(teamList);

    }



    public void printTeamList(){
        System.out.println("Takımlar: ");
        for (String team: teamList) {
            System.out.println(team);
        }

    }



}
