/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp4_s4_wilangely_diaz;

import java.util.Scanner;

/**
 *
 * @author wdiaz
 */
public class Exp4_S4_Wilangely_Diaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        
    Scanner sc = new Scanner (System.in);
      
       int fila = 5;
       int asiento = 5;

          
         boolean[] fila1 = new boolean[asiento];
         boolean[] fila2 = new boolean[asiento];
         boolean[] fila3 = new boolean[asiento];
         boolean[] fila4 = new boolean[asiento];
         boolean[] fila5 = new boolean[asiento];
         
        boolean salir = false;

        System.out.println("¡Hola! bienvenido al sistema de Boleteria");
        System.out.println("Indicanos tu nombre");
        String nombre = sc.nextLine();
                
    for (; !salir ;) {
        System.out.println(".....MENU.....");
        System.out.println("Elige una opción:");
        System.out.println (" 1-. Comprar entrada");
        System.out.println (" 2-. Salir");
        
        int seleccion = sc.nextInt();
        sc.nextLine();
        
        if (seleccion <1 ||seleccion >2){
            System.out.println("Opcion invalida intenta de nuevo");
            continue;
        }
        
        switch (seleccion) {
            case 1:
                salir = true;
                   System.out.println("Asientos disponibles: (X= ocupado , 0= disponible");
                for (int f = 1; f <= fila; f++ ){
                boolean [] filaTemporal = null;
                
                if (f==1) filaTemporal = fila1;
                else if (f==2) filaTemporal = fila2;
                else if (f==3) filaTemporal = fila3;
                else if (f==4) filaTemporal = fila4;
                else filaTemporal = fila5;

                System.out.print("fila " + f + "= ");
                for (int a = 0; a < asiento; a++){
                    if(filaTemporal[a]){
                        System.out.print("[X]");
                    }else {
                        System.out.print("[0]");
                    }
                }
                       System.out.println();
                }

        
         System.out.println("Seleccione una fila (1-" + fila + ")o 0 para salir");
          int filaSeleccionada = sc.nextInt();
          sc.nextLine();
          
          if(filaSeleccionada == 0){
           System.out.println("Salir");
            salir = true;
            break;
          }  
        if(filaSeleccionada <1 || filaSeleccionada > fila){
           System.out.println("Fila invalida");
           continue;
           

           }
           System.out.println("Seleccione un asiento (1-" + asiento + "):");
           int asientoSeleccionado = sc.nextInt();
           sc.nextLine();
        if (asientoSeleccionado < 1 || asientoSeleccionado > asiento){
               System.out.println("Asiento invalido");
               continue;

           }
           
           boolean[]filaActual;
           if (filaSeleccionada ==1) filaActual = fila1;
           else if (filaSeleccionada ==2) filaActual = fila2;
           else if (filaSeleccionada ==3) filaActual = fila3;
           else if (filaSeleccionada ==4) filaActual = fila4;
           else filaActual = fila5;
           
           if (filaActual[asientoSeleccionado - 1]){
               System.out.println("El asiento ya esta ocupado.");
           }else{
               filaActual[asientoSeleccionado -1]=true;
               System.out.println("¡Asiento reservado con exito!");
           
                
        int precioBase = 15000;
           
           System.out.println("Valor de la entrada: "+ precioBase);
           System.out.println("Ingresa tu edad: ");
           int edad = sc.nextInt();
           sc.nextLine();
           
          
           double descuento = 0.0;

           
           if(edad <=17){
                descuento = 0.10;
                System.out.println("Tienes un descuento del 10% por ser menor de edad");
         }else if(edad >= 60){
                descuento = 0.15;
                System.out.println("Tienes un descuento del 15% por ser persona de la tarcera edad");
         }else{
                descuento = 0.0;
                     System.out.println("Paga el total del valor");
         }
       
                       
         double totalPagar= precioBase - (precioBase * descuento);
         System.out.println("Total a pagar; $"+totalPagar);
         
         System.out.println("----RESUMEN DE COMPRA----");
         System.out.println("Nombre del Usuario: "+nombre);
         System.out.println("Fila Seleccionada: "+filaSeleccionada);
         System.out.println("Asiento Seleccionado: "+asientoSeleccionado);
         System.out.println("Edad de " + nombre + ":"+ edad);
         System.out.println("Precio Base: $"+ precioBase);
         System.out.println("Descuento aplicado:"+descuento);
         System.out.println("Valor total a pagar: $"+totalPagar);
         
         
        System.out.println("¿Deseas realizar otra compra? (s/n)");
         String respuesta = sc.next().toLowerCase();            
         if (!respuesta.equals("s")){
             salir= true;
             System.out.println("Gracias por usar el sistema de Boleteria");
             sc.close();
        if (!respuesta.equals("s") || !respuesta.equals("n")){
            System.out.println("Opcion invalida intenta de nuevo");
            continue;
            
        }
         }
         break;
         
         

           }    
        case 2:
                System.out.println("Ok, Adios");
                sc.close();
                return;
                
            default:
                System.out.println("Opción inválida. Intenta de nuevo");
                break;
              }

            } 
    }
    }



               



            