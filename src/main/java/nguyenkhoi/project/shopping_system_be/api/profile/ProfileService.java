package nguyenkhoi.project.shopping_system_be.api.profile;

import nguyenkhoi.project.shopping_system_be.common.mapper.UserMapper;
import nguyenkhoi.project.shopping_system_be.common.model.mybatis.User;
import nguyenkhoi.project.shopping_system_be.common.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileService {
    private final UserMapper userMapper;

    public ProfileService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional
    public GETProfileResponse getProfileResponse (String phone) {
        User user = userMapper.selectUserProfile(User
                .builder()
                .phone(phone)
                .build());

        return GETProfileResponse
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .message(Constant.msgSuccess)
                .build();
    }

    @Transactional
    public PATCHProfileResponse patchProfileResponse (
            PATCHProfilePayload payload) throws Exception {

        int rowAffected = userMapper.updateProfile(User
                .builder()
                .phone(payload.getPhone())
                .email(payload.getEmail())
                .name(payload.getName())
                .build());

        if (rowAffected == 0) {
            throw new Exception();
        }

        return PATCHProfileResponse
                .builder()
                .message(Constant.msgSuccess)
                .build();
    }
}
