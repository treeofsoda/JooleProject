package com.Joole.demo.Controller;


import com.Joole.demo.Entity.Role;
import com.Joole.demo.Entity.User;
import com.Joole.demo.Service.MyUserDetailsService;
import com.Joole.demo.Service.UserService;
import com.Joole.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private AuthenticationManager myauthenticaitonManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    public UserController() {
    }

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }


    //sign in
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User User)
    //)
            throws Exception {

        try {
            myauthenticaitonManager.authenticate(
                    new UsernamePasswordAuthenticationToken(User.getUsername(), User.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            //throw new Exception("Incorrect username or password", e);
            return ResponseHandler.generateResponse("Incorrect username or password!", HttpStatus.MULTI_STATUS, null);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(User.getUsername());//);

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseHandler.generateResponse("Login successful!", HttpStatus.OK, jwt);
    }



    @PostMapping("/createUser")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.ADMIN);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


}
