package com.inspira.rag.models;
import com.inspira.rag.models.enums.UserStatusEnum;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name="users")
@Data
public class User {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  @NotBlank
  private String name;

  @Column
  @NotBlank
  private String cpf;

  @Column
  @NotBlank
  private String oauthId;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private UserStatusEnum status;

  @Column(nullable = true)
  private Instant lastQuery;

  @Column(nullable = false)
  private Integer queryCount = 0;

  @PrePersist
  protected void onCreate() {
    if (this.queryCount == null) {
      this.queryCount = 0;
    }
  }
}
