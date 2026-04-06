package dev.anuradha.financeapp.controller;

import dev.anuradha.financeapp.dto.UserRequestDto;
import dev.anuradha.financeapp.dto.UserResponseDto;
import dev.anuradha.financeapp.entity.User;
import dev.anuradha.financeapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto dto){
        return userService.createUser(dto);
    }

    @GetMapping
    public List<UserResponseDto> getAllusers(){
        return userService.getAllUsers();
    }

    @PatchMapping("/{id}/status")
    public User updateUserStatus(@PathVariable Long id,
                                 @RequestParam boolean active){
        return userService.updateUserStatus(id, active);
    }

}
