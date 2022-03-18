/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Los ninios
 */
@Entity
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long isbn;
    private String titulo;
    private int año;
    private int ejemplares;
    private int ejemplaresPrestados;
    private int ejemplaresRestantes;
    private boolean alta;
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Editorial editorial;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libreria.entidades.Libro[ id=" + isbn + " ]";
    }
    
}
