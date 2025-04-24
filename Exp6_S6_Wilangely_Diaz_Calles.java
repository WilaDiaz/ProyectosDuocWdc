/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp6_s6_wilangely_diaz_calles;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author wdiaz
 */
public class Exp6_S6_Wilangely_Diaz_Calles {

    public static int totalEntradas=0;
    public static int precioEntradas =15000;
    public static int totalAPagar =0;
    public static int edad= 0;
    public static String nombreTeatro= "Teatro Moro";
    public static String nombreEvento = "";
    public static ArrayList<String> asientosSeleccionados = new ArrayList<>();
    
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
                                    nombreEvento = "El lago de los cisnes";
                                    System.out.println("Seleccionaste El lago de los cisnes");
                                    int ubicacionElegida1 = mostrarUbicaciones(sc);
                                    seleccionAsiento(sc, asientos);
                                    finalizarSubmenu = true;
                                    break;
                                case 2:
                                    nombreEvento = "Romeo y Julieta";
                                    System.out.println("Seleccionaste Romeo y Julieta");
                                    int ubicacionElegida2 = mostrarUbicaciones(sc);
                                    seleccionAsiento(sc, asientos);
                                    finalizarSubmenu = true;
                                    break;
                                case 3:
                                    nombreEvento = "La Divina Comedia";
                                    System.out.println("Seleccionaste La Divina Comedia");
                                    int ubicacionElegida3 = mostrarUbicaciones(sc);
                                    seleccionAsiento(sc, asientos);
                                    finalizarSubmenu = true;
                                    break;
                                case 4:
                                    nombreEvento = "El Fantasma de la Opera";
                                    System.out.println("Seleccionaste El Fantasma de la opera");
                                    int ubicacionElegida4 = mostrarUbicaciones(sc);
                                    seleccionAsiento(sc, asientos);
                                    finalizarSubmenu = true;
                                    break;
                                case 5:
                                    nombreEvento = "Hamlet";
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
boolean opcionValida = false;
 
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
                asientosSeleccionados.add("Fila " + (fila + 1)+ ", Asiento " + (asiento + 1));
                
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

 
        System.out.println("---Vista de Asientos Reservados---");
        for(int i =0; i< asientos.length; i++){
            System.out.println("Fila " + (i +1)+ ": ");
            for(int j =0; j< asientos[i].length; j++){
                System.out.print(asientos[i][j] ? "[X]" : "[ ]");
            }
        System.out.println();
        }
        System.out.println("---Detalle de asientos reservados---");
        for (int i = 0; i < asientos.length; i++){
            for (int j =0; j < asientos[i].length; j++){
                if (asientos[i][j]){
                    System.out.println("Fila " + (i + 1) + ", Asiento " + (j + 1));
                }
            }
        }
        
        System.out.println("\n tienes 20seg para confirmar tu compra. ¿Desea confirmar su compra? (S/N)"); 
       
        Timer timer =new Timer();
        TimerTask tarea = new TimerTask(){
        @Override
    public void run(){
    System.out.println("\n Tiempo expirado. reserva cancelada");
    System.exit(0);
}
};
timer.schedule(tarea,20000);  //20 seg

sc.nextLine();
String confirmar = sc.nextLine();

timer.cancel();
        
        
        if(confirmar.equalsIgnoreCase("S")){
            timer.cancel();
            PromocionYDescuento(sc);
}else{
        do{
            System.out.println("¿Que deseas realizar?");
            System.out.println("1-. Agregar asiento");
            System.out.println("2-. eliminar asiento");
            System.out.println("3-. Cancelar compra y volver al menu principal");
            System.out.println("4-. Confirmar compra");
            
            int opcion = sc.nextInt();
            sc.nextLine();
            
            switch(opcion){
                case 1:
                    seleccionAsiento(sc,asientos);
                    opcionValida= true;
                    break;
                case 2:
                    eliminarEntrada(sc, asientos);
                    opcionValida= true;
                    break;
                case 3:
                    System.out.println("Compra Cancelada, Volviendo al menu principal");
                    opcionValida= true;
                    return;
                case 4:
                PromocionYDescuento(sc);
                opcionValida= true;
                return;
                default:
                    System.out.println("Seleccion erronea, ingresa un numero del 1 al 4");
                    break;
            }
        }while (!opcionValida); 
  } 
}
public static void eliminarEntrada(Scanner sc, boolean [][]asientos){
    int fila, asiento;
    boolean entradaValida= true;
    
    do{
        System.out.println("---Asientos reservados---");
        boolean hayReservas= false;
        
        
        for(int i =0;i<asientos.length; i++){
            for (int j = 0; j < asientos[i].length; j++){
                if (asientos[i][j]){
                    System.out.println("Fila " +(i+1)+", Asiento"+ (j+1));
                    hayReservas=true;
                }
            }
        }
        if(!hayReservas){
            System.out.println("No hay entradas reservadas para eliminar");
            return;
        }
        
        System.out.println("Insgrese la fila del asiento seleccionado (nro del 1 al 5");
        fila=sc.nextInt()-1;
        System.out.println("Ingrese el numero de asiento a eliminar (nro del 1 al 5)");
        asiento=sc.nextInt()-1;
        
        if(fila>=0 && fila<asientos.length && asiento >= 0 && asiento < asientos[0].length){
          if (asientos[fila][asiento]){
              System.out.println("Estas seguro de eliminar fila"+(fila+1)+", Asiento " + (asiento +1)+ "? (S/N)");
              sc.nextLine();
              String confirmacion = sc.nextLine();
              
              if (confirmacion.equalsIgnoreCase("S")){
                  asientos[fila][asiento] = false;
                  totalEntradas--;
                  totalAPagar-= precioEntradas;
                  System.out.println("Entrada eliminada correctamente");
                  entradaValida=true;
}else{
                  System.out.println("eliminación cancelada");
                  entradaValida=true;
                  
              }
                            
          }else{
              System.out.println("el asiento indicado no estaba reservado, ingresa de nuevo");
              entradaValida=true;
          }
        }else{
            System.out.println("Fila o asiento erroneos");
        }
    }while (!entradaValida);
    
    System.out.println("¿Desea reservar otro asiento o imprimir la boleta? (1-. Reservar, 2-. Imprimir boleta)");
    int opcion = sc.nextInt();
    sc.nextLine();
    
    if (opcion == 1) {
        seleccionAsiento(sc, asientos);
 
    } else if (opcion ==2){
        PromocionYDescuento(sc);
}else{
        System.out.println("opcion no valida, seleccionar un numero correcto");
    }
}
public static void PromocionYDescuento(Scanner sc){
        
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
           System.out.println("Total a pagar:$ "+ totalPagar);
           

           imprimirBoleta(descuento, totalPagar);
           

           }
public static void imprimirBoleta(double descuento, double totalPagar){
    System.out.println("---------------------");
    System.out.println("---BOLETA DE COMPRA---");
    System.out.println("TEATRO: " + nombreTeatro);
    System.out.println("EVENTO: "+ nombreEvento);
    System.out.println("---------------------");
    System.out.println("Entradas: "+totalEntradas);
    System.out.println("Asientos seleccionados: ");
    for(String asiento : asientosSeleccionados){
        System.out.println(" -" + asiento);
           }
    System.out.println("Precio por entrada: " + precioEntradas);
    System.out.println("total sin descuentos: " + totalAPagar);
    System.out.println("descuento aplicado: " + (int)(descuento*100) + "%");
    System.out.println("Total a pagar: $" + totalPagar);
    System.out.println("---------------------");
    System.out.println("---------------------");
    System.out.println("¡¡Gracias por tu compra!! disfruta de la función");
    System.exit(0);
    
}
       
}

        
      
                       
           