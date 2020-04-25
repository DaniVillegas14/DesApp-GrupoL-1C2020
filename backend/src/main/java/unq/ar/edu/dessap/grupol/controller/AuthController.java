package unq.ar.edu.dessap.grupol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import unq.ar.edu.dessap.grupol.controller.dtos.UserDto;
import unq.ar.edu.dessap.grupol.model.Buyer;
import unq.ar.edu.dessap.grupol.service.BuyerService;
import javax.validation.Valid;


@RestController
@Validated
@RequestMapping(value = "/api/v1/auth")
@Component
public class AuthController {

    @Autowired
    private BuyerService buyerService;

    @PostMapping(value = "/register")
    public ResponseEntity<Buyer> register(@Valid @RequestBody UserDto userData) {
        Buyer buyer = buyerService.create(userData.getUsername(), userData.getPassword(), userData.getEmail());

        //TODO se esta devolviendo la contraseña
        //TODO handlear la excepcion cuando esta repetido el email
        return new ResponseEntity<>(buyer, HttpStatus.OK);
    }

}