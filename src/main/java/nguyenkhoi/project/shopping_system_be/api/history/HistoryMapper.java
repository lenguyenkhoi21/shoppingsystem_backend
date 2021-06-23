package nguyenkhoi.project.shopping_system_be.api.history;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {
    List<HistoryModel> selectUserHistoryDetails(HistoryModel model);
}
