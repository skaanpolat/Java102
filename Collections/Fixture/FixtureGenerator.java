package Fixture;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FixtureGenerator {

    private Teams teams;
    private int round;

    public FixtureGenerator(Teams teams) {
        this.teams = teams;
    }

    public FixtureGenerator() {
        this.teams = new Teams();


    }

    public Teams getTeams() {
        return this.teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void generateFixture(List<String> teamList) {

        List<String> teamListSchedule = new LinkedList<>();
        List<String> teamListTemp = new LinkedList<>(teamList);


        for (int i = 1; i < this.getRound() / 2 + 1; i++) {

            for (int k = 0; k <= (teamList.size() / 2)+2; k += 2) {
                teamListSchedule.add((teamListTemp.get(k)) + " vs " + teamListTemp.get(k + 1));
            }

            teamListTemp.add(1, teamListTemp.get(teamList.size() / 2));
            teamListTemp.add(teamList.size() / 2, teamListTemp.get(teamListTemp.size() - 1));
            teamListTemp.remove(teamListTemp.size() - 1);
            teamListTemp.remove(teamListTemp.size() - 2);

        }



        for (int i = this.getRound() /2 + 2; i <= this.getRound() + 1; i++) {


            for (int k = 0; k <= (teamList.size()/2) + 2; k+=2) {
                teamListSchedule.add((teamListTemp.get(k + 1)) + " vs " + teamListTemp.get(k));
            }

            teamListTemp.add(1, teamListTemp.get(teamList.size() / 2));
            teamListTemp.add(teamList.size() / 2, teamListTemp.get(teamListTemp.size() - 1));
            teamListTemp.remove(teamListTemp.size() - 1);
            teamListTemp.remove(teamListTemp.size() - 2);

        }

        int counter = 0;
        int num;

        for (int i = 1; i <= this.getRound(); i++) {
            System.out.println("*******"+ i+". Round *******");
            List<String> temp = new LinkedList<>();

            for (int n = counter; n < counter + (teamList.size() / 2); n++) {
                temp.add(teamListSchedule.get(n));
            }
            for (int m = 0; m < teamList.size() / 2; m++) {
                num = new Random().nextInt(temp.size());
                System.out.println(temp.get(num));
                temp.remove(num);
            }

            counter += teamList.size() / 2;

        }

    }
}

