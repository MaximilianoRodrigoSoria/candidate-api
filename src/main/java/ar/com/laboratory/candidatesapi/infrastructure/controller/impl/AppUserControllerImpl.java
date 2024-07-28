package ar.com.laboratory.candidatesapi.infrastructure.controller.impl;


import ar.com.laboratory.candidatesapi.application.service.ModifyUserService;
import ar.com.laboratory.candidatesapi.infrastructure.controller.AppUserController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/user")
@AllArgsConstructor

public class AppUserControllerImpl  implements AppUserController {

    private final ModifyUserService modifyUserService;


    @PatchMapping(path = "/enabled_or_disabled")
    public ResponseEntity<Map<String, Boolean>> enabledOrDisabled(@RequestParam String username) {
        return ResponseEntity.ok(this.modifyUserService.enabled(username));
    }


    @PatchMapping(path = "/add_role")
    public ResponseEntity<Map<String, Set<String>>> addRole(@RequestParam String username, @RequestParam String role) {
        return ResponseEntity.ok(this.modifyUserService.addRole(username, role));
    }


    @PatchMapping(path = "/remove_role")
    public ResponseEntity<Map<String, Set<String>>> removeRole(@RequestParam String username, @RequestParam String role) {
        return ResponseEntity.ok(this.modifyUserService.removeRole(username, role));
    }

}
