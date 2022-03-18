package libreria.servicios;

import java.util.Collection;
import java.util.Collections;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import libreria.entidades.Editorial;

public class EditorialServicio {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    EntityManager em = emf.createEntityManager();
    
    public void crearEditorial(String nombre, boolean alta){
        
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(alta);
        
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
        
    }
    
    public void actualizarEditorial(int id, String nombre, boolean alta){
        
        try {
            
            Editorial editorial = (Editorial) em.createQuery("SELECT f FROM Editorial f WHERE f.id = :id").
                setParameter("id", id).getSingleResult();
        
        editorial.setNombre(nombre);
        editorial.setAlta(alta);
        
        em.getTransaction().begin();
        em.merge(alta);
        em.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println("Error en el sistema");
            throw e;
        }

    }
    
    public void eliminarEditorial(int id){
        
        try {
            
            Editorial editorial = (Editorial) em.createQuery("SELECT f FROM Editorial WHERE f.id = :id").
                                setParameter("id",id).getSingleResult();
        
        em.getTransaction().begin();
        em.remove(editorial);
        em.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println("Error en el sistema");
            throw e;
        }
        
        
        
    }
    
    public Collection<Editorial> listarEditoriales(){
        
        Collection<Editorial> editoriales = em.createQuery("SELECT f FROM Editorial f").
                getResultList();
        
        return editoriales;
        
    }
    
}
