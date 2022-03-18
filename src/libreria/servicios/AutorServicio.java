/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

/**
 *
 * @author Los ninios
 */
public class AutorServicio {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    EntityManager em = emf.createEntityManager();
    
    public void crearAutor(String nombre, boolean alta){
        
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(alta);
        
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        
    }
    
    public void actualizarAutor(int id, String nombre, boolean alta){
        
        try {
            
            Autor autor = (Autor) em.createQuery("SELECT f FROM Autor f WHERE f.id= :id").
                                setParameter("id", id).getSingleResult();
        
            autor.setNombre(nombre);
            autor.setAlta(alta);
        
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println("Error en el sistema");
            throw e;
        }
        
        
    }
    
    public void eliminarAutor(int id){
        
        try {
            
            Autor autor = (Autor) em.createQuery("SELECT p FROM Autor p WHERE p.id = :id").
                    setParameter("id", id).getSingleResult();
            
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println("Error en el sistema");
            throw e;
        }
 
    }
    
    public Collection<Autor> listaAutores(){
        
        Collection<Autor> autores = em.createQuery("SELECT f FROM Autor f").getResultList();
        
        return autores;
        
    }

 
    
}
