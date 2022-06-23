public class Main {
    public static void main(String[] args) {
        System.out.println("RUN!");

        Generics<Integer> list = new Generics<>();
//
//        System.out.println("Dizinin Kapasitesi : " + list.getCapacity());
//        System.out.println("Dizideki Eleman Sayısı : " +list.size());
//
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        list.add(40);
//
//        System.out.println("Dizinin Kapasitesi : " + list.getCapacity());
//        System.out.println("Dizideki Eleman Sayısı : " +list.size());
//
//        list.add(50);
//        list.add(60);
//        list.add(70);
//        list.add(80);
//        list.add(90);
//        list.add(100);
//        list.add(110);
//
//        System.out.println("Dizinin Kapasitesi : " + list.getCapacity());
//        System.out.println("Dizideki Eleman Sayısı : " +list.size());


//        list.add(10);
//        list.add(20);
//        list.add(30);
//        System.out.println("2. indisteki değer : " + list.getByIndex(2));
//        list.remove(2);
//        list.add(40);
//        list.set(0,100);
//        System.out.println("2. indisteki değer : " + list.getByIndex(2));
//        System.out.println(list.toString());

        System.out.println("Liste Durumu : " + (list.isEmpty() ? " Boş " : " Dolu"));
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(20);
        list.add(50);
        list.add(60);
        list.add(70);
        System.out.println("Liste Durumu : " + (list.isEmpty() ? " Boş " : " Dolu"));

        System.out.println(list.indexOf(20));

        System.out.println(list.indexOf(100));

        System.out.println(list.lastIndexOf(20));

        Object[] dizi = list.toArray();
        System.out.println("Object dizisinin ilk elemanı : " + dizi[0]);

        Generics<Integer> altListem = list.sublist(0, 3);

        System.out.println(altListem.toString());
        System.out.println("Listemde 20 değeri : " + list.contains(20));
        System.out.println("Listemde 20 değeri : " + list.contains(120));
        list.clear();
        System.out.println(list.toString());


    }
}
