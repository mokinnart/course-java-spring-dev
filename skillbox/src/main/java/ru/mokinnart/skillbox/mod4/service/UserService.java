package ru.mokinnart.skillbox.mod4.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.mokinnart.skillbox.mod4.dto.UserDTO;
import ru.mokinnart.skillbox.mod4.mapper.UserMapper;
import ru.mokinnart.skillbox.mod4.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
    public UserDTO createUser(UserDTO userDTO) {
        var user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}