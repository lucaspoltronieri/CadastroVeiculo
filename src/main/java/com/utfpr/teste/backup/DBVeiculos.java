package com.utfpr.teste.backup;

import com.utfpr.teste.Carga;
import com.utfpr.teste.Passeio;

public class DBVeiculos {

    private static Passeio listaPasseio[];
    private static Carga listaCarga[];

    public DBVeiculos() {
        listaPasseio = new Passeio[5];
        listaCarga = new Carga[5];
    }

    public static Passeio[] getListaPasseio() {
        return listaPasseio;
    }

    public static Carga[] getListaCarga() {
        return listaCarga;
    }

    public static void setListaPasseio(Passeio[] listaPasseio) {
        DBVeiculos.listaPasseio = listaPasseio;
    }

    public static void setListaCarga(Carga[] listaCarga) {
        DBVeiculos.listaCarga = listaCarga;
    }

    public static boolean adicionarPasseio(Passeio passeio) {
        for (int i = 0; i < listaPasseio.length; i++) {
            if (listaPasseio[i] == null) {
                listaPasseio[i] = passeio;
                return true;
            }
        }
        return false; // Vetor cheio
    }

    public static boolean adicionarCarga(Carga carga) {
        for (int i = 0; i < listaCarga.length; i++) {
            if (listaCarga[i] == null) {
                listaCarga[i] = carga;
                return true;
            }
        }
        return false; // Vetor cheio
    }

    public static Passeio buscarPasseioPorPlaca(String placa) {
        for (Passeio p : listaPasseio) {
            if (p != null && p.getPlaca().equalsIgnoreCase(placa)) {
                return p;
            }
        }
        return null;
    }

    public static Carga buscarCargaPorPlaca(String placa) {
        for (Carga c : listaCarga) {
            if (c != null && c.getPlaca().equalsIgnoreCase(placa)) {
                return c;
            }
        }
        return null;
    }
}
