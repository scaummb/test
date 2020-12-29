package design_module.IteratorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/28 13:13
 */
//迭代器对象
public class BookShelfIterator implements Iterator {
	//迭代器要迭代的书架
	private BookShelf bookShelf;
	private int index;

	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	public boolean hasNext(){
		if(index < bookShelf.getLength()){
			return true;
		} else {
			return false;
		}
	}

	public Object next(){
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}
}
