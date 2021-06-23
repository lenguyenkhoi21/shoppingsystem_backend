package nguyenkhoi.project.shopping_system_be.api.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GETProfileResponse {
    private String name;
    private String email;
    private String avatar;
    private String message;
}
