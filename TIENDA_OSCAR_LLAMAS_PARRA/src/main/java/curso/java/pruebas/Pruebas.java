package curso.java.pruebas;

import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		Pattern pattern = Pattern.compile(".*\\d.*");
 
        // El email a validar
        String email = "123";
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find()) {
            System.out.println("Numeros");
        } else {
            System.out.println("No numeros");
        }
	}
}
