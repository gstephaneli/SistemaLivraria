
package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import daos.BookDAO;
import daos.PublisherDAO;
import models.BookModel;
import models.PublisherModel;

public class PublisherController {

	public PublisherController() {
	};

	public Boolean addPublisher(String name, String url) throws Throwable {

		// checa se os valores s�o nulos, vazios ou v�lidos
		if (name != "" && name != null && url != "" && url != null) {
			Boolean res = true;
			PublisherModel publisher = new PublisherModel(name, url);
			PublisherDAO action = new PublisherDAO();

			// checa se o autor j� existe no banco de dados
			// se existir ele retorna falso
			// se n�o exsitir ele adiciona e retorna true
			if (!action.check(publisher)) {
				res = action.store(publisher);
			} else {
				res = false;
			}

			return res;
		} else {
			return false;
		}
	}

	public Boolean deletarEditora(PublisherModel editora) throws Throwable {
		PublisherDAO dao = new PublisherDAO();
		if (editora != null) {
			dao.delete(editora.getPublisher_id());
			return true;
		} else {
			System.out.println("a editora não é uma instância de editora");
			return false;
		}
	}

	public Boolean deletarLivroEditora(PublisherModel editora) throws Throwable {
		PublisherDAO dao = new PublisherDAO();
		BookDAO bDao = new BookDAO();
		if (editora != null) {
			dao.delete(editora.getPublisher_id());
			ArrayList<BookModel> books = bDao.getBookByPublisher(editora.getPublisher_id());
			for (BookModel book : books) {
				bDao.delete(book.getIsbn());
			}
			return true;
		} else {
			System.out.println("a editora não é uma instância de editora");
			return false;
		}
	}

	public ArrayList<PublisherModel> getPublishers() throws Throwable {
		PublisherDAO dao = new PublisherDAO();

		return dao.index();
	}

	public PublisherModel getPublisherById(Integer publisher_id) throws Throwable {
		PublisherModel publisher = new PublisherModel();

		if (publisher_id > 0 && publisher_id != null) {
			PublisherDAO dao = new PublisherDAO();

			publisher = PublisherDAO.edit(publisher_id);
		}

		return publisher;
	}

	public Boolean updatePublisher(Integer publisher_id, String name, String url) throws Throwable {

		// checa se os valores s�o nulos, vazios ou v�lidos
		if (url != "" && url != null && name != "" && name != null && publisher_id > 0 && publisher_id != null) {
			Boolean res = true;
			PublisherModel publisher = new PublisherModel(publisher_id, name, url);
			PublisherDAO action = new PublisherDAO();

			// checa se o autor j� existe no banco de dados
			// se existir ele retorna verdadeiro e faz a modifica��o
			// se n�o existir ele retorna falso
			if (action.checkId(publisher)) {
				res = action.update(publisher);
				return true;
			} else {
				System.out.println("a editora n�o existe");
				res = false;
			}

			return res;
		} else {
			System.out.println("parametros inv�lidos");
			return false;
		}
	}
}
