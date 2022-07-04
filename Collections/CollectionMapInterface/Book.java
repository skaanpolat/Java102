package CollectionMapInterface;

public class Book implements Comparable {

    private String name;
    private int pageCount;
    private String author;
    private String publishDate;

    public Book(String name, int pageCount, String author, String publishDate) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
