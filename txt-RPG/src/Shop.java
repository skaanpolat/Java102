public class Shop extends SafeLocation {

    public Shop(Player player) {
        super(player, "Mağaza");

    }

    @Override
    public boolean onLocation() {

        System.out.println("Mağazaya Hoş Geldin!\n");

        boolean showMenu = true;

        while (showMenu) {
            System.out.println("1) Silahlar\n" +
                    "2) Zırhlar\n" +
                    "3) Çıkış Yap\n");

            int actionChoice = scanner.nextInt();

            while (actionChoice < 1 || actionChoice > 3) {
                System.out.println("Lütfen geçerli bir seçim yapın!!");
                actionChoice = scanner.nextInt();
            }

            switch (actionChoice) {

                case 1:
                    weaponsInShop();
                    buyWeapon();

                    break;

                case 2:
                    armorsInShop();
                    buyArmor();

                    break;
                case 3:
                    System.out.println("Yine beklerim..");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }


    public void buyWeapon() {

        System.out.println("Satın almak istediğin silahı seç.");
        int playerWeaponChoice = scanner.nextInt();

        while (playerWeaponChoice < 1 || playerWeaponChoice > Weapon.weapons().length) {
            System.out.println("Lütfen geçerli bir seçim yap!");
            playerWeaponChoice = scanner.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponByID(playerWeaponChoice);

        if (selectedWeapon != null) {

            if (selectedWeapon.getPrice() > this.getPlayer().getPlayerMoney()) {
                System.out.println("Bakiye yetersiz!\n");
            } else {
                System.out.println(selectedWeapon.getName() + " artık senin!");

                int balance = this.getPlayer().getPlayerMoney() - selectedWeapon.getPrice();
                this.getPlayer().setPlayerMoney(balance);

                System.out.println("Kalan paranız : " + this.getPlayer().getPlayerMoney());
                System.out.println("Önceki silahın : " + this.getPlayer().getInventory().getWeapon().getName());

                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Yeni silahın : " + this.getPlayer().getInventory().getWeapon().getName() + "\n");

            }
        }

    }

    public void buyArmor() {

        System.out.println("Satın almak istediğin zırhı seç.");
        int playerArmorChoice = scanner.nextInt();

        while (playerArmorChoice < 1 || playerArmorChoice > Armor.armors().length) {
            System.out.println("Lütfen geçerli bir seçim yap!");
            playerArmorChoice = scanner.nextInt();
        }

        Armor selectedArmor = Armor.getArmorByID(playerArmorChoice);

        if (selectedArmor != null) {

            if (selectedArmor.getPrice() > this.getPlayer().getPlayerMoney()) {
                System.out.println("Bakiye yetersiz!\n");
            } else {
                System.out.println(selectedArmor.getName() + " zırh artık senin!");

                int balance = this.getPlayer().getPlayerMoney() - selectedArmor.getPrice();
                this.getPlayer().setPlayerMoney(balance);

                System.out.println("Kalan paranız : " + this.getPlayer().getPlayerMoney());
                System.out.println("Önceki Zırhın : " + this.getPlayer().getInventory().getArmor().getName());

                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Yeni Zırhın : " + this.getPlayer().getInventory().getArmor().getName() + "\n");

            }
        }

    }

    public void weaponsInShop() {
        System.out.println("Elimde bu silahlar var:\n");

        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + ") " + weapon.getName() + " | Hasar : " + weapon.getDamage() + " | Fiyat : " + weapon.getPrice());

        }

        System.out.println();


    }

    public void armorsInShop() {
        System.out.println("Elimde bu zırhlar var:\n");

        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + ") " + armor.getName() + " | Defans : " + armor.getDefenseValue() + " | Fiyat : " + armor.getPrice());
        }
//        System.out.println("1) Hafif Zırh | Direnç : 1 | Fiyat : 15\n" +
//                "2) Orta Zırh | Direnç : 3 | Fiyat : 25\n" +
//                "3) Ağır Zırh | Direnç : 5 | Fiyat : 40\n");
        System.out.println();
    }

}
