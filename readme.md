# iText Tutorials

This project shows simple examples of using iText for processing PDFs. A more detailed
tutorial is availabone at [http://www.minh.io](http://www.minh.iotech/2013/07/06/tutorialpdf-image-extraction/)

# ExtractImages 

This program extracts and outputs all images from a PDF. Included is a sample
PDF from [NASA](http://www.nasa.gov/pdf/354470main_aresIX_fs_may09.pdf), which has roughly 4 images.

To execute the program: "mvn exec:exec"

Parameters can also be passed in to configure the source PDF file and the directory to extract images:
"mvn exec:exec -Dsrc=/dir1/file.pdf -Ddest=/dir1/output"

# License

Since iText is [AGPL](http://itextpdf.com/terms-of-use/agpl.php), this project also needs to follow its license. It would be great if iText was MIT or Apache licensed but oh well.