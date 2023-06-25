
package main;

import vista.FrmPrincipal;

public class Main {
       
    public static void main(String[] args) {  
        
        FrmPrincipal frmp = new FrmPrincipal(); 
        frmp.setVisible(true);
    }
    } 
    /*
    public  static void menu (){  
        
        ArrayList<Usuario> resultSet = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int opcion  , interador=0;
        String password, nombre , correo,estado;
        int numUsuario;
        String numUsuarioString;
        do {            
            System.out.println("\tMenu Registro"
            +"\n1.Registrar Usuario "
            +"\n2.Mostrar Todos los Usuarios"
            +"\n3.Buscar Usuario"
            +"\n4.Eliminar Usuario"
            +"\n5.Validar usuario"
            +"\n6.Terminar Programa:"        
            +"\nDigite una Opcion :")
                    ;
            opcion =Integer.parseInt(entrada.nextLine()); 
            System.out.println("");
            
            Usuario usuario = new Usuario();
            try {
                File archivo = new File("archivo.txt");
                
                if(!archivo.exists()){
                    archivo.createNewFile(); 
                    System.out.println("Se ha creado el archivo !");
                }
                else {
                    System.out.println("El Archivo ya existe");
                }
                
                switch (opcion) {
                    case 1: 
                        System.out.println("Registro Usuario!");
                        
                        System.out.println("Proporcione el Numero Usuario:");
                        numUsuario = Integer.parseInt(entrada.nextLine()); 
                        
                        System.out.println("Proporcione la Contraseña :");
                         password = entrada.nextLine(); 
                         
                         System.out.println("Proporcione un nombre de Usuario:");
                         nombre = entrada.nextLine(); 
                         
                         System.out.println("Proporcione un correo :");
                         correo = entrada.nextLine(); 
                         
                         System.out.println("Proporcione el estado :");
                         estado = entrada.nextLine();
                         
                        usuario = new Usuario(numUsuario,password, nombre, correo, estado);
                        
                        usuario.insertarUsuario(archivo);  
                        
                        System.out.println("El usuario se ha registrado CORRECTAMENTE!");
                         break;
                         
                    case 2: 
                        System.out.println("==============================Lista de Usuarios=================================");
                        if (!usuario.mostrarUsuarios(archivo).equals("")) {
                            System.out.println(usuario.mostrarUsuarios(archivo)); 
                            
                        }
                        else System.out.println("Lista Vacia! Agrege un Usuario...");
                        System.out.println("==============================Lista de Usuarios=================================");
                        break;
                        
                    case 3 : 
                        System.out.println("Proporcione un numero de usuario a Buscar :");
                        numUsuarioString = entrada.nextLine();
                        
                        if (usuario.buscarUsuario(archivo, numUsuarioString)!=null){
                            System.out.println("Linea encontrada ="+usuario.buscarUsuario(archivo, numUsuarioString));
                        }
                        else System.out.println("Usuario no encontrado");
                        
                        break;
                    default:
                        System.out.println("No es una Opcion Valida!");
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
               
        } while (opcion!=6);
              
    }
}
*/
