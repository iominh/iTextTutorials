package io.minh.iText.image;

import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author mnguyen
 */
public class PDFImageExtractor {

    public static void main(String[] args) {

        String pdf = "src/main/resources/354470main_aresIX_fs_may09.pdf";
        PdfReader reader = null;

        File file = new File(pdf);
        try {
            reader = new PdfReader(file.getAbsolutePath());
            for (int i = 0; i < reader.getXrefSize(); i++) {
                PdfObject pdfobj = reader.getPdfObject(i);
                if (pdfobj == null || !pdfobj.isStream()) {
                    continue;
                }
                PdfStream stream = (PdfStream) pdfobj;
                PdfObject pdfsubtype = stream.get(PdfName.SUBTYPE);
                if (pdfsubtype != null && pdfsubtype.toString().equals(PdfName.IMAGE.toString())) {
                    byte[] img = PdfReader.getStreamBytesRaw((PRStream) stream);
                    FileOutputStream out = new FileOutputStream(new File(file.getParentFile(), String.format("%1$05d", i) + ".jpg"));
                    out.write(img);
                    out.flush();
                    out.close();
                }
            }

        } catch (IOException ex) {
        }

    }
}
