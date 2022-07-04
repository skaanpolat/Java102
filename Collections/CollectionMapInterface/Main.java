package CollectionMapInterface;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {


        TreeSet<Book> bookSet = new TreeSet<>(new OrderByBookNameComparator());

        Book book1 = new Book("El yazması", 234, "Ali", "08-12-1996");
        Book book2 = new Book("Denemeler", 456, "Orhan", "03-11-1976");
        Book book3 = new Book("Okul", 384, "Hakan", "07-05-1999");
        Book book4 = new Book("Baba ve Tamir", 426, "Celal", "17-07-1972");
        Book book5 = new Book("Kırmızı Göl", 486, "Muhlis", "01-11-1874");

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        System.out.println("BookSet in alphabetical order");
        for (Book book : bookSet) {

            System.out.println("*************************************************\n"
                    + "Book Name : " + book.getName() + " | Page Number : " + book.getPageCount() +
                    "\n*************************************************");

        }

        TreeSet<Book> pageNumCompSet = new TreeSet<>(new OrderByPageCountComparator()) {
        };

        pageNumCompSet.add(book1);
        pageNumCompSet.add(book2);
        pageNumCompSet.add(book3);
        pageNumCompSet.add(book4);
        pageNumCompSet.add(book5);

        System.out.println("\n\nBookSet in ascending order according to page number");
        for (Book book : pageNumCompSet) {


            System.out.println("*************************************************\n"
                    + "Book Name : " + book.getName() + " | Page Number : " + book.getPageCount() +
                    "\n*************************************************");

        }


    }
}
