package dev.anuradha.financeapp.service;

import dev.anuradha.financeapp.dto.UserRequestDto;
import dev.anuradha.financeapp.dto.UserResponseDto;
import dev.anuradha.financeapp.entity.User;
import dev.anuradha.financeapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//    @PreAuthorize("hasRole('ADMIN')")
    public UserResponseDto createUser(UserRequestDto dto){

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        User user = User.builder()
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                        .role(dto.getRole())
                        .active(true)
                        .createdAt(LocalDateTime.now())
                        .build();

        User saved = userRepository.save(user);

        return UserResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .email(saved.getEmail())
                .role(saved.getRole())
                .build();
    }

    public List<UserResponseDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user -> UserResponseDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .toList();
    }

    public User updateUserStatus(Long id,boolean active){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setActive(active);

        return userRepository.save(user);
    }

}
