package ro.robert.licentaDemo.comSunJersey.utils;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class Filtru implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext arg0,
			ContainerResponseContext arg1) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("an request was made");
	}

}
