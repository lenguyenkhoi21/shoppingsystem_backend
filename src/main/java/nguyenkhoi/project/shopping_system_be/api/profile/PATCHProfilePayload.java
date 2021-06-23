package nguyenkhoi.project.shopping_system_be.api.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PATCHProfilePayload {
    private String phone;
    private String name;
    private String email;
}


