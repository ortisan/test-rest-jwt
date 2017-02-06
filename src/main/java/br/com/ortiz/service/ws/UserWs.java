package br.com.ortiz.service.ws;

import br.com.ortiz.annotations.Secured;
import br.com.ortiz.business.ejb.UserService;
import br.com.ortiz.domain.entity.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by marcelo on 11/12/16.
 */
@Path("/user")
public class UserWs {

    @Inject
    private UserService userService;

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public User save(User user) {
        userService.save(user);
        return user;
    }

    @Secured
    @Path("/")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        // Just to test JWT
        return userService.findAll();
    }


}
