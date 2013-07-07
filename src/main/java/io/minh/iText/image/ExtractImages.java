package io.minh.iText.image;

import java.io.IOException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;

/**
 * Extracts images from a PDF file.
 */
public class ExtractImages {

    /**
     * PDF to extract images from
     */
    public static final String SOURCE_PDF = "src/main/resources/354470main_aresIX_fs_may09.pdf";

    /**
     * Parses a PDF and extracts all the images.
     *
     * @param filename the source PDF
     * @param destination the directory to save images
     */
    public void extractImages(String filename, String destination)
            throws IOException, DocumentException {
        System.out.println("Processing PDF at " + filename);
        System.out.println("Saving images to " + destination);

        PdfReader reader = new PdfReader(filename);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        ImageRenderListener listener = new ImageRenderListener(destination + "/Img%s.%s");
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            parser.processContent(i, listener);
        }
        reader.close();
    }

    /**
     * Main method.
     *
     * @param args no arguments needed
     * @throws DocumentException
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, DocumentException {
        String sourcePDF = SOURCE_PDF;
        String destination = "target";
        if (args.length > 0) {
            sourcePDF = args[0];
            if (args.length > 1) {
                destination = args[1];
            }
        }

        new ExtractImages().extractImages(sourcePDF, destination);
    }
}