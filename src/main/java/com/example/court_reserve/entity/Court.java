package com.example.court_reserve.entity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "court_reserve")
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SportType sportType;
    private Double courtValue;
    private boolean isAvailable;

    public void saveCourt(Court court){
        if (court.getCourtValue()<0){
        throw new IllegalArgumentException("Court value cannot be negative");
        }
    }
}
