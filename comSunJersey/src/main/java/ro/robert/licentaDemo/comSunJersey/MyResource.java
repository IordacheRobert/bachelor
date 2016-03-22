package ro.robert.licentaDemo.comSunJersey;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("res")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    
    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(){
    	User user=new User();
    	user.setTask(new Task("titlu","descriere"));
    	user.setUsername("Robert");
    	user.getToDo().add("Termina licenta");
    	user.getToDo().add("Mergi la munca");
    	user.getToDo().add("Mergi la facultate");
    	return user;
    }
    
    
    @GET
    @Path("/images/{name}")
    @Produces("image/jpg")
    public Response downloadImageFile(@PathParam("name")String denumire) {
    	ClassLoader classLoader = getClass().getClassLoader();
        // set file (and path) to be download
    	String path=null;
    	try{
    		 path=classLoader.getResource("images/"+denumire).getFile();
    	}catch(NullPointerException ex){
    		System.out.println(ex.getMessage());
    		 return Response.ok().status(404).build();
    	}
    	System.out.println(path);
        File file = new File(path);
 
        ResponseBuilder responseBuilder = Response.ok((Object) file);
       // responseBuilder.header("Content-Disposition", "attachment; filename=\"MyPngImageFile.png\"");
        return responseBuilder.build();
    }
    	
    @GET
    @Path("/txt/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response downloadTxtFile(@PathParam("name")String denumire) {
    	ClassLoader classLoader = getClass().getClassLoader();
        // set file (and path) to be download
    	String path=null;
    	try{
    		 path=classLoader.getResource("images/"+denumire).getFile();
    	}catch(NullPointerException ex){
    		System.out.println(ex.getMessage());
    		 return Response.ok().status(404).build();
    	}
    	System.out.println(path);
        File file = new File(path);
 
        ResponseBuilder responseBuilder = Response.ok((Object) file);
       // responseBuilder.header("Content-Disposition", "attachment; filename=\"MyPngImageFile.png\"");
        return responseBuilder.build();
    }
    
    
    @POST
    @Path("/upload/images")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadImageFile(
            @FormDataParam("uploadFile") InputStream fileInputStream,
            @FormDataParam("uploadFile") FormDataContentDisposition fileFormDataContentDisposition) {
 
        // local variables
        String fileName = null;
        String uploadFilePath = null;
 
        try {
            fileName = fileFormDataContentDisposition.getFileName();
            uploadFilePath = writeToFileServer(fileInputStream, fileName);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        finally{
            // release resources, if any
        }
        return Response.ok("File uploaded successfully at " + uploadFilePath).build();
    }
 
    /**
     * write input stream to file server
     * @param inputStream
     * @param fileName
     * @throws IOException
     */
    private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {
 
        OutputStream outputStream = null;
        String qualifiedUploadFilePath = getClass().getClassLoader().toString() + fileName;
 
        try {
            outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally{
            //release resource, if any
            outputStream.close();
        }
        return qualifiedUploadFilePath;
    }
    
}
