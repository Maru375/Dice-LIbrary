package main;

import java.util.ArrayList;
import java.util.List;

public class Library {
    int maxbookcount;
    List<String> booklist;

    public Library(int maxbookcount) {
        if (maxbookcount < 0) {
            throw new IllegalArgumentException("음수로는 도서관을 생성할 수 없습니다.");
        }
        this.maxbookcount = maxbookcount;
        this.booklist = new ArrayList<>();
    }

    public int getBook() {
        return this.maxbookcount;
    }

    public void add(String bookname) {
        if (getTotalBookCount() >= maxbookcount) {
            throw new IllegalArgumentException("도서관 최대 용량을 초과해 책을 추가할 수 없습니다.");
        }
        if (find(bookname)) {
            throw new IllegalArgumentException("도서관에 같은 이름의 책이 존재합니다.");
        }
        booklist.add(bookname);
    }

    public int getTotalBookCount() {
        return booklist.size();
    }

    public boolean find(String bookname) {
        return booklist.contains(bookname);
    }

    public void delete(String bookname) {
        if (!find(bookname)) {
            throw new IllegalArgumentException("도서관에 존재하지 않는 책은 삭제할 수 없습니다.");
        }
        booklist.remove(bookname);
    }
}
