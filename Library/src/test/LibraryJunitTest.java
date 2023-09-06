package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import main.Library;

@TestInstance(Lifecycle.PER_CLASS)
public class LibraryJunitTest {
    private static final String NEGATIVE_LIBRARY_MESSAGE = "음수로는 도서관을 생성할 수 없습니다.";
    private static final String ADD_MORE_THAN_MAX_MESSAGE = "도서관 최대 용량을 초과해 책을 추가할 수 없습니다.";
    private static final String ADD_DUPLICATE_BOOK_MESSAGE = "도서관에 같은 이름의 책이 존재합니다.";
    private static final String DELETE_NOT_EXIST_BOOK_MESSAGE = "도서관에 존재하지 않는 책은 삭제할 수 없습니다.";

    private Library library;
    private Library oneLibrary;

    @BeforeEach
    void setUp() {
        library = new Library(5);
        oneLibrary = new Library(1);

        library.add("해리포터");
        library.add("어린왕자");
        library.add("샬롯의거미줄");

        oneLibrary.add("자바의 정석");

    }

    @Test
    @DisplayName("Negative Success!")

    void negativeLibrary() {

        try {
            new Library(-1);
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals(NEGATIVE_LIBRARY_MESSAGE);
        }

    }

    @Test
    @DisplayName("Adding Success!")

    void addBook() {
        library.delete("해리포터");
        library.delete("어린왕자");
        library.delete("샬롯의 거미줄");

        library.add("해리포터");
        library.add("어린왕자");
        library.add("샬롯의 거미줄");
        assert 3 == library.getTotalBookCount();
    }

    @Test
    @DisplayName("MoreThanMax Success!")

    void moreThanMax() {

        try {
            oneLibrary.add("모두의 리눅스");
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals(ADD_MORE_THAN_MAX_MESSAGE);
        }
    }

    @Test
    @DisplayName("Duplicate Success!")

    void duplicateBook() {

        library.add("백설공주");

        try {
            library.add("백설공주");
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals(ADD_DUPLICATE_BOOK_MESSAGE);
        }
    }

    @Test
    @DisplayName("Finding Success!")

    void findBook() {

        assert library.find("어린왕자");
        assert !library.find("엄지공주");

    }

    @Test
    @DisplayName("Deleting Success!")

    void deleteBook() {
        library.add("백설공주");

        library.delete("백설공주");

    }

    @Test
    @DisplayName("DeleteNotExist Success!")

    void deleteNotExist() {

        try {
            library.delete("흥부와 놀부");
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals(DELETE_NOT_EXIST_BOOK_MESSAGE);
        }
    }

    @AfterAll
    void done() {
        System.out.println("done");
    }
}
