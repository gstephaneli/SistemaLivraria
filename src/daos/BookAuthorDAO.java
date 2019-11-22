
package daos;

import models.AuthorModel;
import models.BookModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factories.DatabaseFactory;

public class BookAuthorDAO {
    public BookAuthorDAO() {
    };

    public void addRelacionamento(BookModel book, ArrayList<AuthorModel> authors) {
        final String query = "INSERT INTO public.booksauthors(isbn, author_id, seq_no) VALUES (?, ?, ?)";
        Connection db = DatabaseFactory.getConnection();

        try {
            for (AuthorModel author : authors) {
                int i = 1;
                PreparedStatement pstm = db.prepareStatement(query);
                pstm.setString(1, book.getIsbn());
                pstm.setInt(2, author.getAuthor_id());
                pstm.setInt(3, i++);
                pstm.executeQuery(query);
                i++;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteRelacionamento(BookModel book) {
        final String query = "DELETE FROM public.booksauthors WHERE isbn = ?";
        Connection db = DatabaseFactory.getConnection();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setString(1, book.getIsbn());
            pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void deleteRelacionamentoAutor(AuthorModel author) {

        final String deleteAuthor = "DELETE FROM public.booksauthors WHERE author_id = ?";
        final String selectBook = "SELECT * FROM public.booksauthors WHERE author_id = ?";
        Connection db = DatabaseFactory.getConnection();
        BookDAO dao = new BookDAO();

        try {
            //seleciono os livros que tem aquele isbn
            
            PreparedStatement pstmGetBook = db.prepareStatement(selectBook);
            pstmGetBook.setInt(1, author.getAuthor_id());
            ResultSet rs = pstmGetBook.executeQuery();
            while(rs.next()){
                dao.delete(rs.getString("isbn"));
            }
            PreparedStatement pstmDelAuthor = db.prepareStatement(deleteAuthor);
            pstmDelAuthor.setInt(1, author.getAuthor_id());
            pstmDelAuthor.executeQuery();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
