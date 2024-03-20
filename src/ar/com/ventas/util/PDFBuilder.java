/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.ListaPrecios;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.entities.RenglonNotaCredito;
import ar.com.ventas.entities.Rental;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.SubRubro;
import ar.com.ventas.services.ConfiguracionService;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.WebColors;
import java.awt.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Math.rint;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcvalls
 */
public class PDFBuilder {

    private static final BaseColor FONDO_BLANCO = WebColors.getRGBColor("#FFFFFF");
    private static final BaseColor NEGRO = WebColors.getRGBColor("#000000");
    private Boolean tieneDto = false;
    private final DecimalFormat dfs = new DecimalFormat("0000");
    private final DecimalFormat dfn = new DecimalFormat("00000000");
    private static final DecimalFormat df = new DecimalFormat("#0.00");
    private final DecimalFormat dfc = new DecimalFormat("#0");
    private final DecimalFormat df_ali = new DecimalFormat("#0.0");
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
    private final SimpleDateFormat sdff = new SimpleDateFormat("ddMMyyyy");
    private static final Integer tamLetra = 8;

    private final int BOLD = Font.BOLD;
    private final int PLAIN = Font.PLAIN;

    private String getFileNameFormatted(Activity cons) {
        String filename = "Pr_"
                + "X_" + dfs.format(cons.getNumeroSucursal())
                + "_" + dfn.format(cons.getNumeroFactura())
                + "_" + sdff.format(cons.getFecha())
                + ".pdf";
        return filename;
    }

    private String getFileNameFormattedNc(IvaVentas cons) {
        String filename = "Nc_"
                + cons.getLetra() + dfs.format(cons.getNumeroSucursal()) + "_"
                + dfn.format(cons.getNumeroFactura())
                + "_" + sdff.format(cons.getFecha()) + ".pdf";
        return filename;
    }

    private String getFileNameFormattedNd(IvaVentas cons) {
        String filename = "Nd_"
                + cons.getLetra() + dfs.format(cons.getNumeroSucursal()) + "_"
                + dfn.format(cons.getNumeroFactura())
                + "_" + sdff.format(cons.getFecha()) + ".pdf";
        return filename;
    }
//    

    private String getFileProductosFormatted() {
        String ff = sdf2.format(new Date());
        String filename = "c://pdf//productos_"
                + ff + ".pdf";
        return filename;
    }

    private String getFileNameFormatted2(IvaVentas cons) {
        String filename = "Fc_"
                + "A" + dfs.format(cons.getNumeroSucursal())
                + dfn.format(cons.getNumeroFactura())
                + "_" + sdff.format(cons.getFecha()) + ".pdf";
        return filename;
    }

    private String getFileNameFormatted3(IvaVentas cons) {
        String filename = "Fc_"
                + "B" + dfs.format(cons.getNumeroSucursal())
                + dfn.format(cons.getNumeroFactura())
                + "_" + sdff.format(cons.getFecha()) + ".pdf";
        return filename;
    }

    public File armarPresup(Cliente cli, Activity iv, List<ActivityRow> rf, Integer caNo, Integer caMs, Double sA1, Double sT1, Boolean saldos) throws FileNotFoundException, DocumentException, Exception {

        String fileNameFormatted = getFileNameFormatted(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
        String cod = " ";;
        String fex = sdf.format(iv.getFecha());
        String nro = "X "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        //PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("SERVICIOS PROFESIONALES GENERALES", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("X", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("PRESUPUESTO", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph(" " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("  ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = cli.getRazonSocial();
        String codi = cli.getCodigo();
        String direcc = cli.getDomicilio().getCalle();
        if (cli.getDomicilio().getNumero() != null) {
            direcc += " " + cli.getDomicilio().getNumero();
        }
        if (cli.getDomicilio().getLocalidad() != null) {
            direcc += " - " + cli.getDomicilio().getLocalidad();
        }
//        if (iv.getCliente().getDireccion().getProvincia() != null) {
//            direcc += " - " + iv.getCliente().getDireccion().getProvincia();
//        }
        String cod_cli = iv.getCustomer().getCodigo().toString();
        String cui = ""; //iv.getCliente().getCuit();
        String cat_iva;

        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("   " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph(" " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("   " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 5;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[5];
        anchos[0] = 30;
        anchos[1] = 20;
        anchos[2] = 360;
        anchos[3] = 90;
        anchos[4] = 90;
        //anchos[5] = 90;

        PdfPTable tablaDetalle = new PdfPTable(5);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("PRECIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        //PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        //celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        //tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (ActivityRow re : rf) {
            PdfPTable tablaProd = new PdfPTable(5);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            //String c_ntd = String.valueOf(re.getCantidad());
            String prec;
            if (re.getTotal() > 1) {
                prec = df.format(re.getTotal());
            } else {
                prec = " ";
            }
            Double uni = re.getTotal() / re.getCantidad();
            String s_uni = df.format(uni);
            String ca_n = dfc.format(re.getCantidad());
// re.getCantidad());
            //String tota = df.format(re.getTotal());
            //String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(ca_n, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(s_uni, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            //PdfPCell tablaProd6 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            //tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            //tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(5);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            //PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            //tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            //tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(100);

        String totFc = df.format(iv.getTotal());
        String impu = df.format(iv.getImpuesto());
        String deuAnte = df.format(sA1);
        String deuTotal = df.format(sT1);
        String noble = caNo.toString(); //sdf.format(iv.getFechaVencimCae());
        String massa = caMs.toString(); //dfc.format(iv.getCae());
//        if (iv.getImpuesto() > 0.00) {
//            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
//        }

        String tpd = ""; //iv.getCliente().getTipoDoc().toString();
        String vto = ""; //sdf2.format(iv.getFechaVencimCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = "";//cui.trim();
            tpd = "96";
        } else {
            cuit1 = "";//cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            //cuit1 = s.substring(lar - 11, lar);
        }

        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        String t1 = " ";
        String t2 = " ";
        if (t1 != null) {
            t1 = iv.getTextoPieFactura1();
        }
        if (t2 != null) {
            t2 = iv.getTextoPieFactura2();
        }

        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;
        String saldoAnterior;
        String saldoTotal;
        if (saldos) {
            saldoAnterior = "  SALDO ANTERIOR: " + deuAnte;
            saldoTotal = "  SALDO TOTAL:    " + deuTotal;
        } else {
            saldoAnterior = " ";
            saldoTotal = " ";
        }
        PdfPCell pieFc1 = new PdfPCell(new Paragraph("  Impuestos: " + impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph("Total " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(saldoAnterior, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc6 = new PdfPCell(new Paragraph(t1, FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell pieFc7 = new PdfPCell(new Paragraph(saldoTotal, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc8 = new PdfPCell(new Paragraph(t2, FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell pieFc9 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc10 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc11 = new PdfPCell(new Paragraph("CANTIDAD ATADOS NOBLEZA " + noble, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc12 = new PdfPCell(new Paragraph("CANTIDAD ATADOS MASSALIN " + massa, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

//        com.itextpdf.text.Font font = FontFactory.getFont("C:/ventas/PF_I2OF5_TXT.ttf",
//                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
//        BaseFont baseFont = font.getBaseFont();
//        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
//        PdfPCell pieFc6 = new PdfPCell(new Paragraph(txtCadenaRP, nf));
        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc9.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc10.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc12.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc7).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc8).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc9).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc10).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc11).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc12).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

//pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.close();
        return new File(fileNameFormatted);
    }

    public File armarDevolucion(Cliente cli, Activity iv, List<Rental> rf, Integer caNo, Integer caMs, Double sA1, Double sT1, Boolean saldos) throws FileNotFoundException, DocumentException, Exception {

        String fileNameFormatted = getFileNameFormatted(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
        String cod = " ";;
        String fex = sdf.format(iv.getFecha());
        String nro = "X "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        //PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("SERVICIOS PROFESIONALES GENERALES", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("X", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("PRESUPUESTO", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph(" " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("  ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = cli.getRazonSocial();
        String codi = cli.getCodigo();
        String direcc = cli.getDomicilio().getCalle();
        if (cli.getDomicilio().getNumero() != null) {
            direcc += " " + cli.getDomicilio().getNumero();
        }
        if (cli.getDomicilio().getLocalidad() != null) {
            direcc += " - " + cli.getDomicilio().getLocalidad();
        }
//        if (iv.getCliente().getDireccion().getProvincia() != null) {
//            direcc += " - " + iv.getCliente().getDireccion().getProvincia();
//        }
        String cod_cli = iv.getCustomer().getCodigo().toString();
        String cui = ""; //iv.getCliente().getCuit();
        String cat_iva;

        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("   " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph(" " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("   " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 5;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[5];
        anchos[0] = 30;
        anchos[1] = 20;
        anchos[2] = 360;
        anchos[3] = 90;
        anchos[4] = 90;
        //anchos[5] = 90;

        PdfPTable tablaDetalle = new PdfPTable(5);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("PRECIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        //PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        //celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        //tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (Rental re : rf) {
            PdfPTable tablaProd = new PdfPTable(5);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            //String c_ntd = String.valueOf(re.getCantidad());
            String prec;
            if (re.getTotal() > 1) {
                prec = df.format(re.getTotal());
            } else {
                prec = " ";
            }
            Double uni = re.getTotal() / re.getCantidad();
            String s_uni = df.format(uni);
            String ca_n = dfc.format(re.getCantidad());
// re.getCantidad());
            //String tota = df.format(re.getTotal());
            //String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(ca_n, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(s_uni, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            //PdfPCell tablaProd6 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            //tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            //tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(5);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            //PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            //tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            //tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(100);

        String totFc = df.format(iv.getTotal());
        String impu = df.format(iv.getImpuesto());
        String deuAnte = df.format(sA1);
        String deuTotal = df.format(sT1);
        String noble = caNo.toString(); //sdf.format(iv.getFechaVencimCae());
        String massa = caMs.toString(); //dfc.format(iv.getCae());
//        if (iv.getImpuesto() > 0.00) {
//            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
//        }

        String tpd = ""; //iv.getCliente().getTipoDoc().toString();
        String vto = ""; //sdf2.format(iv.getFechaVencimCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = "";//cui.trim();
            tpd = "96";
        } else {
            cuit1 = "";//cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            //cuit1 = s.substring(lar - 11, lar);
        }

        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        String t1 = " ";
        String t2 = " ";
        if (t1 != null) {
            t1 = iv.getTextoPieFactura1();
        }
        if (t2 != null) {
            t2 = iv.getTextoPieFactura2();
        }
        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;
        String saldoAnterior;
        String saldoTotal;
        if (saldos) {
            saldoAnterior = "  SALDO ANTERIOR: " + deuAnte;
            saldoTotal = "  SALDO TOTAL:    " + deuTotal;
        } else {
            saldoAnterior = " ";
            saldoTotal = " ";
        }
        PdfPCell pieFc1 = new PdfPCell(new Paragraph("  Impuestos: " + impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph("Total " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(saldoAnterior, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc6 = new PdfPCell(new Paragraph(t1, FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell pieFc7 = new PdfPCell(new Paragraph(saldoTotal, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc8 = new PdfPCell(new Paragraph(t2, FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell pieFc9 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc10 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc11 = new PdfPCell(new Paragraph("CANTIDAD ATADOS NOBLEZA " + noble, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc12 = new PdfPCell(new Paragraph("CANTIDAD ATADOS MASSALIN " + massa, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

//        com.itextpdf.text.Font font = FontFactory.getFont("C:/ventas/PF_I2OF5_TXT.ttf",
//                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
//        BaseFont baseFont = font.getBaseFont();
//        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
//        PdfPCell pieFc6 = new PdfPCell(new Paragraph(txtCadenaRP, nf));
        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc9.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc10.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc12.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc7).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc8).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc9).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc10).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc11).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc12).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

//pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.close();
        return new File(fileNameFormatted);
    }

    public File armarFcA(Cliente cli, IvaVentas iv, List<RenglonFactura> rf) throws FileNotFoundException, DocumentException, Exception {
        String nr0 = dfn.format(iv.getNumeroFactura());
        String fileNameFormatted = getFileNameFormatted2(iv);
        tieneDto = false;
        if (iv.getPorcentualDescuentoGlobal() > 0.0) {
            tieneDto = true;
        }
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
        String cod = " 1";;
        String fex = sdf.format(iv.getFecha());
        String nro = "A_"
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("DISTRIBUIDORA A & M", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("A", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("FACTURA", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Av. San Martin 3284", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.nro:" + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("1678 - Caseros Prov.Buenos Aires", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("Tel: 4759-6677 - mail: distaym@yahoo.com.ar", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("CUIT:20-12412758-1 inic.activ.18/04/2005", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph("IVA - RESPONSABLE INSCRIPTO", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = cli.getRazonSocial();
        String direcc = cli.getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo();
        Boolean tieneDescuento;
        if (iv.getDescuentoGlobal() != null) {
            if (iv.getDescuentoGlobal() > 0.0) {
                tieneDescuento = true;
            } else {
                tieneDescuento = false;
            }
        } else {
            tieneDescuento = false;
        }
        Float porcentajeDescuento = iv.getPorcentualDescuentoGlobal();
        Double importeDescuento;
        if (iv.getDescuentoGlobal() != null) {
            importeDescuento = iv.getDescuentoGlobal();
        } else {
            importeDescuento = 0.0;
        }
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("   Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph(" " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("   Domicilio: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("   C.U.I.T.: " + cui, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph("   IVA: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        //     pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 8;
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[8];
        anchos[0] = 30;
        anchos[1] = 30;
        anchos[2] = 290;
        anchos[3] = 60;
        anchos[4] = 70;
        anchos[5] = 70;
        anchos[6] = 80;
        anchos[7] = 60;

        PdfPTable tablaDetalle = new PdfPTable(col);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("PRECIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("GRAVADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos7 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos8 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos7.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos7).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos8).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonFactura re : rf) {
            PdfPTable tablaProd = new PdfPTable(col);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            //String c_ntd = String.valueOf(re.getCantidad());

            String prec = df.format(re.getTotal() / re.getCantidad());
            String can = dfc.format(re.getCantidad());
            String grav = df.format(re.getGravado());
            String impu = df.format(re.getImpuesto());
            String tota = df.format(re.getTotal());
            String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(can, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(grav, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd7 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd8 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd7.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd7).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd8).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(8);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP7 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP7.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP7).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP8).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        // pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        PdfPTable pieToFc = new PdfPTable(6);
        pieToFc.setWidthPercentage(100);
        PdfPCell pieToFc1;
        PdfPCell pieToFc2;
        PdfPCell pieToFc3;
        String a2 = "0.00";
        if (tieneDescuento) {
            if (importeDescuento > 0.00) {
                pieToFc1 = new PdfPCell(new Paragraph("SUBTOTAL C/D", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
                pieToFc2 = new PdfPCell(new Paragraph("DESC. " + df_ali.format(porcentajeDescuento), FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
                a2 = df.format(importeDescuento);
                pieToFc3 = new PdfPCell(new Paragraph("SUBTOTAL S/D", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
            } else {
                pieToFc1 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
                pieToFc2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
                pieToFc3 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
            }
        } else {
            pieToFc1 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
            pieToFc2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
            pieToFc3 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        }

        PdfPCell pieToFc4 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieToFc5 = new PdfPCell(new Paragraph("IVA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieToFc6 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        pieToFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc.addCell(pieToFc1).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc2).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc3).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc4).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc5).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieToFc);
        PdfPTable pieFc = new PdfPTable(6);
        pieFc.setWidthPercentage(100);
        String a1 = df.format(iv.getGravado() + importeDescuento);
        String a3 = df.format(iv.getGravado());
        String a4 = df.format(iv.getImpuesto());
        String a5 = df.format(iv.getIva());
        String a6 = df.format(iv.getTotal());
        PdfPCell pieFc1 = new PdfPCell(new Paragraph(a1, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2;
        if (tieneDescuento) {
            if (importeDescuento > 0.00) {
                pieFc2 = new PdfPCell(new Paragraph(a2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
            } else {
                pieFc2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
            }
        } else {
            pieFc2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        }
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(a3, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(a4, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(a5, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc6 = new PdfPCell(new Paragraph(a6, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

        PdfPTable pie2Fc = new PdfPTable(2);
        pie2Fc.setWidthPercentage(100);

        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
        String tpd = iv.getCliente().getTipo().toString();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = cui.trim();
            tpd = "96";
        } else {
            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            cuit1 = s.substring(lar - 11, lar);
        }

        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        String t1 = "";
        String t2 = "";
        if (t1 != null) {
            t1 = iv.getTextoPieFactura1();
        }
        if (t2 != null) {
            t2 = iv.getTextoPieFactura2();
        }
        if (largo > 8) {
            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);

            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
        }
        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPCell pie2Fc3 = new PdfPCell(new Paragraph("  Fecha Vencimiento CAE: " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pie2Fc4 = new PdfPCell(new Paragraph(t1, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pie2Fc5 = new PdfPCell(new Paragraph("  CAE Nro.: " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pie2Fc6 = new PdfPCell(new Paragraph(t2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        pie2Fc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2Fc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2Fc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2Fc6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        pie2Fc.addCell(pie2Fc3).setBorder(PdfPCell.NO_BORDER);
        pie2Fc.addCell(pie2Fc4).setBorder(PdfPCell.NO_BORDER);
        pie2Fc.addCell(pie2Fc5).setBorder(PdfPCell.NO_BORDER);
        pie2Fc.addCell(pie2Fc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pie2Fc);
        Image imagen = Image.getInstance("c://qr//CodigoQR" + nr0 + ".png");
        Image img2 = Image.getInstance("c://qr//afip.png");
        imagen.setAbsolutePosition(15f, 120f);
        img2.setAbsolutePosition(180f, 160f);
        pdf.add(imagen);
        pdf.add(img2);

        pdf.close();
        return new File(fileNameFormatted);
    }

    public File armarFcB(Cliente cli, IvaVentas iv, List<RenglonFactura> rf) throws FileNotFoundException, DocumentException, Exception {
        String nr0 = dfn.format(iv.getNumeroFactura());
        String fileNameFormatted = getFileNameFormatted3(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 30, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        //FileOutputStream ficheroPdf = new FileOutputStream("c:/pdf/" + fileNameFormatted + ".pdf");
        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
        String cod = " 6";;
        String fex = sdf.format(iv.getFecha());
        String nro = "B "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("DISTRIBUIDORA A & M", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("B", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("FACTURA", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Av. San Martin 3284", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.nro:" + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("1678 - Caseros Prov.Buenos Aires", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("Tel: 4759-6677 - mail: distaym@yahoo.com.ar", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("CUIT:20-12412758-1 inic.activ.18/04/2005", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph("IVA - RESPONSABLE INSCRIPTO", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = cli.getRazonSocial();
        String direcc = cli.getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo().toString();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("   RAZON SOCIAL: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph(" " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("   DOMICILIO: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("   C.U.I.T.: " + cui, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph("   IVA: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        // pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 6;

        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[col];
        anchos[0] = 30;
        anchos[1] = 30;
        anchos[2] = 360;
        anchos[3] = 70;
        anchos[4] = 70;
        anchos[5] = 80;

        PdfPTable tablaDetalle = new PdfPTable(col);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("PRECIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonFactura re : rf) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            //String c_ntd = String.valueOf(re.getCantidad());
            String prec;
            if (re.getTotal() > 1) {
                prec = df.format(re.getTotal() / re.getCantidad());
            } else {
                prec = " ";
            }
            String can = dfc.format(re.getCantidad());
            String tota = df.format(re.getTotal());
            String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(can, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            //String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String totFc = df.format(iv.getTotal());
        String impu = df.format(iv.getImpuesto());
        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
        if (iv.getImpuesto() > 0.00) {
            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
        }

        String tpd = iv.getCliente().getTipo().toString();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = "00000000000";//cui.trim();
            tpd = "96";
        } else {
            cuit1 = "00000000000";//cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        String t1 = "";
        String t2 = "";
        if (t1 != null) {
            t1 = iv.getTextoPieFactura1();
        }
        if (t2 != null) {
            t2 = iv.getTextoPieFactura2();
        }

        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(100);
        PdfPCell pieFc1 = new PdfPCell(new Paragraph(" IMPUESTO: " + impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(" TOTAL: " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(" Fecha Vencimiento CAE: " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(t1, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(" CAE Nro.: " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc6 = new PdfPCell(new Paragraph(t2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        Image imagen = Image.getInstance("c://qr//CodigoQR" + nr0 + ".png");
        Image img2 = Image.getInstance("c://qr//afip.png");

        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);

        pdf.add(pieFc);

        imagen.setAbsolutePosition(20f, 100f);// 10 - 40
        img2.setAbsolutePosition(180f, 160f);
        pdf.add(imagen);
        pdf.add(img2);

        pdf.close();
        return new File(fileNameFormatted);
    }

    public File armarNcA(Cliente cli, IvaVentas iv, List<RenglonNotaCredito> rf) throws FileNotFoundException, DocumentException, Exception {
        String nr0 = dfn.format(iv.getNumeroFactura());
        String fileNameFormatted = getFileNameFormattedNc(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
        String cod = " 3";;
        String fex = sdf.format(iv.getFecha());
        String nro = "A_"
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("DISTRIBUIDORA A & M", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("A", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("NOTA DE CREDITO", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Av. San Martin 3284", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.nro:" + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("1678 - Caseros Prov.Buenos Aires", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("Tel: 4759-6677 - mail: distaym@yahoo.com.ar", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("CUIT:20-12412758-1 inic.activ.18/04/2005", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph("IVA - RESPONSABLE INSCRIPTO", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = cli.getRazonSocial();
        String direcc = cli.getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo().toString();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("   " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph(" " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("   " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph(" " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        // pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 8;
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[8];
        anchos[0] = 30;
        anchos[1] = 30;
        anchos[2] = 290;
        anchos[3] = 60;
        anchos[4] = 70;
        anchos[5] = 70;
        anchos[6] = 80;
        anchos[7] = 60;

        PdfPTable tablaDetalle = new PdfPTable(col);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("PRECIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("GRAVADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos7 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos8 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos7.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos7).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos8).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonNotaCredito re : rf) {
            PdfPTable tablaProd = new PdfPTable(col);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            //String c_ntd = String.valueOf(re.getCantidad());

            String prec = df.format(re.getTotal() / re.getCantidad());
            String can = dfc.format(re.getCantidad());
            String grav = df.format(re.getGravado());
            String impu = df.format(re.getImpuesto());
            String tota = df.format(re.getTotal());
            String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(can, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(grav, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd7 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd8 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd7.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd7).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd8).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(8);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP7 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP7.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP7).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP8).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        PdfPTable pieToFc = new PdfPTable(6);
        pieToFc.setWidthPercentage(100);
        PdfPCell pieToFc1;
        PdfPCell pieToFc2;
        PdfPCell pieToFc3;
        String a2 = "0.00";
        Boolean tieneDescuento;
        Double importeDescuento = 0.0;
        Float porcentajeDescuento = 0F;
        if (iv.getDescuentoGlobal() != null) {
            if (iv.getDescuentoGlobal() < 0) {
                tieneDescuento = true;
                importeDescuento = iv.getDescuentoGlobal();
                porcentajeDescuento = iv.getPorcentualDescuentoGlobal();
            } else {
                tieneDescuento = false;
            }
        } else {
            tieneDescuento = false;
        }
        if (tieneDescuento) {
            if (importeDescuento < 0.00) {
                pieToFc1 = new PdfPCell(new Paragraph("SUBTOTAL C/D", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
                pieToFc2 = new PdfPCell(new Paragraph("DESC. " + df_ali.format(porcentajeDescuento), FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
                a2 = df.format(importeDescuento);
                pieToFc3 = new PdfPCell(new Paragraph("SUBTOTAL S/D", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
            } else {
                pieToFc1 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
                pieToFc2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
                pieToFc3 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
            }
        } else {
            pieToFc1 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
            pieToFc2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
            pieToFc3 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        }

        PdfPCell pieToFc4 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieToFc5 = new PdfPCell(new Paragraph("IVA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieToFc6 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        pieToFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc.addCell(pieToFc1).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc2).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc3).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc4).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc5).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieToFc);
        PdfPTable pieFc = new PdfPTable(6);
        pieFc.setWidthPercentage(100);
        String a1 = df.format(iv.getGravado());
        String a3 = df.format(iv.getGravado() - importeDescuento);
        String a4 = df.format(iv.getImpuesto());
        String a5 = df.format(iv.getIva());
        String a6 = df.format(iv.getTotal());
        PdfPCell pieFc1 = new PdfPCell(new Paragraph(a1, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(a2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(a3, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(a4, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(a5, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc6 = new PdfPCell(new Paragraph(a6, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

        PdfPTable pie2Fc = new PdfPTable(2);
        pie2Fc.setWidthPercentage(100);

        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
        String tpd = iv.getCliente().getTipo().toString();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = cui.trim();
            tpd = "96";
        } else {
            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            cuit1 = s.substring(lar - 11, lar);
        }

        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        String t1 = "";
        String t2 = "";
        if (t1 != null) {
            t1 = iv.getTextoPieFactura1();
        }
        if (t2 != null) {
            t2 = iv.getTextoPieFactura2();
        }
        if (largo > 8) {
            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);

            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
        }
        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPCell pie2Fc3 = new PdfPCell(new Paragraph("  " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pie2Fc4 = new PdfPCell(new Paragraph(t1, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pie2Fc5 = new PdfPCell(new Paragraph("  " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pie2Fc6 = new PdfPCell(new Paragraph(t2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        pie2Fc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2Fc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2Fc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2Fc6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        pie2Fc.addCell(pie2Fc3).setBorder(PdfPCell.NO_BORDER);
        pie2Fc.addCell(pie2Fc4).setBorder(PdfPCell.NO_BORDER);
        pie2Fc.addCell(pie2Fc5).setBorder(PdfPCell.NO_BORDER);
        pie2Fc.addCell(pie2Fc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pie2Fc);
        Image imagen = Image.getInstance("c://qr//CodigoQR" + nr0 + ".png");
        Image img2 = Image.getInstance("c://qr//afip.png");
        imagen.setAbsolutePosition(20f, 100f);
        img2.setAbsolutePosition(180f, 160f);
        pdf.add(imagen);
        pdf.add(img2);

        pdf.close();
        return new File(fileNameFormatted);
    }

    public File armarNcB(Cliente cli, IvaVentas iv, List<RenglonNotaCredito> rf) throws FileNotFoundException, DocumentException, Exception {
        String nr0 = dfn.format(iv.getNumeroFactura());
        String fileNameFormatted = getFileNameFormattedNc(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 30, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        //FileOutputStream ficheroPdf = new FileOutputStream("c:/pdf/" + fileNameFormatted + ".pdf");
        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
        String cod = " 8";;
        String fex = sdf.format(iv.getFecha());
        String nro = "B "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("DISTRIBUIDORA A & M", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("B", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("NOTA DE CREDITO", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Av. San Martin 3284", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.nro:" + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("1678 - Caseros Prov.Buenos Aires", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("Tel: 4759-6677 - mail: distaym@yahoo.com.ar", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("CUIT:20-12412758-1 inic.activ.18/04/2005", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph("IVA - RESPONSABLE INSCRIPTO", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = cli.getRazonSocial();
        String direcc = cli.getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo().toString();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("   " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph(" " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("   " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph(" " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 6;

        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[col];
        anchos[0] = 30;
        anchos[1] = 30;
        anchos[2] = 360;
        anchos[3] = 70;
        anchos[4] = 70;
        anchos[5] = 80;

        PdfPTable tablaDetalle = new PdfPTable(col);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("PRECIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonNotaCredito re : rf) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            //String c_ntd = String.valueOf(re.getCantidad());
            String prec;
            if (re.getTotal() > 1) {
                prec = df.format(re.getTotal() / re.getCantidad());
            } else {
                prec = " ";
            }
            String can = dfc.format(re.getCantidad());
            String tota = df.format(re.getTotal());
            String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(can, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            //String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String totFc = df.format(iv.getTotal());
        String impu = df.format(iv.getImpuesto());
        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
        if (iv.getImpuesto() > 0.00) {
            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
        }

        String tpd = iv.getCliente().getTipo().toString();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
//        if (tpd.equals("96")) {
//            cuit1 = "";//cui.trim();
//            tpd = "96";
//        } else {
//            cuit1 = "";//cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
//        }
        int x = 0;
        if (tpd.equals("96")) {
//            String s = "0000000000" + cuit1;
//            int lar = s.length();
//            cuit1 = s.substring(lar - 11, lar);
        }

        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
//        String txtCadenaRP = "";
        String t1 = "";
        String t2 = "";
        if (t1 != null) {
            t1 = iv.getTextoPieFactura1();
        }
        if (t2 != null) {
            t2 = iv.getTextoPieFactura2();
        }
        if (largo > 8) {
//            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
//            for (int i = 0; i < 39; i++) {
//                if (x == 0) {
//                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
//                    suma1 += num;
//                    x = 1;
//                } else {
//                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
//                    suma2 += num;
//                    x = 0;
//                }
//            }
//            suma1 = suma1 * 3;
//            int total = suma1 + suma2;
//            int dv = (int) (rint(total / 10 + .9) * 10);
//            dv = dv - total;
//            cadena += String.valueOf(dv);

//            for (int i = 0; i < 40; i = i + 2) {
//                String charNum = cadena.substring(i, i + 2);
//                int numChar = Integer.valueOf(charNum);
//                if (numChar < 50) {
//                    numChar += 48;
//                } else {
//                    numChar += 142;
//                }
//                char c = (char) numChar;
//                txtCadenaRP = txtCadenaRP + c;
//            }
        }
//        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(100);
        PdfPCell pieFc1 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(" TOTAL: " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(" VENCIMIENTO CAE: " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(t1, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(" CAE " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc6 = new PdfPCell(new Paragraph(t2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        Image imagen = Image.getInstance("c://qr//CodigoQR" + nr0 + ".png");
        Image img2 = Image.getInstance("c://qr//afip.png");

        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);

        pdf.add(pieFc);

        imagen.setAbsolutePosition(10f, 50f);
        img2.setAbsolutePosition(230f, 140f);
        pdf.add(imagen);
        pdf.add(img2);

        pdf.close();
        System.out.println(ficheroPdf);
        return new File(fileNameFormatted);
    }

    public File armarNdA(Cliente cli, IvaVentas iv, List<RenglonFactura> rf) throws FileNotFoundException, DocumentException, Exception {
        String nr0 = dfn.format(iv.getNumeroFactura());
        String fileNameFormatted = getFileNameFormatted2(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
        String cod = " 2";;
        String fex = sdf.format(iv.getFecha());
        String nro = "A_"
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("DISTRIBUIDORA A & M", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("A", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("NOTA DE DEBITO", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Av. San Martin 3284", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.nro:" + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("1678 - Caseros Prov.Buenos Aires", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("Tel: 4759-6677 - mail: distaym@yahoo.com.ar", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("CUIT:20-12412758-1 inic.activ.18/04/2005", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph("IVA - RESPONSABLE INSCRIPTO", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = cli.getRazonSocial();
        String direcc = cli.getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo().toString();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("   " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph(" " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("   " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph(" " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        //     pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 8;
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[8];
        anchos[0] = 30;
        anchos[1] = 30;
        anchos[2] = 290;
        anchos[3] = 60;
        anchos[4] = 70;
        anchos[5] = 70;
        anchos[6] = 80;
        anchos[7] = 60;

        PdfPTable tablaDetalle = new PdfPTable(col);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("PRECIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("GRAVADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos7 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos8 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos7.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos7).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos8).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonFactura re : rf) {
            PdfPTable tablaProd = new PdfPTable(col);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            //String c_ntd = String.valueOf(re.getCantidad());

            String prec = df.format(re.getTotal() / re.getCantidad());
            String can = dfc.format(re.getCantidad());
            String grav = df.format(re.getGravado());
            String impu = df.format(re.getImpuesto());
            String tota = df.format(re.getTotal());
            String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(can, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(grav, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd7 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd8 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd7.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd7).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd8).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(8);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP7 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP7.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP7).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP8).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        // pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        PdfPTable pieToFc = new PdfPTable(5);
        pieToFc.setWidthPercentage(100);
        PdfPCell pieToFc1 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieToFc2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieToFc3 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieToFc4 = new PdfPCell(new Paragraph("IVA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieToFc5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        pieToFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieToFc.addCell(pieToFc1).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc2).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc3).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc4).setBorder(PdfPCell.NO_BORDER);
        pieToFc.addCell(pieToFc5).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieToFc);
        PdfPTable pieFc = new PdfPTable(5);
        pieFc.setWidthPercentage(100);
        String a1 = df.format(iv.getGravado());
        String a2 = df.format(iv.getImpuesto());
        String a3 = df.format(iv.getIva());
        String a4 = df.format(iv.getTotal());
        PdfPCell pieFc1 = new PdfPCell(new Paragraph(a1, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(a2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(a3, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(a4, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

        PdfPTable pie2Fc = new PdfPTable(2);
        pie2Fc.setWidthPercentage(100);

        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
        String tpd = iv.getCliente().getTipo().toString();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = cui.trim();
            tpd = "96";
        } else {
            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            cuit1 = s.substring(lar - 11, lar);
        }

        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        String t1 = "";
        String t2 = "";
        if (t1 != null) {
            t1 = iv.getTextoPieFactura1();
        }
        if (t2 != null) {
            t2 = iv.getTextoPieFactura2();
        }
        if (largo > 8) {
            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);

            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
        }
        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPCell pie2Fc3 = new PdfPCell(new Paragraph("  " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pie2Fc4 = new PdfPCell(new Paragraph(t1, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pie2Fc5 = new PdfPCell(new Paragraph("  " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pie2Fc6 = new PdfPCell(new Paragraph(t2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        pie2Fc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2Fc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2Fc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2Fc6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        pie2Fc.addCell(pie2Fc3).setBorder(PdfPCell.NO_BORDER);
        pie2Fc.addCell(pie2Fc4).setBorder(PdfPCell.NO_BORDER);
        pie2Fc.addCell(pie2Fc5).setBorder(PdfPCell.NO_BORDER);
        pie2Fc.addCell(pie2Fc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pie2Fc);
        Image imagen = Image.getInstance("c://qr//CodigoQR" + nr0 + ".png");
        Image img2 = Image.getInstance("c://qr//afip.png");
        imagen.setAbsolutePosition(10f, 50f);
        img2.setAbsolutePosition(230f, 140f);
        pdf.add(imagen);
        pdf.add(img2);

        pdf.close();
        return new File(fileNameFormatted);
    }

    public File armarNdB(Cliente cli, IvaVentas iv, List<RenglonFactura> rf) throws FileNotFoundException, DocumentException, Exception {
        String nr0 = dfn.format(iv.getNumeroFactura());
        String fileNameFormatted = getFileNameFormattedNd(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 30, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        //FileOutputStream ficheroPdf = new FileOutputStream("c:/pdf/" + fileNameFormatted + ".pdf");
        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
        String cod = " 7";;
        String fex = sdf.format(iv.getFecha());
        String nro = "B "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("DISTRIBUIDORA A & M", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("B", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("NOTA DE DEBITO", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Av. San Martin 3284", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.nro:" + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("1678 - Caseros Prov.Buenos Aires", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("Tel: 4759-6677 - mail: distaym@yahoo.com.ar", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("CUIT:20-12412758-1 inic.activ.18/04/2005", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph("IVA - RESPONSABLE INSCRIPTO", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = cli.getRazonSocial();
        String direcc = cli.getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo().toString();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("   " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph(" " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("   " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph(" " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        // pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 6;

        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[col];
        anchos[0] = 30;
        anchos[1] = 30;
        anchos[2] = 360;
        anchos[3] = 70;
        anchos[4] = 70;
        anchos[5] = 80;

        PdfPTable tablaDetalle = new PdfPTable(col);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("PRECIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonFactura re : rf) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            //String c_ntd = String.valueOf(re.getCantidad());
            String prec;
            if (re.getTotal() > 1) {
                prec = df.format(re.getTotal() / re.getCantidad());
            } else {
                prec = " ";
            }
            String can = dfc.format(re.getCantidad());
            String tota = df.format(re.getTotal());
            String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(can, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            //String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String totFc = df.format(iv.getTotal());
        String impu = df.format(iv.getImpuesto());
        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
        if (iv.getImpuesto() > 0.00) {
            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
        }

        String tpd = iv.getCliente().getTipo().toString();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = "00000000000";//cui.trim();
            tpd = "96";
        } else {
            cuit1 = "00000000000";//cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
//            String s = "0000000000" + cuit1;
//            int lar = s.length();
//            cuit1 = s.substring(lar - 11, lar);
        }

        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        String t1 = "";
        String t2 = "";
        if (t1 != null) {
            t1 = iv.getTextoPieFactura1();
        }
        if (t2 != null) {
            t2 = iv.getTextoPieFactura2();
        }
        if (largo > 8) {
//            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
//            for (int i = 0; i < 39; i++) {
//                if (x == 0) {
//                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
//                    suma1 += num;
//                    x = 1;
//                } else {
//                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
//                    suma2 += num;
//                    x = 0;
//                }
//            }
//            suma1 = suma1 * 3;
//            int total = suma1 + suma2;
//            int dv = (int) (rint(total / 10 + .9) * 10);
//            dv = dv - total;
//            cadena += String.valueOf(dv);

//            for (int i = 0; i < 40; i = i + 2) {
//                String charNum = cadena.substring(i, i + 2);
//                int numChar = Integer.valueOf(charNum);
//                if (numChar < 50) {
//                    numChar += 48;
//                } else {
//                    numChar += 142;
//                }
//                char c = (char) numChar;
//                txtCadenaRP = txtCadenaRP + c;
//            }
        }
        //txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(100);
        PdfPCell pieFc1 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(" TOTAL: " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(" VENCIMIENTO CAE: " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(t1, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(" CAE " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc6 = new PdfPCell(new Paragraph(t2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        Image imagen = Image.getInstance("c://qr//CodigoQR" + nr0 + ".png");
        Image img2 = Image.getInstance("c://qr//afip.png");

        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);

        pdf.add(pieFc);

        imagen.setAbsolutePosition(10f, 50f);
        img2.setAbsolutePosition(230f, 140f);
        pdf.add(imagen);
        pdf.add(img2);

        pdf.close();
        //System.out.println(ficheroPdf);
        return new File(fileNameFormatted);
    }

    public File armarListaPrecios(List<Producto> productos) throws FileNotFoundException, DocumentException, Exception {

        String fileNameFormatted = getFileProductosFormatted();
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle(690F, 990F);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 30, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        //FileOutputStream ficheroPdf = new FileOutputStream("c:/pdf/" + fileNameFormatted + ".pdf");
        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();
        // colocar logo
        Image imagen = Image.getInstance("c://ventas//logo//logo.png");
        imagen.setAbsolutePosition(370f, 780f);
        pdf.add(imagen);

        // INICIO ENCABEZADO FACTURA
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        float[] ancho = new float[3];
        ancho[0] = 40;
        ancho[1] = 30;
        ancho[2] = 30;
        encabezado.setTotalWidth(ancho);
        int tamanio = 11;
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("GOLOSINAS Y ARTICULOS PARA KIOSCO", FontFactory.getFont("arial", tamanio, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Av. San Martin 3284 - CASEROS", FontFactory.getFont("arial", tamanio, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Tel: 4759-6677", FontFactory.getFont("arial", tamanio, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("distaym@yahoo.com.ar", FontFactory.getFont("arial", tamanio, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("WhatsApp 1144947516", FontFactory.getFont("arial", tamanio, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph("LISTA DE PRECIOS AL 08/11/2021", FontFactory.getFont("arial", tamanio, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("   ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("   ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        // pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 6;

        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[col];
        anchos[0] = 30;
        anchos[1] = 30;
        anchos[2] = 360;
        anchos[3] = 70;
        anchos[4] = 70;
        anchos[5] = 80;

        PdfPTable tablaDetalle = new PdfPTable(col);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("PRECIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);
        pdf.close();
        return new File(fileNameFormatted);
    }

    public File armarListaPrecios2(List<Producto> productos, Boolean sinLogo) throws FileNotFoundException, DocumentException, Exception {
        Configuracion config = new ConfiguracionService().getFacturas(1L);
        Float iva = config.getIva();
        String fileNameFormatted = getFileProductosFormatted();
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle(690F, 990F);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(30, 30, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

//        ABRO EL DOCUMENTO
        pdf.open();

        PdfPTable encabezado1 = crearEncabezado1();

        Integer numHoja = 0;
        Integer numLinea = 0;
        Integer numCol = 0;
        List<ListaPrecios> lista1 = new ArrayList<>();
        List<ListaPrecios> lista2 = new ArrayList<>();
        List<ListaPrecios> lista3 = new ArrayList<>();
        List<List<ListaPrecios>> listaCompleta = new ArrayList<>();
        int max = 59;//61
        int lim2 = 71;//77
        if (sinLogo) {
            max = lim2;
        }
        int todos = productos.size();
        SubRubro ru1 = null;
        SubRubro ru2;
        Integer n = 0;
        for (Producto pro : productos) {
            n += 1;
            if (todos < 240) {
                int colu = todos / 3;
//                max = colu;
                if (sinLogo) {
                    max = lim2;
                }
            }
            if (numLinea.equals(0)) {
                numCol = 1;
                numHoja = 1;
                ru1 = pro.getSubRubro();
                numLinea += 1;
                ListaPrecios lp = new ListaPrecios();
                lp.setDetalle(ru1.getDetalle());
                lp.setPrecio(0.0);
                lista1.add(lp);
                numLinea += 1;
            }
            numLinea += 1;
            ru2 = pro.getSubRubro();
            if (!ru1.equals(ru2)) {
                if (numLinea > max - 6) {
                    numCol += 1;
                    numLinea = 1;
                    if (numCol > 3) {
                        listaCompleta.add(lista1);
                        listaCompleta.add(lista2);
                        listaCompleta.add(lista3);
                        if (sinLogo) {
                            if (!numHoja.equals(1)) {
                                pdf.newPage();
                            }
                            PdfPTable encabezadoSL = crearEncabezadoSL(numHoja);
                            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                            pdf.add(encabezadoSL);
                            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                        } else {
                            if (numHoja.equals(1)) {

                                pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                                pdf.add(encabezado1);

                                for (int i = 0; i < 3; i++) {
                                    pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                                }

                                Image img = colocarImagen();
                                pdf.add(img);
                            } else {
                                pdf.newPage();
                                if (sinLogo) {
                                    PdfPTable encabezadoSL = crearEncabezadoSL(numHoja);
                                    pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                                    pdf.add(encabezadoSL);
                                    pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                                } else {
                                    PdfPTable encabezado2 = crearEncabezado2(numHoja);
                                    pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                                    pdf.add(encabezado2);
                                    pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                                }
                            }
                        }

//                        PdfPTable tabla = crearLista1();
                        PdfPTable tabla2 = crearLista5(listaCompleta);
//                        pdf.add(tabla);
                        pdf.add(tabla2);
                        lista1 = new ArrayList<>();
                        lista2 = new ArrayList<>();
                        lista3 = new ArrayList<>();
                        listaCompleta = new ArrayList<>();
                        numHoja += 1;
                        numCol = 1;
                        numLinea = 1;
                        max = lim2;
                        ListaPrecios lp = new ListaPrecios();
                        lp.setDetalle(ru1.getDetalle());
//                        lp.setDetalle(n.toString() + "_" + ru1.getDetalle());
                        lp.setPrecio(0.0);
                        ru1 = ru2;
                        if (numCol.equals(1)) {
                            lista1.add(lp);
                        } else {
                            if (numCol.equals(2)) {
                                lista2.add(lp);
                            } else {
                                lista3.add(lp);
                            }
                        }
                        numLinea += 1;
//                        return tabla;
                    } else {
                        ListaPrecios lp = new ListaPrecios();

                        lp.setDetalle(ru2.getDetalle());
//                        lp.setDetalle(n.toString() + "_" + ru1.getDetalle());
                        lp.setPrecio(0.0);
                        ru1 = ru2;
                        if (numCol.equals(1)) {
                            lista1.add(lp);
                        } else {
                            if (numCol.equals(2)) {
                                lista2.add(lp);
                            } else {
                                lista3.add(lp);
                            }
                        }
                        numLinea += 1;
                    }
                } else {
                    if (numLinea > max - 6) {

                        numCol += 1;
                        numLinea = 1;
                        if (numCol > 3) {

                            listaCompleta.add(lista1);
                            listaCompleta.add(lista2);
                            listaCompleta.add(lista3);
                            if (sinLogo) {
                                if (!numHoja.equals(1)) {
                                    pdf.newPage();
                                }
                                PdfPTable encabezadoSL = crearEncabezadoSL(numHoja);
                                pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                                pdf.add(encabezadoSL);
                                pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                            } else {
                                if (numHoja.equals(1)) {

                                    pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                                    pdf.add(encabezado1);

                                    for (int i = 0; i < 3; i++) {
                                        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                                    }

                                    Image img = colocarImagen();
                                    pdf.add(img);
                                } else {
                                    pdf.newPage();
                                    PdfPTable encabezado2 = crearEncabezado2(numHoja);
                                    pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                                    pdf.add(encabezado2);
                                    pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));

                                }
                            }
//                            PdfPTable tabla = crearLista1();
                            PdfPTable tabla2 = crearLista5(listaCompleta);
//                            pdf.add(tabla);
                            pdf.add(tabla2);
//                            pdf.close();
//                            break;
                            lista1 = new ArrayList<>();
                            lista2 = new ArrayList<>();
                            lista3 = new ArrayList<>();
                            listaCompleta = new ArrayList<>();
                            numHoja += 1;
                            numCol = 1;
                            numLinea = 1;
                            max = lim2;
                            ListaPrecios lp = new ListaPrecios();
                            lp.setDetalle(ru1.getDetalle()); //XXX
//                            lp.setDetalle(n.toString() + "_" + ru1.getDetalle());
                            lp.setPrecio(0.0);
                            ru1 = ru2;
                            if (numCol.equals(1)) {
                                lista1.add(lp);
                            } else {
                                if (numCol.equals(2)) {
                                    lista2.add(lp);
                                } else {
                                    lista3.add(lp);
                                }
                            }
                            numLinea += 1;
                        } else {
                            ListaPrecios lp = new ListaPrecios();
                            lp.setDetalle(ru1.getDetalle());
//                            lp.setDetalle(n.toString() + "_" + ru1.getDetalle());
                            lp.setPrecio(0.0);
                            ru1 = ru2;
                            if (numCol.equals(1)) {
                                lista1.add(lp);
                            } else {
                                if (numCol.equals(2)) {
                                    lista2.add(lp);
                                } else {
                                    lista3.add(lp);
                                }
                            }
                            numLinea += 1;
                        }
                    } else {
                        ru1 = pro.getSubRubro();
                        ListaPrecios lp = new ListaPrecios();
                        lp.setDetalle(ru1.getDetalle()); //XXX
//                        lp.setDetalle(n.toString() + "_" + ru1.getDetalle());
                        lp.setPrecio(0.0);
                        ru1 = ru2;
                        if (numCol.equals(1)) {
                            lista1.add(lp);
                        } else {
                            if (numCol.equals(2)) {
                                lista2.add(lp);
                            } else {
                                lista3.add(lp);
                            }
                        }
                        numLinea += 1;
                    }
                }
            }
            if (numLinea > max - 6) {
                numCol += 1;
                numLinea = 1;
                if (numCol > 3) {
                    listaCompleta.add(lista1);
                    listaCompleta.add(lista2);
                    listaCompleta.add(lista3);
                    if (sinLogo) {
                        if (!numHoja.equals(1)) {
                            pdf.newPage();
                        }
                        PdfPTable encabezadoSL = crearEncabezadoSL(numHoja);
                        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                        pdf.add(encabezadoSL);
                        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                    } else {
                        if (numHoja.equals(1)) {

                            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                            pdf.add(encabezado1);

                            for (int i = 0; i < 3; i++) {
                                pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                            }

                            Image img = colocarImagen();
                            pdf.add(img);
                        } else {
                            pdf.newPage();
                            PdfPTable encabezado2 = crearEncabezado2(numHoja);
                            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
                            pdf.add(encabezado2);
                            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));

                            //document.NewPage();
                        }
                    }
//                    PdfPTable tabla = crearLista1();
                    PdfPTable tabla2 = crearLista5(listaCompleta);
//                    pdf.add(tabla);
                    pdf.add(tabla2);

//                    pdf.close();
//                    
//                    break;
                    lista1 = new ArrayList<>();
                    lista2 = new ArrayList<>();
                    lista3 = new ArrayList<>();
                    listaCompleta = new ArrayList<>();
                    numHoja += 1;
                    numCol = 1;
                    numLinea = 1;
                    max = lim2;
                    ListaPrecios lp = new ListaPrecios();
                    lp.setDetalle(ru1.getDetalle()); //XXX
//                    lp.setDetalle(n.toString() + "_" + ru1.getDetalle());
                    lp.setPrecio(0.0);
                    ru1 = ru2;
                    if (numCol.equals(1)) {
                        lista1.add(lp);
                    } else {
                        if (numCol.equals(2)) {
                            lista2.add(lp);
                        } else {
                            lista3.add(lp);
                        }
                    }
                    numLinea += 1;
                } else {
                    // XXXX parte agregada
                    ListaPrecios lp = new ListaPrecios();
                    lp.setDetalle(ru1.getDetalle()); //XXX
//                    lp.setDetalle(n.toString() + "_" + ru1.getDetalle());
                    lp.setPrecio(0.0);
                    if (numCol.equals(1)) {
                        lista1.add(lp);
                    } else {
                        if (numCol.equals(2)) {
                            lista2.add(lp);
                        } else {
                            lista3.add(lp);
                        }
                    }
                    numLinea += 1;
                }
            }
            ListaPrecios lp = new ListaPrecios();
            Double precioPro = calcularPrecioDeProducto(pro, iva);
            lp.setDetalle(pro.getDetalle()); //XXX
//            lp.setDetalle(n.toString() + "_" + pro.getDetalle());
            lp.setPrecio(precioPro);
            if (numCol.equals(1)) {
                lista1.add(lp);
            } else {
                if (numCol.equals(2)) {
                    lista2.add(lp);
                } else {
                    lista3.add(lp);
                }
            }
            pdf.newPage();
        }
//        System.out.println("numCol");
//        System.out.println(numCol);
//        System.out.println("lista 1");
//        System.out.println(lista1);
//        System.out.println("lista 2");
//        System.out.println(lista2);
//        System.out.println("lista 3");
//        System.out.println(lista3);
//        System.out.println("lista completa");
//        System.out.println(listaCompleta);
//        System.exit(0);
        if (sinLogo) {
            PdfPTable encabezadoSL = crearEncabezadoSL(numHoja);
            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
            pdf.add(encabezadoSL);
            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
        } else {
            PdfPTable encabezado2 = crearEncabezado2(numHoja);
            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
            pdf.add(encabezado2);
            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));//FONDO_BLANCO)));
        }
//        PdfPTable tabla = crearLista1();
//        pdf.add(tabla);
        if (numCol.equals(1)) {
            PdfPTable tabla2 = crearLista4(lista1);
            pdf.add(tabla2);
        }
        if (numCol.equals(2)) {
            PdfPTable tabla3 = crearLista3(lista1, lista2);
            pdf.add(tabla3);
        }
        if (numCol.equals(3)) {
            PdfPTable tabla4 = crearLista2(lista1, lista2, lista3);
            pdf.add(tabla4);
        }

        pdf.close();
        File fil = new File(fileNameFormatted);
        return fil;
    }

    private Double calcularPrecioDeProducto(Producto pro, Float iva) {
        Double pre = pro.getPrecio();
        if (pro.getIvaCero() != null) {
            if (!pro.getIvaCero()) {
                pre = pre * (1 + iva / 100);
            }
        }
        pre += pro.getImpuesto();
        return pre;
    }

    private Image colocarImagen() {
        Image imagen;
        try {
            imagen = Image.getInstance("c://ventas//logo//logo.png");

        } catch (BadElementException | IOException ex) {
            Logger.getLogger(PDFBuilder.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        imagen.setAbsolutePosition(370f, 780f);
        return imagen;
    }

    private PdfPTable crearEncabezado1() {
//        INICIO ENCABEZADO LISTA DE PRECIOS  PdfPTable encabezado = new PdfPTable(3);
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        float[] ancho = new float[3];
        ancho[0] = 40;
        ancho[1] = 30;
        ancho[2] = 30;
        try {
            encabezado.setTotalWidth(ancho);

        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        int tamanio = 12;
        String fecha = sdf.format(new Date());
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("GOLOSINAS Y ARTICULOS PARA KIOSCO", FontFactory.getFont("arial", tamanio, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Av. San Martin 3284 - CASEROS", FontFactory.getFont("arial", tamanio, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Tel: 4759-6677", FontFactory.getFont("arial", tamanio, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("distaym@yahoo.com.ar", FontFactory.getFont("arial", tamanio, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("WhatsApp 1144947516", FontFactory.getFont("arial", tamanio, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph("LISTA DE PRECIOS AL: " + fecha, FontFactory.getFont("arial", tamanio, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

//        FIN ENCABEZADO
        return encabezado;
    }

    private PdfPTable crearLista2(List<ListaPrecios> lista1, List<ListaPrecios> lista2, List<ListaPrecios> lista3) {

        List<List<ListaPrecios>> listaParcial = new ArrayList<>();
        listaParcial.add(lista1);
        listaParcial.add(lista2);
        listaParcial.add(lista3);

        float[] anchos = new float[6];
        anchos[0] = 22;
        anchos[1] = 5;
        anchos[2] = 22;
        anchos[3] = 5;
        anchos[4] = 22;
        anchos[5] = 5;

        List<ListaPrecios> lp1 = listaParcial.get(0);
        List<ListaPrecios> lp2 = listaParcial.get(1);
        List<ListaPrecios> lp3 = listaParcial.get(2);
        int la1 = lp1.size();
        int la2 = lp2.size();
        int la3 = lp3.size();

        System.out.println(la1);
        System.out.println(la2);
        System.out.println(la3);

        PdfPTable prec = new PdfPTable(6);
        prec.setWidthPercentage(100);
        try {
            prec.setWidths(anchos);
        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (la1 == la2) {
            if (la1 == la3) {
                for (int y = 0; y < la1; y += 1) {
                    if (y > la1 - 1) {
                        PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                        producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                        prec.addCell(producto1).setBorder(PdfPCell.BOX);
                        prec.addCell(producto2).setBorder(PdfPCell.BOX);
                    } else {
                        if (lp1.get(y).getPrecio() < 0.01) {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(07);
                            prec.addCell(producto2).setBorder(11);
                        } else {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        }
                    }
                    if (y > la2 - 1) {
                        PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                        producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                        prec.addCell(producto3).setBorder(PdfPCell.BOX);
                        prec.addCell(producto4).setBorder(PdfPCell.BOX);
                    } else {
                        if (lp2.get(y).getPrecio() < 0.01) {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(07);
                            prec.addCell(producto4).setBorder(11);
                        } else {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        }
                    }
                    if (y > la3 - 1) {
                        PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                        producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                        prec.addCell(producto5).setBorder(PdfPCell.BOX);
                        prec.addCell(producto6).setBorder(PdfPCell.BOX);
                    } else {
                        if (lp3.get(y).getPrecio() < 0.01) {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(07);
                            prec.addCell(producto6).setBorder(11);
                        } else {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(PdfPCell.BOX);
                            prec.addCell(producto6).setBorder(PdfPCell.BOX);
                        }
                    }
                }
            } else {
                if (la1 > la3) {
                    for (int y = 0; y < la1; y += 1) {
                        if (y > la1 - 1) {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp1.get(y).getPrecio() < 0.01) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(07);
                                prec.addCell(producto2).setBorder(11);
                            } else {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la2 - 1) {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp2.get(y).getPrecio() < 0.01) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(07);
                                prec.addCell(producto4).setBorder(11);
                            } else {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la3 - 1) {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(PdfPCell.BOX);
                            prec.addCell(producto6).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp3.get(y).getPrecio() < 0.01) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(07);
                                prec.addCell(producto6).setBorder(11);
                            } else {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            }
                        }
                    }
                } else {
                    for (int y = 0; y < la3; y += 1) {
                        if (y > la1 - 1) {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp1.get(y).getPrecio() < 0.01) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(07);
                                prec.addCell(producto2).setBorder(11);
                            } else {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la2 - 1) {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp2.get(y).getPrecio() < 0.01) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(07);
                                prec.addCell(producto4).setBorder(11);
                            } else {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la3 - 1) {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(PdfPCell.BOX);
                            prec.addCell(producto6).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp3.get(y).getPrecio() < 0.01) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(07);
                                prec.addCell(producto6).setBorder(11);
                            } else {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            }
                        }
                    }
                }
            }
        } else {
            if (la1 > la2) {
                if (la1 == la3) {
                    for (int y = 0; y < la1; y += 1) {
                        if (y > la1 - 1) {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp1.get(y).getPrecio() < 0.01) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(07);
                                prec.addCell(producto2).setBorder(11);
                            } else {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la2 - 1) {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp2.get(y).getPrecio() < 0.01) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(07);
                                prec.addCell(producto4).setBorder(11);
                            } else {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la3 - 1) {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(PdfPCell.BOX);
                            prec.addCell(producto6).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp3.get(y).getPrecio() < 0.01) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(07);
                                prec.addCell(producto6).setBorder(11);
                            } else {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            }
                        }
                    }
                } else {
                    if (la1 > la3) {
                        for (int y = 0; y < la1; y += 1) {
                            if (y > la1 - 1) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp1.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(07);
                                    prec.addCell(producto2).setBorder(11);
                                } else {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto2).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la2 - 1) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp2.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(07);
                                    prec.addCell(producto4).setBorder(11);
                                } else {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto4).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la3 - 1) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp3.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(07);
                                    prec.addCell(producto6).setBorder(11);
                                } else {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto6).setBorder(PdfPCell.BOX);
                                }
                            }
                        }
                    } else {
                        for (int y = 0; y < la3; y += 1) {
                            if (y > la1 - 1) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp1.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(07);
                                    prec.addCell(producto2).setBorder(11);
                                } else {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto2).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la2 - 1) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp2.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(07);
                                    prec.addCell(producto4).setBorder(11);
                                } else {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto4).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la3 - 1) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp3.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(07);
                                    prec.addCell(producto6).setBorder(11);
                                } else {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto6).setBorder(PdfPCell.BOX);
                                }
                            }
                        }
                    }
                }
            } else {
                if (la2 == la3) {
                    for (int y = 0; y < la2; y += 1) {
                        if (y > la1 - 1) {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp1.get(y).getPrecio() < 0.01) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(07);
                                prec.addCell(producto2).setBorder(11);
                            } else {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la2 - 1) {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp2.get(y).getPrecio() < 0.01) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(07);
                                prec.addCell(producto4).setBorder(11);
                            } else {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la3 - 1) {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(PdfPCell.BOX);
                            prec.addCell(producto6).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp3.get(y).getPrecio() < 0.01) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(07);
                                prec.addCell(producto6).setBorder(11);
                            } else {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            }
                        }
                    }
                } else {
                    if (la2 > la3) {
                        for (int y = 0; y < la2; y += 1) {
                            if (y > la1 - 1) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp1.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(07);
                                    prec.addCell(producto2).setBorder(11);
                                } else {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto2).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la2 - 1) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp2.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(07);
                                    prec.addCell(producto4).setBorder(11);
                                } else {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto4).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la3 - 1) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp3.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(07);
                                    prec.addCell(producto6).setBorder(11);
                                } else {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto6).setBorder(PdfPCell.BOX);
                                }
                            }
                        }
                    } else {
                        for (int y = 0; y < la3; y += 1) {
                            if (y > la1 - 1) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp1.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(07);
                                    prec.addCell(producto2).setBorder(11);
                                } else {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto2).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la2 - 1) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp2.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(07);
                                    prec.addCell(producto4).setBorder(11);
                                } else {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto4).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la3 - 1) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp3.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(07);
                                    prec.addCell(producto6).setBorder(11);
                                } else {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto6).setBorder(PdfPCell.BOX);
                                }
                            }
                        }
                    }
                }
            }
        }
        return prec;
    }

    private PdfPTable crearLista5(List<List<ListaPrecios>> listaParcial) {

//        List<List<ListaPrecios>> listaParcial = new ArrayList<>();
//        listaParcial.add(lista1);
//        listaParcial.add(lista2);
//        listaParcial.add(lista3);
        float[] anchos = new float[6];
        anchos[0] = 22;
        anchos[1] = 5;
        anchos[2] = 22;
        anchos[3] = 5;
        anchos[4] = 22;
        anchos[5] = 5;

        List<ListaPrecios> lp1 = listaParcial.get(0);
        List<ListaPrecios> lp2 = listaParcial.get(1);
        List<ListaPrecios> lp3 = listaParcial.get(2);
        int la1 = lp1.size();
        int la2 = lp2.size();
        int la3 = lp3.size();

        System.out.println(la1);
        System.out.println(la2);
        System.out.println(la3);

        PdfPTable prec = new PdfPTable(6);
        prec.setWidthPercentage(100);
        try {
            prec.setWidths(anchos);
        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (la1 == la2) {
            if (la1 == la3) {
                for (int y = 0; y < la1; y += 1) {
                    if (y > la1 - 1) {
                        PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                        producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                        prec.addCell(producto1).setBorder(PdfPCell.BOX);
                        prec.addCell(producto2).setBorder(PdfPCell.BOX);
                    } else {
                        if (lp1.get(y).getPrecio() < 0.01) {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(07);
                            prec.addCell(producto2).setBorder(11);
                        } else {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        }
                    }
                    if (y > la2 - 1) {
                        PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                        producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                        prec.addCell(producto3).setBorder(PdfPCell.BOX);
                        prec.addCell(producto4).setBorder(PdfPCell.BOX);
                    } else {
                        if (lp2.get(y).getPrecio() < 0.01) {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(07);
                            prec.addCell(producto4).setBorder(11);
                        } else {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        }
                    }
                    if (y > la3 - 1) {
                        PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                        producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                        producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                        prec.addCell(producto5).setBorder(PdfPCell.BOX);
                        prec.addCell(producto6).setBorder(PdfPCell.BOX);
                    } else {
                        if (lp3.get(y).getPrecio() < 0.01) {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(07);
                            prec.addCell(producto6).setBorder(11);
                        } else {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                    FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(PdfPCell.BOX);
                            prec.addCell(producto6).setBorder(PdfPCell.BOX);
                        }
                    }
                }
            } else {
                if (la1 > la3) {
                    for (int y = 0; y < la1; y += 1) {
                        if (y > la1 - 1) {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp1.get(y).getPrecio() < 0.01) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(07);
                                prec.addCell(producto2).setBorder(11);
                            } else {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la2 - 1) {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp2.get(y).getPrecio() < 0.01) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(07);
                                prec.addCell(producto4).setBorder(11);
                            } else {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la3 - 1) {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(PdfPCell.BOX);
                            prec.addCell(producto6).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp3.get(y).getPrecio() < 0.01) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(07);
                                prec.addCell(producto6).setBorder(11);
                            } else {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            }
                        }
                    }
                } else {
                    for (int y = 0; y < la3; y += 1) {
                        if (y > la1 - 1) {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp1.get(y).getPrecio() < 0.01) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(07);
                                prec.addCell(producto2).setBorder(11);
                            } else {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la2 - 1) {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp2.get(y).getPrecio() < 0.01) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(07);
                                prec.addCell(producto4).setBorder(11);
                            } else {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la3 - 1) {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(PdfPCell.BOX);
                            prec.addCell(producto6).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp3.get(y).getPrecio() < 0.01) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(07);
                                prec.addCell(producto6).setBorder(11);
                            } else {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            }
                        }
                    }
                }
            }
        } else {
            if (la1 > la2) {
                if (la1 == la3) {
                    for (int y = 0; y < la1; y += 1) {
                        if (y > la1 - 1) {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp1.get(y).getPrecio() < 0.01) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(07);
                                prec.addCell(producto2).setBorder(11);
                            } else {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la2 - 1) {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp2.get(y).getPrecio() < 0.01) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(07);
                                prec.addCell(producto4).setBorder(11);
                            } else {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la3 - 1) {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(PdfPCell.BOX);
                            prec.addCell(producto6).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp3.get(y).getPrecio() < 0.01) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(07);
                                prec.addCell(producto6).setBorder(11);
                            } else {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            }
                        }
                    }
                } else {
                    if (la1 > la3) {
                        for (int y = 0; y < la1; y += 1) {
                            if (y > la1 - 1) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp1.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(07);
                                    prec.addCell(producto2).setBorder(11);
                                } else {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto2).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la2 - 1) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp2.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(07);
                                    prec.addCell(producto4).setBorder(11);
                                } else {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto4).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la3 - 1) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp3.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(07);
                                    prec.addCell(producto6).setBorder(11);
                                } else {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto6).setBorder(PdfPCell.BOX);
                                }
                            }
                        }
                    } else {
                        for (int y = 0; y < la3; y += 1) {
                            if (y > la1 - 1) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp1.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(07);
                                    prec.addCell(producto2).setBorder(11);
                                } else {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto2).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la2 - 1) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp2.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(07);
                                    prec.addCell(producto4).setBorder(11);
                                } else {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto4).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la3 - 1) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp3.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(07);
                                    prec.addCell(producto6).setBorder(11);
                                } else {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto6).setBorder(PdfPCell.BOX);
                                }
                            }
                        }
                    }
                }
            } else {
                if (la2 == la3) {
                    for (int y = 0; y < la2; y += 1) {
                        if (y > la1 - 1) {
                            PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp1.get(y).getPrecio() < 0.01) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(07);
                                prec.addCell(producto2).setBorder(11);
                            } else {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la2 - 1) {
                            PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp2.get(y).getPrecio() < 0.01) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(07);
                                prec.addCell(producto4).setBorder(11);
                            } else {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            }
                        }
                        if (y > la3 - 1) {
                            PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                    FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                            producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                            prec.addCell(producto5).setBorder(PdfPCell.BOX);
                            prec.addCell(producto6).setBorder(PdfPCell.BOX);
                        } else {
                            if (lp3.get(y).getPrecio() < 0.01) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(07);
                                prec.addCell(producto6).setBorder(11);
                            } else {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                        FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            }
                        }
                    }
                } else {
                    if (la2 > la3) {
                        for (int y = 0; y < la2; y += 1) {
                            if (y > la1 - 1) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp1.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(07);
                                    prec.addCell(producto2).setBorder(11);
                                } else {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto2).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la2 - 1) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp2.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(07);
                                    prec.addCell(producto4).setBorder(11);
                                } else {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto4).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la3 - 1) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp3.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(07);
                                    prec.addCell(producto6).setBorder(11);
                                } else {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto6).setBorder(PdfPCell.BOX);
                                }
                            }
                        }
                    } else {
                        for (int y = 0; y < la3; y += 1) {
                            if (y > la1 - 1) {
                                PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                prec.addCell(producto2).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp1.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(07);
                                    prec.addCell(producto2).setBorder(11);
                                } else {
                                    PdfPCell producto1 = new PdfPCell(new Paragraph(lp1.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto2 = new PdfPCell(new Paragraph(df.format(lp1.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto1).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto2).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la2 - 1) {
                                PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                prec.addCell(producto4).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp2.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(07);
                                    prec.addCell(producto4).setBorder(11);
                                } else {
                                    PdfPCell producto3 = new PdfPCell(new Paragraph(lp2.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto4 = new PdfPCell(new Paragraph(df.format(lp2.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto3).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto4).setBorder(PdfPCell.BOX);
                                }
                            }
                            if (y > la3 - 1) {
                                PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                        FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                prec.addCell(producto6).setBorder(PdfPCell.BOX);
                            } else {
                                if (lp3.get(y).getPrecio() < 0.01) {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                                            FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(07);
                                    prec.addCell(producto6).setBorder(11);
                                } else {
                                    PdfPCell producto5 = new PdfPCell(new Paragraph(lp3.get(y).getDetalle(),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    PdfPCell producto6 = new PdfPCell(new Paragraph(df.format(lp3.get(y).getPrecio()),
                                            FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
                                    producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                    producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                    prec.addCell(producto5).setBorder(PdfPCell.BOX);
                                    prec.addCell(producto6).setBorder(PdfPCell.BOX);
                                }
                            }
                        }
                    }
                }
            }
        }
        return prec;
    }

//    private PdfPTable crearLista1() {
//
//        float[] anchos = new float[6];
//        anchos[0] = 22;
//        anchos[1] = 5;
//        anchos[2] = 22;
//        anchos[3] = 5;
//        anchos[4] = 22;
//        anchos[5] = 5;
//
//        PdfPTable tablaDetalle = new PdfPTable(6);
//        tablaDetalle.setWidthPercentage(100);
//        PdfPTable prec = new PdfPTable(6);
//        prec.setWidthPercentage(100);
//        PdfPTable precios = new PdfPTable(6);
//        precios.setWidthPercentage(100);
//        try {
//            tablaDetalle.setWidths(anchos);
//            prec.setWidths(anchos);
//            precios.setWidths(anchos);
//        } catch (DocumentException ex) {
//            Logger.getLogger(PDFBuilder.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//
//        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, BOLD, NEGRO)));
//        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("$", FontFactory.getFont("arial", 9, BOLD, NEGRO)));
//        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, BOLD, NEGRO)));
//        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("$", FontFactory.getFont("arial", 9, BOLD, NEGRO)));
//        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, BOLD, NEGRO)));
//        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("$", FontFactory.getFont("arial", 9, BOLD, NEGRO)));
//
//        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//// NOMBRES DE COLUMNAS NO MOSTRAR
////        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.BOX);
////        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.BOX);
////        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.BOX);
////        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.BOX);
////        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.BOX);
////        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.BOX);
//
//        return tablaDetalle;
//    }
    private PdfPTable crearEncabezado2(Integer numHoja) {
        float[] anchos = new float[3];
        anchos[0] = 33;
        anchos[1] = 34;
        anchos[2] = 33;
        PdfPTable encabezado2 = new PdfPTable(3);
        encabezado2.setWidthPercentage(100);
        try {
            encabezado2.setWidths(anchos);

        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        PdfPCell encabLinea0 = new PdfPCell(new Paragraph("GOLOSINAS Y ARTICULOS PARA KIOSCO",
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        PdfPCell encabLinea1 = new PdfPCell(new Paragraph("DISTRIBUIDORA A & M",
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        PdfPCell encabLinea2 = new PdfPCell(new Paragraph("Hoja nro: " + dfc.format(numHoja),
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        encabLinea0.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encabLinea1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        encabLinea2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        encabezado2.addCell(encabLinea0).setBorder(PdfPCell.BOX);
        encabezado2.addCell(encabLinea1).setBorder(PdfPCell.BOX);
        encabezado2.addCell(encabLinea2).setBorder(PdfPCell.BOX);
        return encabezado2;
    }

    private PdfPTable crearEncabezadoSL(Integer numHoja) {
        float[] anchos = new float[3];
        anchos[0] = 33;
        anchos[1] = 34;
        anchos[2] = 33;
        PdfPTable encabezadoSL = new PdfPTable(3);
        encabezadoSL.setWidthPercentage(100);
        try {
            encabezadoSL.setWidths(anchos);

        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        PdfPCell encabLinea0 = new PdfPCell(new Paragraph("GOLOSINAS Y ARTICULOS PARA KIOSCO",
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        PdfPCell encabLinea1 = new PdfPCell(new Paragraph(sdf.format(new Date()),
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        PdfPCell encabLinea2 = new PdfPCell(new Paragraph("Hoja nro: " + dfc.format(numHoja),
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        encabLinea0.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encabLinea1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        encabLinea2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        encabezadoSL.addCell(encabLinea0).setBorder(PdfPCell.BOX);
        encabezadoSL.addCell(encabLinea1).setBorder(PdfPCell.BOX);
        encabezadoSL.addCell(encabLinea2).setBorder(PdfPCell.BOX);
        return encabezadoSL;
    }

    public static File armarEtiquetas(List<Producto> productos) throws FileNotFoundException, DocumentException, Exception {
        if (productos.size() < 1) {
            return null;
        }
        int cuantos = productos.size();
        Configuracion con = null;
        Long lo = 1L;
        try {
            con = new ConfiguracionService().getFacturas(lo);
        } catch (Exception ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        Float por_iva = con.getIva();
        BigDecimal bd_por_iva = new BigDecimal(df.format(por_iva).replace(",", "."));
        String name2 = "yyyyMMddHHmm";
        SimpleDateFormat sdfN = new SimpleDateFormat(name2);
        String name3 = sdfN.format(new Date());
        String fileNameFormatted = "c:/informes/etiquetas_gondola_" + name3 + ".pdf";
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle(690F, 990F);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 20, 20, 20);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        pdf.open();

        int tamanio1 = 11;
        int tamanio2 = 40;

        BigDecimal bd_precio1;
        BigDecimal bd_impuesto1;
        BigDecimal bd_precio2;
        BigDecimal bd_impuesto2;
        BigDecimal bd_resultado1;
        BigDecimal bd_resultado2;
        String s_precio1;
        String s_precio2 = "";
        String neme1 = "";
        String neme2;
        int cuenta = 0;

        float[] ancho = new float[4];
        ancho[0] = 13;
        ancho[1] = 37;
        ancho[2] = 13;
        ancho[3] = 37;

        for (int i = 0; i < cuantos; i += 2) {

            Producto p = productos.get(i);

            Double precio = p.getPrecio();
            Float impuesto = p.getImpuesto();
            cuenta += 1;
            PdfPTable linea = new PdfPTable(4);
            linea.setWidthPercentage(100);
            linea.setTotalWidth(ancho);

            bd_precio1 = new BigDecimal(df.format(precio).replace(",", "."));
            bd_impuesto1 = new BigDecimal(df.format(impuesto).replace(",", "."));
            bd_resultado1 = bd_precio1.multiply(bd_por_iva);
            bd_resultado1 = bd_resultado1.divide(new BigDecimal("100"));
            bd_resultado1 = bd_resultado1.add(bd_precio1).add(bd_impuesto1);
            s_precio1 = df.format(bd_resultado1.doubleValue()).replace(",", ".");
            neme1 = p.getDetalle();

            try {
                p = productos.get(i + 1);

                precio = p.getPrecio();
                impuesto = p.getImpuesto();
            } catch (Exception ex) {
                precio = 0.0;
                impuesto = 0.0F;
            }

            bd_precio2 = new BigDecimal(df.format(precio).replace(",", "."));
            bd_impuesto2 = new BigDecimal(df.format(impuesto).replace(",", "."));
            bd_resultado2 = bd_precio2.multiply(bd_por_iva);
            bd_resultado2 = bd_resultado2.divide(new BigDecimal("100"));
            bd_resultado2 = bd_resultado2.add(bd_precio2).add(bd_impuesto2);
            s_precio2 = df.format(bd_resultado2.doubleValue()).replace(",", ".");
            neme2 = p.getDetalle();

            PdfPCell linea1 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", tamanio2, Font.PLAIN, NEGRO)));
            PdfPCell linea2 = new PdfPCell(new Paragraph("$" + s_precio1, FontFactory.getFont("arial", tamanio2, Font.PLAIN, NEGRO)));
            PdfPCell linea3 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", tamanio2, Font.PLAIN, NEGRO)));
            PdfPCell linea4 = new PdfPCell(new Paragraph("$" + s_precio2, FontFactory.getFont("arial", tamanio2, Font.PLAIN, NEGRO)));

            linea1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            linea2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            linea3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            linea4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

            linea.addCell(linea1).setBorder(13);
            linea.addCell(linea2).setBorder(PdfPCell.BOX);
            linea.addCell(linea3).setBorder(13);
            linea.addCell(linea4).setBorder(PdfPCell.BOX);

            PdfPCell linea5 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", tamanio1, Font.PLAIN, NEGRO)));
            PdfPCell linea6 = new PdfPCell(new Paragraph(neme1, FontFactory.getFont("arial", tamanio1, Font.PLAIN, NEGRO)));
            PdfPCell linea7 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", tamanio1, Font.PLAIN, NEGRO)));
            PdfPCell linea8 = new PdfPCell(new Paragraph(neme2, FontFactory.getFont("arial", tamanio1, Font.PLAIN, NEGRO)));

            linea5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            linea6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            linea7.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            linea8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

            linea.addCell(linea5).setBorder(14);
            linea.addCell(linea6).setBorder(PdfPCell.BOX);
            linea.addCell(linea7).setBorder(14);
            linea.addCell(linea8).setBorder(PdfPCell.BOX);

            pdf.add(linea);

            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 14, Font.PLAIN, FONDO_BLANCO)));

            Image imagen;
            try {
                imagen = Image.getInstance("c://ventas//logo//logo2.png");

            } catch (BadElementException | IOException ex) {
                Logger.getLogger(PDFBuilder.class
                        .getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            imagen.setAbsolutePosition(342f, 918f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(12f, 918f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(342f, 837f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(12f, 837f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(342f, 756f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(12f, 756f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(342f, 677f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(12f, 677f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(342f, 596f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(12f, 596f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(342f, 515f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(12f, 515f);
            pdf.add(imagen);

            imagen.setAbsolutePosition(340f, 434f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(10f, 434f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(340f, 353f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(10f, 353f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(340f, 272f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(10f, 272f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(340f, 191f);
            pdf.add(imagen);
            imagen.setAbsolutePosition(10f, 191f);
            pdf.add(imagen);

            if (cuenta > 9) {
                pdf.newPage();
                cuenta = 0;
            }
        }

        pdf.close();
        File fil = new File(fileNameFormatted);
        return fil;

    }

    private PdfPTable crearLista3(List<ListaPrecios> lista1, List<ListaPrecios> lista2) {
        List<List<ListaPrecios>> listaParcial = new ArrayList<>();
        listaParcial.add(lista1);
        listaParcial.add(lista2);

        float[] anchos = new float[6];
        anchos[0] = 22;
        anchos[1] = 5;
        anchos[2] = 22;
        anchos[3] = 5;
        anchos[4] = 22;
        anchos[5] = 5;

        List<ListaPrecios> lp1 = listaParcial.get(0);
        List<ListaPrecios> lp2 = listaParcial.get(1);

        int la1 = lp1.size();
        int la2 = lp2.size();

        System.out.println(la1);
        System.out.println(la2);

        PdfPTable prec = new PdfPTable(6);
        prec.setWidthPercentage(100);
        try {
            prec.setWidths(anchos);
        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (la1 == la2) {
            for (int y = 0; y < la1; y += 1) {
                if (lp1.get(y).getPrecio() < 0.01) {
                    PdfPCell producto1 = poner1titulo(lp1.get(y).getDetalle());
                    PdfPCell producto2 = poner2blanco();
                    prec.addCell(producto1).setBorder(07);
                    prec.addCell(producto2).setBorder(11);
                } else {
                    PdfPCell producto1 = poner1producto(lp1.get(y).getDetalle());
                    PdfPCell producto2 = poner2producto(df.format(lp1.get(y).getPrecio()));
                    prec.addCell(producto1).setBorder(PdfPCell.BOX);
                    prec.addCell(producto2).setBorder(PdfPCell.BOX);
                }
                if (lp2.get(y).getPrecio() < 0.01) {
                    PdfPCell producto3 = poner3titulo(lp2.get(y).getDetalle());
                    PdfPCell producto4 = poner4blanco();
                    prec.addCell(producto3).setBorder(07);
                    prec.addCell(producto4).setBorder(11);
                } else {
                    PdfPCell producto3 = poner3producto(lp2.get(y).getDetalle());
                    PdfPCell producto4 = poner4producto(df.format(lp2.get(y).getPrecio()));
                    prec.addCell(producto3).setBorder(PdfPCell.BOX);
                    prec.addCell(producto4).setBorder(PdfPCell.BOX);
                }
                PdfPCell producto5 = poner5blanco();
                prec.addCell(producto5).setBorder(PdfPCell.BOX);
                PdfPCell producto6 = poner6blanco();
                prec.addCell(producto6).setBorder(PdfPCell.BOX);
            }
        } else {
            if (la1 > la2) {
                for (int y = 0; y < la1; y += 1) {
                    if (y > la2 - 1) {
                        if (lp1.get(y).getPrecio() < 0.01) {
                            PdfPCell producto1 = poner1titulo(lp1.get(y).getDetalle());
                            PdfPCell producto2 = poner2blanco();
                            prec.addCell(producto1).setBorder(07);
                            prec.addCell(producto2).setBorder(11);
                        } else {
                            PdfPCell producto1 = poner1producto(lp1.get(y).getDetalle());
                            PdfPCell producto2 = poner2producto(df.format(lp1.get(y).getPrecio()));
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        }
                        PdfPCell producto3 = poner3blanco();
                        PdfPCell producto4 = poner4blanco();
                        prec.addCell(producto3).setBorder(PdfPCell.BOX);
                        prec.addCell(producto4).setBorder(PdfPCell.BOX);
                    } else {
                        if (lp1.get(y).getPrecio() < 0.01) {
                            PdfPCell producto1 = poner1titulo(lp1.get(y).getDetalle());
                            PdfPCell producto2 = poner2blanco();
                            prec.addCell(producto1).setBorder(07);
                            prec.addCell(producto2).setBorder(11);
                        } else {
                            PdfPCell producto1 = poner1producto(lp1.get(y).getDetalle());
                            PdfPCell producto2 = poner2producto(df.format(lp1.get(y).getPrecio()));
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        }
                        if (lp2.get(y).getPrecio() < 0.01) {
                            PdfPCell producto3 = poner3titulo(lp2.get(y).getDetalle());
                            PdfPCell producto4 = poner4blanco();
                            prec.addCell(producto3).setBorder(07);
                            prec.addCell(producto4).setBorder(11);
                        } else {
                            PdfPCell producto3 = poner3producto(lp2.get(y).getDetalle());
                            PdfPCell producto4 = poner4producto(df.format(lp2.get(y).getPrecio()));
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        }
                    }
                    PdfPCell producto5 = poner5blanco();
                    prec.addCell(producto5).setBorder(PdfPCell.BOX);
                    PdfPCell producto6 = poner6blanco();
                    prec.addCell(producto6).setBorder(PdfPCell.BOX);
                }
            } else {
                for (int y = 0; y < la2; y += 1) {
                    if (y < la1) {
                        if (lp1.get(y).getPrecio() < 0.01) {
                            PdfPCell producto1 = poner1titulo(lp1.get(y).getDetalle());
                            PdfPCell producto2 = poner2blanco();
                            prec.addCell(producto1).setBorder(07);
                            prec.addCell(producto2).setBorder(11);
                        } else {
                            PdfPCell producto1 = poner1producto(lp1.get(y).getDetalle());
                            PdfPCell producto2 = poner2producto(df.format(lp1.get(y).getPrecio()));
                            prec.addCell(producto1).setBorder(PdfPCell.BOX);
                            prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        }
                        if (lp2.get(y).getPrecio() < 0.01) {
                            PdfPCell producto3 = poner3titulo(lp2.get(y).getDetalle());
                            PdfPCell producto4 = poner4blanco();
                            prec.addCell(producto3).setBorder(07);
                            prec.addCell(producto4).setBorder(11);
                        } else {
                            PdfPCell producto3 = poner3producto(lp2.get(y).getDetalle());
                            PdfPCell producto4 = poner4producto(df.format(lp2.get(y).getPrecio()));
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        }
                    } else {
                        PdfPCell producto1 = poner1blanco();
                        PdfPCell producto2 = poner2blanco();
                        prec.addCell(producto1).setBorder(PdfPCell.BOX);
                        prec.addCell(producto2).setBorder(PdfPCell.BOX);
                        if (lp2.get(y).getPrecio() < 0.01) {
                            PdfPCell producto3 = poner3titulo(lp2.get(y).getDetalle());
                            PdfPCell producto4 = poner4blanco();
                            prec.addCell(producto3).setBorder(07);
                            prec.addCell(producto4).setBorder(11);
                        } else {
                            PdfPCell producto3 = poner3producto(lp2.get(y).getDetalle());
                            PdfPCell producto4 = poner4producto(df.format(lp2.get(y).getPrecio()));
                            prec.addCell(producto3).setBorder(PdfPCell.BOX);
                            prec.addCell(producto4).setBorder(PdfPCell.BOX);
                        }
                    }
                    PdfPCell producto5 = poner5blanco();
                    prec.addCell(producto5).setBorder(PdfPCell.BOX);
                    PdfPCell producto6 = poner6blanco();
                    prec.addCell(producto6).setBorder(PdfPCell.BOX);
                }
            }
        }
        return prec;
    }

    private PdfPTable crearLista4(List<ListaPrecios> lista1) {
        List<List<ListaPrecios>> listaParcial = new ArrayList<>();
        listaParcial.add(lista1);
        float[] anchos = new float[6];
        anchos[0] = 22;
        anchos[1] = 5;
        anchos[2] = 22;
        anchos[3] = 5;
        anchos[4] = 22;
        anchos[5] = 5;

        List<ListaPrecios> lp1 = listaParcial.get(0);

        int la1 = lp1.size();

        System.out.println(la1);

        PdfPTable prec = new PdfPTable(6);
        prec.setWidthPercentage(100);
        try {
            prec.setWidths(anchos);
        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        for (int y = 0; y < la1; y += 1) {
            if (lp1.get(y).getPrecio() < 0.01) {
                PdfPCell producto1 = poner1titulo(lp1.get(y).getDetalle());
                PdfPCell producto2 = poner2blanco();
                prec.addCell(producto1).setBorder(07);
                prec.addCell(producto2).setBorder(11);
            } else {
                PdfPCell producto1 = poner1producto(lp1.get(y).getDetalle());
                PdfPCell producto2 = poner2producto(df.format(lp1.get(y).getPrecio()));
                prec.addCell(producto1).setBorder(PdfPCell.BOX);
                prec.addCell(producto2).setBorder(PdfPCell.BOX);
            }
            PdfPCell producto3 = poner5blanco();
            prec.addCell(producto3).setBorder(PdfPCell.BOX);
            PdfPCell producto4 = poner6blanco();
            prec.addCell(producto4).setBorder(PdfPCell.BOX);
            PdfPCell producto5 = poner5blanco();
            prec.addCell(producto5).setBorder(PdfPCell.BOX);
            PdfPCell producto6 = poner6blanco();
            prec.addCell(producto6).setBorder(PdfPCell.BOX);
        }
        return prec;
    }

    private PdfPCell poner1blanco() {
        PdfPCell producto1 = new PdfPCell(new Paragraph(" ",
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        return producto1;
    }

    private PdfPCell poner2blanco() {
        PdfPCell producto2 = new PdfPCell(new Paragraph(" ",
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        return producto2;
    }

    private PdfPCell poner3blanco() {
        PdfPCell producto3 = new PdfPCell(new Paragraph(" ",
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        return producto3;
    }

    private PdfPCell poner4blanco() {
        PdfPCell producto4 = new PdfPCell(new Paragraph(" ",
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        return producto4;
    }

    private PdfPCell poner5blanco() {
        PdfPCell producto5 = new PdfPCell(new Paragraph(" ",
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        return producto5;
    }

    private PdfPCell poner6blanco() {
        PdfPCell producto6 = new PdfPCell(new Paragraph(" ",
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        return producto6;
    }

    private PdfPCell poner1producto(String detalle) {
        PdfPCell producto1 = new PdfPCell(new Paragraph(detalle,
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        return producto1;
    }

    private PdfPCell poner2producto(String detalle) {
        PdfPCell producto2 = new PdfPCell(new Paragraph(detalle,
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        return producto2;
    }

    private PdfPCell poner3producto(String detalle) {
        PdfPCell producto3 = new PdfPCell(new Paragraph(detalle,
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        return producto3;
    }

    private PdfPCell poner4producto(String detalle) {
        PdfPCell producto4 = new PdfPCell(new Paragraph(detalle,
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        return producto4;
    }

    private PdfPCell poner5producto(String detalle) {
        PdfPCell producto5 = new PdfPCell(new Paragraph(detalle,
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        return producto5;
    }

    private PdfPCell poner6producto(String detalle) {
        PdfPCell producto6 = new PdfPCell(new Paragraph(detalle,
                FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        producto6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        return producto6;
    }

    private PdfPCell poner1titulo(String detalle) {
        PdfPCell producto1 = new PdfPCell(new Paragraph(detalle,
                FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        producto1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        return producto1;
    }

    private PdfPCell poner3titulo(String detalle) {
        PdfPCell producto3 = new PdfPCell(new Paragraph(detalle,
                FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        producto3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        return producto3;
    }

    private PdfPCell poner5titulo(String detalle) {
        PdfPCell producto5 = new PdfPCell(new Paragraph(detalle,
                FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        producto5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        return producto5;
    }

    public File armarListaPrecios3(List<Producto> productos, Boolean sinLogo) throws FileNotFoundException, DocumentException, Exception {
        Configuracion config = new ConfiguracionService().getFacturas(1L);
        Float iva = config.getIva();
        String fileNameFormatted = getFileProductosFormatted();
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle(690F, 990F);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(30, 30, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

//        ABRO EL DOCUMENTO
        pdf.open();

//        PdfPTable encabConLogo = crearEncabezadoConLogo(1);
//        PdfPTable encabSinLogo = crearEncabezadoSinLogo(1);
        Integer numHoja = 0;
        Integer numLinea = 0;
        Integer numCol = 0;
        List<ListaPrecios> lista1 = new ArrayList<>();
        List<ListaPrecios> lista2 = new ArrayList<>();
        List<ListaPrecios> lista3 = new ArrayList<>();
        List<List<ListaPrecios>> listaCompleta = new ArrayList<>();
        int max = 55;//61
        int lim2 = 70;//77
        if (sinLogo) {
            max = lim2;
        }
//        Integer todos = productos.size();
//        Integer cantidadRubros = cantidadRubrosEnListaCompleta(productos);
//        if (todos < ((max * 3) - (cantidadRubros))) {
//            max = todos / 3;
//        }
        SubRubro ru1;
        SubRubro ru2 = null;
        Integer n = 0;
        for (Producto pro : productos) {
            n += 1;
//            String nu = n.toString() + " ";
            String nu = "";
            ru1 = pro.getSubRubro();
            Double precioPro = calcularPrecioDeProducto(pro, iva);
            if (numLinea.equals(0)) {
                numCol = 1;
                numHoja = 1;
                ru1 = pro.getSubRubro();
                ru2 = ru1;
                numLinea += 1;
                ListaPrecios lp = new ListaPrecios();
                ListaPrecios lp1 = new ListaPrecios();
                lp.setDetalle(ru1.getDetalle());
                lp.setPrecio(0.0);
                lista1.add(lp);
                numLinea += 1;
                lp1.setDetalle(nu + pro.getDetalle());
                lp1.setPrecio(precioPro);
                lista1.add(lp1);
            } else {
                if (ru2.equals(ru1)) {
                    if (numLinea < max) {
                        numLinea += 1;
                        switch (numCol) {
                            case 1:
                                ListaPrecios lp1 = new ListaPrecios();
                                lp1.setDetalle(nu + pro.getDetalle());
                                lp1.setPrecio(precioPro);
                                lista1.add(lp1);
                                break;
                            case 2:
                                ListaPrecios lp2 = new ListaPrecios();
                                lp2.setDetalle(nu + pro.getDetalle());
                                lp2.setPrecio(precioPro);
                                lista2.add(lp2);
                                break;
                            case 3:
                                ListaPrecios lp3 = new ListaPrecios();
                                lp3.setDetalle(nu + pro.getDetalle());
                                lp3.setPrecio(precioPro);
                                lista3.add(lp3);
                                break;
                        }
                    } else {
                        if (numCol < 3) {
                            switch (numCol) {
                                case 1:
                                    ListaPrecios lp1 = new ListaPrecios();
                                    lp1.setDetalle(nu + pro.getDetalle());
                                    lp1.setPrecio(precioPro);
                                    lista1.add(lp1);
                                    break;
                                case 2:
                                    ListaPrecios lp2 = new ListaPrecios();
                                    lp2.setDetalle(nu + pro.getDetalle());
                                    lp2.setPrecio(precioPro);
                                    lista2.add(lp2);
                                    break;
                                case 3:
                                    ListaPrecios lp3 = new ListaPrecios();
                                    lp3.setDetalle(nu + pro.getDetalle());
                                    lp3.setPrecio(precioPro);
                                    lista3.add(lp3);
                            }
                            numCol += 1;
                            numLinea = 1;
                        } else {
                            switch (numCol) {
                                case 1:
                                    ListaPrecios lp1 = new ListaPrecios();
                                    lp1.setDetalle(nu + pro.getDetalle());
                                    lp1.setPrecio(precioPro);
                                    lista1.add(lp1);
                                    break;
                                case 2:
                                    ListaPrecios lp2 = new ListaPrecios();
                                    lp2.setDetalle(nu + pro.getDetalle());
                                    lp2.setPrecio(precioPro);
                                    lista2.add(lp2);
                                    break;
                                case 3:
                                    ListaPrecios lp3 = new ListaPrecios();
                                    lp3.setDetalle(nu + pro.getDetalle());
                                    lp3.setPrecio(precioPro);
                                    lista3.add(lp3);
                                    break;
                            }
                            listaCompleta.add(lista1);
                            listaCompleta.add(lista2);
                            listaCompleta.add(lista3);
                            PdfPTable pdt;
                            PdfPTable pdt1;
                            if (sinLogo) {
                                pdt = crearEncabezadoSinLogo(numHoja);
                                pdf.add(pdt);
                                pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", tamLetra, PLAIN, FONDO_BLANCO)));
                            } else {
                                if (numHoja.equals(1)) {
                                    pdf.add(crearEncabezado1());
                                    for (int i = 0; i < 7; i++) {
                                        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", tamLetra, PLAIN, FONDO_BLANCO)));
                                    }
                                    Image imagen = Image.getInstance("c://ventas//logo//logo.png");
                                    imagen.setAbsolutePosition(370f, 780f);
                                    pdf.add(imagen);
                                    max = lim2;
                                } else {
                                    pdt = crearEncabezadoConLogo(numHoja);
                                    pdf.add(pdt);
                                    pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", tamLetra, PLAIN, FONDO_BLANCO)));
                                }
                            }
                            pdt1 = pasarToPdf(listaCompleta, max);
                            pdf.add(pdt1);
                            pdf.newPage();
                            numCol = 1;
                            numLinea = 1;
                            numHoja += 1;
                            lista1 = new ArrayList<>();
                            lista2 = new ArrayList<>();
                            lista3 = new ArrayList<>();
                            listaCompleta = new ArrayList<>();
                        }
                    }
                } else {
//                    99
                    switch (numCol) {
                        case 1:
                            numLinea += 1;
                            ListaPrecios lp0 = new ListaPrecios();
                            lp0.setDetalle(pro.getSubRubro().getDetalle());
                            lp0.setPrecio(0.0);
                            lista1.add(lp0);
                            numLinea += 1;
                            ListaPrecios lp1 = new ListaPrecios();
                            lp1.setDetalle(nu + pro.getDetalle());
                            lp1.setPrecio(precioPro);
                            lista1.add(lp1);
                            break;
                        case 2:
                            numLinea += 1;
                            ListaPrecios lp9 = new ListaPrecios();
                            lp9.setDetalle(pro.getSubRubro().getDetalle());
                            lp9.setPrecio(0.0);
                            lista2.add(lp9);
                            numLinea += 1;
                            ListaPrecios lp2 = new ListaPrecios();
                            lp2.setDetalle(nu + pro.getDetalle());
                            lp2.setPrecio(precioPro);
                            lista2.add(lp2);
                            break;
                        case 3:
                            numLinea += 1;
                            ListaPrecios lp8 = new ListaPrecios();
                            lp8.setDetalle(pro.getSubRubro().getDetalle());
                            lp8.setPrecio(0.0);
                            lista3.add(lp8);
                            numLinea += 1;
                            ListaPrecios lp3 = new ListaPrecios();
                            lp3.setDetalle(nu + pro.getDetalle());
                            lp3.setPrecio(precioPro);
                            lista3.add(lp3);
                            break;
                    }
                    ru2 = pro.getSubRubro();
////                    ListaPrecios lp = new ListaPrecios();
////                    ListaPrecios lp1 = new ListaPrecios();
////                    lp.setDetalle(ru1.getDetalle());
////                    lp.setPrecio(0.0);
////                    lista1.add(lp);
//                    numLinea += 1;
////                    ru2 = ru1;
//                    lp1.setDetalle(nu + pro.getDetalle());
//                    lp1.setPrecio(precioPro);
//                    lista1.add(lp1);
                }
            }
        }
        PdfPTable pdt;
        PdfPTable pdt1;
        switch (numCol) {
            case 1:
                listaCompleta.add(lista1);
                ListaPrecios lp0 = new ListaPrecios();
                lp0.setDetalle(" ");
                lp0.setPrecio(0.0);
                lista2.add(lp0);
                lista3.add(lp0);
                listaCompleta.add(lista2);
                listaCompleta.add(lista3);
                break;
            case 2:
                listaCompleta.add(lista1);
                listaCompleta.add(lista2);
                ListaPrecios lp1 = new ListaPrecios();
                lp1.setDetalle(" ");
                lp1.setPrecio(0.0);
                lista3.add(lp1);
                listaCompleta.add(lista3);
                break;
            case 3:
                listaCompleta.add(lista1);
                listaCompleta.add(lista2);
                listaCompleta.add(lista3);
                break;
        }
        if (sinLogo) {
            pdt = crearEncabezadoSinLogo(numHoja);
            pdf.add(pdt);
            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", tamLetra, PLAIN, FONDO_BLANCO)));
        } else {
            if (numHoja.equals(1)) {
                pdf.add(crearEncabezado1());
                for (int i = 0; i < 7; i++) {
                    pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", tamLetra, PLAIN, FONDO_BLANCO)));
                }
                Image imagen = Image.getInstance("c://ventas//logo//logo.png");
                imagen.setAbsolutePosition(370f, 780f);
                pdf.add(imagen);
            } else {
                pdt = crearEncabezadoConLogo(numHoja);
                pdf.add(pdt);
                pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", tamLetra, PLAIN, FONDO_BLANCO)));
            }
        }
        pdt1 = pasarToPdf(listaCompleta, max);
        pdf.add(pdt1);
        pdf.close();
        File fil = new File(fileNameFormatted);
        return fil;
    }

    private PdfPTable crearEncabezadoConLogo(Integer numHoja) {
        float[] anchos = new float[3];
        anchos[0] = 33;
        anchos[1] = 34;
        anchos[2] = 33;
        PdfPTable encabezado2 = new PdfPTable(3);
        encabezado2.setWidthPercentage(100);
        try {
            encabezado2.setWidths(anchos);
        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        PdfPCell encabLinea0 = new PdfPCell(new Paragraph("GOLOSINAS Y ARTICULOS PARA KIOSCO",
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        PdfPCell encabLinea1 = new PdfPCell(new Paragraph("DISTRIBUIDORA A & M",
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        PdfPCell encabLinea2 = new PdfPCell(new Paragraph("Hoja nro: " + dfc.format(numHoja),
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        encabLinea0.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encabLinea1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        encabLinea2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        encabezado2.addCell(encabLinea0).setBorder(PdfPCell.BOX);
        encabezado2.addCell(encabLinea1).setBorder(PdfPCell.BOX);
        encabezado2.addCell(encabLinea2).setBorder(PdfPCell.BOX);
        return encabezado2;
    }

    private PdfPTable crearEncabezadoSinLogo(Integer numHoja) {
        float[] anchos = new float[3];
        anchos[0] = 33;
        anchos[1] = 34;
        anchos[2] = 33;
        PdfPTable encabezadoSL = new PdfPTable(3);
        encabezadoSL.setWidthPercentage(100);
        try {
            encabezadoSL.setWidths(anchos);

        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        PdfPCell encabLinea0 = new PdfPCell(new Paragraph("GOLOSINAS Y ARTICULOS PARA KIOSCO",
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        PdfPCell encabLinea1 = new PdfPCell(new Paragraph(sdf.format(new Date()),
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        PdfPCell encabLinea2 = new PdfPCell(new Paragraph("Hoja nro: " + dfc.format(numHoja),
                FontFactory.getFont("arial", 9, BOLD, NEGRO)));
        encabLinea0.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encabLinea1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        encabLinea2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        encabezadoSL.addCell(encabLinea0).setBorder(PdfPCell.BOX);
        encabezadoSL.addCell(encabLinea1).setBorder(PdfPCell.BOX);
        encabezadoSL.addCell(encabLinea2).setBorder(PdfPCell.BOX);

        return encabezadoSL;
    }

//    private Integer cantidadRubrosEnListaCompleta(List<Producto> productos) {
//        Integer cantidad = 1;
//        Rubro ru1 = productos.get(0).getRubro();
//        for (Producto p : productos) {
//            Rubro ru2 = p.getRubro();
//            if (!ru1.equals(ru2)) {
//                cantidad += 1;
//                ru1 = ru2;
//            }
//        }
//        return cantidad;
//    }
    private PdfPTable pasarToPdf(List<List<ListaPrecios>> listaCompleta, Integer mx) {
        List<ListaPrecios> li1 = listaCompleta.get(0);
        List<ListaPrecios> li2 = listaCompleta.get(1);
        List<ListaPrecios> li3 = listaCompleta.get(2);
        PdfPTable pdfTable = new PdfPTable(6);
        pdfTable.setWidthPercentage(100);
        float[] anchos = new float[6];
        anchos[0] = 22;
        anchos[1] = 5;
        anchos[2] = 22;
        anchos[3] = 5;
        anchos[4] = 22;
        anchos[5] = 5;
        try {
            pdfTable.setWidths(anchos);
        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        int largo1 = li1.size();
        int largo2 = li2.size();
        int largo3 = li3.size();
        if (largo1 > largo2) {
            if (largo1 > largo3) {
                mx = largo1;
            } else {
                mx = largo3;
            }
        } else {
            if (largo2 > largo3) {
                mx = largo2;
            } else {
                mx = largo3;
            }
        }
        for (int i = 0; i < mx; i++) {
            if (i < largo1) {
                if (df.format(li1.get(i).getPrecio()).equals("0,00")) {
                    String rubro = li1.get(i).getDetalle();
                    PdfPCell celdaDescrip = new PdfPCell(new Paragraph(rubro,
                            FontFactory.getFont("arial", tamLetra, BOLD, NEGRO)));
                    PdfPCell celdaPrec = new PdfPCell(new Paragraph("",
                            FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                    celdaDescrip.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                    celdaPrec.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                    pdfTable.addCell(celdaDescrip).setBorder(07);
                    pdfTable.addCell(celdaPrec).setBorder(11);
                } else {
                    PdfPCell celdaDescrip = new PdfPCell(new Paragraph(li1.get(i).getDetalle(),
                            FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                    PdfPCell celdaPrec = new PdfPCell(new Paragraph(df.format(li1.get(i).getPrecio()),
                            FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                    celdaDescrip.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                    celdaPrec.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                    pdfTable.addCell(celdaDescrip).setBorder(PdfPCell.BOX);
                    pdfTable.addCell(celdaPrec).setBorder(PdfPCell.BOX);
                }
            } else {
                PdfPCell celdaDescrip = new PdfPCell(new Paragraph(" ",
                        FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                PdfPCell celdaPrec = new PdfPCell(new Paragraph(" ",
                        FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                celdaDescrip.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                celdaPrec.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                pdfTable.addCell(celdaDescrip).setBorder(PdfPCell.BOX);
                pdfTable.addCell(celdaPrec).setBorder(PdfPCell.BOX);
            }
            if (i < largo2) {
                if (df.format(li2.get(i).getPrecio()).equals("0,00")) {
                    String rubro = li2.get(i).getDetalle();
                    PdfPCell celdaDescrip = new PdfPCell(new Paragraph(rubro,
                            FontFactory.getFont("arial", tamLetra, BOLD, NEGRO)));
                    PdfPCell celdaPrec = new PdfPCell(new Paragraph("",
                            FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                    celdaDescrip.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                    celdaPrec.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                    pdfTable.addCell(celdaDescrip).setBorder(07);
                    pdfTable.addCell(celdaPrec).setBorder(11);
                } else {
                    PdfPCell celdaDescrip = new PdfPCell(new Paragraph(li2.get(i).getDetalle(),
                            FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                    PdfPCell celdaPrec = new PdfPCell(new Paragraph(df.format(li2.get(i).getPrecio()),
                            FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                    celdaDescrip.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                    celdaPrec.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                    pdfTable.addCell(celdaDescrip).setBorder(PdfPCell.BOX);
                    pdfTable.addCell(celdaPrec).setBorder(PdfPCell.BOX);
                }
            } else {
                PdfPCell celdaDescrip = new PdfPCell(new Paragraph(" ",
                        FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                PdfPCell celdaPrec = new PdfPCell(new Paragraph(" ",
                        FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                celdaDescrip.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                celdaPrec.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                pdfTable.addCell(celdaDescrip).setBorder(PdfPCell.BOX);
                pdfTable.addCell(celdaPrec).setBorder(PdfPCell.BOX);
            }
            if (i < largo3) {
                if (df.format(li3.get(i).getPrecio()).equals("0,00")) {
                    String rubro = li3.get(i).getDetalle();
                    PdfPCell celdaDescrip = new PdfPCell(new Paragraph(rubro,
                            FontFactory.getFont("arial", tamLetra, BOLD, NEGRO)));
                    PdfPCell celdaPrec = new PdfPCell(new Paragraph("",
                            FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                    celdaDescrip.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                    celdaPrec.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                    pdfTable.addCell(celdaDescrip).setBorder(07);
                    pdfTable.addCell(celdaPrec).setBorder(11);
                } else {
                    PdfPCell celdaDescrip = new PdfPCell(new Paragraph(li3.get(i).getDetalle(),
                            FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                    PdfPCell celdaPrec = new PdfPCell(new Paragraph(df.format(li3.get(i).getPrecio()),
                            FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                    celdaDescrip.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                    celdaPrec.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                    pdfTable.addCell(celdaDescrip).setBorder(PdfPCell.BOX);
                    pdfTable.addCell(celdaPrec).setBorder(PdfPCell.BOX);
                }
            } else {
                PdfPCell celdaDescrip = new PdfPCell(new Paragraph(" ",
                        FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                PdfPCell celdaPrec = new PdfPCell(new Paragraph(" ",
                        FontFactory.getFont("arial", tamLetra, PLAIN, NEGRO)));
                celdaDescrip.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                celdaPrec.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                pdfTable.addCell(celdaDescrip).setBorder(PdfPCell.BOX);
                pdfTable.addCell(celdaPrec).setBorder(PdfPCell.BOX);
            }
        }
        return pdfTable;
    }
}
