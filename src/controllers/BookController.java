
package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import daos.BookAuthorDAO;
import daos.BookDAO;
import models.AuthorModel;
import models.BookModel;

public class BookController {

	public BookController() {
	};

	public Boolean addBook(String title, String isbn, Integer publisher_id, Double price) throws Throwable {

		// checa se os valores s�o nulos, vazios ou v�lidos
		if (title != "" && title != null && isbn != "" && isbn != null && isbn.length() == 13 && publisher_id > 0
				&& publisher_id != null && price > 0 && price != null) {
			Boolean res = true;
			BookModel book = new BookModel(title, isbn, publisher_id, price);
			BookDAO action = new BookDAO();

			// checa se o autor j� existe no banco de dados
			// se existir ele retorna falso
			// se n�o exsitir ele adiciona e retorna true
			if (!action.check(book)) {
				res = action.store(book);
			} else {
				res = false;
			}

			return res;
		} else {
			return false;
		}
	}

	public Boolean storeOrUpdate(BookModel book, ArrayList<AuthorModel> authors) throws SQLException, Throwable {
		
		//checar se o livro já existe
		BookDAO dao = new BookDAO();
		BookAuthorDAO baDao = new BookAuthorDAO();
		if( dao.edit(book.getIsbn()).getIsbn() == "" ){
			//se entrou aqui quer dizer que o livro não existe
			//então adicionamos
			if(dao.store(book)){
				baDao.addRelacionamento(book, authors);
				System.out.println("Livro adicionado com sucesso!");
				return true;
			} else {
				System.out.println("O Livro não foi adicionado.");
				return false;
			}
		} else {
			//se entrou aqui quer dizer que o livro já exsite
			//então damos update
			if(dao.update(book)){
				baDao.deleteRelacionamento(book);
				baDao.addRelacionamento(book, authors);
				System.out.println("Livro atualizado com sucesso!");
				return true;
			} else {
				System.out.println("Houve um problema ao atualizar o livro.");
				return false;
			}
		}
	}

	public Boolean deleteBook(BookModel book) throws SQLException {
		BookDAO dao = new BookDAO();
		if(book != null){
			dao.delete(book.getIsbn());
			return true;
		} else {
			System.out.println("o livro não é uma instância de livro");
			return false;
		}
	}
	
}
