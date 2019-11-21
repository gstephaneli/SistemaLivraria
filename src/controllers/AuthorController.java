
package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import daos.AuthorDAO;
import daos.BookAuthorDAO;
import models.AuthorModel;

public class AuthorController {

	public AuthorController() {
	}

	public ArrayList<AuthorModel> getAuthors() throws SQLException {
		AuthorDAO dao = new AuthorDAO();

		return dao.index();
	}

	public Boolean addAuthor(String fname, String name) throws Throwable {

		// checa se os valores s�o nulos, vazios ou v�lidos
		if (fname != "" && fname != null && fname.matches("[a-zA-Z_]+") && name != "" && name != null
				&& name.matches("[a-zA-Z_]+")) {
			Boolean res = true;
			AuthorModel author = new AuthorModel(name, fname);
			AuthorDAO action = new AuthorDAO();

			// checa se o autor j� existe no banco de dados
			// se existir ele retorna falso
			// se n�o exsitir ele adiciona e retorna true
			if (!action.check(author)) {
				res = action.store(author);
			} else {
				res = false;
			}

			return res;
		} else {
			return false;
		}
	}

	public AuthorModel getAuthorById(Integer author_id) throws Throwable {
		AuthorModel autor = new AuthorModel();

		if (author_id > 0 && author_id != null) {
			AuthorDAO dao = new AuthorDAO();

			autor = dao.edit(author_id);
		}

		return autor;
	}

	public ArrayList<AuthorModel> getAuthorByName(String name) throws Throwable {
		ArrayList<AuthorModel> autorList = new ArrayList<>();

		if (name != "" && name != null) {
			AuthorDAO dao = new AuthorDAO();

			autorList = dao.getAuthorByName(name);
		}

		return autorList;
	}

	public Boolean updateAuthor(Integer author_id, String fname, String name) throws Throwable {

		// checa se os valores s�o nulos, vazios ou v�lidos
		if (fname != "" && fname != null && fname.matches("[a-zA-Z_]+") && name != "" && name != null
				&& name.matches("[a-zA-Z_]+") && author_id > 0 && author_id != null) {
			Boolean res = true;
			AuthorModel author = new AuthorModel(author_id, name, fname);
			AuthorDAO action = new AuthorDAO();

			// checa se o autor j� existe no banco de dados
			// se existir ele retorna verdadeiro e faz a modifica��o
			// se n�o existir ele retorna falso
			if (action.checkId(author)) {
				res = action.update(author);
				return true;
			} else {
				System.out.println("O autor n�o existe");
				res = false;
			}

			return res;
		} else {
			System.out.println("parametros inv�lidos");
			return false;
		}
	}

	public Boolean deleteAuthor(Integer author_id, String fname, String name) throws Throwable {

		// checa se os valores s�o nulos, vazios ou v�lidos
		if (fname != "" && fname != null && fname.matches("[a-zA-Z_]+") && name != "" && name != null
				&& name.matches("[a-zA-Z_]+") && author_id > 0 && author_id != null) {
			Boolean res = true;
			AuthorModel author = new AuthorModel(author_id, name, fname);
			AuthorDAO action = new AuthorDAO();

			// checa se o autor j� existe no banco de dados
			// se existir ele retorna verdadeiro e faz a modifica��o
			// se n�o existir ele retorna falso
			if (action.checkId(author)) {
				res = action.delete(author_id);
				BookAuthorDAO dao = new BookAuthorDAO();
				dao.deleteRelacionamento(book);
				return true;
			} else {
				System.out.println("O autor n�o existe");
				res = false;
			}

			return res;
		} else {
			System.out.println("parametros inv�lidos");
			return false;
		}
	}

	public Boolean deleteAuthorAndBooks(Integer author_id, String fname, String name) throws Throwable {
		// checa se os valores s�o nulos, vazios ou v�lidos
		if (fname != "" && fname != null && fname.matches("[a-zA-Z_]+") && name != "" && name != null
				&& name.matches("[a-zA-Z_]+") && author_id > 0 && author_id != null) {
			Boolean res = true;
			AuthorModel author = new AuthorModel(author_id, name, fname);
			AuthorDAO action = new AuthorDAO();

			// checa se o autor j� existe no banco de dados
			// se existir ele retorna verdadeiro e faz a modifica��o
			// se n�o existir ele retorna falso
			if (action.checkId(author)) {
				res = action.delete(author_id);

				return true;
			} else {
				System.out.println("O autor n�o existe");
				res = false;
			}

			return res;
		} else {
			System.out.println("parametros inv�lidos");
			return false;
		}
	}
}
