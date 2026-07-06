/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reports;
import Main.DBConnection;
import java.sql.Connection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.io.InputStream;
/**
 *
 * @author shani
 */
public class ReportManager {
    
     public static void showProductInventoryReport() {

        try {

            Connection con = DBConnection.createConnection();

            InputStream reportStream = ReportManager.class.getResourceAsStream("/Reports/ProductInventoryReport.jrxml");

            if (reportStream == null) {
                throw new RuntimeException("ProductInventoryReport.jrxml not found!");
        }

            JasperPrint print = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(reportStream),
                    null,
                    con);

            JasperViewer.viewReport(print, false);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
     public static void showMonthlySalesReport() {

    try {

        Connection con = DBConnection.createConnection();

        InputStream reportStream =
                ReportManager.class.getResourceAsStream("/Reports/MonthlySalesReport.jrxml");

        if (reportStream == null) {
            throw new RuntimeException("MonthlySalesReport.jrxml not found!");
        }

        JasperPrint print = JasperFillManager.fillReport(
                JasperCompileManager.compileReport(reportStream),
                null,
                con);

        JasperViewer.viewReport(print, false);

    } catch (Exception e) {
        e.printStackTrace();
    }

}
     public static void showSalesInvoiceReport() {

    try {

        Connection con = DBConnection.createConnection();

        InputStream reportStream =
                ReportManager.class.getResourceAsStream("/Reports/SalesInvoiceReport.jrxml");

        if (reportStream == null) {
            throw new RuntimeException("SalesInvoiceReport.jrxml not found!");
        }

        JasperPrint print = JasperFillManager.fillReport(
                JasperCompileManager.compileReport(reportStream),
                null,
                con);

        JasperViewer.viewReport(print, false);

    } catch (Exception e) {
        e.printStackTrace();
    }

}

    
    
    
}
