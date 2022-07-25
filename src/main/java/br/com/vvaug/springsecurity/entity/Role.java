package br.com.vvaug.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "roles")
public class Role implements GrantedAuthority {

    @Id
    private String id;
    private String name;

    @Override
    public String getAuthority() {
        return this.getName();
    }
}
