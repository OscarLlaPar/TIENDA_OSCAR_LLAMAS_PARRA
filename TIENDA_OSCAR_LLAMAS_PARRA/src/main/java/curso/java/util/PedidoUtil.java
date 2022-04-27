package curso.java.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import curso.java.modelo.DetallePedido;
import curso.java.modelo.Pedido;

public class PedidoUtil {
	public static boolean generarFactura(Pedido p, String path) {
		Document document = new Document();
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream(path+"/"+p.getNumFactura()+".pdf"));
			document.open();
			
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
			
			HashMap<Integer,DetallePedido> detalles=p.getDetallesPedido();
			
			PdfPTable tablaDetalles=new PdfPTable(5);
			
			PdfPCell cabeceraDetalles=new PdfPCell(new Paragraph("Detalles del pedido"));
			cabecera.setColspan(5);
			
			tablaDetalles.addCell(cabeceraDetalles);
			
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
