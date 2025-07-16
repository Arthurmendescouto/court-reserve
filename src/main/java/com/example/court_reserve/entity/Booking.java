package com.example.court_reserve.entity;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(name = "Booking", description = "Entidade que representa um agendamento de quadra.")
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "booking")
public class Booking {
    @Schema(description = "Identificador único do agendamento.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Data e hora de início do agendamento.", example = "2024-06-01T10:00:00")
    private LocalDateTime startDateTime;

    @Schema(description = "Data e hora de término do agendamento.", example = "2024-06-01T11:00:00")
    private LocalDateTime endDateTime;

    @Schema(description = "Quadra reservada para o agendamento.")
    @ManyToOne
    @JoinColumn(name = "court_id",nullable = false)
    private Court court;

    @Schema(description = "Usuário que realizou o agendamento.")
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private  User user;
}
