package design_module.IteratorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/28 13:18
 */

public class TestIteratorPattern {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("倚天屠龙记"));
		bookShelf.appendBook(new Book("葵花宝典"));
		bookShelf.appendBook(new Book("九阳真经"));
		bookShelf.appendBook(new Book("神雕侠侣"));
		Iterator it = bookShelf.iterator();
		while (it.hasNext()){
			Book book = (Book) it.next();
			System.out.println(book.getName());
		}
	}
}
