package vn.quantda.microservices.core.product;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import vn.quantda.api.core.product.Product;
import vn.quantda.microservices.core.product.persistence.ProductEntity;
import vn.quantda.microservices.core.product.services.ProductMapper;

public class MapperTests {

	private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

	  @Test
	  void mapperTests() {

	    assertNotNull(mapper);

	    Product api = new Product(1, "n", 1, "sa");

	    ProductEntity entity = mapper.apiToEntity(api);

	    assertEquals(api.getProductId(), entity.getProductId());
	    assertEquals(api.getProductId(), entity.getProductId());
	    assertEquals(api.getName(), entity.getName());
	    assertEquals(api.getWeight(), entity.getWeight());

	    Product api2 = mapper.entityToApi(entity);

	    assertEquals(api.getProductId(), api2.getProductId());
	    assertEquals(api.getProductId(), api2.getProductId());
	    assertEquals(api.getName(),      api2.getName());
	    assertEquals(api.getWeight(),    api2.getWeight());
	    assertNull(api2.getServiceAddress());
	  }
}
