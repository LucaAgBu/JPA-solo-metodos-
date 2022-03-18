package libreria.servicios;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroServicio {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    EntityManager em = emf.createEntityManager();
    
    public void crearLibro(String titulo, int año, int ejemplares, int ejemplaresPrestados, int ejemplaresRestantes, boolean alta, Editorial editorial, Autor autor){
        
       Libro libro = new Libro();
       libro.setTitulo(titulo);
       libro.setAño(año);
       libro.setEjemplares(ejemplares);
       libro.setEjemplaresPrestados(ejemplaresPrestados);
       libro.setEjemplaresRestantes(ejemplaresRestantes);
       libro.setEditorial(editorial);
       libro.setAutor(autor);
       
       em.getTransaction().begin();
       em.persist(libro);
       em.getTransaction().commit();
        
    }
    
    public void actualizarLibro(int isbn, String titulo, int año, int ejemplares, int ejemplaresPrestados, int ejemplaresRestantes, boolean alta, Editorial editorial, Autor autor){
        
        try {
            
            Libro libro = (Libro) em.createQuery("SELECT f FROM Libro WHERE f.isbn = :isbn").
                setParameter("isbn", isbn).getSingleResult();
            
            libro.setTitulo(titulo);
       libro.setAño(año);
       libro.setEjemplares(ejemplares);
       libro.setEjemplaresPrestados(ejemplaresPrestados);
       libro.setEjemplaresRestantes(ejemplaresRestantes);
       libro.setEditorial(editorial);
       libro.setAutor(autor);
       
       em.getTransaction().begin();
       em.merge(libro);
       em.getTransaction().commit();
       
        } catch (Exception e) {
            System.out.println("Error en el sistema");
            throw e;
        }
        
    }
    
    public void eliminarLibro(int isbn){
        
        try{
        Libro libro = (Libro) em.createQuery("SELECT f FROM Libro f WHERE f.isbn = :isbn").
                setParameter("isbn", isbn).getSingleResult();
        
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en el sistema");
            throw e;
        }
        
    }
    
    public Collection<Libro> listarLibro(){
        
        Collection<Libro> libros = em.createQuery("SELECT f FROM Libro f").getResultList();
        
        return libros;
        
    }
    
}
