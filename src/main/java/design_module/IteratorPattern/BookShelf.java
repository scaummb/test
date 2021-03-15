package design_module.IteratorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/28 13:13
 */

public class BookShelf implements BookIteratorGenerator {
	private Book[] books;
	private int last = 0;

	public BookShelf(int maxsize) {
		this.books = new Book[maxsize];
	}

	public Book getBookAt(int index) {
		return books[index];
	}

	public void appendBook(Book book) {
		this.books[last] = book;
		last++;
	}

	public int getLength() {
		return last;
	}

	@Override
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}
}
