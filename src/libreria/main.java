package libreria;

/*Al alumno le toca desarrollar, las siguientes funcionalidades:
1) Crear base de datos Librería
2) Crear unidad de persistencia
3) Crear entidades previamente mencionadas ( excepto Préstamo )
4) Generar las tablas con JPA
5) Crear servicios previamente mencionados.
6) Crear los métodos para persistir entidades en la base de datos librería
7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título.
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.*/

import java.util.Scanner;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

public class main {


    public static void main(String[] args) {

        AutorServicio serviAutor = new AutorServicio();
        LibroServicio serviLibro = new LibroServicio();
        EditorialServicio serviEditorial = new EditorialServicio();
        
        Scanner leer = new Scanner(System.in);
        
        boolean s=true;
        int n, ejemplares, restantes, prestados, año;
        String nombre;
        
        while (s) {     
            
            System.out.println("Menu"
                    + "1-ingresar un libro\n"
                    + "2-ingresar una editorial\n"
                    + "3-ingresar un autor\n"
                    + "4-actualizar libro\n"
                    + "5-actualizar editorial\n"
                    + "6-actualizar autor\n"
                    + "7-eliminar libro\n"
                    + "8-eliminar editorial\n"
                    + "9-eliminar autor\n"
                    + "10-lista de libros\n"
                    + "11-lista de editoriales\n"
                    + "12-lista de autores\n");
            
            n=leer.nextInt();
            
            switch (n) {
                case 1:

                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                case 10:
                    
                    break;
                case 11:
                    
                    break;
                case 12:
                    
                    break;
                default:
                    throw new AssertionError();
            }
            
        }
        
       // servi.crearAutor("luca5", true);
       // servi.actualizarAutor(3, "luca2", true);
     //   servi.eliminarAutor(3);
      //  System.out.println(servi.listaAutores());
    }
    
}
