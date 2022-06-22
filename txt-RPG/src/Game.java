import java.util.Scanner;

public class Game {


    public void run() {

        Location location = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Adaya Hoş Geldin!\nİsmin nedir? : ");
        Player player = new Player(scanner.nextLine());

        System.out.println(player.getPlayerName() + "...\nGüzel isim...\n" +
                "Bakalım BU SEFERKİ " + player.getPlayerName().toUpperCase() + " ne kadar yaşayacak ? :/\n" +
                "\nHangi karakter sana daha uygun?");

        player.charSelector();

        while (true) {

            player.shortPlayerInfo();

            System.out.println("Gitmek istediğin yeri seç :\n" +
                    "1) Güvenli Ev\n" +
                    "2) Mağara\n" +
                    "3) Orman\n" +
                    "4) Nehir\n" +
                    "5) Mağaza\n" +
                    "6) Maden\n" +
                    "0) Oyunu Kapat");

            int playerLocationChoice = scanner.nextInt();

            switch (playerLocationChoice) {


                case 1:

                    location = new SafeHouse(player);

                    break;

                case 2:

                    if (!player.getInventory().isFood()) {
                        location = new Cave(player);

                    } else {
                        System.out.println("Bu bölge temiz ve ödül 'Yemek' alındı. Tekrar giremezsin!");
                        location = new SafeHouse(player);
                    }
                    break;

                case 3:

                    if (!player.getInventory().isWood()) {
                        location = new Forest(player);

                    } else {
                        System.out.println("Bu bölge temiz ve ödül 'Odun' alındı. Tekrar giremezsin!");
                        location = new SafeHouse(player);
                    }
                    break;

                case 4:

                    if (!player.getInventory().isWater()) {
                        location = new River(player);
                    } else {
                        System.out.println("Bu bölge temiz ve ödül 'Su' alındı. Tekrar giremezsin!");
                        location = new SafeHouse(player);

                    }
                    break;

                case 5:
                    location = new Shop(player);

                    break;
                case 6:
                    location = new Mine(player);

                    break;
                case 0:
                    location = null;
                    break;

                default:
                    System.out.println("Geçerli bir seçim yapmadın. Sizi güvenli bir yere alalım.\n");
                    location = new SafeHouse(player);


            }
            if (location == null) {
                System.out.println("Oyunu sonlandırdınız! Görüşmek üzere!!!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("ÖLDÜN! OYUN BİTTİ!!\n\n!!!GAME OVER!!!");
                break;
            }

            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInventory().isWater() && player.getInventory().isFood() && player.getInventory().isWood()) {
                    System.out.println("******************************TEBRİKLER******************************\n" +
                            "                  !!!OYUNU BAŞARIYLA TAMAMLADINIZ!!!\n\n");


                    break;
                }

            }

        }


    }
}
