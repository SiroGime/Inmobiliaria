package com.Inmobiliaria.Inmueble.Controllers;

import com.Inmobiliaria.Inmueble.DTOs.LeadResponseDTO;
import com.Inmobiliaria.Inmueble.Services.LeadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.emptyList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {
        "app.jwt.secret=12345678901234567890123456789012",
        "app.notifications.to=test@example.com",
        "spring.mail.host=localhost",
        "spring.mail.port=2525"
})
@AutoConfigureMockMvc
class LeadControllerSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LeadService leadService;

    @Test
    void crearLead_sinAutenticacion_deberiaSerPublico() throws Exception {
        LeadResponseDTO response = new LeadResponseDTO();
        response.setId(1);
        response.setEstado("NUEVO");

        when(leadService.crearLead(any())).thenReturn(response);

        mockMvc.perform(post("/api/v1/leads")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "inmuebleId": 1,
                                  "nombre": "Test",
                                  "email": "test@mail.com"
                                }
                                """))
                .andExpect(status().isCreated());
    }

    @Test
    void listarLeads_sinAutenticacion_deberiaRechazar() throws Exception {
        when(leadService.listarLeads()).thenReturn(emptyList());

        mockMvc.perform(get("/api/v1/admin/leads"))
                .andExpect(status().is4xxClientError());
    }
}