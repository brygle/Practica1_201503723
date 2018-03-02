/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1practica1_201503723;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Bryan
 */
public class Menu {

    Scanner entrada = null;

    public void MenuPrincipal() {
        String opcion;
        entrada = new Scanner(System.in);
        System.out.println("\nMenú Principal");
        System.out.println("\n1. Dificultad del juego");
        System.out.println("2. Parámetros iniciales");
        System.out.println("3. Iniciar Juego");
        System.out.println("4. Salir");
        opcion = entrada.nextLine();
        switch (opcion) {
            case "1":
                MenuDificultadDelJuego();
                break;
            case "2":
                MenuParametrosIniciales();
                break;
            case "3":
                tablero = new Tablero(this.dificultad);
                tablero.setBajadas(bajadas);
                tablero.setSubidas(subidas);
                tablero.asignarNumeroCelda();
                Algoritmo();
                break;
            case "4":
                exit(0);
            default:
                System.out.println("\nOPCIÓN INCORRECTA");
                MenuPrincipal();
        }

    }

    public void Algoritmo() {
        int turno = 0;
        int random;
        int fila, columna;
        String texto, textoNuevo;
        while (turno < jugadores) {
            texto = tablero.getMatriz(0, 0);
            textoNuevo = texto.substring(0, turno + 1) + usuario[turno].getCaracterUsuario() + texto.substring((turno + 2), (texto.length()));
            tablero.setMatriz(0, 0, textoNuevo);
            turno++;
        }
        AsignarSubida();
        tablero.imprimirMatriz();
        turno = 0;
        while (true) {
            System.out.println("\nTURNO DEL JUGADOR " + (turno + 1) + " " + usuario[turno].getCaracterUsuario());
            entrada.nextLine();
            System.out.println("Lanzara los dados! Presione cualquier tecla para continuar");
            entrada.nextLine();
            random = usuario[turno].getRandom(dificultad);
            System.out.println("Avanzara " + random + " casillas ");
            entrada.nextLine();
            //obtengo la celda
            texto = tablero.getMatriz(usuario[turno].getFila(), usuario[turno].getColumna());
            //limpio la matriz
            textoNuevo = texto.substring(0, turno + 1) + " " + texto.substring((turno + 2), (texto.length()));
            //seteo la celda nueva
            tablero.setMatriz(usuario[turno].getFila(), usuario[turno].getColumna(), textoNuevo);
            usuario[turno].setFilaColumna(random, dificultad);
            fila = usuario[turno].getFila();
            columna = usuario[turno].getColumna();
            //validacion si el juego termino
            if (dificultad == 1 && fila > 4) {
                texto = tablero.getMatriz(4, 7);
                textoNuevo = texto.substring(0, turno + 1) + usuario[turno].getCaracterUsuario() + texto.substring((turno + 2), (texto.length()));
                tablero.setMatriz(4, 7, textoNuevo);
                tablero.imprimirMatriz();
                System.out.println("\nFELICITACIONES!!! EL GANADOR DEL JUEGO HA SIDO EL JUGADOR " + (turno + 1));
                entrada.nextLine();
                MenuPrincipal();
            } else if (dificultad == 2 && fila > 19) {
                texto = tablero.getMatriz(19, 0);
                textoNuevo = texto.substring(0, turno + 1) + usuario[turno].getCaracterUsuario() + texto.substring((turno + 2), (texto.length()));
                tablero.setMatriz(19, 0, textoNuevo);
                tablero.imprimirMatriz();
                System.out.println("\nFELICITACIONES!!! EL GANADOR DEL JUEGO HA SIDO EL JUGADOR " + (turno + 1));
                entrada.nextLine();
                MenuPrincipal();
            }
            //obtengo la nueva celda
            texto = tablero.getMatriz(usuario[turno].getFila(), usuario[turno].getColumna());
            //texto de la nueva casilla
            textoNuevo = texto.substring(0, turno + 1) + usuario[turno].getCaracterUsuario() + texto.substring((turno + 2), (texto.length()));
            //seteo el texto nuevo
            tablero.setMatriz(usuario[turno].getFila(), usuario[turno].getColumna(), textoNuevo);
            tablero.imprimirMatriz();
            //verifico lo que hay en la celda
            fila = usuario[turno].getFila();
            columna = usuario[turno].getColumna();

            while (tablero.getMatriz(fila, columna).substring(6, 7).equalsIgnoreCase("+")
                    || tablero.getMatriz(fila, columna).substring(6, 7).equalsIgnoreCase("-")) {
                if (tablero.getMatriz(fila, columna).substring(6, 7).equalsIgnoreCase("+")) {
                    System.out.println("HA CAIDO EN UNA CASILLA ESPECIAL");
                    random = usuario[turno].getRandom(dificultad);
                    System.out.println("Avanzara " + random + " casillas ");
                    entrada.nextLine();
                    texto = tablero.getMatriz(usuario[turno].getFila(), usuario[turno].getColumna());
                    textoNuevo = texto.substring(0, turno + 1) + " " + texto.substring((turno + 2), (texto.length()));
                    tablero.setMatriz(usuario[turno].getFila(), usuario[turno].getColumna(), textoNuevo);
                    usuario[turno].setFilaColumna(random, dificultad);
                    fila = usuario[turno].getFila();
                    columna = usuario[turno].getColumna();
                    if (dificultad == 1 && fila > 4) {
                        texto = tablero.getMatriz(4, 7);
                        textoNuevo = texto.substring(0, turno + 1) + usuario[turno].getCaracterUsuario() + texto.substring((turno + 2), (texto.length()));
                        tablero.setMatriz(4, 7, textoNuevo);
                        tablero.imprimirMatriz();
                        System.out.println("\nFELICITACIONES!!! EL GANADOR DEL JUEGO HA SIDO EL JUGADOR " + (turno + 1));
                        entrada.nextLine();
                        MenuPrincipal();
                    } else if (dificultad == 2 && fila > 19) {
                        texto = tablero.getMatriz(19, 0);
                        textoNuevo = texto.substring(0, turno + 1) + usuario[turno].getCaracterUsuario() + texto.substring((turno + 2), (texto.length()));
                        tablero.setMatriz(19, 0, textoNuevo);
                        tablero.imprimirMatriz();
                        System.out.println("\nFELICITACIONES!!! EL GANADOR DEL JUEGO HA SIDO EL JUGADOR " + (turno + 1));
                        entrada.nextLine();
                        MenuPrincipal();
                    }
                    //obtengo la nueva celda
                    texto = tablero.getMatriz(usuario[turno].getFila(), usuario[turno].getColumna());
                    //texto de la nueva casilla
                    textoNuevo = texto.substring(0, turno + 1) + usuario[turno].getCaracterUsuario() + texto.substring((turno + 2), (texto.length()));
                    //seteo el texto nuevo
                    tablero.setMatriz(usuario[turno].getFila(), usuario[turno].getColumna(), textoNuevo);
                    tablero.imprimirMatriz();
                } else if (tablero.getMatriz(fila, columna).substring(6, 7).equalsIgnoreCase("-")) {
                    System.out.println("HA CAIDO EN UNA CASILLA ESPECIAL");
                    random = usuario[turno].getRandom(dificultad);
                    System.out.println("Regresara " + random + " casillas ");
                    entrada.nextLine();
                    texto = tablero.getMatriz(usuario[turno].getFila(), usuario[turno].getColumna());
                    textoNuevo = texto.substring(0, turno + 1) + " " + texto.substring((turno + 2), (texto.length()));
                    tablero.setMatriz(usuario[turno].getFila(), usuario[turno].getColumna(), textoNuevo);
                    usuario[turno].setFilaColumnaNegativo(random, dificultad);
                    fila = usuario[turno].getFila();
                    columna = usuario[turno].getColumna();
                    if (dificultad == 1 && fila > 4) {
                        texto = tablero.getMatriz(4, 7);
                        textoNuevo = texto.substring(0, turno + 1) + usuario[turno].getCaracterUsuario() + texto.substring((turno + 2), (texto.length()));
                        tablero.setMatriz(4, 7, textoNuevo);
                        tablero.imprimirMatriz();
                        System.out.println("\nFELICITACIONES!!! EL GANADOR DEL JUEGO HA SIDO EL JUGADOR " + (turno + 1));
                        entrada.nextLine();
                        MenuPrincipal();
                    } else if (dificultad == 2 && fila > 19) {
                        texto = tablero.getMatriz(19, 0);
                        textoNuevo = texto.substring(0, turno + 1) + usuario[turno].getCaracterUsuario() + texto.substring((turno + 2), (texto.length()));
                        tablero.setMatriz(19, 0, textoNuevo);
                        tablero.imprimirMatriz();
                        System.out.println("\nFELICITACIONES!!! EL GANADOR DEL JUEGO HA SIDO EL JUGADOR " + (turno + 1));
                        entrada.nextLine();
                        MenuPrincipal();
                    }
                    //obtengo la nueva celda
                    texto = tablero.getMatriz(usuario[turno].getFila(), usuario[turno].getColumna());
                    //texto de la nueva casilla
                    textoNuevo = texto.substring(0, turno + 1) + usuario[turno].getCaracterUsuario() + texto.substring((turno + 2), (texto.length()));
                    //seteo el texto nuevo
                    tablero.setMatriz(usuario[turno].getFila(), usuario[turno].getColumna(), textoNuevo);
                    tablero.imprimirMatriz();
                }
            }
            turno++;
            if (turno == jugadores) {
                turno = 0;
            }
        }

    }

    int dificultad;
    int subidasMin, subidasMax, bajadasMin, bajadasMax;
    int random;
    int jugadoresMin = 2;
    int jugadoresMax = 3;

    public void MenuDificultadDelJuego() {
        entrada = new Scanner(System.in);
        String opcion;
        System.out.println("\nDificultad del Juego");
        System.out.println("\n1. Fácil");
        System.out.println("2. Difícil");
        System.out.println("3. Regresar");
        opcion = entrada.nextLine();
        switch (opcion) {
            case "1":
                System.out.println("\nDificultad fácil seleccionada.");
                System.out.println("Jugadores: 2 a 3");
                System.out.println("Subidas 5 a 10");
                System.out.println("Bajones 5 a 10");
                dificultad = 1;
                subidasMin = 5;
                subidasMax = 10;
                bajadasMin = 5;
                bajadasMax = 10;
                random = 6;
                filas = 5;
                columnas = 8;
                MenuPrincipal();
                break;
            case "2":
                System.out.println("\nDificultad difícil seleccionada.");
                System.out.println("Jugadores: 2 a 4");
                System.out.println("Subidas 20 a 40");
                System.out.println("Bajones 20 a 40");
                dificultad = 2;
                subidasMin = 20;
                subidasMax = 40;
                bajadasMin = 20;
                bajadasMax = 40;
                jugadoresMax = 4;
                random = 12;
                filas = 20;
                columnas = 10;
                MenuPrincipal();
                break;
            case "3":
                MenuPrincipal();
                break;
            default:
                System.out.println("\nOPCIÓN INCORRECTA");
                MenuDificultadDelJuego();
        }

    }

    int jugadores;
    Tablero tablero = null;
    int subidas;
    int bajadas;
    Usuario[] usuario = new Usuario[4];

    public void MenuParametrosIniciales() {
        entrada = new Scanner(System.in);
        String caracterUsuario;
        String opcion;
        System.out.println("\nParametros Iniciales");
        System.out.println("\n1. Jugadores");
        System.out.println("2. Subidas y Bajones");
        System.out.println("3. Regresar");
        opcion = entrada.nextLine();
        switch (opcion) {
            case "1":
                System.out.println("\nIngrese el numero de jugadores:");
                jugadores = entrada.nextInt();
                while (jugadores < jugadoresMin || jugadores > jugadoresMax) {
                    System.out.println("\nEl juego es solamente de " + jugadoresMin + " a " + jugadoresMax + " jugadores");
                    System.out.println("Ingrese nuevamente el numero de jugadores");
                    jugadores = entrada.nextInt();
                }
                int i,
                 j;
                for (i = 0; i < jugadores; i++) {
                    System.out.println("\nIngrese el simbolo del jugador " + (i + 1));
                    caracterUsuario = "" + entrada.next();
                    int c = 0;
                    while (c < i) {
                        while (caracterUsuario.length() != 1) {
                            System.out.println("\nDEBE INGRESAR SOLO UN CARACTER O EL CARACTER ES INVALIDO");
                            System.out.println("INTENTE NUEVAMENTE");
                            caracterUsuario = "" + entrada.next();
                        }

                        if (caracterUsuario.equalsIgnoreCase(this.usuario[c].getCaracterUsuario())) {
                            System.out.println("\nEL CARACTER YA EXISTE! INGRESE OTRO!");
                            caracterUsuario = entrada.next();
                            c = 0;
                        } else {
                            c++;
                        }
                    }

                    usuario[i] = new Usuario(caracterUsuario);
                }

                MenuParametrosIniciales();
                break;
            case "2":
                System.out.println("\nIngrese Numero de Subidas: ");
                subidas = entrada.nextInt();
                while (subidas < subidasMin || subidas > subidasMax) {
                    System.out.println("\nLa cantidad de subidas debe estar entre " + subidasMin + " y " + subidasMax);
                    System.out.println("Vuelva a ingresar la cantidad de subidas");
                    subidas = entrada.nextInt();
                }
                System.out.println("\nIngrese Numero de Bajones: ");
                bajadas = entrada.nextInt();
                while (bajadas < bajadasMin || bajadas > bajadasMax) {
                    System.out.println("\nLa cantidad de bajones debe estar entre " + bajadasMin + " y " + bajadasMax);
                    System.out.println("Vuelva a ingresar la cantidad de bajadas");
                    bajadas = entrada.nextInt();
                }

                subidaBajon = new SubidaBajon[subidas + bajadas];
                MenuParametrosIniciales();
                break;
            case "3":
                MenuPrincipal();
                break;
            default:
                System.out.println("\nOPCIÓN INCORRECTA");
                MenuParametrosIniciales();
        }
    }
    int filas;
    int columnas;

    public void AsignarSubida() {
        boolean bandera = false;
        int contador = 0;
        int x, y;
        String texto, textoNuevo;
        for (int i = 0; i < (subidas + bajadas); i++) {
            do {
                x = (int) ((Math.random() * (filas)));
                y = (int) (Math.random() * (columnas));
                subidaBajon[i] = new SubidaBajon();
                subidaBajon[i].setX(x);
                subidaBajon[i].setY(y);
                contador = 0;
                while (contador < i) {
                    if (subidaBajon[i].getX() == 0
                            && subidaBajon[i].getY() == 0) {
                        bandera = true;
                    } else if ((dificultad == 1)
                            && (subidaBajon[i].getX() == filas - 1)
                            && (subidaBajon[i].getY() == columnas - 1)) {
                        bandera = true;
                    } else if ((dificultad == 2)
                            && (subidaBajon[i].getX() == filas - 1)
                            && (subidaBajon[i].getY() == 0)) {
                        bandera = true;
                    } else if ((subidaBajon[i].getX() == subidaBajon[contador].getX())
                            && (subidaBajon[i].getY() == subidaBajon[contador].getY())) {
                        bandera = true;
                    } else if ((subidaBajon[i].getX() == subidaBajon[contador].getX())
                            && (subidaBajon[i].getY() > 0)
                            && (subidaBajon[i].getY() < columnas - 1)
                            && (subidaBajon[i].getY() == (subidaBajon[contador].getY() - 1))) {
                        bandera = true;
                    } else if ((subidaBajon[i].getX() == subidaBajon[contador].getX())
                            && (subidaBajon[i].getY() > 0)
                            && (subidaBajon[i].getY() < columnas - 1)
                            && (subidaBajon[i].getY() == (subidaBajon[contador].getY() + 1))) {
                        bandera = true;
                    } else if ((subidaBajon[i].getX() == subidaBajon[contador].getX())
                            && (subidaBajon[i].getY() == 0)
                            && (subidaBajon[i].getY() == (subidaBajon[contador].getY() + 1))) {
                        bandera = true;
                    } else if ((subidaBajon[i].getX() == subidaBajon[contador].getX())
                            && (subidaBajon[i].getY() == columnas - 1)
                            && (subidaBajon[i].getY() == (subidaBajon[contador].getY() - 1))) {
                        bandera = true;
                    } else if ((subidaBajon[i].getX() == subidaBajon[contador].getX())
                            && (subidaBajon[i].getY() == 0)
                            && (subidaBajon[i].getY() == (subidaBajon[contador].getY() - 1))) {
                        bandera = true;
                    } else if ((subidaBajon[i].getX() == subidaBajon[contador].getX())
                            && (subidaBajon[i].getY() == columnas - 1)
                            && (subidaBajon[i].getY() == (subidaBajon[contador].getY() + 1))) {
                        bandera = true;
                    } else {
                        bandera = false;
                    }

                    if (bandera == true) {
                        contador = 300;
                    } else {
                        contador++;
                    }
                }

            } while (bandera == true);

        }
        int k;
        for (k = 0; k < (subidas + bajadas); k++) {
            if (k < subidas) {
                texto = tablero.getMatriz(subidaBajon[k].getX(), subidaBajon[k].getY());
                textoNuevo = texto.substring(0, 6) + "+" + texto.substring(7, texto.length());
                tablero.setMatriz(subidaBajon[k].getX(), subidaBajon[k].getY(), textoNuevo);
            } else {
                texto = tablero.getMatriz(subidaBajon[k].getX(), subidaBajon[k].getY());
                textoNuevo = texto.substring(0, 6) + "-" + texto.substring(7, texto.length());
                tablero.setMatriz(subidaBajon[k].getX(), subidaBajon[k].getY(), textoNuevo);
            }
        }
    }
    SubidaBajon[] subidaBajon = null;
}
