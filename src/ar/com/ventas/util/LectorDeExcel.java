/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.SubRubro;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/**
 *
 * @author Marcela
 */
public class LectorDeExcel {
    
    public static List<Producto> leerExcelProducto(File file) throws IOException, BiffException, Exception {
        Workbook archivoExcel = Workbook.getWorkbook(file);
        int cantidadFilas = archivoExcel.getSheet(0).getRows();
        Sheet hoja = archivoExcel.getSheet(0);
        List<Producto> listaProductos = new ArrayList<Producto>();
        Boolean salir = false;
        for (int i = 1; i < cantidadFilas; i++) {
            try {
                Producto prod = new Producto();
                prod.setRubro(new Rubro());
                prod.setSubRubro(new SubRubro());
                prod.setInactivo(false);
                prod.setCodigo(Integer.valueOf(hoja.getCell(0, i).getContents()));
                prod.setDetalle(hoja.getCell(1,i).getContents());
                prod.setStock(Float.valueOf(hoja.getCell(2,i).getContents().replaceAll("\\,", "\\.")));
                listaProductos.add(prod);
                salir = false;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en linea: " + String.valueOf(i+1));
                throw new Exception(ex);
            }
            if (salir){
                break;
            }
        }
        if (salir) {
            listaProductos = null;            
        }
        return listaProductos;
    }

    public static boolean validarExtension(File archivo) {
        String[] splitNombreArchivo = archivo.getName().split("\\.");
        String extension = splitNombreArchivo[splitNombreArchivo.length - 1];
        if (extension.equalsIgnoreCase(Constantes.EXTENSION_EXCEL_1)){
            return true;
        } else {
            return false;
        }        
    }
    
    public static List<Cliente> leerExcelCliente(File file) throws IOException, BiffException, Exception {
        Workbook archivoExcel = Workbook.getWorkbook(file);
        int cantidadFilas = archivoExcel.getSheet(0).getRows();
        Sheet hoja = archivoExcel.getSheet(0);
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        for (int i = 1; i < cantidadFilas; i++) {
            try {
                Cliente cliente = new Cliente();
                cliente.setCodigo(hoja.getCell(0,i).getContents());
                cliente.setRazonSocial(hoja.getCell(1,i).getContents());
                cliente.setCuit(hoja.getCell(2,i).getContents());
                cliente.setDomicilio(new Domicilio());
                cliente.getDomicilio().setCalle(hoja.getCell(3,i).getContents());
                cliente.getDomicilio().setNumero(hoja.getCell(4,i).getContents());
                cliente.getDomicilio().setPiso(hoja.getCell(5,i).getContents());
                cliente.getDomicilio().setDepartamento(hoja.getCell(6,i).getContents());
                cliente.getDomicilio().setCodigoPostal(hoja.getCell(7,i).getContents());
                cliente.getDomicilio().setLocalidad(hoja.getCell(8,i).getContents());
                cliente.setTelefono(hoja.getCell(9,i).getContents());
                cliente.setMail(hoja.getCell(10,i).getContents());
                cliente.setFormaDePago(Integer.valueOf(hoja.getCell(11,i).getContents()));
                cliente.setCategoriaDeIva(Integer.valueOf(hoja.getCell(12,i).getContents()));
                cliente.setDescuento((float) 0);
                cliente.setTieneDescuento(false);
                cliente.setSaldo(0.0);
                cliente.setActivo(true);
                listaClientes.add(cliente);
            }catch(Exception ex){
                throw new Exception(ex);
            }
        }
        return listaClientes;
    }
    
}
