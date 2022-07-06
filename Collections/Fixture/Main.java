package Fixture;

public class Main {

    public static void main(String[] args) {


        FixtureGenerator fxGen = new FixtureGenerator();

        fxGen.getTeams().teamListGenerator();

        fxGen.getTeams().printTeamList();

        fxGen.setRound((fxGen.getTeams().getTeamList().size() - 1) * 2);

        fxGen.generateFixture(fxGen.getTeams().teamList);


    }
}
