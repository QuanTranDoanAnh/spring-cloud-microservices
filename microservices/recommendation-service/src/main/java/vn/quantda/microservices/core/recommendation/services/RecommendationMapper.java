package vn.quantda.microservices.core.recommendation.services;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import vn.quantda.api.core.recommendation.Recommendation;
import vn.quantda.microservices.core.recommendation.persistence.RecommendationEntity;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {

	@Mappings({ @Mapping(target = "rate", source = "entity.rating"),
			@Mapping(target = "serviceAddress", ignore = true) })
	Recommendation entityToApi(RecommendationEntity entity);

	@Mappings({ @Mapping(target = "rating", source = "api.rate"), @Mapping(target = "id", ignore = true),
			@Mapping(target = "version", ignore = true) })
	RecommendationEntity apiToEntity(Recommendation api);

	List<Recommendation> entityListToApiList(List<RecommendationEntity> entity);

	List<RecommendationEntity> apiListToEntityList(List<Recommendation> api);
}
