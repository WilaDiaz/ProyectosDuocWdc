/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp8_s8_wilangely_Diaz_Calles;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author wdiaz
 */
public class Exp8_S8_Wilangely_Diaz_Calles {

   static final String nombreTeatro = "TEATRO MORO";
   static final int capacidadSala = 25;
   static int totalEntradasVendidas = 0;
   static int totalIngresos = 0;
   static String nombreCliente = "";
   static int edad = 0;
   static ArrayList<String> asientosSeleccionados = new ArrayList<>();
   
   static ArrayList<Ventas> ventas = new ArrayList<>();
   static boolean[][] asientos = new boolean[5][5];
   static Scanner sc = new Scanner(System.in);
   
    static class Ventas{
        String nombreCliente;
        String nombreEvento;
        String ubicacion;
        int precioBase;
        double descuentoAplicado;
        int precioFinal;
        int cantidadAsientos;
        ArrayList<String> asientosSeleccionados;
        
        public Ventas(String nombreCliente,String nombreEvento, String ubicacion, int precioBase, double descuentoAplicado, int precioFinal, int cantidadAsientos, ArrayList<String> asientosSeleccionados){
            this.nombreCliente = nombreCliente;
            this.nombreEvento = nombreEvento;
            this.ubicacion = ubicacion;
            this.precioBase = precioBase;
            this.descuentoAplicado = descuentoAplicado;
            this.precioFinal = precioFinal;
            this.cantidadAsientos = cantidadAsientos;
            this.asientosSeleccionados = asientosSeleccionados;
        }

        private Ventas(String nombreCliente, String nombreEvento, int precioBase, double descuentoAplicado, int precioFinal, boolean asientosReservados, ArrayList<String> asientosSeleccionados) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
    
    
    
    public static void main (String[] args){
        
        
        int opcion;
        
        do{
            System.out.println("\n---BIENVENIDO AL SISTEMA DE VENTAS DEL " + nombreTeatro + "---");
            System.out.println("1-. Compra de entrada");
            System.out.println("2-. Modificar o eliminar reserva");
            System.out.println("3-. Generar Boleta");
            System.out.println("4-. Salir");
            System.out.println("Selecciona una opcion del 1 al 4");
            opcion = sc.nextInt();
            sc.nextLine();
            
            
            switch (opcion){
                case 1:
                    compraDeEntrada(sc);
                    break;
                case 2:
                    modificarOeliminar();
                    break;
                case 3:
                    generarBoleta();
                    break;
                case 4:
                    System.out.println("VuelvePronto");
                    break;
                    default:
                    System.out.println("Opcion invalida intenta de nuevo");
                    
                }
            }while (opcion !=4);
        }
    
    public static void compraDeEntrada (Scanner sc){
        boolean finalizaSubmenu = false;
        int opcionEventos;
        
        do{
            System.out.println("---Menu de Eventos---");
            System.out.println("1-. El lago de los cisnes");
            System.out.println("2-. Romeo y Julieta");
            System.out.println("3-. La divina Comedia ");
            System.out.println("4-. El Fantasma de la Opera");
            System.out.println("5-. Hamlet");
            System.out.println("6-.---Volver al menu principal---");
            System.out.println("Selecciona tu obra de preferencia (del 1 al 6)");
            
            try{
                opcionEventos = sc.nextInt();
                sc.nextLine();
                
                String nombreEvento = "";
                switch (opcionEventos){
                    case 1:
                        nombreEvento = "El lago de los cisnes";
                        break;
                    case 2:
                        nombreEvento = "Romeo y Julieta";
                        break;
                    case 3:
                        nombreEvento = "La divina Comedia";
                        break;
                    case 4:
                        nombreEvento = "El fantasma dela opera";
                        break;
                    case 5:
                        nombreEvento = "Hamlet";
                        break;
                    case 6:
                        nombreEvento = "Volviendo al menu principal";
                        return;
                    default:
                        System.out.println("Opcion invlida, intente de nuevo");
                        continue;
                }
                System.out.println("\nSeleccionaste: " + nombreEvento);
                System.out.println("Indica tu nombre");
                nombreCliente = sc.nextLine();
                
                System.out.println("Hola " + nombreCliente + " Indicanos tu edad");
                edad = sc.nextInt();
                sc.nextLine();
                if (edad<=18){
                    System.out.println("\n Eres menor de edad! cuentas con un descuento promocional del 10%");
                    
                }else if (edad>60){
                    System.out.println("\nEres persona de la 3era edad, cuentas con un dcto del 15%");
    
}
                
                System.out.println("\n---Selecciona Ubicación---");
                System.out.println("1-.VIP ($30.000)");
                System.out.println("2-. Platea Baja ($25.000)");
                System.out.println("3-. Platea alta ($20.000)");
                System.out.println("4-. Cancha General ($15.000)");
                System.out.println("Selecciona la ubicación del 1 al 4");
                int ubicacionOpcion = sc.nextInt();
                sc.nextLine();
                
                String ubicacion = "";
                int precioBase = 0;
                switch (ubicacionOpcion){
                    case 1:
                        ubicacion = "VIP";
                        precioBase = 30000;
                        break;
                    case 2:
                        ubicacion = "Platea Baja";
                        precioBase = 25000;
                        break;
                    case 3:
                        ubicacion = "Platea Alta";
                        precioBase = 20000;
                        break;
                        case 4:
                    ubicacion = "Cancha General";
                        precioBase = 15000;
                        break;
                    default:
                        System.out.println("Seleccion Invalida, intenta de nuevo");
                        continue;
                    }
                
                System.out.println("\n ubicacion seleccionada con exito");
                SeleccionAsiento(sc, nombreCliente, nombreEvento, precioBase, ubicacion);

                finalizaSubmenu = true;
                
            } catch (Exception e) {
                    System.out.println("Opción inválida. Por favor, ingresa un número.");
                    sc.nextLine();
                    
        }
            
            
    }while (!finalizaSubmenu);
    }
    
    public static double calcularDescuentos (){
        double descuentoAplicado =0;
         if (edad < 18){
          descuentoAplicado = 0.10;
                
        }else if (edad >= 60){
           descuentoAplicado= 0.15;
        }    
            return descuentoAplicado;
}
public static void SeleccionAsiento (Scanner sc, String nombreCliente, String nombreEvento, int precioBase, String ubicacion){
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
    int asientosReservados = 0;
    
 for(int r =1; r <= cantidad; r++){
     int fila, columna;
     boolean reservado =false;
     
     do{
         System.out.println("\n---Vista de Asientos---");
         for(int i = 0; i < 5; i++){
            System.out.print("Fila " + (i + 1) + ": ");
            for(int j = 0; j < 5; j++){
                 System.out.print(asientos[i][j] ? "[X]" : "[ ]");
        }
            System.out.println();
             }
         
         try{
             System.out.println("\nSeleccion " + r + " de " + cantidad);
             System.out.print("elige la fila (del 1 al 5): ");
             fila= sc.nextInt()-1;
             System.out.print("Elige el numero de Asiento (del 1 al 5): ");
             columna = sc.nextInt()-1;
             sc.nextLine();
             
             if (fila >=0 && fila < 5 && columna >= 0 && columna < 5){
                if(!asientos[fila][columna]){
                    asientos[fila][columna]=true;
                    System.out.println("Asiento(s) Reservado correctamente");
                    reservado = true;
                    asientosReservados++;
                    asientosSeleccionados.add("Fila " + (fila+1) + ", Asiento " + (columna + 1));
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

        System.out.println("\n---Vista de Asientos Reservados---");
        for(int i =0; i< asientos.length; i++){
            System.out.println("Fila " + (i +1)+ ": ");
            for(int j =0; j< asientos[i].length; j++){
                System.out.print(asientos[i][j] ? "[X]" : "[ ]");
            }
        System.out.println();
        }
        System.out.println("\n---Detalle de asientos reservados---");
        for (int i = 0; i < asientos.length; i++){
            for (int j =0; j < asientos[i].length; j++){
                if (asientos[i][j]){
                    System.out.println("Fila " + (i + 1) + ", Asiento " + (j + 1));
}
}
                    System.out.println("¿Deseas continuar con la venta?(S/N)");
                    String confirmar = sc.nextLine();
                    if(confirmar.equalsIgnoreCase("S")){
                    
                    double descuentoAplicado = calcularDescuentos();
                    int precioTotalBase = precioBase * asientosReservados;
                     resumenVenta(sc, precioTotalBase, descuentoAplicado, precioBase, asientosReservados, nombreCliente, nombreEvento,ubicacion, asientosSeleccionados);

} else {
    boolean salirMenu = false;
        do{
            System.out.println("\n¿Que deseas realizar?");
            System.out.println("1-. Agregar asiento");
            System.out.println("2-. Cancelar compra y volver al menu principal");
            System.out.println("3-. eliminar asiento");
            System.out.println("4-. Continuar y finalizar compra");
            
            int opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion){
                case 1:
                    
                    SeleccionAsiento (sc,nombreCliente, nombreEvento,precioBase, ubicacion);
                    salirMenu = true;
                    break;
                case 2:
                    for (String asiento : asientosSeleccionados){
                String[] partes = asiento.replace("fila ","").replace("Asiento","").split(",");
                    int fila = Integer.parseInt(partes[0].trim()) - 1;
                    int columna = Integer.parseInt(partes[1].trim())-1;
                    asientos[fila][columna]=false;
                    }
                    System.out.println("Compra Cancelada, Volviendo al menu principal");
                    salirMenu= true;
                    return;
                case 3:
                    if (asientosSeleccionados.isEmpty()){
                        System.out.println("No hay asientos seleccionados");
                        break;
}
                    System.out.println("\n----Asientos reservaods actualmente----");
                        for(int j =0; j < asientosSeleccionados.size(); j++){
                            System.out.println(j+1+"." + asientosSeleccionados.get(j));
                    }
                    System.out.println("Ingresa el numero de asientos que deseas eliminar");
                            try {
                           int indexEliminar = sc.nextInt()-1;
                            sc.nextLine();
                            
                            if(indexEliminar >= 0 && indexEliminar < asientosSeleccionados.size()){
                                String asientoAEliminar = asientosSeleccionados.get(indexEliminar);
                                
                                String[] partes = asientoAEliminar.replace("Fila","").replace("Asiento","").split(",");
                                int fila = Integer.parseInt(partes[0].trim()) - 1;
                                int columna = Integer.parseInt(partes[1].trim())-1;
                                
                                asientos[fila][columna]= false;
                                asientosSeleccionados.remove(indexEliminar);
                                asientosReservados--;
                                System.out.println("Asiento eliminado correctamente");
                            }else{
                                System.out.println("Numero fuera de rango");
                            }
                            }catch (Exception e){
                                System.out.println("ingreso invalido");
                                sc.nextLine();
                            }
                            break;
                case 4:
                    double descuentoAplicado = calcularDescuentos();
                    int precioTotalBase = precioBase * asientosSeleccionados.size();
                    resumenVenta(sc, precioTotalBase, descuentoAplicado, precioBase, asientosSeleccionados.size(), nombreCliente, nombreEvento, ubicacion, asientosSeleccionados);
                    salirMenu = true;
                    break;
                default:
                    System.out.println("Seleccion erronea, ingresa un numero del 1 al 4");
                    break;
            }
        }while (!salirMenu);
                }
            }
        }


public static void modificarOeliminar(){
    System.out.println("\n---Modificar o eliminar reserva---");
    if (ventas.isEmpty()){
        System.out.println("No hay reservas para modificar o eliminar");
        return;
    }
    for (int i =0; i < ventas.size(); i++){
        Ventas v = ventas.get(i);
        System.out.println((i+1)+ ". Cliente " + v.nombreCliente + "| Ubicacion" + v.ubicacion);
    }
    System.out.print("Seleccione el número de la reserva que desea eliminar: ");
    int seleccion = sc.nextInt();
    sc.nextLine();
    
    if (seleccion >= 1 && seleccion <= ventas.size()){
        Ventas reserva = ventas.get(seleccion - 1);
        
        for (String asiento : reserva.asientosSeleccionados){
            String[] partes = asiento.replace("Fila ","").replace("Asiento","").split(",");
            int fila = Integer.parseInt(partes[0].trim()) - 1;
            int columna = Integer.parseInt(partes[1].trim())-1;
        }
        ventas.remove(seleccion -1);
        System.out.println("Reserva eliminada correctamente");
 
    }else{ 
        System.out.println("Numero de reserva invalido.");
    }
}
public static void resumenVenta (Scanner sc, int precioTotalBase,double descuentoAplicado, int precioBase, int asientosReservados, String nombreCliente, String nombreEvento, String ubicacion, ArrayList<String> asientosSeleccionados){
    
    int precioFinal = (int) (precioTotalBase - (precioTotalBase * descuentoAplicado)); 
                    
            Ventas nuevaVenta = new Ventas(
                        nombreCliente,
                        nombreEvento,
                        ubicacion,
                        precioBase,
                        descuentoAplicado,
                        precioFinal,
                        asientosReservados,
                        asientosSeleccionados
                );
                ventas.add(nuevaVenta);
                
    
    
    System.out.println("\n---RESUMEN DE RESERVA---");
    
    if(ventas.isEmpty()){
        System.out.println("No hay compras registradas");
        return;        
    }
    for(int i = 0; i < ventas.size(); i++){
        Ventas v = ventas.get(i);
        
        System.out.println("\n Venta #" + (i + 1));
        System.out.println("Nombre de cliente: " + v.nombreCliente);
        System.out.println("Nombre del Evento: " + v.nombreEvento);
        System.out.println("Ubicación: " + v.ubicacion);
        System.out.println("Cantidad de Asientos: " + v.cantidadAsientos);
        System.out.println("Asientos Seleccionados: ");
        for(String asiento : v.asientosSeleccionados){
            System.out.println("-" + asiento);
        }
        System.out.println("Precio de asiento: $" + v.precioBase);
        System.out.println("Precio total: $" + v.precioBase * v.cantidadAsientos);
        System.out.println("Descuento aplicado: " + (v.descuentoAplicado * 100)+ "%");
        System.out.println("Precio Final a pagar: $" + v.precioFinal);
}
    System.out.println("\n Deseas confirmar o eliminar compra? (s/n)");
    String respuesta = sc.next().toLowerCase();
    
    if(respuesta.equalsIgnoreCase("s")){
    System.out.println("Compra confirmada");
    generarBoleta();
    
}else if (respuesta.equals("n")){
    System.out.println("volviendo al menu");
    
}else{
        System.out.println("Opcion Invalida, intenta nuevamente");
        }

}
public static void generarBoleta(){
    System.out.println("\n---BOLETA DE COMPRA---");
    System.out.println("Teatro: " + nombreTeatro);
    
    if (ventas.isEmpty()){
        System.out.println("No hay ventas registradas");
        return;
    }
    
    int totalFinal = 0;
    for(int i = 0; i < ventas.size(); i++){
        Ventas v = ventas.get(i);
        System.out.println(" Venta #" + (i + 1));
        System.out.println("-------------------------");
        System.out.println("\nCliente: " + v.nombreCliente);
        System.out.println("Nombre del Evento: " + v.nombreEvento);
        System.out.println("Ubicacion: " + v.ubicacion);
        System.out.println("Cantidad de Asientos: " + v.cantidadAsientos);
        System.out.println("Asientos Seleccionados: ");
        for(String asiento : v.asientosSeleccionados){
            System.out.println("-" + asiento);
        }
        System.out.println("Precio por asiento" + v.precioBase);
        System.out.println("Precio total: $" + v.precioBase * v.cantidadAsientos);
        System.out.println("Descuento aplicado: " + (v.descuentoAplicado * 100)+ "%");
        System.out.println("Precio Final a pagar: $" + v.precioFinal);
        totalFinal += v.precioFinal;
    }
        
        System.out.println("\n----------------------");
        System.out.println("Total a pagar: $" + totalFinal);
        System.out.println("\n----------------------");
        System.out.println("¡Gracias por tu compra!");
        System.exit(0);
        
    }
}



    
  