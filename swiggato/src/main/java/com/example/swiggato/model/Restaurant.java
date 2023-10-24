package com.example.swiggato.model;

import com.example.swiggato.Enum.RestarauntCategory;
import com.example.swiggato.Enum.RestaurantCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String location;

    @Enumerated(EnumType.STRING)
    RestarauntCategory restrauntCategory;

    @Column(unique = true,nullable = false)
    @Size(min = 10, max = 10)
    String contactNumber;

    boolean opened;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    List<MenuItem> availableMenuItems = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();
 }
