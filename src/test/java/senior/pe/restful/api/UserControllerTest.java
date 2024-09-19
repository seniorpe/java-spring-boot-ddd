package senior.pe.restful.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import senior.pe.restful.application.UserApplicationService;
import senior.pe.restful.domain.user.model.UserDTO;
import senior.pe.restful.factories.dto.UserDTOFactory;

import java.util.UUID;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserApplicationService userApplicationService;

    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        userDTO = UserDTOFactory.build();
    }

    @Test
    void testGetUserById_Success() throws Exception {
        UUID userId = UUID.randomUUID();
        when(userApplicationService.getUserById(any(UUID.class))).thenReturn(userDTO);

        mockMvc.perform(get("/users/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userDTO.getId().toString()))
                .andExpect(jsonPath("$.name").value(userDTO.getName()))
                .andExpect(jsonPath("$.email").value(userDTO.getEmail()));

        verify(userApplicationService).getUserById(userId);
    }

    @Test
    void testGetUserById_NotFound() throws Exception {
        UUID userId = UUID.randomUUID();
        when(userApplicationService.getUserById(any(UUID.class))).thenReturn(null);

        mockMvc.perform(get("/users/{id}", userId))
                .andExpect(status().isNotFound());

        verify(userApplicationService).getUserById(userId);
    }

    @Test
    void testCreateUser_Success() throws Exception {
        when(userApplicationService.createUser(any(UserDTO.class))).thenReturn(userDTO);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(userDTO.getName()))
                .andExpect(jsonPath("$.email").value(userDTO.getEmail()))
                .andExpect(jsonPath("$.password").value(userDTO.getPassword()));

        verify(userApplicationService).createUser(any(UserDTO.class));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
