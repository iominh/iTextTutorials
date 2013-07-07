/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
     * The new document to which we've added a border rectangle.
     */
    public static final String RESULT = "src/main/resources/Img%s.%s";
    /**
     * PDF to extract images from
     */
    public static final String SOURCE_PDF = "src/main/resources/354470main_aresIX_fs_may09.pdf";

    /**
     * Parses a PDF and extracts all the images.
     *
     * @param src the source PDF
     * @param dest the resulting PDF
     */
    public void extractImages(String filename)
            throws IOException, DocumentException {
        PdfReader reader = new PdfReader(filename);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        ImageRenderListener listener = new ImageRenderListener(RESULT);
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
        if (args.length > 0) {
            sourcePDF = args[0];
        }
        new ExtractImages().extractImages(sourcePDF);
    }
}