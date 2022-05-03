package curso.java.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Header;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import curso.java.modelo.DetallePedido;
import curso.java.modelo.Pedido;
import curso.java.modelo.Usuario;
import curso.java.servicio.ConfiguracionServicio;

public class PedidoUtil {
	public static boolean generarFactura(Pedido p, String path, Usuario u) {
		Document document = new Document();
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream(path+"/"+p.getNumFactura()+".pdf"));
			document.open();
			
			String nombreTienda=ConfiguracionServicio.obtenerConfiguracion("nombreTienda").getValor();
			String direccionTienda=ConfiguracionServicio.obtenerConfiguracion("direccionTienda").getValor();
			
			Font font = FontFactory.getFont(FontFactory.HELVETICA, 24, BaseColor.RED);
			 Anchor anchor = new Anchor(nombreTienda, font);
		        anchor.setName(nombreTienda);

		        // Second parameter is the number of the chapter
		        Paragraph catPart = new Paragraph(anchor);
		        
		       
		        catPart.add(new Paragraph(direccionTienda));
		        catPart.add(new Paragraph(" "));
		        
		        catPart.add(new Paragraph("Nombre del cliente: "+u.getNombre()+" "+u.getApellido1()+" "+u.getApellido2()));
		        catPart.add(new Paragraph("Dirección del cliente: "+u.getLocalidad()+ " ("+u.getProvincia()+"), "+ u.getDireccion()));
		        

		   
		        Paragraph paragraph = new Paragraph();
			
		       document.add(catPart);
			
			
			document.add(new Paragraph(" "));
			
			PdfPTable tablaPedido=new PdfPTable(3);
			
			PdfPCell cabecera=new PdfPCell(new Paragraph("Pedido"));
			cabecera.setColspan(3);
			
			tablaPedido.addCell(cabecera);
			
			tablaPedido.addCell("Núm. Factura");
			tablaPedido.addCell("Fecha");
			tablaPedido.addCell("Total");
			
			tablaPedido.addCell(p.getNumFactura());
			tablaPedido.addCell(p.getFecha().toString());
			tablaPedido.addCell(String.valueOf(p.getTotal()));
			
			document.add(tablaPedido);
			
			document.add(new Paragraph(" "));
			
			HashMap<Integer,DetallePedido> detalles=p.getDetallesPedido();
			
			PdfPTable tablaDetalles=new PdfPTable(5);
			
			document.add(new Paragraph("Detalles del pedido"));
			document.add(new Paragraph(" "));
			
			tablaDetalles.addCell("Producto");
			tablaDetalles.addCell("Precio unidad");
			tablaDetalles.addCell("Unidades");
			tablaDetalles.addCell("Impuesto");
			tablaDetalles.addCell("Total");
			
			
			for(Map.Entry<Integer,DetallePedido> detalle : detalles.entrySet()) {
				tablaDetalles.addCell(detalle.getValue().getProducto().getNombre());
				tablaDetalles.addCell(String.valueOf(detalle.getValue().getPrecioUnidad()));
				tablaDetalles.addCell(String.valueOf(detalle.getValue().getUnidades()));
				tablaDetalles.addCell(String.valueOf(detalle.getValue().getImpuesto()));
				tablaDetalles.addCell(String.valueOf(detalle.getValue().getTotal()));
			}
			
			document.add(tablaDetalles);
			
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			document.close();
		}
	}
}
