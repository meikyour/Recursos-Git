/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.lib;

/**
 *
 * @author - Raul Granel - raul.granel@gmail.com
 */
public class Library {

    public static String obtenerString(String mensaje) {
        java.util.Scanner scn = new java.util.Scanner(System.in, "ISO-8859-1");
        String nombre = "";
        while (nombre.equals("")) {
            System.out.print(mensaje);
            nombre = scn.nextLine();
            if (nombre.equals("")) {
                System.out.println("Por favor introduce un valor");
            }
        }
        return nombre;
    }

    public static int obtenerInt(String mensaje) {
        java.util.Scanner scn = new java.util.Scanner(System.in, "ISO-8859-1");
        int nombre = 0;
        boolean testOK = true;
        while (testOK) {
            try {
                System.out.print(mensaje);
                nombre = scn.nextInt();
                testOK = false;
            } catch (Exception e) {
                System.out.println("Por favor introduce un valor");
            } finally {
                scn.nextLine();
            }
        }
        return nombre;
    }

    public static double obtenerDouble(String mensaje) {
        java.util.Scanner scn = new java.util.Scanner(System.in, "ISO-8859-1");
        double nombre = 0;
        boolean testOK = true;
        while (testOK) {
            try {
                System.out.print(mensaje);
                nombre = scn.nextDouble();
                testOK = false;
            } catch (Exception e) {
                System.out.println("Por favor introduce un valor");
            } finally {
                scn.nextLine();
            }
        }
        return nombre;
    }

    public static char obtenerChar(String usrMsg, String usrErr) {
        java.util.Scanner scn = new java.util.Scanner(System.in, "ISO-8859-1");
        boolean testOK = true;
        char i = ' ';
        while (testOK) {
            try {
                System.out.print(usrMsg);
                i = scn.nextLine().charAt(0);
                testOK = false;
            } catch (Exception e) {
                System.out.println(usrErr);
            }
        }
        return i;
    }

    public static boolean obtenerBoolean(String usrMsg, String usrErr) {
        java.util.Scanner scn = new java.util.Scanner(System.in, "ISO-8859-1");
        boolean testOK = true;
        boolean i = true;
        while (testOK) {
            try {
                System.out.print(usrMsg);
                i = scn.nextBoolean();
                testOK = false;
            } catch (Exception e) {
                System.out.println(usrErr);
            } finally {
                scn.nextLine();
            }
        }
        return i;
    }

    public static double segundoGrado(double a, double b, double c) {
        double x = (-b + Math.sqrt(Math.pow(b, 2.0) - 4 * a * c)) / (2 * a);
        return x;
    }

    public static int obtenerRandomInt(int MIN, int MAX) {
        java.util.Random rnd = new java.util.Random();
        return rnd.nextInt(MAX - MIN + 1) + MIN;
    }

    public static String generarPassword(int longitud) {
        String password = "";
        String letrasMay = "ABCDEFGHIJKLMNOPQRSTUVWXYZÇ";
        String letrasMin = "abcdefghijklmnopqrstuvwxyzç";
        String numeros = "1234567890";
        String especiales = "-_#$.:/+*()=?{}[]&¿";
        while (password.length() < longitud) {
            password = password + letrasMay.charAt(obtenerRandomInt(0, letrasMay.length() - 1));
            password = password + letrasMin.charAt(obtenerRandomInt(0, letrasMin.length() - 1));
            password = password + numeros.charAt(obtenerRandomInt(0, numeros.length() - 1));
            password = password + especiales.charAt(obtenerRandomInt(0, especiales.length() - 1));
        }
        return password.substring(0, longitud);
    }

    public static String getRestanteTiempo(int h, int m, int s) {
        java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
        long hora = gc.get(java.util.Calendar.HOUR_OF_DAY);
        long minuto = gc.get(java.util.Calendar.MINUTE);
        long segundo = gc.get(java.util.Calendar.SECOND);
        long rHora = h - hora;
        long rMinuto = m - minuto;
        long rSegundo = s - segundo;
        while (rMinuto < 0) {
            rMinuto = rMinuto + 60;
            rHora--;
        }

        while (rMinuto > 60) {
            rMinuto = rMinuto - 60;
            rHora++;
        }

        while (rSegundo < 0) {
            rSegundo = rSegundo + 60;
            rMinuto--;
        }

        while (rSegundo > 60) {
            rSegundo = rSegundo - 60;
            rMinuto++;
        }
        return String.format("Tiempo restante : %02d:%02d:%02d\n", rHora, rMinuto, rSegundo);
    }

    public static String getTiempoExtra(int h, int m, int s) {
        java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
        long hora = gc.get(java.util.Calendar.HOUR_OF_DAY);
        long minuto = gc.get(java.util.Calendar.MINUTE);
        long segundo = gc.get(java.util.Calendar.SECOND);
        return String.format("Hora de mas: %02d:%02d:%02d\n", hora - 10, minuto - 5, segundo);
    }

    public static double calcularPermimetroCirculo(double radio) {
        return 2 * Math.PI * radio;
    }

    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    public static double calcularAreaEsfera(double radio) {
        return 4 * Math.PI * Math.pow(radio, 2);
    }

    public static double calcularVolumenEsfera(double radio) {
        return 4.0 / 3 * Math.PI * Math.pow(radio, 3);
    }

    public static long getTiempoUnix() {
        long x = System.currentTimeMillis();
        return x;
    }

    private boolean comprobarFecha(int dia, int mes, int any) {
        return comprobarMes(mes) && comprobarDia(any, mes, dia);
    }

    private boolean comprobarMes(int mes) {
        return mes >= 0 && mes <= 12;
    }

    private boolean comprobarDia(int any, int mes, int dia) {
        int diasMax = obtenerDiasDelMes(any, mes);
        return dia >= 0 && dia <= diasMax;

    }

    private boolean comprobarMes31(int mes) {
        return mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12;
    }

    private boolean comprobarMes30(int mes) {
        return mes == 4 || mes == 6 || mes == 9 || mes == 11;
    }

    private int obtenerDiasDelMes(int any, int mes) {
        int dias;
        if (comprobarMes31(mes)) {
            dias = 31;
        } else if (comprobarMes30(mes)) {
            dias = 30;
        } else {
            dias = obtenerDiasFebrero(any);
        }
        return dias;
    }

    private boolean comprobarBisiesto(int any) {
        return any % 400 == 0 || any % 100 != 0 && any % 4 == 0;
    }

    private int obtenerDiasFebrero(int any) {
        int dias;
        if (comprobarBisiesto(any)) {
            dias = 29;
        } else {
            dias = 28;
        }
        return dias;
    }
}
