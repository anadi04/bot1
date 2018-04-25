package selenium;

import java.io.*;

public class html1 {

    public  void creation()
    { 
    	int i=0;
        try {
            //define a HTML String Builder
            StringBuilder htmlStringBuilder=new StringBuilder();
            //append html header and title
            htmlStringBuilder.append("<html><head><title>Orders </title></head>");
            //append body
            htmlStringBuilder.append("<body>");
            //append table
            htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#005430\">");
            //append row
            htmlStringBuilder.append("<tr><td><b>Product Name</b></td><td><b>Seller</b></td><td><b>OrderID</b></td><td><b>Oredered on</b></td><td><b>Delivered on</b></td><td><b>Order Total</b></td></tr>");
            //append row
            for(i=1;i<=autologin.counter;i++)
            {
            	htmlStringBuilder.append("<tr><td>"+autologin.title[i]+"</td><td>"+autologin.seller[i]+"</td><td>"+autologin.id[i]+"</td><td>"+autologin.orderdate[i]+"</td><td>"+autologin.deldate[i]+"</td><td>"+autologin.price[i]+"</td></tr>");
            }
            htmlStringBuilder.append("</table></body></html>");
            //write html string content to a file
            WriteToFile(htmlStringBuilder.toString(),"orders.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void WriteToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator+fileName;
        File file = new File(tempFile);
        // if file does exists, then delete and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator+ "backup_"+fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer=new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();

    }
  /*  public static void main(String[] args)
    {
    	html1 h=new html1();
    	h.creation();
    }*/
}