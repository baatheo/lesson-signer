package pl.baatheo.lessonsigner.subject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SubjectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SubjectService service;

    @Test
    @DisplayName("Validate parameters for login")
    void saveNewSubject() throws Exception {
        val newSubject = new Subject();
        mockMvc.perform(post("/subject")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newSubject)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Validate parameters for login")
    void findAll() throws Exception {
        val newSubject = new Subject();
        doReturn(List.of(newSubject)).when(service).findAll();
        mockMvc.perform(get("/subject"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
