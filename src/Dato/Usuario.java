
package Dato;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Usuario {
    
    private String usuario;
    private String password; 
    private String nombre; 
    private String correo; 
    private int estado; 

    public Usuario() {
    }

    public Usuario(String usuario,String password, String nombre, String correo, int estado) {
        this.password = password;
        this.nombre = nombre;
        this.correo = correo;
        this.estado = estado;
        this.usuario= usuario;
    }
     public String getUsuario() {
        return this.usuario;
    }

    public  void setUsuario(String aUsuario) {
        this.usuario = aUsuario;
    }
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    /**
     * Este metodo hace una insercion hacia el documento archivo.txt. 
     * 
     * @since Java-8 
     * @return retorna un true si se inserto en el documento txt el usuario y un false si no se inserto nada.
     * @throws si ocurre un error como la creacion la creacion de un archivo 
     */
    public boolean insertarUsuario(File archivo){
        boolean encontrado = false;
        try {
            
            Scanner lectura = new Scanner(archivo); 
            FileWriter writer = new FileWriter(archivo,true);
            BufferedWriter archivoEs = new BufferedWriter(writer); 
           
            if (!archivo.exists()){
                archivo.createNewFile();        
            }
            else if(archivo.exists()){ 
                archivoEs.write(this.toString());  
                archivoEs.newLine(); 
                archivoEs.close();    
                 
             
                JOptionPane.showMessageDialog(null, "Se ha ingresado un Usuario!");
                encontrado = true;
            }
        } catch (Exception e) { 
            encontrado = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return encontrado;
    }
    /**
     * Este metodo es la que mostrara un tipo de tableModel con el contenido del archivo . la idea es hacer que con los metodos
     * como toString() haga algo similar a esto con el metodo .split() usuario (,separador)  password (,separador)... 
     * 
     * se haria con cada interacion del arreglo .
     * y asi sucesivamente. 
     * 
     * @param archivo
     * @return el metodo retornara las lineas del archivo para asi con el metodo split agregarlo en un modeloTabla con cada 
     * interacion
     */
    public String[] mostrarUsuarios(File archivo){
//        
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.setColumnIdentifiers(new String []{"Usuario","Password","Nombre","Correo","Estado"});  
//        
           ArrayList<String> lineList =new ArrayList<>();
        
        try {   
                // esto lee el archivo 
                Scanner lectura = new Scanner(archivo);
                  
//                   Recorre linea por linea..
                    while (lectura.hasNextLine()) {   
                        
                      String linea = lectura.nextLine();
                      lineList.add(linea);
//                      
                    }
                
                } catch (Exception e) { 
                    System.out.println(e.getMessage());
                }
                String [] lineasArray = new String [lineList.size()]; 
                lineasArray = lineList.toArray(lineasArray);
                
        return lineasArray;
    }
    
    /**
     * Este es el metodo buscar usuario , se utiliza para buscar por ejemplo en esta caso utilice 
     * el parametro como un idUsuario para compararlo con las lineas del documento txt 
     * 
     * Utilice la clase BufferedReader con la instanciacion de FileReader (nameArchivo) 
     * que lo que hace es que lee los archivo linea por linea . y asi mediante un bucle leerlo. 
     * 
     * @param archivo este permite leer el archivo al cual se va leer...
     * @param usuarioEncontrar permite buscar la palabra a Buscar...
     * @return Retorna la linea o el string si se encontro o retornara no encontrado. 
     */
    
    public String  buscarUsuario(File archivo ,String usuarioEncontrar){
        String usuarioEncontrado ="No Encontrado";
        String linea ;
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));  
            while ((linea= lector.readLine())!=null) {                
                if (linea.contains(usuarioEncontrar)) {
                    usuarioEncontrado= linea; 
                    break;
                }  
            }       
            lector.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuarioEncontrado;
    }
        
    @Override
    public String toString() {
        return this.getUsuario() +","+this.password +","+this.nombre +","+this.estado;
    }

  
    
    
    
}
