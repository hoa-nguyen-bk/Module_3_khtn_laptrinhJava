package businessLogic;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Author;

public class AuthorBL {
	public static List<Author> getAuthors() {
		String sql = "SELECT at FROM Author at";
		try (Session session = CSDL.getFactory().openSession()) {
			return session.createQuery(sql, Author.class).list();
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public static Author getAuthor(int id) {
// cách cũ
		// String sql = "SELECT at FROM Author at WHERE authorid = "+id;
		try (Session session = CSDL.getFactory().openSession()) {
			return session.get(Author.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	public static void addAuthor(Author at) {
		// thêm sửa xóa đòi tạo transaction của Hibernate
		Transaction tx = null;
		try (Session session = CSDL.getFactory().openSession()) {
			tx = session.beginTransaction();
			session.persist(at);
			tx.commit();
		} catch (Exception e) {
			e.getMessage();
			System.out.println("lỗi");
			if (tx != null)
				tx.rollback();
		}
	}

	public static void editAuthor(Author at) {
		// thêm sửa xóa đòi tạo transaction của Hibernate
		Transaction tx = null;
		try (Session session = CSDL.getFactory().openSession()) {
			tx = session.beginTransaction();
			session.update(at);
			tx.commit();
		} catch (Exception e) {
			e.getMessage();
			System.out.println("lỗi");
			if (tx != null)
				tx.rollback();

		}
	}

	public static void deleteAuthor(int id) {
		Transaction tx = null;
		try (Session session = CSDL.getFactory().openSession()) {
			tx = session.beginTransaction();
			Author atx = getAuthor(id);
			session.delete(atx);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			System.out.println("lỗi");
			if (tx != null)
				tx.rollback();

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Author> ds = getAuthors();
		ds.forEach(at -> System.out.println(at.getAuthorName()));

//		Author at = getAuthor(1);
//		System.out.println(at.getAuthorName() + " - " + at.getAuthorId());
//		
//		Author newAt = new Author();
//		newAt.setAuthorName("hòa minzy hihi");
//		addAuthor(newAt);
	
//		Author author = getAuthor(100);
//		author.setAuthorName("bees bi");
//		editAuthor(author);

		deleteAuthor(100);
	}

}
