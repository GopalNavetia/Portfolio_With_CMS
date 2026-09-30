package com.portfolio.cms_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;
import java.time.LocalDateTime;

@Entity
@Table(name = "about")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class About {

    @Id
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be under 100 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Title is required")
    @Size(max = 150, message = "Title must be under 150 characters")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Summary is required")
    @Size(max = 2000, message = "Summary must be under 2000 characters")
    @Column(columnDefinition = "TEXT")
    private String summary;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email")
    private String email;

    @Pattern(regexp = "^[+]?[0-9\\s-]{7,20}$", message = "Must be a valid phone number")
    private String phone;

    @Size(max = 100, message = "Location must be under 100 characters")
    private String location;

    @URL(message = "Must be a valid image URL")
    private String profileImage;

    @URL(message = "Must be a valid URL")
    private String resumeUrl;

    @URL(message = "Must be a valid GitHub URL")
    private String githubUrl;

    @URL(message = "Must be a valid LinkedIn URL")
    private String linkedinUrl;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}