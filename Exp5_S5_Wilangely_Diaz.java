/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp5_s5_wilangely_diaz;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author wdiaz1
 */
public class Exp5_S5_Wilangely_Diaz {

    public static int totalEntradas=0;
    public static int precioEntradas =15000;
    public static int totalAPagar =0;
    public static int edad= 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner (System.in);
    int opcionEvento = 0;
    boolean salir =false;
    boolean [][] asientos = new boolean [5][5];
    
        System.out.println("Bienvenido al sistema de selección de boletas del Teatro Moro");
        System.out.println("Indicanos tu nombre: ");
        String nombre =sc.nextLine();
        System.out.println("¡Hola "+nombre+ " Indicanos tu Edad!: ");
        edad= sc.nextInt();
        sc.nextLine();

    int opcion;
    do { 
      
        System.out.println("-----Menu General----");
        System.out.println("1-. Eventos");
        System.out.println("2-. Ver promociones");
        System.out.println("3-. Eliminar Entrada");
        System.out.println("4-. Salir");
        System.out.println("Elige una opción del 1 al 4");
        opcion=sc.nextInt();
                
        boolean finalizarSubmenu = false;
        
        switch (opcion) {
                case 1:
                    do{
                        System.out.println("-----Menu de Eventos----");
                        System.out.println("1-. El lago de los cisnes");
                        System.out.println("2-. Romeo y Julieta");
                        System.out.println("3-. La divina Comedia ");
                        System.out.println("4-. El Fantasma de la Opera");
                        System.out.println("5-. Hamlet");
                        System.out.println("6-.---Volver al menu principal---");
                        System.out.println("Selecciona tu obra de preferencia (del 1 al 6)");
                        
                        try {
                        opcionEvento = sc.nextInt();

                        
                            switch (opcionEvento){
                                case 1:
                                    System.out.println("Seleccionaste El lago de los cisnes");
                                    int ubicacionElegida1 = mostrarUbicaciones(sc);
                                    seleccionAsiento(sc, asientos);
                                    finalizarSubmenu = true;
                                    break;
                                case 2:
                                    System.out.println("Seleccionaste Romeo y Julieta");
                                    int ubicacionElegida2 = mostrarUbicaciones(sc);
                                    seleccionAsiento(sc, asientos);
                                    finalizarSubmenu = true;
                                    break;
                                case 3:
                                    System.out.println("Seleccionaste La Divina Comedia");
                                    int ubicacionElegida3 = mostrarUbicaciones(sc);
                                    seleccionAsiento(sc, asientos);
                                    finalizarSubmenu = true;
                                    break;
                                case 4:
                                    System.out.println("Seleccionaste El Fantasma de la opera");
                                    int ubicacionElegida4 = mostrarUbicaciones(sc);
                                    seleccionAsiento(sc, asientos);
                                    finalizarSubmenu = true;
                                    break;
                                case 5:
                                    System.out.println("Seleccionaste Hamlet");
                                    int ubicacionElegida5 = mostrarUbicaciones(sc);
                                    seleccionAsiento(sc, asientos);
                                    finalizarSubmenu = true;
                                    break;
                                case 6:
                                    System.out.println("Volviendo al menu principal");
                                     break;
                                    
                                default:
                                    System.out.println("Opción invalida");
                        }
                            
                    }catch (InputMismatchException e){
                        System.out.println("Por Favor ingresa un numero correcto");
                            sc.nextLine();
                            }
                 }while (! finalizarSubmenu && opcionEvento !=6);
                    break;
                case 2:
                    System.out.println("---Descuentos adicionales---");
                    System.out.println(" 10% de descuento a menores de 18 años");
                    System.out.println(" 15% de descuento a mayores de 60 años");
                    System.out.println(" 20% de descuento por mas de 3 compras");
                    System.out.println();
                    int volver;
                    do{
                        System.out.println("presiona 1 para volver al menu principal");
                        while (!sc.hasNextInt()){
                            System.out.println("Opcion invalida, Presiona 1 y vuelve al menu principal");
                            sc.nextInt();
                        }
                        volver=sc.nextInt();
                    }while(volver!= 1);
                    break;
                    
                case 3:
                    eliminarEntrada(sc, asientos);
                    break;
                    
                case 4:
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    
        }
    }while (opcion !=4);        
    }  
public static int mostrarUbicaciones(Scanner sc) {
     int ubicacion = 0;
     boolean valido = false;
     
     
     do{
         System.out.println("---Selecciona la Ubicación---");
         System.out.println("1-.VIP");
         System.out.println("2-. Platea Baja");
         System.out.println("3-. Platea alta");
         System.out.println("4-. Cancha General");
         System.out.println("Selecciona la ubicación del 1 al 4");
         
         try{
             ubicacion= sc.nextInt();
             if (ubicacion >= 1 && ubicacion <=4){
                     
                 valido=true;
             }else{
                 System.out.println("Opcion Fuera de Rango");
             }
         }catch (Exception e){
             System.out.println("Opcion Invalida");
             sc.nextLine();
         }
     }while(!valido);
     return ubicacion;
         }
public static void seleccionAsiento (Scanner sc, boolean [][] asientos){
int cantidad =0;
boolean entradaValida = false;
 
 do{
     System.out.println("Cuantos Asientos desea reservar? (hasta 5 por persona): ");
     try{
         cantidad = sc.nextInt();

         if (cantidad>=1 && cantidad<=5){
             entradaValida=true;
         }else{
             System.out.println("excede la cantidad");
         }
    }catch(Exception e){
         System.out.println("dato mal ingresado");
         sc.nextInt();
    }
 }while(!entradaValida);
 
 for(int r =1; r <= cantidad; r++){
     int fila = -1;
     int asiento= -1;
     boolean reservado =false;
     
     do{
         System.out.println("---Vista de Asientos---");
         for(int i =0; i< asientos.length; i++){
            System.out.print("Fila " + (i + 1) + ": ");
            for(int j = 0; j< asientos[i].length; j++){
                 System.out.print(asientos[i][j] ? "[X]" : "[ ]");
            
            }
            System.out.println();
             }
        try{
             System.out.println("Seleccion " + r + "de " + cantidad);
             System.out.print("elige la fila de tu preferencia (del 1 al 5): ");
             fila= sc.nextInt()-1;
             System.out.print("Elige el numero de Asiento: ");
             asiento = sc.nextInt()-1;
             
             if (fila >=0 && fila < asientos.length && asiento >= 0 && asiento < asientos[0].length){
                if(!asientos[fila][asiento]){
                    asientos[fila][asiento]=true;
                    System.out.println("Asiento(s) Reservado correctamente");
                    reservado =true;
                totalEntradas++;
                totalAPagar += precioEntradas;
                
                }else{
                    System.out.println("Asiento ocupado. Intenta con otro asiento");
                    
                }
             }else{
                 System.out.println("Fila o asiento erroneo");
             }
        }catch (Exception e){
            System.out.println("Entrada invalida");
            sc.nextLine();
        }        
    }while(!reservado);
        
        }
 PromocionYDescuento(sc);
                
    } 
public static void eliminarEntrada(Scanner sc, boolean [][]asientos){
    int fila, asiento;
    boolean entradaValida= true;
    
    do{
        System.out.println("---Eliminar Entrada reservada---");
        System.out.println("Insgrese la fila del asiento seleccionado (nro del 1 al 5");
        fila=sc.nextInt()-1;
        System.out.println("Ingrese el numero de asiento a eliminar (nro del 1 al 5)");
        asiento=sc.nextInt()-1;
        
        if(fila>=0 && fila<asientos.length && asiento >= 0 && asiento < asientos[0].length){
          if (asientos[fila][asiento]){
              asientos[fila][asiento]= false;
              System.out.println("¡Listo! entrada eliminada");
              entradaValida=true;
          }else{
              System.out.println("el asiento indicado no estaba reservado, ingresa de nuevo");
              entradaValida=true;
          }
        }else{
            System.out.println("Fila o asiento erroneos");
        }
    }while (!entradaValida);
    
    System.out.println("Desea reservar otro asiento (S/N");
    sc.nextLine();
    String respuesta = sc.nextLine();
    
    if(respuesta.equalsIgnoreCase("S")){
        seleccionAsiento(sc,asientos);
    }else{
        System.out.println("Continua con la fase de pago");
    }
          }
public static void PromocionYDescuento(Scanner sc){
    System.out.println("---Resumen de Compra---");
    System.out.println("Total de entradas reservadas: " + totalEntradas);
    System.out.println("Valor unitario: " + precioEntradas);
    System.out.println("Total sin descuentos: " + totalAPagar);
        
    double descuento = 0.0;

           
           if(edad <= 17){
                descuento += 0.10;
                System.out.println("Tienes un descuento del 10% por ser menor de edad");
         }else if(edad >= 60){
                descuento += 0.15;
                System.out.println("Tienes un descuento del 15% por ser persona de la tarcera edad");
         }
           
           if (totalEntradas>=3){
               descuento+=0.20;
               System.out.println("Tienes un descuento del 20% por comprar 3 o mas entradas");
           }
           
           double totalPagar = totalAPagar - (totalAPagar * descuento);
           System.out.println("Total a pagar con descuento:$ "+ totalPagar);
           
           System.out.println("Desea realizar otra operacion (S/N");
           sc.nextLine();
           String respuestaEntrada= sc.nextLine();
           
           if (!respuestaEntrada.equalsIgnoreCase("S")){
               System.out.println("---DISFRUTA DE LA FUNCIÓN---");
               System.exit(0);
           }
           
           }
       
}

        
      
            
