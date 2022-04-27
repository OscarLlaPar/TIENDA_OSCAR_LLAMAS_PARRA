package curso.java.pruebas;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import curso.java.modelo.MetodoPago;
import curso.java.modelo.ProductoDBH;
import curso.java.modelo.UsuarioDB;

public class Pruebas {
	public static void main(String[] args) {
		Document document = new Document();
        
        try{
            PdfWriter.getInstance(document, new FileOutputStream("tablassdasd.pdf"));
            document.open();
             
            // Este codigo genera una tabla de 3 columnas
            PdfPTable table = new PdfPTable(3);                
             
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell("Celda 1");
            table.addCell("Celda 2");
            table.addCell("Celda 3");
             
            table.addCell("Celda 4");
            table.addCell("Celda 5");
            table.addCell("Celda 6");
             
            table.addCell("Celda 7");
            table.addCell("Celda 8");
            table.addCell("Celda 9");
             
            // Si desea crear una celda de mas de una columna
            // Cree un objecto Cell y cambie su propiedad span
             
            PdfPCell celdaFinal = new PdfPCell(new Paragraph("Final de la tabla"));
             
            // Indicamos cuantas columnas ocupa la celda
            celdaFinal.setColspan(3);
            table.addCell(celdaFinal);
             
            // Agregamos la tabla al documento            
            document.add(table);
             
            document.close();
             
        }catch(Exception e)
        {
            System.err.println("Ocurrio un error al crear el archivo");
            System.exit(-1);
        }
	}
}
