package com.Inmobiliaria.Inmueble.Services;

import com.Inmobiliaria.Inmueble.DTOs.LeadRequestDTO;
import com.Inmobiliaria.Inmueble.Models.Lead;
import com.Inmobiliaria.Inmueble.Repositories.ILeadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LeadServiceTest {

    @Mock
    private ILeadRepository leadRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private LeadService leadService;

    @Test
    void crearLead_guardaLeadYPublicaEvento() {
        LeadRequestDTO request = new LeadRequestDTO();
        request.setInmuebleId(77);
        request.setNombre("Juan Pérez");
        request.setEmail("juan@mail.com");
        request.setTelefono("1122334455");
        request.setMensaje("Quiero más info");

        when(leadRepository.save(any(Lead.class))).thenAnswer(invocation -> {
            Lead l = invocation.getArgument(0);
            l.setId(10);
            return l;
        });

        var response = leadService.crearLead(request);

        assertEquals(10, response.getId());
        assertEquals("NUEVO", response.getEstado());
        assertEquals(77, response.getInmuebleId());

        ArgumentCaptor<LeadCreatedEvent> eventCaptor = ArgumentCaptor.forClass(LeadCreatedEvent.class);
        verify(eventPublisher).publishEvent(eventCaptor.capture());
        assertEquals(10, eventCaptor.getValue().lead().getId());
    }
}