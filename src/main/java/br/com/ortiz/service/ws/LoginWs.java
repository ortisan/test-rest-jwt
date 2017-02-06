package br.com.ortiz.service.ws;

import br.com.ortiz.business.ejb.UserService;
import br.com.ortiz.domain.entity.User;
import br.com.ortiz.to.LoginTo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;

/**
 * Created by marcelo on 02/02/17.
 */
@Path("/login")
public class LoginWs {

    @Inject
    private UserService userService;

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response login(LoginTo loginTo) {
        String token = null;

        User userLoaded = userService.findByUserName(loginTo.getUsername());

        if (userLoaded != null && loginTo.getPassword().equals(userLoaded.getPassword())) {
            try {
                token = JWT.create().withClaim("user_id", userLoaded.getId().toString()).withClaim("username", userLoaded.getUsername()).sign(Algorithm.HMAC256("aloha"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        Response response = Response.ok(token).header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", token)).build();
        return response;
    }
}
