package senior.pe.restful.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senior.pe.restful.application.UserApplicationService;
import senior.pe.restful.domain.user.model.UserDTO;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserApplicationService userApplicationService;

    @GetMapping
    @Operation(summary = "Get all users", description = "Get a list of all registered users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by ID", description = "Get a specific user based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<?> getUser(@PathVariable UUID id) {
        UserDTO userDTO = userApplicationService.getUserById(id);

        return userDTO != null ? new ResponseEntity<>(userDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new user and returns the created user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid user data provided")
    })
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userApplicationService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
